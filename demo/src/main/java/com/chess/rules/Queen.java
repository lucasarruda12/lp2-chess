package com.chess.rules;

import java.util.ArrayList;

import com.chess.structure.Board;
import com.chess.structure.Color;
import com.chess.structure.Piece;
import com.chess.structure.Position;

public class Queen extends Piece {
    public Queen(Color color, Position pos){
        this.color = color;
        this.pos = pos;

        if (color == Color.WHITE) {
            this.icon = '♕';
        }

        if (color == Color.BLACK) {
            this.icon = '♛';
        }
    }

    @Override
    public ArrayList<Position> calculateValidMoves(Board state){
        ArrayList<Position> validMoves = new ArrayList<>();

        // A queen can move like a Rook and a Bishop
        ArrayList<Position> RookValidMoves = new Rook(color, pos).calculateValidMoves(state);
        ArrayList<Position> BishopValidMoves = new Bishop(color, pos).calculateValidMoves(state);
        
        validMoves.addAll(RookValidMoves);
        validMoves.addAll(BishopValidMoves);

        return validMoves;
    }
}
