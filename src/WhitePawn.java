import java.util.ArrayList;

public class WhitePawn {
  private Color color;

  public Color getColor(){
    return Color.WHITE;
  }

  public ArrayList<Cell<Collored>> calculateValidMoves(Position p, Cell<Collored>[][] state){
    ArrayList<Cell<Collored>> validMoves = new ArrayList<>();

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
