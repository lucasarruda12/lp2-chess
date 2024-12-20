public class Cell<T> {
  private T occupant;

  public Cell(T occupant){
    this.occupant = occupant;
  }

  public T getOccupant(){
    return this.occupant;
  }

  public boolean isEmpty(){
    return occupant == null;
  }
}
