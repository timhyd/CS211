//Test method for GenericStack.java for Exercise 19_1
//Timothy Hydanus
public class Exercise19_1 {
   public static void main(String[] args) {
      System.out.println("Here You can observe the Modified GenericStack Class in action.");
      GenericStack<String> stack1 = new GenericStack<>();
      System.out.println("Here we are going to add the words: London, Paris, and Berlin");
      stack1.push("London");
      stack1.push("Paris");
      stack1.push("Berlin");
      System.out.println("Here we see the array put into a String");
      System.out.println(stack1.toString());
      System.out.println("And finally we can display that array without the last element");
      stack1.pop();
      System.out.println(stack1.toString());
   }
}
