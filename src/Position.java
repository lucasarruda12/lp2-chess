public class Position {
  private int x;
  private int y;

  public Position(int x, int y){
    this.x = x;
    this.y = y;
  }

  public int getX() {return x;}
  public int getY() {return y;}

  public Position move(int x2, y2){
    return new Position(x + x2, y + y2);
  }
}
