package some.pack;

import static some.pack.Mark.*;

public class TicTacToe {

    private Mark[][] squares = new Mark[3][3];
    private Mark lastPlayed = O;
    
    public TicTacToe() {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                squares[i][j] = _;
            }
        }
    }
    
    public Mark currentPlayer() {
        if (lastPlayed == O) return X;
        return O;
    }
    
    public void mark(int x, int y) throws InvalidSquareException, AlreadyMarkedException {
        if (x < 0 || x >= 3 || y < 0 || y >= 3 ) throw new InvalidSquareException();
        if (squares[x][y] != _) throw new AlreadyMarkedException();
        squares[x][y] = currentPlayer();
        lastPlayed = currentPlayer();
    }
    
    private boolean areAllRowsMarked() {
        for (Mark[] line: squares) {
            for (Mark square: line) {
                if (square == _) return false;
            }
        }
        return true;
    }
    
    public boolean finished() {
        return areAllRowsMarked() || winner() != _;
    }
    
    public Mark winner() {
        if (allTheSame(squares[0][0], squares[0][1], squares[0][2])) return squares[0][0];
        if (allTheSame(squares[1][0], squares[1][1], squares[1][2])) return squares[1][0];
        if (allTheSame(squares[2][0], squares[2][1], squares[2][2])) return squares[2][0];
        
        if (allTheSame(squares[0][0], squares[1][0], squares[2][0])) return squares[0][0];
        if (allTheSame(squares[0][1], squares[1][1], squares[2][1])) return squares[0][1];
        if (allTheSame(squares[0][2], squares[1][2], squares[2][2])) return squares[0][2];
        
        if (allTheSame(squares[0][0], squares[1][1], squares[2][2])) return squares[0][0];
        if (allTheSame(squares[2][0], squares[1][1], squares[0][2])) return squares[2][0];
        
        return _;
    }
    
    private boolean allTheSame(Mark m1, Mark m2, Mark m3) {
        return m1 == m2 && m2 == m3;
    }
    
    public Mark[][] status() {
        return squares.clone();
    }
    
    public String toString() {
        StringBuffer buf = new StringBuffer("+-+-+-+\n");
        for (Mark[] line: squares) {
            for (Mark square: line) {
                buf.append("|");
                buf.append(square);
            }
            buf.append("|\n+-+-+-+\n");
        }
        return buf.toString();
    }
    
}