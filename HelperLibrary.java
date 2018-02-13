/* Developer: Daniel Busuttil
 * Start date: 1 February 2018
 * Last update: 13 February 2018
 * 
 * Description:
 * Personal library with functions that I find used, such as printing elements of an array. Used by some of my
 * Java programs by means of inheritance. */

public class HelperLibrary {
  /* Function to print out elements of an array of type T, where T is a primitive type (or String). Option for a
   * more comprehensive 'debug' mode, which prints index numbers for added clarity. */
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
  
  // The next two functions are implementations of MergeSort
  public static void merge( int arr[], int left, int middle, int right ) {
    // Find sizes of two subarrays to be merged
    int length1 = middle - left + 1;
    int length2 = right - middle;
    
    // Create temp arrays to hold our sorted left and right sub-array's values
    int L[] = new int [length1];
    int R[] = new int [length2];
    
    // Copy data to temp arrays for later processing
    for ( int i = 0 ; i < length1; ++i )
      L[i] = arr[left + i];
    for ( int j = 0 ; j < length2 ; ++j )
      R[j] = arr[middle + 1 + j];
    
    // Initial indices of first and second subarrays
    int i = 0, j = 0;
    // Initial index of merged subarry
    int k = left;
    
    // Guard to make sure we cycle through all the elements of at least one temp array
    while ( i < length1 && j < length2 ) {
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
    
    // We copy over any elements that we have 'left over'
    while ( i < length1 ) {
      arr[k] = L[i];
      i++;
      k++;
    }
    while ( j < length2 ) {
      arr[k] = R[j];
      j++;
      k++;
    }
    
    // Array is now sorted so we exit
  }
  
  // Second half of MergeSort, sorts arr[left, 2, ... , right] using merge()
  public static void sort(int arr[], int left, int right) {
    // Guard to ensure a recursive base case (arr is a single celled-array) will be reached
    if ( left < right ) {
      // Find the middle point
      int middle = (left + right ) / 2;
      
      // Sort first and second halves of arr
      sort(arr, left, middle);
      sort(arr , middle+1, right);
      
      // Merge the sorted halves
      merge(arr, left, middle, right);
    }
  }
  
  
}