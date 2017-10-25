import java.util.Scanner;
class avg
{
public static void main(String[]aa)
{
int a,b,c,d,e,sum,ave;
Scanner sc=new Scanner(System.in);
System.out.println("enter a number");
a=sc.nextInt();
b=sc.nextInt();
c=sc.nextInt();
d=sc.nextInt();
e=sc.nextInt();
sum=a+b+c+d+e;
ave=sum/5;
System.out.println(ave);
}
}