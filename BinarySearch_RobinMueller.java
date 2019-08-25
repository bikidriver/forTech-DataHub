/******************************************************************************

Simple BinarySearch by Robin Mueller for Tech&DataHub, DaimlerAG

*******************************************************************************/


public class Main
{
    public static int[] list = {0,0,0,0,0,0,0,0,0,0};
    
	public static void main(String[] args) 
	{
	    
	System.out.println("Please enter unique integers for the list BinarySearch will use.\nThe List will have 10 elements as an example");
    	for (int i = 0;i<10;i++) //read the list from the console
        {
        	list[i]=Integer.parseInt(System.console().readLine());
        }
        
        
        quicksort(0,list.length-1); //sort the entered list
        System.out.println("\nYour input has been sorted:\nList:");
        printout(list); //show off sorted list
        
        
        System.out.println("\nPlease enter the integer you are searching for.");
        int x=Integer.parseInt(System.console().readLine()); //enter the target element
        System.out.println("\nThank you. We will now search for "+x+" in the list.");
        int answer=BinarySearch(x)+1; //search for the target element
        
        
        if (answer==11) //elemt not found
        {
             System.out.println("Your input was not found in the list!");
        }
        else //element found
        {
             System.out.println("The number you were searching for is the "+answer+ " element of the list!");
        }
    
	}
	
	
	public static void quicksort(int l, int r) //quicksort main fnc
	{
	    if (l<r)
	    {
	        int devisor=devide(l,r);
	        quicksort(l, devisor-1);
	        quicksort(devisor+1, r);
	    
	    }
	}
	
	public static int devide(int l, int r) //quicksort secundary function
	{
	        int i=l;
	        int j=r-1;
	        int pivot=list[r];
	        
	        do 
	        {
	            while (i<r && list[i]<pivot)
	            {
	                i=i+1;
	            }
	            while (j>l && list[j]>=pivot)
	            {
	                j=j-1;
	            }
	            if (i<j)
	            {
	                int help=list[j];
	                list[j]=list[i];
	                list[i]=help;
	            }
	        } while (i<j);
	        
	        int help=list[i];
	        list[i]=list[r];
	        list[r]=help;
	        
	        return i;
	}
	
	
	public static void printout(int[] list) //print list
	{
	    for (int i = 0;i<10;i++)
        {
        	System.out.println(list[i]);
        }
	}
	
	public static int BinarySearch(int x) //BinarySearch
	{
	    int l=0;
	    int r=list.length-1;
	    
	    while (l<=r)
	    {
            int m=(l+r+((l+r)%2))/2;
            
            if(list[m]>x)
            {
                r=m-1;
            }
            if(list[m]<x)
            {
                l=m+1;
            }
            if(list[m]==x)
            {
                return m;
            }
	    } 
	    return 10;
	}   
}