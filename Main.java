import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

class Main{
    public static int[] createArray(int[] A,int length,int number) {
    	A = new int[length];
    	switch (number){
			case 1:  // Equal Numbers
				for(int i = 0; i < A.length; i++) {
					A[i] = 5;
				}
				break;
			case 2:   // Random Numbers
				for(int i = 0; i < A.length; i++) {
					A[i] = (int)(Math.random() * 10000000 + 1);				
				}
				break;
			case 3:   // Increasing Numbers
				for(int i = 0; i < A.length; i++) {
					A[i] = i;
				}
				break;
			case 4:   // Decreasing Numbers
				for(int i = 0; i < A.length; i++) {
					A[i] = length - i;
				}
				break;
    	}
    	return A;
    }
    
    public static int numberChoice() {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        int scan = 0;
        while(true) {
        	System.out.println("Select the Order of the Numbers: \n"
        			+ "1 - Equal Numbers \n"
        			+ "2 - Random Numbers \n"
        			+ "3 - Increasing Numbers \n"
        			+ "4 - Decreasing Numbers");  
        	scan = scanner.nextInt();
        	if(!(scan == 1 || scan == 2 || scan == 3 || scan == 4)){
        		scan = 0;
        		System.out.println("Wrong input! Check your choice!");
        		break;
        	}
        	else
        		break;
        }
        System.out.println();
        return scan;
    }
    
    public static int lengthChoice() {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        int scan = 0;
        while(true) {
        	System.out.println("Select the Length of the Array: \n"
        			+ "1 - 1.000 \n"
        			+ "2 - 10.000 \n"
        			+ "3 - 100.000 \n"
        			+ "4 - Manuel Input");
    		scan = scanner.nextInt();
        	if(!(scan == 1 || scan == 2 || scan == 3 || scan == 4)){
        		scan = 0;
        		System.out.println("Wrong input! Check your choice!");
        		break;
        	}
        	else if(scan == 4) {
        		System.out.print("Input Size: ");
        		scan = scanner.nextInt();
        		break;
        	}
        	else
        		scan = (int) Math.pow(10, 1+scan);
        		break;
        }
        System.out.println();
        return scan;
    }
    
    public static void printArray(int[] A){
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + "-");
        }
        System.out.println();
        System.out.println(A[A.length-1]);
    }
    
    public static void main(String[] args) {
        int[] arr = null;
        NumberFormat formatter = new DecimalFormat("#0.00000000000");
        
        int length = lengthChoice();
        int number = numberChoice();
        arr = createArray(arr,length, number);
        
        int[] arr2 = arr.clone();
        System.out.println("************* HEAP SORT *************");
        //System.out.println("Array before sorting: "  ); printArray(arr2);
        long startTime = System.nanoTime();
        SortingClass.heapSort(arr2);
        long estimatedTime = System.nanoTime() - startTime;
        //System.out.println("Array after sorting: "  ); printArray(arr2);
        System.out.println("Run Time of Heap Sort: " + formatter.format(estimatedTime / 1000000d));

        arr2 = arr.clone();
        System.out.println();
        System.out.println("******* DUAL PIVOT QUICKSORT *******");
        //System.out.println("Array before sorting: "  ); printArray(arr2);
        startTime = System.nanoTime();
        SortingClass.dualPivotQuickSort(arr2, 0, arr2.length -1);
        estimatedTime = System.nanoTime() - startTime;
        //System.out.println("Array after sorting: "  ); printArray(arr2);
        System.out.println("Run Time of Dual Pivot QuickSort: " + formatter.format(estimatedTime / 1000000d));
       
        arr2 = arr.clone();
        System.out.println();
        System.out.println("************ SHELL SORT ************");
        //System.out.println("Array before sorting: "  ); printArr(arr2);
        startTime = System.nanoTime();
        SortingClass.shellSort(arr2);
        estimatedTime = System.nanoTime() - startTime;
        //System.out.println("Array after sorting: "  ); printArray(arr2);
        System.out.println("Run Time of Shell Sort: " + formatter.format(estimatedTime / 1000000d));
         
        System.out.println();
    }
}