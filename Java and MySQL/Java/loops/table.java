//WAP to display the table of any number.//
import java.util.Scanner;
class table
{
public static void main(String[]args)
{
Scanner sin=new Scanner(System.in);
int num;
System.out.println("enter the number");
num=sin.nextInt();
for(int i=1;i<=10;i++)
{
System.out.println(num*i);
}
}
}