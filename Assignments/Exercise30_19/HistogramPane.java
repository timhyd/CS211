
import java.io.*;
import java.util.*;
import java.lang.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.concurrent.Task;
import javafx.scene.layout.HBox;
import java.lang.InterruptedException;

class HistogramPane extends Pane {
  private int[] numbers;
  int coloredBarIndex = -1;

  public void setNumbers(int[] numbers) {
    this.numbers = numbers;
    //repaint(this, numbers);
  }

  public void setColoredBarIndex(int index) {
    coloredBarIndex = index;
    //repaint(this, numbers);
  }


/*
  public void repaint() {
    // Find maximum integer
    int max = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      if (max < numbers[i]) {
        max = numbers[i];
      }
    }

    this.getChildren().clear();

    double height = getHeight() * 0.88;
    double width = getWidth() - 20;
    double unitWidth = width * 1.0 / numbers.length;
    for (int i = 0; i < numbers.length; i++) {
      Rectangle bar =  new Rectangle(i * unitWidth + 10, getHeight()
        - (numbers[i] * 1.0 / max) * height, unitWidth, (numbers[i] * 1.0 / max) * height);
      bar.setFill(Color.WHITE);
      bar.setStroke(Color.BLACK);
      this.getChildren().add(bar);
      //this.getChildren().add(new Text(i * unitWidth + 10 + 10,
    //    getHeight() - (numbers[i] * 1.0 / max) * height - 10,
    //    numbers[i] + ""));
    }

    if (coloredBarIndex >= 0) {
      int i = coloredBarIndex;
      Rectangle filledRectangle = new Rectangle(i * unitWidth + 10, getHeight()
        - (numbers[i] * 1.0 / max) * height, unitWidth, (numbers[i] * 1.0 / max) * height);
      filledRectangle.setFill(Color.RED);
      this.getChildren().add(filledRectangle);
    }

  }
  */
}
