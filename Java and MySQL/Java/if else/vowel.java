import java.util.Scanner;
class vowel
{
public static void main(String[]aa)
{
char ch;
Scanner sc=new Scanner(System.in);
System.out.println("enter the character");
ch=sc.next().charAt(0);
switch (ch)
{
case 'a':
case 'e':
case 'i':
case 'o':
case 'u':
System.out.println("this is vowel");
break;
default :
System.out.println("this is not vowel");
break;
}
}
}