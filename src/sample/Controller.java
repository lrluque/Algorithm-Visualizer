package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

public class Controller implements Initializable {
    private int[] array;

    @FXML
    private CategoryAxis arrayPositionAxis;

    @FXML
    private NumberAxis arrayValueAxis;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private AnchorPane canvas;

    @FXML
    private Button newArrayButton;

    @FXML
    private Button startButton;

    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void draw(){
        barChart.getData().clear();
        barChart.setAnimated(false);
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        for (int i = 0; i < 10; i++) {
            series.getData().add(new XYChart.Data<>(Integer.toString(i), array[i]));
        }

        barChart.getData().add(series);
    }

    public void drawChart(ActionEvent actionEvent) {
        barChart.setAnimated(false);
        barChart.getData().clear();
        array = new int[10];

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        for (int i = 0; i < 10; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 10);
            array[i] = randomNum;
            series.getData().add(new XYChart.Data<>(Integer.toString(i), randomNum));
        }

        barChart.getData().add(series);
    }

    public void start(ActionEvent actionEvent) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = key;
        }
        draw();
    }
}
