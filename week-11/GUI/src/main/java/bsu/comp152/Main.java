package bsu.comp152;

import com.sun.javafx.stage.EmbeddedWindow;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        //Create Label to display prompt
        Label messageLabel = new Label("Enter a color:");
        //Create Button to perform color change
        Button colorButton = new Button("Change Color");
        //Register the event handler
        //colorButton.setOnAction(new ButtonClickHandle());

        Circle circle = new Circle(150.0f, 150.0f, 80.f);
        Group group = new Group(circle);
        Scene circleScene = new Scene(group, 500, 300);
        Stage colorStage = null;
        colorStage.setScene(circleScene);
        colorStage.show();

        VBox vbox = new VBox(messageLabel);
        Scene scene = new Scene(vbox, 300, 100);
        vbox.setAlignment(Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GUI with Circle");
        primaryStage.show();
    }
}
