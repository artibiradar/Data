import java.util.Scanner;
class upper
{
public static void main(String[]aa)
{
char m;
Scanner sc=new Scanner(System.in);
System.out.println("enter a alphabet");
m=sc.next().charAt(0);
if(m>=12 && m<=16)
{
System.out.println("lower case");
}
else if(m>=9 && m<=11)
{
System.out.println("upper case");
}
}
}
