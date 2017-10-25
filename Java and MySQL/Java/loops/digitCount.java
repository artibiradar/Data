//WAP to count the number of digits in a number.//
import java.util.Scanner;
 
class digitCount 
{
    public static void main(String args[])
    {   
        int n, i=0;
        System.out.print("Enter a Number:");
        Scanner get = new Scanner(System.in);
        n = get.nextInt();
        while(n>0)
        {
           n=n/10;
            i++;
        }
        System.out.println();
        System.out.println("Number of Digits present : "+i);
    }
}