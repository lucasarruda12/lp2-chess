package com.chess.structure;

import java.util.ArrayList;
import java.util.Optional;

import com.chess.rules.Bishop;
import com.chess.rules.King;
import com.chess.rules.Knight;
import com.chess.rules.Pawn;
import com.chess.rules.Queen;
import com.chess.rules.Rook;

public class Board {
    private ArrayList<Piece> state;

    private Board(ArrayList<Piece> state){
        this.state = state;
    }

    public static Board newGame() {
        ArrayList<Piece> state = new ArrayList<>();

        // add 16 pawns
        for (int i = 0; i < 8; i++){
            state.add(new Pawn(Color.BLACK, new Position(i, 1)));
            state.add(new Pawn(Color.WHITE, new Position(i, 6)));
        }

        // 4 Rooks
        state.add(new Rook(Color.WHITE, new Position(0, 0)));
        state.add(new Rook(Color.WHITE, new Position(7, 0)));
        state.add(new Rook(Color.BLACK, new Position(0, 7)));
        state.add(new Rook(Color.BLACK, new Position(7, 7)));

        // 4 knights
        state.add(new Knight(Color.WHITE, new Position(1, 0)));
        state.add(new Knight(Color.WHITE, new Position(6, 0)));
        state.add(new Knight(Color.BLACK, new Position(1, 7)));
        state.add(new Knight(Color.BLACK, new Position(6, 7)));

        // 4 bishops
        state.add(new Bishop(Color.WHITE, new Position(2, 0)));
        state.add(new Bishop(Color.WHITE, new Position(5, 0)));
        state.add(new Bishop(Color.BLACK, new Position(2, 7)));
        state.add(new Bishop(Color.BLACK, new Position(5, 7)));

        // 4 kings and queens
        state.add(new King(Color.WHITE, new Position(3, 0)));
        state.add(new Queen(Color.WHITE, new Position(4, 0)));
        state.add(new King(Color.BLACK, new Position(3, 7)));
        state.add(new Queen(Color.BLACK, new Position(4, 7)));

        return new Board(state);
    }

    public void move(Position target, Position destination){
        
    }

    public char getIconAtPosition(Position p){
        return findAt(p).map(piece -> piece.getIcon()).orElse(' ');
    }

    public boolean isOcupied(Position p){
        return findAt(p).isPresent();
    }

    public boolean isOpositColor(Position p, Color c) {
        return findAt(p).map(piece -> piece.getColor() != c).orElse(false);
    }

    public ArrayList<Position> getPossibleMovesFromPosition(Position p) {
        return findAt(p)
            .map(piece -> piece.calculateValidMoves(this))
            .orElse(new ArrayList<>());
    }

    private Optional<Piece> findAt(Position p) {
        return state.stream()
            .filter(piece -> piece.getPosition().equals(p))
            .findFirst();
    }
}