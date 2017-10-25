import java.util.Scanner;
class rem
{
public static void main(String[]aa)
{
int a,b,c;
Scanner sc=new Scanner(System.in);
System.out.println("enter a number");
a=sc.nextInt();
b=a%10;
c=a/10;
System.out.println(b);
System.out.println(c);
}
}