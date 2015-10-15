class InsertionSort {
   @SuppressWarnings("unchecked")
   int i = 1;
  /** The method for sorting the numbers */
  public void insertionSort(int[] list) {
   //long startTime = System.currentTimeMillis();
    //for (int i = 1; i < list.length; i++)
      if (i < list.length){
      /** insert list[i] into a sorted sublist list[0..i-1] so that
           list[0..i] is sorted. */
      int currentElement = list[i];
      int k;
      for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
        list[k + 1] = list[k];
      }

      // Insert the current element into list[k+1]
      list[k + 1] = currentElement;
      i++;
   }//End of each step of for loop
    /*
    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    System.out.println(executionTime);
    */
  }
}//End InsertionSort
