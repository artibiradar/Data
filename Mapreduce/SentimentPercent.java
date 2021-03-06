package sentimentpercent;

import java.io.BufferedReader;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer.Context;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;


public class SentimentPercent 
{

	public static class SentimentMapper extends Mapper<LongWritable, Text, Text,IntWritable> 
	{
	   private Map<String, String> abMap = new HashMap<String, String>();
	   private Text word=new Text();
	   private static IntWritable total_value=new IntWritable();
	   String myword="";
	   int myValue=0;
				
       protected void setup(Context context) throws java.io.IOException, InterruptedException, ArrayIndexOutOfBoundsException
       {
			try
			{
			super.setup(context);

		   Path[] files = DistributedCache.getLocalCacheFiles(context.getConfiguration()); // getCacheFiles returns null

		    Path p = files[0];
		
			if (p.getName().equals("AFINN.txt")) 
			{
				BufferedReader reader = new BufferedReader(new FileReader(p.toString()));
					String line = reader.readLine();
					while(line != null) {
						String[] tokens = line.split("\t");
						String dictionary_wor = tokens[0];
						String dictionary_val = tokens[1];
						abMap.put(dictionary_wor, dictionary_val);
						line = reader.readLine();
					}
					reader.close();
			}
			
			if (abMap.isEmpty()) 
			{
				throw new IOException("MyError:Unable to load store data.");
			}
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println(e.getMessage());
			}
		}
        public void map(LongWritable key, Text value, Context context)
		throws IOException, InterruptedException,ArrayIndexOutOfBoundsException 
		{
        	try
        	{
        	StringTokenizer itr = new StringTokenizer(value.toString());
        	while(itr.hasMoreTokens())
        	{
        	  myword = itr.nextToken().toLowerCase();
        	  if(abMap.get(myword)!=null)
        	  {
        		myValue = Integer.parseInt(abMap.get(myword));
        		if(myValue > 0)
        		{
        		  myword = "positive";	
        	    }
        		if(myValue < 0)
        		{
        			myword = "negative";
        			myValue = myValue * -1;
        		}
        	  }
        	  else
        	  {
        		  myword = "neutral";
      			  myValue = 0;
        	  }
        	}
	        word.set(myword);
	        total_value.set(myValue);
	        context.write(word,total_value);
        	}
        	catch(ArrayIndexOutOfBoundsException e)
        	{
        		System.out.println(e.getMessage());
        	}
         }
	}
        
        public static class ReduceClass extends Reducer<Text,IntWritable,NullWritable,Text>
 	   {
 	      
 	      public int pos_total=0;
 	      public int neg_total=0;
 	      double sentpercent=0;
 	      public void reduce(Text key, Iterable <IntWritable> values, Context context) 
 	      throws IOException, InterruptedException
 	      {
 	    	     int sum=0;
	    	  
 		         for (IntWritable val : values)
 		         {   
 		        	 sum+=val.get(); 
 		         }
 		         if(key.toString().equals("positive"))
 		         {
 		        	 pos_total=sum;
 		         }
 		        if(key.toString().equals("negative"))
		         {
		        	 neg_total=sum;
		         }
 	      }
         protected void cleanup(Context context) throws IOException,InterruptedException
         {
          sentpercent = (((double)pos_total)-((double)neg_total))/(((double)pos_total)+((double)neg_total))*100;
          String str="Sentiment percent of given text\t"+String.format("%.2f", sentpercent);
          context.write(NullWritable.get(), new Text(str));
         }
 	   }
	public static void main(String ar[]) throws Exception
	{
		try
		{
		Configuration conf = new Configuration();
		  Job job =new Job(conf,"sentiment %");
		  job.setJarByClass(SentimentPercent.class);			
	      job.setMapperClass(SentimentMapper.class);
	    //  job.addCacheFile(new Path("AFINN.txt").toUri());
	      DistributedCache.addCacheFile(new URI("E:/data of sandeep/sentimental analysis/AFINN.txt"),job.getConfiguration());
	      job.setReducerClass(ReduceClass.class);
	      //job.setNumReduceTasks(0);	      
	      job.setMapOutputKeyClass(Text.class);
	      job.setMapOutputValueClass(IntWritable.class);	      
	      job.setInputFormatClass(TextInputFormat.class);			
	      job.setOutputFormatClass(TextOutputFormat.class);
	      job.setOutputKeyClass(NullWritable.class);
	      job.setOutputValueClass(Text.class);	      
	      FileInputFormat.setInputPaths(job, new Path(ar[0]));
	      FileOutputFormat.setOutputPath(job,new Path(ar[1]));			
	      System.exit(job.waitForCompletion(true)? 0 : 1);
		}
		catch(ArrayIndexOutOfBoundsException e)
    	{
    		System.out.println(e.getMessage());
    	}
	}
}