package CSCI1933P2;
public abstract class Piece {

    // Piece object's internal row position
    protected int row;

    // Piece object's internal col position
    protected int col;

    // Boolean representing Piece object's color (white/black)
    protected boolean isBlack;

    // Unicode character representing the piece
    protected char representation;

    /**
     * Checks if a move to a destination square is legal.
     * Hint: Use your verification methods from Board in each implementation of this method.
     * @param board     The game board.
     * @param endRow    The row of the destination square.
     * @param endCol    The column of the destination square.
     * @return True if the move to the destination square is legal, false otherwise.
     */
    public abstract boolean isMoveLegal(Board board, int endRow, int endCol);

    /**
     * Sets the internal position of the piece.
     * @param row   The row to move the piece to.
     * @param col   The column to move the piece to.
     */
    public void setPosition(int row, int col){

    }



    /**
     * Return the position of the piece.
     * @return  The row of the piece.
     */
    public int getRow(){

    }



    /**
     * Return the position of the piece.
     * @return  The col of the piece.
     */
    public int getCol(){

    }



    /**
     * Return the color of the piece.
     * @return  The color of the piece.
     */
    public boolean getIsBlack(){

    }


    /**
     * Returns a string representation of the piece.
     * @return  A string representation of the piece.
     */
    public String toString() {
        return representation + "";
    }


}
