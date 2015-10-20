import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.lang.*;
import java.lang.System.*;

/*
Timothy Hydanus
Input example for echo commands

java Exercise20_11 nestingTest.java

Sadly there is a timing error in the code. Not all of the created methods activate. Such as the one to remove indecies. and the one to actually anilize the braces. This is due to the fact that the program seemingly continues to the next line of code once an instance of the methods are made. Thus the code finishes with a default return/setting before the methods can return a result.
*/
public class Exercise20_11 {
    public static void main (String[] args) {
        for (String s: args) {
           //Scanner input = new Scanner(System.in);
           File file = new File(s);
           if (file.exists()) {
             //System.out.println("The number of keywords in " + filename + " is " +

             boolean passFail = false;
             boolean correctness = true;
             String[] arrayNesting = new String[1];

             String[] keywordString = {"{", "}", "[", "]", "(", ")"};

             Set<String> keywordSet =
               new HashSet<>(Arrays.asList(keywordString));
             int count = 0;

            try{ Scanner input = new Scanner(file);


             while (input.hasNext()) {
               int i = 0;
               String word = input.next();
               if (keywordSet.contains(word)){
                 arrayNesting = addOneElement(arrayNesting);
                 arrayNesting[i] = word;
                 i++;
              }//End contains if
            }
            //End While
         }//end try
         catch(FileNotFoundException e){}

            for(int j = 0; j == arrayNesting.length; j++){
               if(arrayNesting[j] == ")" || arrayNesting[j] == "}" || arrayNesting[j] == "]" ){
                  //activate system to actually pass or fail the brace nesting
                  arrayNesting = checkNesting(arrayNesting, j);
               }//End if
            }//End for
             if(arrayNesting.length == 0){
                System.out.println(arrayNesting.length);
                correctness = true;
             }
             else{
                correctness = false;
             }
             System.out.println("Correctness: "+correctness);
             passFail = correctness;
             if (passFail == true){
                System.out.println("The File is properly nested");
             }//End passFail if
             else{
                System.out.println("The File is Horribly Arranged!!!!");
             }//End else
           }//End file exists if
           else {
             System.out.println("File " + file + " does not exist");
          }//End else
       }//Ends for
    }//End Main


     public static String[] addOneElement(String[] arrayNesting1){
        System.out.println("addOneElement called");
        String[] arrayNestingAdd = new String[arrayNesting1.length + 1];
        java.lang.System.arraycopy(arrayNesting1, 0, arrayNestingAdd, 0, arrayNesting1.length);
        //arraycopy(arrayNestingAdd, 0, arrayNesting1, 0, arrayNesting, arrayNestingAdd.length);
        return arrayNestingAdd;
     }//end addOneElement method

     public static String[] checkNesting(String[] array, int found){
        System.out.println("checkNesting called");
        String symbolopen = array[found];
        String symbol = "";
        if (symbolopen == ")"){
           symbol = "(";
        }//End if
        else{
           if(symbolopen == "}"){
             symbol = "{";
          }//end if
             else{
                symbol = "[";
             }//End else
          }//end else
        if (array[found-1] == symbol){
           //return array minus symbols at index found & at found-1
           array = removeIndex(array, found);
           array = removeIndex(array, (found - 1));
        }//end if
        return array;
     }//End checkNesting method
    public static String[] removeIndex(String[] arrayRemove, int index){
      System.out.println("removeIndex called");
      String[] arrayCopy = new String[arrayRemove.length + 1];
      java.lang.System.arraycopy(arrayRemove, 0, arrayCopy, 0, (index - 1));
      java.lang.System.arraycopy(arrayRemove, (index + 1), arrayCopy, index, arrayRemove.length);
      return arrayCopy;
   }//end removeIndex method

}//Ends Exercise20_11
