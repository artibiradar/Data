//write a program to even and odd no
import java.util.Scanner;
class demo
{
int a;
void sum()
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a no");
a=sc.nextInt();
if(a>0)
{
System.out.println("no is +v");
} 
else if(a<0)
{
System.out.println("no is -ve");
}
else
{
System.out.println("no is zero");
}
}
}
class imp
{
public static void main(String[]aa)
{
demo obj=new demo();
obj.sum();
}
}

