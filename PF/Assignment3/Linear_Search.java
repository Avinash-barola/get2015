import java.util.*;
public class Linear_Search 
{
	int i=0;
	int linearSearch(int[] input,int item)
	{
		if(i==input.length)
		    return -1;
		else if(item==input[i])
			return i;
		else
		{
	        i++;
			return linearSearch(input,item);
		}
	}
	public static void main(String args[])
	{
	Scanner sc=new Scanner(System.in);
	
	int size;
	System.out.println("Enter size of array:");
	size=sc.nextInt();
   
	int input[]=new int[size];
    System.out.println("Enter elements in array:");
    for(int i=0;i<size;i++)
        input[i]=sc.nextInt();
	
    System.out.println("Enter element to be search:");
	int item=sc.nextInt();
    
	Linear_Search LS=new Linear_Search();
    
	int found=LS.linearSearch(input,item);
    if(found<0)
        System.out.println("Item not found:");
    else
    	System.out.println("Item found at "+(found+1));
	}
}
