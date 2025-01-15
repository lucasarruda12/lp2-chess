package com.example;

import java.util.ArrayList;
import com.example.gamerules.Position;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
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

                b.setOnAction(event -> {
                    Integer rowIndex = GridPane.getRowIndex(b);
                    Integer colIndex = GridPane.getColumnIndex(b);

                    handleClick(colIndex, rowIndex);
                });

                if ((i + j) % 2 == 0) {
                    b.setStyle("-fx-background-color: #32a852;");
                } else {
                    b.setStyle("-fx-background-color: white");
                }

                b.setFont(Font.font("Arial", 22));

                board.add(b, i, j);
            }
        }
    }

    private void reset(){
        for (Node child : board.getChildren()) {
            int x = GridPane.getColumnIndex(child);
            int y = GridPane.getRowIndex(child);

            if ((x + y) % 2 == 0) {
                child.setStyle("-fx-background-color: #32a852;");
            } else {
                child.setStyle("-fx-background-color: white");
            }

            Button b = (Button) child;

            b.setOnAction(event -> {
                Integer rowIndex = GridPane.getRowIndex(b);
                Integer colIndex = GridPane.getColumnIndex(b);

                handleClick(colIndex, rowIndex);
            });
        }
    }

    private void handleClick(int x, int y){
        ArrayList<Position> possibleMoves = game.getPossibleMovesFromPosition(new Position(x, y));

        for (Node child : board.getChildren()) {
            Position p = new Position(GridPane.getColumnIndex(child), GridPane.getRowIndex(child));

            if (possibleMoves.contains(p)){
                child.setStyle("-fx-background-color: lightblue;");
            } else {
                Button button = (Button) child;

                button.setOnAction(event -> {
                    reset();
                });
            }
        }
    }

    private void highlightButtonAt(int x, int y){
        Button button = (Button) board.getChildren().stream()
                .filter(node -> GridPane.getRowIndex(node) == y && GridPane.getColumnIndex(node) == x)
                .findFirst()
                .orElse(null);

        if (button != null) {
            button.setStyle("-fx-background-color: lightblue;");
        }
    }
}