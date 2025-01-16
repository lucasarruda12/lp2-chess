package com.chess.rules;

import java.util.ArrayList;

import com.chess.structure.Board;
import com.chess.structure.Color;
import com.chess.structure.Piece;
import com.chess.structure.Position;

public class Bishop extends Piece {
    public Bishop(Color color, Position pos){
        this.color = color;
        this.pos = pos;

        if (color == Color.WHITE) {
            this.icon = '♗';
        }

        if (color == Color.BLACK) {
            this.icon = '♝';
        }
    }

    @Override
    public ArrayList<Position> calculateValidMoves(Board state){
        ArrayList<Position> validMoves = new ArrayList<Position>();

        /** A bishop can move in 4 directions: up-right, up-left, down-right and down-left
         *  and it can move in at most 7 squares in one direction
         */

        // Check if the bishop can move up-right
        for (int i = 1; i < 8; i++) {
            Position upRight = pos.move(i, i);
            if (upRight.getX() < 8 && upRight.getY() < 8) {
                if (!state.isOcupied(upRight)) {
                    validMoves.add(upRight);
                } else {
                    if (state.isOpositColor(upRight, this.color)) {
                        validMoves.add(upRight);
                    }
                    break;
                }
            }
        }

        // Check if the bishop can move up-left
        for (int i = 1; i < 8; i++) {
            Position upLeft = pos.move(-i, i);
            if (upLeft.getX() >= 0 && upLeft.getY() < 8) {
                if (!state.isOcupied(upLeft)) {
                    validMoves.add(upLeft);
                } else {
                    if (state.isOpositColor(upLeft, this.color)) {
                        validMoves.add(upLeft);
                    }
                    break;
                }
            }
        }

        // Check if the bishop can move down-right
        for (int i = 1; i < 8; i++) {
            Position downRight = pos.move(i, -i);
            if (downRight.getX() < 8 && downRight.getY() >= 0) {
                if (!state.isOcupied(downRight)) {
                    validMoves.add(downRight);
                } else {
                    if (state.isOpositColor(downRight, this.color)) {
                        validMoves.add(downRight);
                    }
                    break;
                }
            }
        }

        // Check if the bishop can move down-left
        for (int i = 1; i < 8; i++) {
            Position downLeft = pos.move(-i, -i);
            if (downLeft.getX() >= 0 && downLeft.getY() >= 0) {
                if (!state.isOcupied(downLeft)) {
                    validMoves.add(downLeft);
                } else {
                    if (state.isOpositColor(downLeft, this.color)) {
                        validMoves.add(downLeft);
                    }
                    break;
                }
            }
        }

        return validMoves;
    }
}
