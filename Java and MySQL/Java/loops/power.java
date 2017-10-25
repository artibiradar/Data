//WAP to calculate the power of any base//
import java.util.Scanner;

class power
{

      void pow(int c, int d)
    {       
              int n=1;
              for(int i=0;i<d;i++)
              {
                      n=c*n;
              }
           
   System.out.println(n);
     } 
}
 class head
{
    public static void main(String arg[])
    {
    int a,b;
    Scanner sc=new Scanner(System.in);                          
    System.out.println("Enter the number you want to get multiplied");
    a=sc.nextInt();
    System.out.println("Enter the power");
    b=sc.nextInt();
        power c=new power();
        c.pow(a,b);
    }
}