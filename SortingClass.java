
public class SortingClass {
	///// HEAP SORT /////
	public static void heapSort(int[] A){
        int n = A.length; 
        
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(A, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = A[0]; 
            A[0] = A[i]; 
            A[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(A, i, 0); 
        }
    }
    private static void heapify(int A[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && A[l] > A[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && A[r] > A[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = A[i]; 
            A[i] = A[largest]; 
            A[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(A, n, largest); 
        } 
    } 
	
    ///// DUAL PIVOT QUICK SORT /////
	static void dualPivotQuickSort(int[] A, int left, int right) {
	    if (right > left) {
	        // Choose outermost elements as pivots
	        if (A[left] > A[right]) swap(A, left, right);
	        int p = A[left], q = A[right];

	        // Partition A according to invariant below
	        int l = left + 1, g = right - 1, k = l;
	        while (k <= g) {
	            if (A[k] < p) {
	                swap(A, k, l);
	                ++l;
	            } else if (A[k] >= q) {
	                while (A[g] > q && k < g) --g;
	                swap(A, k, g);
	                --g;
	                if (A[k] < p) {
	                    swap(A, k, l);
	                    ++l;
	                }
	            }
	            ++k;
	        }
	        --l; ++g;

	        // Swap pivots to final place
	        swap(A, left, l); swap(A, right, g);

	        // Recursively sort partitions
	        dualPivotQuickSort(A, left, l - 1);
	        dualPivotQuickSort(A, l + 1, g - 1);
	        dualPivotQuickSort(A, g + 1, right);
	    }
	}
	static void swap(int[] A, int i, int j) {
	    final int tmp = A[i]; A[i] = A[j]; A[j] = tmp;
	}
	
	///// SHELL SORT /////
    /* function to sort arr using shellSort */
    static int shellSort(int A[]) 
    { 
        int n = A.length; 
  
        // Start with a big gap, then reduce the gap 
        for (int gap = n/2; gap > 0; gap /= 2) 
        { 
            // Do a gapped insertion sort for this gap size. 
            // The first gap elements a[0..gap-1] are already 
            // in gapped order keep adding one more element 
            // until the entire array is gap sorted 
            for (int i = gap; i < n; i += 1) 
            { 
                // add a[i] to the elements that have been gap 
                // sorted save a[i] in temp and make a hole at 
                // position i 
                int temp = A[i]; 
  
                // shift earlier gap-sorted elements up until 
                // the correct location for a[i] is found 
                int j; 
                for (j = i; j >= gap && A[j - gap] > temp; j -= gap) 
                    A[j] = A[j - gap]; 
  
                // put temp (the original a[i]) in its correct 
                // location 
                A[j] = temp; 
            } 
        } 
        return 0; 
    }
}
