package com.chess.structure;

import java.util.ArrayList;

public abstract class Piece implements Cloneable {
    protected Color color;
    protected char icon;
    protected Position pos;

    public Color getColor(){
        return this.color;
    }

    public char getIcon(){
        return this.icon;
    }

    public Position getPosition(){
        return this.pos;
    }

    public Piece move(Position p){
        Piece moved = this.clone();
        moved.pos = p;
        
        return moved;
    }
    
    public Piece clone() {
        try {
            Piece clone = (Piece) super.clone();

            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public abstract ArrayList<Position> calculateValidMoves(Board state);
}