import java.util.*;
public class Remainder 
{
	int rem(int x,int y)
	{
		int remainder=0;
        if(x<0||y<=0)
         return -1;
        else if(x>y)
		{
			x=x%y;
		   return rem(x,y);
		}
		else
		remainder=x;
		return remainder;
	}
   public static void main(String args[])
   {
	   Scanner sc=new Scanner(System.in);
	   int x,y;
	   System.out.println("Enter value of dividend");
	   x=sc.nextInt();
	   System.out.println("Enter value of divisor");
	   y=sc.nextInt();
	   Remainder R=new Remainder();
	   int z=R.rem(x,y);
	   if(z<0)
	   System.out.println("Enter positive value");
	   else
	   System.out.println("Remainder is:"+z);
   }
}
