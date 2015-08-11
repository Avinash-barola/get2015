import java.util.*;
public class GCD 
{
	int gcd(int x,int y)
	{
		if(x==y)
			return x;
		else
		{
			if(x>=y)
				return gcd(x-y,y);
			else
				return gcd(x,y-x);
		}
	}
public static void main(String args[])
    {
	 Scanner sc=new Scanner(System.in);
	   int x,y;
	   System.out.println("Enter value of first number");
	   x=sc.nextInt();
	   System.out.println("Enter value of second number");
	   y=sc.nextInt();
	   GCD G=new GCD();
	   int z=G.gcd(x,y);
	   System.out.println("Remainder is"+z);
	}
}
