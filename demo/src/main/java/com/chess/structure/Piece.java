package com.chess.structure;

import java.util.ArrayList;

public class Piece implements Cloneable {
    protected Color color;
    protected char icon;
    protected Position pos;

    private Piece(Color c, Position p){
        this.color = c;
        this.pos = p;
    }

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
        try{
            Piece moved = (Piece) super.clone();

            moved.pos = p;

            return moved;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public ArrayList<Position> calculateValidMoves(Board state){
        return new ArrayList<>();
    };
}