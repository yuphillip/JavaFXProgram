package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    class timerclass {
        Timer timer1;
        private int timecounter = 0;

        TimerTask Task1 = new TimerTask() {
            @Override
            public void run() {
                setTimecounter(getTimecounter()+1);
            }
        };

        public timerclass(){
            timer1 = new Timer();

        }

        public int getTimecounter() {
            return timecounter;
        }

        public void setTimecounter(int timecounter) {
            this.timecounter = timecounter;
        }
    }
}
