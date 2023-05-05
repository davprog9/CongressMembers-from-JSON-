package org.example;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;


// Creating a class - always extend it with Application if trying to build an GUI program/code.
public class GuiFXML extends Application {

    // We call the main function, so it can launch our interface program, but it is not important to do.
    public static void main(String[] args) {
        launch(args);
    }


    // We always start with our STAGE. A stage is the box where our scene will go in, and all our GUI buttons, text fields and many features will go into scene.
    public void start(Stage stage){

        stage.setWidth(700);
        stage.setHeight(600);
        stage.setMinWidth(500);
        stage.setMinHeight(400);
        stage.setTitle("CongressMembers GUI");


        // We declare our FXMLLoader, so we can work with our sceneBuilder, and we attach it to a FXML file so we can open the scene builder from there.
        FXMLLoader loader;
        loader = new FXMLLoader(GuiFXML.class.getResource("/Controller_GUI.fxml"));

        // We always need to have a top level container which will hold a scene in it, and we always call that container root.
        // In our case, our root is the AnchorPane root object, we need it to put the scene into that.
        try{
            AnchorPane root = loader.load();

            Scene loadedScene = new Scene(root);
            stage.setScene(loadedScene);

            stage.show();

        }catch(IOException e){
            System.err.println(e.getMessage());
            stage.close();
        }

    }

}
