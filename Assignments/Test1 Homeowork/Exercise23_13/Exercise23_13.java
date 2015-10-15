
import java.io.*;
import java.util.*;
import java.lang.*;
/*
In honor to the graders poor computer. May your CPU rest in pieces.
For thus shalt your CPU be rendered under the burden of this code.


*A moment of Silence in honor of it's tribute....*


*/


public class Exercise23_13{

public static void main(String[] args) {

int heapSize;

int[] a = new int[1];

int[] intOne = new int[50000];
int[] orgIntOne = new int[50000];
for(int i = 0; i < intFive.length; i++){
   intOne[i] = (int)(Math.random() * 100000);
   orgIntOne[i] = intOne[i];
}
int[] intTwo = new int[100000];
int[] orgIntTwo = new int[100000];
for(int i = 0; i < intFour.length; i++){
   intTwo[i] = (int)(Math.random() * 100000);
   orgIntTwo[i] = intTwo[i];
}
int[] intThree = new int[150000];
int[] orgIntThree = new int[150000];
for(int i = 0; i < intThree.length; i++){
   intThree[i] = (int)(Math.random() * 100000);
   orgIntThree[i] = intThree[i];
}
int[] intFour = new int[200000];
int[] orgIntFour = new int[200000];
for(int i = 0; i < intFour.length; i++){
   intFour[i] = (int)(Math.random() * 100000);
   orgIntFour[i] = intFour[i];
}
int[] intFive = new int[250000];
int[] orgIntFive = new int[250000];
for(int i = 0; i < intFive.length; i++){
   intFive[i] = (int)(Math.random() * 100000);
   orgIntFive[i] = intFive[i];
}
int[] intSix = new int[300000];
int[] orgIntSix = new int[30000];
for(int i = 0; i < intSix.length; i++){
   intSix[i] = (int)(Math.random() * 100000);
   orgIntSix[i] = intSix[i];
}

/*
Obtain Execution time:
long startTime = System.currentTimeMillis();
perform the task
long endTime = System.currentTimeMillis();
long executionTime = endTime - startTime;
*/



String rowOne = ("");
String rowTwo = ("");
String rowThree = ("");
String rowFour = ("");
String rowFive = ("");
String rowSix = ("");
System.out.println("Size \t\t|\t\t Selection Sort \t\t|\t\t Insertion Sort \t\t|\t\t mergeSort \t\t|\t\t");

System.out.print("50,000  \t|");
analize(intOne);
System.out.print("100,000 \t|");
analize(intTwo);
System.out.print("150,000 \t|");
analize(intThree);
System.out.print("200,000 \t|");
analize(intFour);
System.out.print("250,000 \t|");
analize(intFive);
System.out.print("300,000 \t|");
analize(intSix);

}//End main


public static void analize(int[] intOne){
   long startTime = System.currentTimeMillis();
   long endTime = System.currentTimeMillis();
   long executionTime = endTime - startTime;
//SelectionSort
startTime = System.currentTimeMillis();
selectionSort(intOne);
endTime = System.currentTimeMillis();
executionTime = endTime - startTime;
String rowOne = ("\t\t" + executionTime + "\t\t|");


//insertionSort
startTime = System.currentTimeMillis();
insertionSort(intOne);
endTime = System.currentTimeMillis();
executionTime = endTime - startTime;
rowOne += "\t\t" + executionTime + "\t\t|";


//BubbleSort
startTime = System.currentTimeMillis();
//bubbleSort(intOne);
endTime = System.currentTimeMillis();
executionTime = endTime - startTime;
//rowOne += "\t\t" + executionTime + "\t\t|");


//MergeSort
startTime = System.currentTimeMillis();
mergeSort(intOne);
endTime = System.currentTimeMillis();
executionTime = endTime - startTime;
rowOne += "\t\t" + executionTime + "\t\t|";


//Quick Sort
startTime = System.currentTimeMillis();
//Quicksort(intOne);
endTime = System.currentTimeMillis();
executionTime = endTime - startTime;
//rowOne += "\t\t" + executionTime + "\t\t|");

//HeapSort
startTime = System.currentTimeMillis();
//HEAP_SORT(intOne);
endTime = System.currentTimeMillis();
executionTime = endTime - startTime;
//rowOne += "\t\t" + executionTime + "\t\t|");


//radixSort
startTime = System.currentTimeMillis();
//radixSort(intOne);
endTime = System.currentTimeMillis();
executionTime = endTime - startTime;
//rowOne += "\t\t" + executionTime + "\t\t|");


startTime = System.currentTimeMillis();
insertionSort(intOne);
endTime = System.currentTimeMillis();
executionTime = endTime - startTime;
rowOne += "\t\t" + executionTime + "\t\t|";

System.out.println(rowOne);
}//End analize

static void mergeSort(int num[])
    {	int size = num.length;  // size of array holding the numbers to be sorted
        if (size <= 1)  // base step
	{   //return num;
	}
	else  // recursive step
	{   int mid = size / 2;
	    int firstHalf[] = new int[mid];
	    int secondHalf[] = new int[size - mid];
	    // Copy first half of the array
	    for (int i = 0; i < mid; i++)
	    {	firstHalf[i] = num[i];
	    }
	    // Copy second half of the array
	    for (int i = mid; i < size; i++)
	    {	secondHalf[i - mid] = num[i];
	    }
	    //return merge(mergeSort(firstHalf), mergeSort(secondHalf));
	}
    }

public static void radixSort( int[] a)
     {
         int i, m = a[0], exp = 1, n = a.length;
         int[] b = new int[10];
         for (i = 1; i < n; i++)
             if (a[i] > m)
                 m = a[i];
         while (m / exp > 0)
         {
             int[] bucket = new int[n];

             for (i = 0; i < n; i++)
                 bucket[(a[i] / exp) % 10]++;
             for (i = 1; i < 10; i++)
                 bucket[i] += bucket[i - 1];
             for (i = n - 1; i >= 0; i--)
                 b[--bucket[(a[i] / exp) % 10]] = a[i];
             for (i = 0; i < n; i++)
                 a[i] = b[i];
             exp *= 10;
         }
     }//End radexsort

static void selectionSort(int[] list) {
  for (int i = list.length - 1; i >= 1; i--) {
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
  }
}//End selectionSort

public static void insertionSort(int[] list) {
  for (int i = 1; i < list.length; i++) {
    /** insert list[i] into a sorted sublist list[0..i-1] so that
         list[0..i] is sorted. */
    int currentElement = list[i];
    int k;
    for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
      list[k + 1] = list[k];
    }

    // Insert the current element into list[k+1]
    list[k + 1] = currentElement;
  }
}
/*
public static void swap(int left,int right){
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
public static void bubbleSort(int[] number) {
           boolean swapped = true;
           int last = number.length - 2;

           // only continue if swapping of number has occurred
           while (swapped) {
               swapped = false;

               for (int i = 0; i <= last; i++) {
                   if (number[i] > number[i + 1]) {

                       // pair is out of order, swap them
                       swap(number, i, i + 1);

                       swapped = true; // swapping occurred
                   }
               }
               last--;
           }
       }//End bubbleSort
*/



}//End Exercise
