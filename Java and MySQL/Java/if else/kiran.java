import java.util.Scanner;
class demo
{
int a,b,c,d,e,sum,avg;
void get()
{
Scanner sc=new Scanner(System.in);
System.out.println("enter a no");
a=sc.nextInt();
b=sc.nextInt();
c=sc.nextInt();
d=sc.nextInt();
e=sc.nextInt();
sum=a+b+c+d+e;
avg=sum/5;
if(a==100)
{
System.out.println("avg of 5 no is 100");
}
else
{
System.out.println("avg of 5 no is not 100");
}
}
}
class kiran
{
public static void main(String[]aa)
{
demo obj=new demo();
obj.get();
}
}
