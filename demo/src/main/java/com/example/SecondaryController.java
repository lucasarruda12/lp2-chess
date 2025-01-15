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
        reloadBoard();
    }

    private void reset(){
        board.getChildren().clear();
    }

    private void reloadBoard(){
        reset();

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

    private void handleClick(int x, int y){
        Position initial = new Position(x, y);
        ArrayList<Position> possibleMoves = game.getPossibleMovesFromPosition(initial);

        for (Node child : board.getChildren()) {
            Position p = new Position(GridPane.getColumnIndex(child), GridPane.getRowIndex(child));

            Button button = (Button) child;

            if (possibleMoves.contains(p)){
                button.setStyle("-fx-background-color: lightblue;");

                button.setOnAction(event -> {
                    game.move(initial, p);
                    reloadBoard();
                });
            } else {
                button.setOnAction(event -> {
                    reloadBoard();
                });
            }
        }
    }
}