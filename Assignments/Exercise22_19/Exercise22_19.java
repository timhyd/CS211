import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;


public class Exercise22_19 extends Application
{
  @Override
  public void start(Stage primaryStage)
  {
    GridPane gridpane = new GridPane();
    Button resetButton = new Button("Reset");
    Button findButton = new Button("Find Largest Block");

    HBox hBox = new HBox(10);
    hBox.getChildren().addAll(resetButton, findButton);
    hBox.setAlignment(Pos.CENTER);

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridpane);
    borderPane.setBottom(hBox);

    Scene scene = new Scene(borderPane, 300, 300);
    primaryStage.setTitle("Exercise18_35"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    TextField[][] matrixFields = new TextField[10][10];
    int[][] matrix = new int[10][10];
    for (int i = 0; i < 10; i++) {
     for (int j = 0; j < 10; j++) {
         if(Math.random() < 0.5){
            matrix[i][j] = 1;
            matrixFields[i][j] = new TextField((int)(1) + "");
         }
         else{
            matrix[i][j] = 0;
            matrixFields[i][j] = new TextField((int)(0) + "");
         }
         matrixFields[i][j].setPrefColumnCount(1);
         gridpane.add(matrixFields[i][j], j, i);
     }
   }

   findButton.setOnAction((ActionEvent e) -> {
         for (int i = 0; i < matrixFields.length; i++)
           for (int j = 0; j < matrixFields[i].length; j++) {

             if (matrixFields[i][j].getText().trim().length() == 0) {
                matrixFields[i][j].setPrefColumnCount(1);
              gridpane.add(matrixFields[i][j], j, i);
               return;
             }
             else
               matrix[i][j] = Integer.parseInt(matrixFields[i][j].getText().trim());
           }

     Square sq = getLargestSquare(matrix);
     for(int i = sq.getEX(); i < (sq.getDegree()-1); i++){
        for (int j = sq.getWhy(); j < (sq.getDegree()-1); j++){
           Rectangle squareLoc = new Rectangle(5,5);
           //squareLoc.setStroke();
           gridpane.add(squareLoc, j, i);


         // matrixFields[i][j].setStyle("-fx-background: red");
         //  matrixFields[i][j].setPrefColumnCount(1);
         // gridpane.add(matrixFields[i][j], j, i);
        }
     }

     System.out.println("Largest square: " + sq);
 });

   resetButton.setOnAction((ActionEvent e) -> {
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
           if(Math.random() < 0.5){
              matrix[i][j] = 1;
              matrixFields[i][j] = new TextField((int)(1) + "");
              matrixFields[i][j].setStyle("-fx-background: white");
           }
           else{
              matrix[i][j] = 0;
              matrixFields[i][j] = new TextField((int)(0) + "");
              matrixFields[i][j].setStyle("-fx-background: white");
           }
           matrixFields[i][j].setPrefColumnCount(1);
           gridpane.add(matrixFields[i][j], j, i);
        }
     }
   });

  }

    private static final class Square
    {
        private final int x, y, size;

        public Square(int x, int y, int size)
        {
            super();
            this.x = x;
            this.y = y;
            this.size = size;
        }

        @Override
        public String toString()
        {
            return String.format("Square at (%d,%d) is size %d", x, y, size);
        }
        public int getEX(){
           return this.x;
        }
        public int getWhy(){
           return this.y;
        }
        public int getDegree(){
           return this.size;
        }

    }

    public static void main(String[] args)
    {

        launch(args);
    }

    private static Square getLargestSquare(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0)
        {
            return null;
        }

        final int height = matrix.length;
        final int width = matrix[0].length;

        Square max = null;


        int[] previous = null;
        int[] current = matrix[0];

        for (int y = 1; y < height; y++)
        {

            previous = current;
            current = new int[width];
            for (int x = 0; x < width; x++)
            {
                if (matrix[y][x] == 1)
                {
                    int span = 1;
                    if (x > 0)
                    {

                        span = 1 + Math.min(current[x - 1], Math.min(previous[x], previous[x - 1]));
                    }
                    if (max == null || span > max.size)
                    {

                        max = new Square(x - span + 1, y - span + 1, span);
                    }
                    current[x] = span;
                }
            }
        }
        return max;
    }

}
