/* Developer: Daniel Busuttil
 * Start date: 7 February 2018
 * Last update: 13 February 2018
 * 
 * Description:
 * Program designed to take an input word and return an ArrayList of all possible anagrams. Viable 
 * words are pulled from a textfile, "wordList.txt", which contains roughly 70,000 words (in the
 * English language), not accounting for slang. */

// Necessary libraries for our program:
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

// Class declaration, extends a personal library of methods
public class AnagramMain extends HelperLibrary {
  // Private ArrayList to keep track of viable words, based on our text file
  private static final ArrayList<String> wordList = new ArrayList<String>();
  
  // Method to build our program's dictionary of words (~69,000 words)
  private boolean buildDictionary( String fileName ) throws IOException {
    try {
      // I/O stream
      BufferedReader inputStream =  new BufferedReader( new FileReader(fileName) );
      
      // String object to hold each line of data; in the text file only a single word is on a line
      String line;
      // While loop to read each line of data and trim all whitespace/non-character input
      while( ( line = inputStream.readLine() ) != null ) {
        String word = line.trim();
        wordList.add(word);
      }
      return true;
    }
    
    /* This should never be reached as we only invoke this method with the correct text file but
     * in order to account for safety we handle the possibilty of an incorrect fileName input */
    catch( FileNotFoundException ex ) {
      System.out.println("Unable to open file '" + fileName + "'");
      return false;
    }
    
    // If we have some issue reading the file, we handle it here:
    catch( IOException ex ) {
      System.out.println("Error reading file '" + fileName + "'");
      return false;
    }
  }
  
  // MergeSort implementation of alphabetically sorting our String, O(log n)
  public String sortLetters(String input) {
    // Creates a char array of our input String:
    int length = input.length();
    char[] inputAsCharArray = input.toCharArray();
    int [] inputAsIntArray = new int[length];
    for ( int i = 0 ; i < length ; i++ ){
      inputAsIntArray[i] = Character.getNumericValue(inputAsCharArray[i]);
    }
    
    // We sort the int values corresponding to the ascii letters in our String:
    sort(inputAsIntArray, 0, inputAsIntArray.length - 1);
    String result = "";
    
    // Construct a new String from the sorted int array
    for ( int i = 0 ; i < length ; i++ ){
      result += Character.toChars(inputAsCharArray[i]);
    }
    return result;
  }
  
  // Returns an ArrayList
  public ArrayList<String> getAnagrams(String targetWord) {
    ArrayList<String> result = new ArrayList<String>();
    String sortedTW = sortLetters(targetWord);
    for(int i = 0; i < wordList.size() - 1; i ++){
      if ( sortedTW.length() == wordList.get(i).length() ) {
        // Temp variable to hold the word from the ArrayList/complete dictionary
        String temp = sortLetters(wordList.get(i));
        boolean sameLetters = true;
        for ( int j = 0; j < sortedTW.length() ; j++){
          if (sortedTW.charAt(j) != temp.charAt(j) ) {
            sameLetters = false;
            break;
          }
        }
        if ( sameLetters ) result.add(wordList.get(i));
      }
    }
    
    // To print out each element of 'result' in result for debugging
    for ( int k = 0; k < result.size() - 1 ; k++){
      System.out.println(result.get(k));
    }
    return result;
  }
  
  
  
  
}