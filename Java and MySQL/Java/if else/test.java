import java.util.Scanner;
class demo
{
int a,b,c;
void grt()
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a no");
a=sc.nextInt();
b=sc.nextInt();
c=sc.nextInt();
if(a>b)
{ 
if(a>c)
{
System.out.println("a is greater");
}
else
{
System.out.println("c is greater");
}
}
else
{
if(b>c)
{
System.out.println("b is greater");
}
else
{
System.out.println("c is greater");
}
}
}
}
class test
{
public static void main(String[]aa)
{
demo obj=new demo();
obj.grt();
}
}

