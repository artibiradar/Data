import java.util.Scanner;
class cons
{
public static void main(String[]aa)
{
char c;
Scanner sc=new Scanner(System.in);
System.out.println("enter the character");
c=sc.next().charAt(0);
if(c== 'a' || c== 'e' || c== 'i' || c== 'o' || c== 'u')
{
System.out.println("this is vowels");
}
else
{
System.out.println("this is constant");
}
}
}