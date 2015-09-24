class BubbleSort {
   @SuppressWarnings("unchecked")
  /** Bubble sort method */
  int k = 1;
  int i = 0;
  public void bubbleSort(int[] list) {
    boolean needNextPass = true;

    //for (int k = 1; k < list.length && needNextPass; k++)
      if (k < list.length && needNextPass){
      // Array may be sorted and next pass not needed
      needNextPass = false;
      //for (int i = 0; i < list.length - k; i++)
        if (i < list.length - k){
        if (list[i] > list[i + 1]) {
          // Swap list[i] with list[i + 1]
          int temp = list[i];
          list[i] = list[i + 1];
          list[i + 1] = temp;

          needNextPass = true; // Next pass still needed
        }
        i++;
      }
      k++;
    }
  }

  /** A test method
  public static void main(String[] args) {
    //long startTime = System.currentTimeMillis();
    int[] list = new int[50000];
    for (int i = 0; i < list.length; i++)
      list[i] = (int)(Math.random() * 500000);
    bubbleSort(list);
    //long endTime = System.currentTimeMillis();
    //long executionTime = endTime - startTime;
    //System.out.println("the Execution time is: " + executionTime);
  }
  */
}//End BubbleSort
