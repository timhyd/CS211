public class SelectionSort{
   int i = 10000;
   public int[] selectionSort(int[] list) {
     //for (int i = list.length - 1; i >= 1; i--)
       if (i == 10000){
          i = list.length;
       }
       if(i >= 1){

       // Find the maximum in the list[0..i]
       int currentMax = list[0];
       int currentMaxIndex = 0;

       for (int j = 1; j <= i; j++) {
         if (currentMax < list[j]) {
           currentMax = list[j];
           currentMaxIndex = j;
         }
       }

       // Swap list[i] with list[currentMaxIndex] if necessary;
       if (currentMaxIndex != i) {
         list[currentMaxIndex] = list[i];
         list[i] = currentMax;
       }
       i--;
     }
     return list;
   }//End selectionSort
}
