//WAP to check whether the number is armstrong number or not//
import java.util.Scanner;
class armstrong
{
public static void main(String[] args) 
{
int a,no,b,temp=0;
Scanner s=new Scanner(System.in);
System.out.println("Enter any num: ");
no=s.nextInt();
b=no;
while(no>0)
{
a=no%10;
no=no/10;
temp=temp+(a*a*a);
}
if(temp==b)
{
System.out.println("armstrong");
}
else
{
System.out.println("not armstrong");
}
}
}