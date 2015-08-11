import java.util.*;
public class Binary_Search 
{
	int binarySearch(int[] input,int item,int beg,int end,int mid)
	{
		if(input[mid]==item)
			return mid+1;
		else if(beg<end)
		{
			if(item>input[mid])
			{
				beg=mid+1;
				mid=(beg+end)/2;
				return binarySearch(input,item,mid,end,mid);
			}
			else
				{
					end=mid-1;
					mid=(beg+end)/2;
					return binarySearch(input,item,mid,end,mid);
				}
		}
		else return -1;
	}
    public static void main(String args[])
    {
    	Scanner sc=new Scanner(System.in);
    	int size;
    	
    	System.out.println("Enter size of array:");
    	size=sc.nextInt();
        
    	int input[]=new int[size];
        System.out.println("Enter elements in array in sorted manner:");
        for(int i=0;i<size;i++)
            input[i]=sc.nextInt();
    	
        System.out.println("Enter element to be search:");
    	int item=sc.nextInt();
    	
    	int beg=0,end=size-1,mid=(beg+size)/2;
        
    	Binary_Search LS=new Binary_Search();
        int found=LS.binarySearch(input,item,beg,end,mid);
        
        if(found==-1)
        System.out.println("Item not found:");
        else
        	System.out.println("Item found at "+found);
    }
}
