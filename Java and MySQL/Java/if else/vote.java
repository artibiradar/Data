import java.util.Scanner;
class vote
{
public static void main(String[]aa)
{
int a;
Scanner sc=new Scanner(System.in);
System.out.println("enter a no");
a=sc.nextInt();
if(a>18)
{
System.out.println("person is eligible for vote");
}
else
{
System.out.println("person is not eligible for vote");
}
}
}
