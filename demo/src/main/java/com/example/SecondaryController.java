package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class SecondaryController {
    private ChessGame game = new ChessGame();

    @FXML
    private GridPane board; 

    @FXML
    private void initialize(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                char icon = game.getIconAtPosition(i, j);

                Button b = new Button(Character.toString(icon));

                if ((i + j) % 2 == 0) {
                    b.setStyle("-fx-background-color: #32a852;");;    
                }

                board.add(b, i, j);
            }
        }
    }

    // private void nextTurn() {
    //     game.nextTurn();
    // }

    @FXML
    private void update(){
        for (Node square : board.getChildren()) {
            if (square instanceof Button) {
                ((Button) square).setText("♙");
            }
        }
    }

    @FXML
    private void switchToPrimary() throws IOException {
       update();
    }
}