package com.chess.structure;

import java.util.ArrayList;

public abstract class Piece {
    protected Color color;
    public char icon;

    public Color getColor(){
        return this.color;
    }

    public char getIcon(){
        return this.icon;
    }

    public abstract ArrayList<Position> calculateValidMoves(Position p, Board state);
}