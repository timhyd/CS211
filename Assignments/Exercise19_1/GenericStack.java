import java.util.Arrays;

public class GenericStack<E> {
  //private java.util.ArrayList<E> list = new java.util.ArrayList<>();

   private Object[] list = new Object[1];

  public int getSize() {
    return list.length;
  }

  //This added method checks the last index of the array to see if there is space.
  //If so it doubles the size of the Array
  public void checkSize() {
     int size = getSize();
     if (size == 1){}else{
     int newSize = (2*size);
     if (newSize <= 2){
        newSize = 2;
     }
     if(list[size-1] == null){
        Object[] newArray = new Object[newSize];
        System.arraycopy(list, 0, newArray, 0, size);
        System.arraycopy(newArray, 0, list, 0, newSize);
     }}
 }

  public void push(E o) {
    checkSize();
    if (getSize == 1){
      list[0] = o;
   }
   else{
    Object[] newArray = new Object[list.length+1];
    System.arraycopy(list, 0, newArray, 0, list.length);
    newArray[list.length+1] = o;
    System.arraycopy(newArray, 0, list, 0, newArray.length);
    }
}


  public Object pop() {
    Object[] o = new Object[list.length-1];
    System.arraycopy(list, 0, o, 0, (list.length-1));
    return o;
  }

  public boolean isEmpty() {
    //return list.isEmpty();
    if (list.length == 0){
      return true;
   }//End if statement
   else{
      return false;
   }//End else statement
}//End isEmpty

  @Override
  public String toString() {
/*
  private arrayString = "";
     for(int i = 0; i<getSize; i++){

     }
*/
	return "stack: " + list.toString();
  }
}
