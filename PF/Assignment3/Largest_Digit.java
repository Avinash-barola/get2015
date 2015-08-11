import java.util.*;
public class Largest_Digit 
{
	int large=0,rem=0;
	int largestDigit(int num)
	{
		if(num<0)
			return -1;
		else if(num==0)
			return large;
		else
		{
           rem=num%10;
           if(rem>large)
        	   large=rem;
           largestDigit(num/10);
           
		}
		return large;
	}
  public static void main(String args[])
  {
	   Scanner sc=new Scanner(System.in);
	   
	   int num;
	   System.out.println("Enter value of first number");
	   num=sc.nextInt();
	   
	   Largest_Digit LD=new Largest_Digit();
	   
	   int l_digit=LD.largestDigit(num);
	   if(l_digit<0)
		   System.out.println("Enter positive num:");
	   else
	       System.out.println("Largest digit is:"+l_digit);
  }
}
