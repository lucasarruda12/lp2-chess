# lp2-chess
Chess implementation in Java submitted as final assignment for the Programming Languages II class at [IMD](imd.ufrn.br)/[UFRN](ufrn.br)

## Class Diagram

```mermaid
classDiagram
    ChessGame : - Board gameBoard
    ChessGame : - Color turn
    ChessGame : + ChessGame()
    ChessGame : + char getIconAtPosition(int x, int y)
    ChessGame : + ArrayList<Position> getPossibleMovesFromPosition(Position p) 
    ChessGame : + boolean doesMoveThreatenKing(Position target, Position destination)
    ChessGame : + void move(Position target, Position destination)
    ChessGame : + boolean checkMate(Position p)
    ChessGame : + boolean stalemate() 

    Board : - ArrayList<Piece> state
    Board : - Board (ArrayList<Piece> state)
    Board : + static Board newGame()
    Board : + Board clone()
    Board : + Board move(Position target, Position destination)
    Board : + boolean isKingInCheck(Color color)
    Board : + boolean isPieceThreathened(Piece p)
    Board : + char getIconAtPosition(Position p)
    Board : + boolean isOcupied(Position p)
    Board : + boolean isOpositColor(Position p, Color c) 
    Board : + ArrayList<Position> getPossibleMovesFromPosition(Position p) 
    Board : + Optional<Piece> findAt(Position p)  

    class Color {<<enumeration>>}
    Color : BLACK
    Color : WHITE
    Color : + Color opositeColor()

    class Piece {<<abstract>>}
    Piece : * Color color
    Piece : * Position pos
    Piece : * char icon
    Piece : + Color getColor()
    Piece : + char getIcon()
    Piece : + Position getPosition()
    Piece : + Piece move(Position p)
    Piece : + Piece clone() 
    Piece : + abstract ArrayList<Position> calculateValidMoves(Board state)

    Position : - int x
    Position : - int y
    Position : + int getX()
    Position : + int getY()
    Position : + Position(int x, int y)
    Position : + Position move(int x2, int y2)
    Position : + int to1D()
    Position : + boolean equals(Object obj) 

    Bishop : + Bishop(Color color, Position pos)
    Bishop : + ArrayList<Position> calculateValidMoves(Board state)

    Pawn : + Pawn(Color color, Position pos)
    Pawn : + ArrayList<Position> calculateValidMoves(Board state)
    Pawn : - ArrayList<Position> calculateWhitePawn(Board state)
    Pawn : - ArrayList<Position> calculateBlackPawn(Board state)

    King : + King(Color color, Position pos)
    King : + ArrayList<Position> calculateValidMoves(Board state)

    Queen : + Queen(Color color, Position pos)
    Queen : + ArrayList<Position> calculateValidMoves(Board state)

    Rook : + Rook(Color color, Position pos)
    Rook : + ArrayList<Position> calculateValidMoves(Board state)

    Knight : + Knight(Color color, Position pos)
    Knight : + ArrayList<Position> calculateValidMoves(Board state)

    Piece <|-- Rook
    Piece <|-- Pawn
    Piece <|-- Knight
    Piece <|-- King
    Piece <|-- Queen
    Piece <|-- Bishop

    Piece o-- Color
    Piece o-- Position

    Board *-- Piece

    ChessGame *-- Board
```
