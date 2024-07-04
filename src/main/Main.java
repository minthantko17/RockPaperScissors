package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.view.DisplayPane;
import main.view.SelectionPane;

public class Main extends Application {
    public static void main(String[] args) {
        // System.out.println("java vesion: "+ System.getProperty("java.version"));
        // System.out.println("javafx version: "+ System.getProperty("javafx.runtime.version"));
        // System.out.println("Module Path: " + System.getProperty("jdk.module.path"));
        // System.out.println("Classpath: " + System.getProperty("java.class.path"));
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        SelectionPane sp= new SelectionPane();
        sp.drawPane();

        BorderPane borderPane=new BorderPane();
        borderPane.setBottom(sp);
        borderPane.setTop(DisplayPane.displayLabel);

        Scene scene = new Scene(borderPane,301,400);
        stage.setScene(scene);
        stage.show();
    }

}
