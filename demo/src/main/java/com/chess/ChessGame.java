package com.chess;

import java.util.ArrayList;

import com.chess.structure.Board;
import com.chess.structure.Color;
import com.chess.structure.Position;

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

        ArrayList<Position> validMoves = gameBoard.getPossibleMovesFromPosition(p);
        validMoves.removeIf(target -> doesMoveThreatenKing(p, target));
        return validMoves;
    }

    private boolean doesMoveThreatenKing(Position target, Position destination){
        Board possibleBoard = gameBoard.move(target, destination);

        return possibleBoard.isKingInCheck(turn);
    }

    public void move(Position target, Position destination){
        turn = turn.opositeColor();
        gameBoard = gameBoard.move(target, destination);
    }

    public boolean checkMate(Position p){
        return gameBoard.isKingInCheck(turn) && gameBoard.getPossibleMovesFromPosition(p).isEmpty();
    }

    public boolean stalemate() {
        return true;
    }
}
