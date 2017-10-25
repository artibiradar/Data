import java.util.Scanner;
class demo
{
int a;
void inc()
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a no");
a=sc.nextInt();
if(a%2==0)
{
System.out.println("no is even");
}
else 
{
System.out.println("no is odd");
}
}
}
class dem
{
public static void main(String[]aa)
{
demo obj=new demo();
obj.inc();
}
}
