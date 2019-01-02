package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class Controller {

    public Label helloWorld;
    public Label clicks;

    private static int Variable;

    public int getVariable(){
        return Variable;
    }

    public void setVariable(int Variable){
        this.Variable = Variable;
    }
    public void sayHelloWorld(ActionEvent actionEvent) {
        Variable++;
        helloWorld.setText("Hello World!");
        clicks.setText("You have clicked this button " + Variable + " times");

    }


}
