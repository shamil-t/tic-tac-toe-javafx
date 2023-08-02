package com.shamilt.myapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TicTacToeController {

    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public Button btn5;
    public Button btn6;
    public Button btn7;
    public Button btn8;
    public Button btn9;
    public Label cpText;

    Map<Integer, String> map = new HashMap<>();
    int currentPlayer = 0;
    int round = 0;

    public void resetGame() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        btn1.setDisable(false);
        btn2.setDisable(false);
        btn3.setDisable(false);
        btn4.setDisable(false);
        btn5.setDisable(false);
        btn6.setDisable(false);
        btn7.setDisable(false);
        btn8.setDisable(false);
        btn9.setDisable(false);

        currentPlayer = 0;
        round = 0;
        cpText.setText("Player 1 (X)");
        map.clear();
    }

    public void onBtnClick(ActionEvent actionEvent) {
        Node btn = (Node) actionEvent.getSource();
        int btnId = Integer.parseInt(btn.getId().replace("btn", ""));
        System.out.println(btnId);

        switch (btnId) {
            case 1 -> {
                if (currentPlayer == 0)
                    btn1.setText("X");
                else btn1.setText("O");
                btn1.setDisable(true);

            }
            case 2 -> {
                if (currentPlayer == 0)
                    btn2.setText("X");
                else btn2.setText("O");
                btn2.setDisable(true);
            }
            case 3 -> {
                if (currentPlayer == 0)
                    btn3.setText("X");
                else btn3.setText("O");
                btn3.setDisable(true);
            }
            case 4 -> {
                if (currentPlayer == 0)
                    btn4.setText("X");
                else btn4.setText("O");
                btn4.setDisable(true);
            }
            case 5 -> {
                if (currentPlayer == 0)
                    btn5.setText("X");
                else btn5.setText("O");
                btn5.setDisable(true);
            }
            case 6 -> {
                if (currentPlayer == 0)
                    btn6.setText("X");
                else btn6.setText("O");
                btn6.setDisable(true);
            }
            case 7 -> {
                if (currentPlayer == 0)
                    btn7.setText("X");
                else btn7.setText("O");
                btn7.setDisable(true);
            }
            case 8 -> {
                if (currentPlayer == 0)
                    btn8.setText("X");
                else btn8.setText("O");
                btn8.setDisable(true);
            }
            case 9 -> {
                if (currentPlayer == 0)
                    btn9.setText("X");
                else btn9.setText("O");
                btn9.setDisable(true);
            }
        }

        map.put(btnId, currentPlayer == 0 ? "X" : "O");
        round++;
//        printValues();

        if (checkWinner()) {
            System.out.println(currentPlayer + 1 + "won the game");
            showWinnerWindow("Player " + currentPlayer + 1 + " won the game", true);
            resetGame();
        } else if (round > 8) {
            showWinnerWindow("Game draw....", false);
            resetGame();
        } else {
            currentPlayer = currentPlayer == 0 ? 1 : 0;
            cpText.setText(currentPlayer == 0 ? "Player 1 (X)" : "Player 2 (O)");
        }
    }

    public boolean checkWinner() {
        System.out.println(Objects.equals(map.get(1), map.get(2)));

//        1 = 2 = 3
        if (map.get(1) != null && map.get(2) != null && map.get(3) != null)
            if (Objects.equals(map.get(1), map.get(2)) && Objects.equals(map.get(1), map.get(3)))
                return true;

//        4 = 5 = 6
        if (map.get(4) != null && map.get(5) != null && map.get(6) != null)
            if (Objects.equals(map.get(4), map.get(5)) && Objects.equals(map.get(4), map.get(6)))
                return true;
//        7 = 8 = 9
        if (map.get(7) != null && map.get(8) != null && map.get(9) != null)
            if (Objects.equals(map.get(7), map.get(8)) && Objects.equals(map.get(7), map.get(9)))
                return true;

//      1 = 5 = 9
        if (map.get(1) != null && map.get(5) != null && map.get(9) != null)
            return (Objects.equals(map.get(1), map.get(5)) && Objects.equals(map.get(1), map.get(9)));

        //      3 = 5 = 7
        if (map.get(3) != null && map.get(5) != null && map.get(7) != null)
            if (Objects.equals(map.get(3), map.get(5)) && Objects.equals(map.get(3), map.get(7)))
                return true;

//      1 = 4= 7
        if (map.get(1) != null && map.get(4) != null && map.get(7) != null)
            if (Objects.equals(map.get(1), map.get(4)) && (Objects.equals(map.get(1), map.get(7))))
                return true;

//        2 = 5 = 8
        if (map.get(2) != null && map.get(5) != null && map.get(8) != null)
            if (Objects.equals(map.get(2), map.get(5)) && Objects.equals(map.get(2), map.get(8)))
                return true;

//        3 = 6 = 9
        if (map.get(3) != null && map.get(6) != null && map.get(9) != null)
            if (Objects.equals(map.get(3), map.get(6)) && Objects.equals(map.get(3), map.get(9)))
                return true;
        return false;
    }

    public void showWinnerWindow(String content, boolean won) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(TicTacToeApplication.class.getResource("dialog-view.fxml"));
            fxmlLoader.setController(new DialogController(content, won));
            Scene scene = new Scene(fxmlLoader.load(), 200, 50);

            Stage stage = new Stage();
            stage.setTitle("Winner !!");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}