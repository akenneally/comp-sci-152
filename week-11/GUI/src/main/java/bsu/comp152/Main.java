package bsu.comp152;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

import java.util.Locale;

public class Main extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        var vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(15);
        var hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(15);
        Scene scene = new Scene(vBox, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GUI with Circle");

        //Popup for when invalid color is entered
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Incorrect response type.");
        alert.setHeaderText("Please try again with a color.");
        alert.setContentText("Examples: teal, red, blue");

        //Create Label to display prompt
        Label messageLabel = new Label("Enter a color:");

        //Create Text Field to display prompt
        var myTextField = new TextField();

        //Create circle to display
        Circle colorCircle = new Circle(100, Color.PURPLE);
        //colorCircle(new Insets(15,15,15,15));

        //Create Button to perform color change
        Button colorButton = new Button("Change Color");
        colorButton.setOnAction(event -> {
            try {
                var f = Color.class.getField(myTextField.getText().toUpperCase(Locale.ROOT));
                colorCircle.setFill((Color) f.get(null));
            } catch (Exception e) {
                alert.show();
            }
        });

        hBox.getChildren().add(messageLabel);
        hBox.getChildren().add(myTextField);
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(colorButton);
        vBox.getChildren().add(colorCircle);

        primaryStage.show();
    }
}
