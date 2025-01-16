package com.chess.rules;

import java.util.ArrayList;

import com.chess.structure.Board;
import com.chess.structure.Color;
import com.chess.structure.Piece;
import com.chess.structure.Position;

public class King extends Piece {
    public King(Color color){
        this.color = color;

        if (color == Color.WHITE) {
            this.icon = '♔';
        }

        if (color == Color.BLACK) {
            this.icon = '♚';
        }
    }

    @Override
    public ArrayList<Position> calculateValidMoves(Position pos, Board state){
        ArrayList<Position> validMoves = new ArrayList<Position>();

        /** A king can move in 8 directions: up, down, left, right, up-right, 
         *  up-left, down-right and down-left
         *  and it can move in at most 1 square in one direction
         */
        int X[] = {0, 0, -1, 1, -1, 1, -1, 1};
        int Y[] = {1, -1, 0, 0, 1, 1, -1, -1};

        for (int i = 0; i < 8; i++) {
            // If a move is possible, then check if the move is valid
            if (pos.getX() + X[i] >= 0 && pos.getX() + X[i] < 8 && pos.getY() + Y[i] >= 0 && pos.getY() + Y[i] < 8) {
                // (TODO) Check if the king is in check
                Position move = pos.move(X[i], Y[i]);
                if (!state.isOcupied(move) || state.isOpositColor(move, this.color)) {
                    validMoves.add(move);
                }
            }
        }

        return validMoves;
    }
}
