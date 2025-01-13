package com.example;

import com.example.gamerules.Board;
import com.example.gamerules.Position;

public class ChessGame {
    private Board gameBoard;

    public ChessGame(){
        this.gameBoard = Board.newGame();
    }

    public char getIconAtPosition(int x, int y){
        return gameBoard.getIconAtPosition(new Position(x, y));
    }
}
