package com.chess.rules;

import java.util.ArrayList;

import com.chess.structure.Board;
import com.chess.structure.Color;
import com.chess.structure.Piece;
import com.chess.structure.Position;

public class Rook extends Piece {
    public Rook(Color color){
        this.color = color;

        if (color == Color.WHITE) {
            this.icon = '♖';
        }

        if (color == Color.BLACK) {
            this.icon = '♜';
        }
    }

    @Override
    public ArrayList<Position> calculateValidMoves(Position pos, Board state){
        ArrayList<Position> validMoves = new ArrayList<Position>();

        /** A rook can move in 4 directions: up, down, left and right
         *  and it can move in at most 7 squares in one direction
         */

        // Check if the rook can move up
        for (int i = 1; i < 8; i++) {
            Position up = pos.move(0, i);
            if (up.getY() < 8) {
                if (!state.isOcupied(up)) {
                    validMoves.add(up);
                } else {
                    if (state.isOpositColor(up, this.color)) {
                        validMoves.add(up);
                    }
                    break;
                }
            }
        }

        // Check if the rook can move down
        for (int i = 1; i < 8; i++) {
            Position down = pos.move(0, -i);
            if (down.getY() >= 0) {
                if (!state.isOcupied(down)) {
                    validMoves.add(down);
                } else {
                    if (state.isOpositColor(down, this.color)) {
                        validMoves.add(down);
                    }
                    break;
                }
            }
        }

        // Check if the rook can move left
        for (int i = 1; i < 8; i++) {
            Position left = pos.move(-i, 0);
            if (left.getX() >= 0) {
                if (!state.isOcupied(left)) {
                    validMoves.add(left);
                } else {
                    if (state.isOpositColor(left, this.color)) {
                        validMoves.add(left);
                    }
                    break;
                }
            }
        }

        // Check if the rook can move right
        for (int i = 1; i < 8; i++) {
            Position right = pos.move(i, 0);
            if (right.getX() < 8) {
                if (!state.isOcupied(right)) {
                    validMoves.add(right);
                } else {
                    if (state.isOpositColor(right, this.color)) {
                        validMoves.add(right);
                    }
                    break;
                }
            }
        }

        return validMoves;
    }
}
