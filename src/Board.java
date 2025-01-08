public class Board {
    private Cell<Piece>[8][8] state;

    private void Board(Cell<Piece>[8][8] state){
        // (TODO)
    }

    public static Board new() {
        Cell<Piece>[8][8] state = new Cell<Piece>[8][8];

        // (TODO) popular isso aqui com piões, só pra poder testar.
    }

    public boolean isOcupied(Position p){
        return state[p.getX()][p.getY()].getOccupant() != null
    }

    public boolean isOpositColor(Position p, Color c) {
        Cell<Piece> it = state[p.getX()][p.getY()];
        Piece occupant = it.getOccupant();
        return occupant != null && occupant.getColor() != c;
    }
}