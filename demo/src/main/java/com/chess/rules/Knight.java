package com.chess.rules;

import java.util.ArrayList;

import com.chess.structure.Board;
import com.chess.structure.Color;
import com.chess.structure.Piece;
import com.chess.structure.Position;

public class Knight extends Piece{
    public Knight(Color color, Position pos){
        this.color = color;
        this.pos = pos;

        if (color == Color.WHITE) {
            this.icon = '♘';
        }

        if (color == Color.BLACK) {
            this.icon = '♞';
        }
    }

    @Override
    public ArrayList<Position> calculateValidMoves(Board state){
        ArrayList<Position> validMoves = new ArrayList<Position>();

        /** A knight can move in an L shape, two squares in one direction 
         *  and one square in a perpendicular direction.
         *  The knight can move in at most 8 different directions
         */
        int X[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int Y[] = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int i = 0; i < 8; i++) {
            // If a move is possible, then check if the move is valid
            if (pos.getX() + X[i] >= 0 && pos.getX() + X[i] < 8 && pos.getY() + Y[i] >= 0 && pos.getY() + Y[i] < 8) {
                Position move = pos.move(X[i], Y[i]);
                if (!state.isOcupied(move) || state.isOpositColor(move, this.color)) {
                    validMoves.add(move);
                }
            }
        }

        return validMoves;
    }
}
