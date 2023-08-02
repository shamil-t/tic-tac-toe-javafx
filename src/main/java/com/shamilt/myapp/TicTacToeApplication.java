package com.shamilt.myapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToeApplication extends Application {
    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TicTacToeApplication.class.getResource("TicTacToe-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);

        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();

    }
}