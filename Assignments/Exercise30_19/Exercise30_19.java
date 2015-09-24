
import java.io.*;
import java.util.*;
import java.lang.*;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.concurrent.*;
import javafx.scene.layout.HBox;
import java.lang.InterruptedException;
import javafx.scene.control.Label;

/*

In honor to the graders' poor computer. May your CPU rest in pieces.
For thus shalt your CPU be rendered into goo under the burden of this code.


*A moment of Silence in honor of it's tribute....*


*/

public class Exercise30_19 extends Application{
   public void repaint(HistogramPane pane, int[] numbers) {
     // Find maximum integer
     int max = numbers[0];
     for (int i = 1; i < numbers.length; i++) {
      if (max < numbers[i]) {
         max = numbers[i];
      }
     }

     pane.getChildren().clear();

     double height = 150;
     double width = 215;
     double unitWidth = width * 1.0 / numbers.length;
     for (int i = 0; i < numbers.length; i++) {
      Rectangle bar =  new Rectangle(i * unitWidth + 10, pane.getHeight()
         - (numbers[i] * 1.0 / max) * height, unitWidth, (numbers[i] * 1.0 / max) * height);
      bar.setFill(Color.WHITE);
      bar.setStroke(Color.BLACK);
      pane.getChildren().add(bar);
      //this.getChildren().add(new Text(i * unitWidth + 10 + 10,
     //    getHeight() - (numbers[i] * 1.0 / max) * height - 10,
     //    numbers[i] + ""));
     }

     if (pane.coloredBarIndex >= 0) {
      int i = pane.coloredBarIndex;
      Rectangle filledRectangle = new Rectangle(i * unitWidth + 10, pane.getHeight()
         - (numbers[i] * 1.0 / max) * height, unitWidth, (numbers[i] * 1.0 / max) * height);
      filledRectangle.setFill(Color.RED);
      pane.getChildren().add(filledRectangle);
     }
  }//End Repaint

   public static void main(String[] args) {
       launch(args);
   }//End main

