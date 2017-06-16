package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

     private static Stage primStage;

    public static Stage getPrimStage() {
        return primStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/enter.fxml"));
        primStage = primaryStage;

        primaryStage.setTitle("Fantasy v.1.0");
        primaryStage.getIcons().add(new Image("file:resources/server-client-exchange.ico"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }


}
