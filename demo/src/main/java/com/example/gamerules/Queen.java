package com.example.gamerules;

import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(Color color){
        this.color = color;

        if (color == Color.WHITE) {
            this.icon = '♕';
        }

        if (color == Color.BLACK) {
            this.icon = '♛';
        }
    }

    @Override
    public ArrayList<Position> calculateValidMoves(Position pos, Board state){
        ArrayList<Position> validMoves = new ArrayList<>();

        // A queen can move like a Rook and a Bishop
        ArrayList<Position> RookValidMoves = new Rook(color).calculateValidMoves(pos, state);
        ArrayList<Position> BishopValidMoves = new Bishop(color).calculateValidMoves(pos, state);
        
        validMoves.addAll(RookValidMoves);
        validMoves.addAll(BishopValidMoves);

        return validMoves;
    }
}
