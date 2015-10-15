import java.util.*;
import java.io.*;
import java.lang.*;

public class Exercise20_11 {
    public static void main (String[] args) {
        for (String s: args) {
           File file = new File(s);
           if (file.exists()) {
             //System.out.println("The number of keywords in " + filename + " is " +
             boolean passFail=countKeywords(file);
             if (passFail){==
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

      public static boolean countKeywords(File file) throws Exception {
        // Array of all Java keywords + true, false and null
        boolean correctness = true;
        String[] arrayNesting = new String[0];

        String[] keywordString = {"{", "}", "[", "]", "(", ")"};

        Set<String> keywordSet =
          new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        Scanner input = new Scanner(file);

        while (input.hasNext() && correctness) {
          int i = 0;
          String word = input.next();
          if (keywordSet.contains(word)){
            arrayNesting = addOneElement(arrayNesting);
            arrayNesting[i] = word;
            i++;
         }//End contains if
       }//End While



        return correctness;
     }//Ends count keywords Method
     public static String[] addOneElement(String[] arrayNesting1){
        String[] arrayNestingAdd = new String[arrayNesting.length + 1];
        arraycopy(arrayNesting1, 0, arrayNestingAdd, 0, arrayNesting1.length);
        //arraycopy(arrayNestingAdd, 0, arrayNesting1, 0, arrayNesting, arrayNestingAdd.length);
        return arrayNestingAdd;
     }//end addOneElement method

     public static boolean checkNesting(String[] array){

     }//End checkNesting method

}//Ends Exercise20_11
