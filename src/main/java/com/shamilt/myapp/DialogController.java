package com.shamilt.myapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class DialogController {

    private final String content;
    private final boolean won;
    public Label text;

    public DialogController(String content, boolean won) {
        this.content = content;
        this.won = won;
    }

    @FXML
    public void initialize() {
        if (won) {
            text.setTextFill(Color.GREEN);
        } else {
            text.setTextFill(Color.RED);
        }
        text.setText(content);
    }
}
