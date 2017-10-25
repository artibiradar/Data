import java.util.Scanner;
class demo
{
int a,b;
void num()
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a no");
a=sc.nextInt();
b=sc.nextInt();
if(a>b)
{
System.out.println("a is greater");
}
else
{
System.out.println("b is greater");
}
}
}
class test
{
public static void main(String[]aa)
{
demo obj=new demo();
obj.num();
}
}

