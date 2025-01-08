public class Pawn extends Piece {
    public void Pawn(Color color){
        this.color = color;
    }

    public ArrayList<Cell<Collored>> calculateValidMoves(Position p, Board state){
        if (this.color == Color.WHITE) return calculateWhitePawn(p, state);
        if (this.color == Color.BLACK) return calculateBlackPawn(p, state);
    }

    // (TODO) Não sei se ficou melhor assim, ainda tô terminando.
    private ArrayList<Position> calculateBlackPawn(Position pos, Board state){
        ArrayList<Position> validMoves = new ArrayList<Position>();

        // If the pawn is at the end of the board, then it cannot move
        if (pos.y == 0) return validMoves;

        // A pawn can move forward if no piece occupies that space
        Position forward = pos.move(0, -1);
        if (!state.isOcupied(forward)) validMoves.add(forward);

        // A pawn can move diagonnally if an oposite color piece ocupies that space
        if (pos.x > 0) {
            Position leftDown = pos.move(-1, -1);
            if (state.isOpositColor(leftDown, this.color)) validMoves(leftDown);
        }

        if (x < 7) {
            Position rightDown = pos.move(+1, -1);
            if (state.isOpositColor(rightDown, this.color)) validMoves(rightDown);
        }

        // A pawn can move forward two spaces if this is its first move and both squares in front of it are empty
        if (pos.y == 6) /* Is it's firstMove */ {
            Position forforward = forward.move(0, -1);
            if (!state.isOcupied(forward) && !state.isOcupied(forforward)) validMoves(forforward);
        }

        return validMoves;
    }

    private ArrayList<Position> calculateWhitePawn(Position p, Board state){
        ArrayList<Position> validMoves = new ArrayList<>();

        // Sanity varibles
        int x = p.getX();
        int y = p.getY();
        Cell<Collored> it;

        // If the pawn is at the end of the board, then it cannot move
        if (y == 7) return validMoves;

        // A pawn can move forward if no piece occupies that space
        it = state[x][y + 1];
        if (it.isEmpty()) validMoves.add(it);

        // A pawn can move diagonnally if an oposite color piece ocupies that space
        if (x > 0) {
        it = state[x - 1][y + 1];
        if (it.getOccupant() != null && it.getOccupant().getColor() != this.color) validMoves.add(it);
        }

        if (x < 7) {
        it = state[x + 1][y + 1];
        if (it.getOccupant() != null && it.getOccupant().getColor() != this.color) validMoves.add(it);
        }

        // A pawn can move forward two spaces if this is its first move and both squares in front of it are empty
        if (y == 1) /* Is it's firstMove */ {
        it = state[x][y + 2];
        if (state[x][y + 1].isEmpty() && it.isEmpty()) validMoves.add(it);
        }

        return validMoves;
    }
}