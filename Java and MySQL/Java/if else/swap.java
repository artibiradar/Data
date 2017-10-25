import java.util.Scanner;
class swap
{
public static void main(String[]aa)
{
int a,b;
Scanner s=new Scanner(System.in);
System.out.println("enter value in a");
a=s.nextInt();
System.out.println("enter value in b");
b=s.nextInt();
a=a+b;
b=a-b;
a=a-b;
System.out.println("value in a" +a);
System.out.println("value in b" +b);
}
}
