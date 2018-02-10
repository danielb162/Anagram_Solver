
public class HelperLibrary {
  
  
  // Function to print out elements of an array of type T, option for a 'debug' mode which also prints index num.
  public static <T> void pprint( T[] arr, boolean debug ) {
    if ( debug ) {
      for ( int i = 0; i < arr.length; i++ ) {
        System.out.println("#" + (i + 1) + ": " + arr[i]);
      }
    }
    else {
      for ( int i = 0; i < arr.length; i++ ) {
        System.out.println( arr[i] );
      }
    }
  }
  
  // Function to merge two sub/half arrays
  public static void merge( int arr[], int l, int m, int r ) {
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;
    
    // Create temp arrays
    int L[] = new int [n1];
    int R[] = new int [n2];
    
    // Copy data to temp arrays
    for ( int i = 0 ; i < n1; ++i )
      L[i] = arr[l + i];
    for ( int j = 0 ; j < n2 ; ++j )
      R[j] = arr[m + 1 + j];
    
    
    // Merge the temp arrays (in ascending order)
    
    // Initial indexes of first and second subarrays
    int i = 0, j = 0;
    // Initial index of merged subarry array
    int k = l;
    
    // Guard to make sure we cycle through all the elements of at least one temp array
    while (i < n1 && j < n2) {
      if ( L[i] <= R[j] ) {
        arr[k] = L[i];
        i++;
      }
      else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }
    
    // These next two loops simply copy over any elements that we have 'left over'
    while ( i < n1 ) {
      arr[k] = L[i];
      i++;
      k++;
    }
    
    while ( j < n2 ) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }
  
  // Main function that sorts arr[l, 2, ... , r] using merge()
  public static void sort(int arr[], int l, int r) {
    // Guard so that we have a base case (single celled-array)
    if ( l < r ) {
      // Find the middle point
      int m = (l + r ) / 2;
      
      // Sort first and second halves of arr
      sort(arr, l, m);
      sort(arr , m+1, r);
      
      // Merge the sorted halves
      merge(arr, l, m, r);
    }
  } 
}