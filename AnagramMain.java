import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnagramMain extends HelperLibrary {
  
  
  
  private static final int MIN_NUM_ANAGRAMS = 5;
  private static final int DEFAULT_WORD_LENGTH = 3;
  private static final int MAX_WORD_LENGTH = 7;
  private static final ArrayList<String> wordList = new ArrayList<String>();
  
  /*
  public AnagramDictionary(Reader reader) throws IOException {
    BufferedReader in = new BufferedReader(reader);
    String line;
    while((line = in.readLine()) != null) {
      String word = line.trim();
      wordList.add(word);
    }
  }
  */
  
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
  
  public List<String> getAnagrams(String targetWord) {
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