/*
 A IDEIA É QUE CADA PEÇA SAIBA SÓ, RECEBENDO O ESTADO DO TABULEIRO
 E A SUA POSIÇÃO, QUAIS SÃO AS CASAS QUE ELA PODERIA IR.

 Eu comecei fazendo isso, pra ter alguma coisa pra pelo menos ver no JAVAFX,
 mas aconteceram vários problemas relacionados a eu não saber como q esse 
 negócio funciona. Deus nos ilumine a todos. Amém.

 (Os comentários que estão em português eu pretendo apagar, os que tão
 em inglês eu ia deixar pra posterioridade. Não sei porque decidi fazer assim,
 mas agora já está feito. Deus nos ilumine a todos. Amém.)
*/

public abstract class Piece implements Colorred {
    protected Color color;

    public Color getColor(){
        return this.color;
    }

    public ArrayList<Position> calculateValidMoves(Position p, Board state);
}