   @Override
   public void start(Stage primaryStage){
      HistogramPane pane = new HistogramPane();
      SelectionSort selection = new SelectionSort();
      //HeapSort heap = new HeapSort();
      InsertionSort insert = new InsertionSort();
      QuickSort quick = new QuickSort();
      BubbleSort bubble = new BubbleSort();

      HistogramPane selectionpane = new HistogramPane();
      //HistogramPane heappane = new HistogramPane();
      HistogramPane insertpane = new HistogramPane();
      HistogramPane quickpane = new HistogramPane();
      HistogramPane bubblepane = new HistogramPane();

      Label selectionlbl = new Label("Selection Sort");
      //Label heaplbl = new Label("Heap Sort");
      Label insertlbl = new Label("Insertion Sort");
      Label quicklbl = new Label("Quick Sort");
      Label bubblelbl = new Label("Bubble Sort");

      selectionpane.setStyle("-fx-border-color: black");
      //heappane.setStyle("-fx-border-color: black");
      insertpane.setStyle("-fx-border-color: black");
      quickpane.setStyle("-fx-border-color: black");
      bubblepane.setStyle("-fx-border-color: black");

      selectionpane.getChildren().addAll(selectionlbl);
      //heappane.getChildren().addAll(heaplbl);
      insertpane.getChildren().addAll(insertlbl);
      quickpane.getChildren().addAll(quicklbl);
      bubblepane.getChildren().addAll(bubblelbl);

      GridPane gridpane = new GridPane();
      gridpane.add(selectionpane, 1, 0);
      //gridpane.add(heappane, 1, 1);
      gridpane.add(insertpane, 2, 0);
      gridpane.add(quickpane, 2, 1);
      gridpane.add(bubblepane, 1, 2);


/*
      Button btStep = new Button("Step");
      Button btReset = new Button("Reset");
*/
      HBox hBox = new HBox(5);
      //hBox.getChildren().addAll(btStep);
      hBox.setAlignment(Pos.CENTER);

      BorderPane borderPane = new BorderPane();
      borderPane.setCenter(gridpane);
      Label lblStatus = new Label();
      borderPane.setTop(lblStatus);
      BorderPane.setAlignment(lblStatus, Pos.CENTER);

      // Create a scene and place it in the stage
      Scene scene = new Scene(borderPane, 400, 250);
      primaryStage.setTitle("Exercise23_16"); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage

      StepControl control = new StepControl();
/*      borderPane.setNumbers(control.getArray());

      borderPane.widthProperty().addListener(ov -> borderPane.repaint());
      borderPane.heightProperty().addListener(ov -> borderPane.repaint());
*/
int[] list = control.initializeNumbers();
final int[] selectlist = list;
final int[] heaplist = list;
final int[] bubblelist = list;
final int[] insertlist = list;
final int[] quicklist = list;




/*


      Task select_Task = new Task<Void>()
      {
        @Override
        public Void call() throws InterruptedException
        {
          while(true)
          {
            //MergeSort.mergeSort(mergeList);
            Platform.runLater(() ->
            {
              //repaint(mergeSortpane, mergeList);
            });
            Thread.sleep(50);
          }
        }
      };
*/
Task select_Task = new Task<Void>()
{
 @Override
 public Void call() throws InterruptedException
 {
    int[] selectlist2 = selectlist;
    while(true)
    {
      selection.selectionSort(selectlist2);
      Platform.runLater(() ->
      {
        repaint(selectionpane, selectlist2);
      });
      Thread.sleep(50);
    }
 }
};

Task bubble_Task = new Task<Void>()
{
 @Override
 public Void call() throws InterruptedException
 {
    int[] bubblelist2 = bubblelist;
    while(true)
    {
      bubble.bubbleSort(bubblelist2);
      Platform.runLater(() ->
      {
        repaint(bubblepane, bubblelist2);
      });
      Thread.sleep(50);
    }
 }
};
Task insert_Task = new Task<Void>()
{
 @Override
 public Void call() throws InterruptedException
 {
    int[] insertlist2 = insertlist;
    while(true)
    {
      insert.insertionSort(insertlist2);
      Platform.runLater(() ->
      {
        repaint(insertpane, insertlist2);
      });
      Thread.sleep(50);
    }
 }
};
Task quick_Task = new Task<Void>()
{
 @Override
 public Void call() throws InterruptedException
 {
    int[] quicklist2 = quicklist;
    while(true)
    {
      quick.quickSort(quicklist2);
      Platform.runLater(() ->
      {
        repaint(quickpane, quicklist2);
      });
      Thread.sleep(50);
    }
 }
};





      while(control.step()){
//        pane.setColoredBarIndex(control.getCurrentIndex());
     }
      lblStatus.setText("The array is sorted!");
      //Creates on action listener to sort through the given array
/*
      btStep.setOnAction(e -> {
        if (control.step())
          pane.setColoredBarIndex(control.getCurrentIndex());
        else
          lblStatus.setText("The array is sorted!");
      });
*/

   }//End Start
   class StepControl {
     public final int ARRAY_SIZE = 50;
     private int[] list = new int[ARRAY_SIZE];

     public int[] getArray() {
       return list;
     }
     public void setArray(int[] l) {
       list = l;
    }

     StepControl() {
       initializeNumbers();
     }

     public int[] initializeNumbers() {
       for (int i = 0; i < list.length; i++) {
        list[i] = i + 1;
       }

       // Random shuffle
       for (int i = 0; i < list.length; i++) {
        int index = (int) (Math.random() * ARRAY_SIZE);
        int temp = list[i];
        list[i] = list[index];
        list[index] = temp;
       }
      return list;
     }

     private int i = 1;
     private int j = 0;

     public int getCurrentIndex() {
       return j;
     }
  /*
     public void reset() {
       i = 1;
       j = 0;
       initializeNumbers();
     }
  */

     public boolean step() {

       if (i >= list.length)
        return false;

       if (j < list.length - i) {
        if (list[j] > list[j + 1]) {
           // Swap list[i] with list[i + 1]
           int temp = list[j];
           list[j] = list[j + 1];
           list[j + 1] = temp;
        }
        j++;
       }
       else {
        i++;
        j = 0;
       }

       return true;
     }
   }

}//End Exercise
