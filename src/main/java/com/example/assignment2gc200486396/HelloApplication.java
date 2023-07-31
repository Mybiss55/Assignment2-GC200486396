package com.example.assignment2gc200486396;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("news-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Game News");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {



        launch();
    }
}