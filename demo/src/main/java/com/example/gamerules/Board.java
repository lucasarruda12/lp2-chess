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
            if (i == 0 || i == 7) {
                state.add(new Cell<Piece>(new Rook(Color.BLACK)));
            } else if (i == 1 || i == 6) {
                state.add(new Cell<Piece>(new Knight(Color.BLACK)));
            } else if (i == 2 || i == 5) {
                state.add(new Cell<Piece>(new Bishop(Color.BLACK)));
            } else if (i == 3) {
                state.add(new Cell<Piece>(new Queen(Color.BLACK)));
            } else if (i == 4) {
                state.add(new Cell<Piece>(new King(Color.BLACK)));
            }
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
            if (i == 0 || i == 7) {
                state.add(new Cell<Piece>(new Rook(Color.WHITE)));
            } else if (i == 1 || i == 6) {
                state.add(new Cell<Piece>(new Knight(Color.WHITE)));
            } else if (i == 2 || i == 5) {
                state.add(new Cell<Piece>(new Bishop(Color.WHITE)));
            } else if (i == 3) {
                state.add(new Cell<Piece>(new Queen(Color.WHITE)));
            } else if (i == 4) {
                state.add(new Cell<Piece>(new King(Color.WHITE)));
            }
        }

        return new Board(state);
    }

    public void move(Position target, Position destination){
        Cell<Piece> targetCell = state.get(target.to1D());

        state.set(target.to1D(), new Cell<>());
        state.set(destination.to1D(), targetCell);
    }

    public char getIconAtPosition(Position p){
        Cell<Piece> cell = state.get(p.to1D());

        if (cell.isEmpty()) {
            return ' ';
        } else {
            return cell.getOccupant().getIcon();
        }

    }

    public ArrayList<Position> getPossibleMovesFromPosition(Position p) {
        Cell<Piece> cell = state.get(p.to1D());

        if (cell.isEmpty()) {
            return new ArrayList<>();
        } else {
            return cell.getOccupant().calculateValidMoves(p, this);
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