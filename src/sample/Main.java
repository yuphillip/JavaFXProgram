package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 475));
        primaryStage.show();
       long timeStep;
       boolean scoring = true;
       int clicked = 0;

            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

            primaryStage.setTitle("Hello World");
            Button button1 = new Button("0");

            Label label1 = new Label("time:");
            HBox theBox = new HBox(button1, label1);
            theBox.setSpacing(20);
            //Text txt = new Text(10,0,"Click Score");
            primaryStage.setScene(new Scene(theBox, 300, 275));
            primaryStage.show();
            timeStep = System.nanoTime() + 10000000000L;

            new AnimationTimer() {
                public void handle(long now) {
                    if (now > timeStep) {
                        timeStep = now + 10000000000L;
                        scoring = !scoring;
                    }
                    if (!scoring) {
                        button1.setText("Amount of clicks:" + clicked);


                    } else {
                        button1.setText("timer active");

                    }
                    // txt.setText("Score:" + Integer.toString(score));

                }
            }.start();

            button1.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent actionEvent) {
                    clicked++;
                    button1.setText(String.valueOf(clicked));
                }
            });

        }


    }

}
