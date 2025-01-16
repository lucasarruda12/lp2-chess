package com.chess.rules;

import java.util.ArrayList;

import com.chess.structure.Board;
import com.chess.structure.Color;
import com.chess.structure.Piece;
import com.chess.structure.Position;

public class Pawn extends Piece {
    public Pawn(Color color, Position pos){
        this.color = color;
        this.pos = pos;

        if (color == Color.WHITE) {
            this.icon = '♙';
        }

        if (color == Color.BLACK) {
            this.icon = '♟';
        }
    }

    @Override
    public ArrayList<Position> calculateValidMoves(Board state){
        if (this.color == Color.WHITE) return calculateWhitePawn(state);
        if (this.color == Color.BLACK) return calculateBlackPawn(state);
        
        return null;
    }

    private ArrayList<Position> calculateWhitePawn(Board state){
        ArrayList<Position> validMoves = new ArrayList<Position>();

        // If the pawn is at the end of the board, then it cannot move
        if (pos.getY() == 0) return validMoves;

        // A pawn can move forward if no piece occupies that space
        Position forward = pos.move(0, -1);
        if (!state.isOcupied(forward)) validMoves.add(forward);

        // A pawn can move diagonnally if an oposite color piece ocupies that space
        if (pos.getX() > 0) {
            Position leftDown = pos.move(-1, -1);
            if (state.isOpositColor(leftDown, this.color)) validMoves.add(leftDown);
        }

        if (pos.getX() < 7) {
            Position rightDown = pos.move(1, -1);
            if (state.isOpositColor(rightDown, this.color)) validMoves.add(rightDown);
        }

        // A pawn can move forward two spaces if this is its first move and both squares in front of it are empty
        if (pos.getY() == 6) /* Is it's firstMove */ {
            Position forforward = forward.move(0, -1);
            if (!state.isOcupied(forward) && !state.isOcupied(forforward)) validMoves.add(forforward);
        }

        return validMoves;
    }

    private ArrayList<Position> calculateBlackPawn(Board state){
        ArrayList<Position> validMoves = new ArrayList<Position>();

        // If the pawn is at the end of the board, then it cannot move
        if (pos.getY() == 7) return validMoves;

        // A pawn can move forward if no piece occupies that space
        Position forward = pos.move(0, 1);
        if (!state.isOcupied(forward)) validMoves.add(forward);

        // A pawn can move diagonnally if an oposite color piece ocupies that space
        if (pos.getX() > 0) {
            Position leftDown = pos.move(-1, 1);
            if (state.isOpositColor(leftDown, this.color)) validMoves.add(leftDown);
        }

        if (pos.getX() < 7) {
            Position rightDown = pos.move(1, 1);
            if (state.isOpositColor(rightDown, this.color)) validMoves.add(rightDown);
        }

        // A pawn can move forward two spaces if this is its first move and both squares in front of it are empty
        if (pos.getY() == 1) /* Is it's firstMove */ {
            Position forforward = forward.move(0, 1);
            if (!state.isOcupied(forward) && !state.isOcupied(forforward)) validMoves.add(forforward);
        }

        return validMoves;
    }
}