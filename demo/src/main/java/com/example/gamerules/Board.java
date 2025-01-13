package com.example.gamerules;

import java.util.ArrayList;

public class Board {
    private ArrayList<Cell<Piece>> state;

    private Board(ArrayList<Cell<Piece>> state){
        this.state = state;
    }

    public static Board newGame() {
        ArrayList<Cell<Piece>> state = new ArrayList<>();

        for (int i = 0; i < 8; i++){
            state.add(new Cell<Piece>());
        }

        for (int i = 0; i < 8; i++){
            state.add(new Cell<Piece>(new Pawn(Color.BLACK)));
        }

        for (int i = 0; i < 32; i++){
            state.add(new Cell<Piece>());
        }

        for (int i = 0; i < 8; i++){
            state.add(new Cell<Piece>(new Pawn(Color.WHITE)));
        }

        for (int i = 0; i < 8; i++){
            state.add(new Cell<Piece>());
        }

        return new Board(state);
    }

    public char getIconAtPosition(Position p){
        Cell<Piece> cell = state.get(p.to1D());

        if (cell.isEmpty()) {
            return ' ';
        } else {
            return cell.getOccupant().getIcon();
        }

    }

    public boolean isOcupied(Position p){
        return state.get(p.to1D()).getOccupant() != null;
    }

    public boolean isOpositColor(Position p, Color c) {
        Cell<Piece> it = state.get(p.to1D());

        Piece occupant = it.getOccupant();
        return occupant != null && occupant.getColor() != c;
    }
}