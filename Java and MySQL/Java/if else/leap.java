import java.util.Scanner;
class leap
{
public static void main(String[]aa)
{
int year;
Scanner sc=new Scanner(System.in);
System.out.println("enter  a year");
year=sc.nextInt();
if((year%4==0) && (year%100!=0))
{
System.out.println("this is leap year");
}
else
{
System.out.println("this is not leap year");
}
}
}