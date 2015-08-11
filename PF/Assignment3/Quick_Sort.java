import java.util.Scanner;


public class Quick_Sort 
{
	int partition(int[] input,int left,int right)
	{
		int j;
		int pivot=(left+right)/2;
		while(left<=right && left<=pivot && right>=pivot)
		{
			while(input[left]<=input[pivot] && left<pivot)
				left++;
			while(input[right]>=input[pivot] && right>pivot)
                right--;
			if(left==pivot)
				pivot=right;
			else if(right==pivot)
				pivot=left;
			
				int temp;
				temp=input[right];
				input[right]=input[left];
				input[left]=temp;
				left++;right--;
		}
		
		return pivot;
	}
	int[] quickSort(int[] input,int left,int right)
	{
        if(input.length==0)
        {   int output[]=new int[1];
            output[0]=-1;
        	return output;
        }
        else
        {
		int index=partition(input,left,right);
		if (left<(index-1))
		{
            quickSort(input,left,index-1);
		}
        if ((index+1)<right)
        {
            quickSort(input,index+1,right);
        }
            return input;
        }
	}
  public static void main(String args[])
  {
	  
	  Scanner sc = new Scanner(System.in);
	 
	  System.out.println("Enter size of array:");
	  int size=sc.nextInt();
	  
	  int input[]=new int[size];
	  System.out.println("Enter elements in array:");
	  for(int i=0;i<size;i++)
		  input[i]=sc.nextInt();
	 
	  Quick_Sort QS=new Quick_Sort();
	  
	  int right=size-1;
	  int left=0;
	  
	  int k[]=QS.quickSort(input,left,right);
	  
	  if(k[0]==-1)
		  System.out.println("Please enter some elements in array");
	  else
	  {
		  System.out.println("Sorted array is:");
	      for(int i=0;i<size;i++)
		        System.out.print(k[i]+" ");
	  }
  }
}
