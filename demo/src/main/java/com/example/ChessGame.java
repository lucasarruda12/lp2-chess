package com.example;

import java.util.ArrayList;

import com.example.gamerules.Board;
import com.example.gamerules.Position;
import com.example.gamerules.Color;

public class ChessGame {
    private Board gameBoard;
    private Color turn;

    public ChessGame(){
        this.gameBoard = Board.newGame();
        this.turn = Color.WHITE;
    }

    public char getIconAtPosition(int x, int y){
        return gameBoard.getIconAtPosition(new Position(x, y));
    }

    public ArrayList<Position> getPossibleMovesFromPosition(Position p) {
        if (gameBoard.isOpositColor(p, turn)){
            return new ArrayList<>();
        }

        return gameBoard.getPossibleMovesFromPosition(p);
    }

    public void move(Position target, Position destination){
        gameBoard.move(target, destination);
        turn = turn.opositeColor();
    }
}
