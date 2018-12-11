package com.tic.tac.toe;

public class Player {
    private String id;
    private Move move;

    public boolean play(Board board){

        board.updateBoard(move);

        if(board.checkIfPlayerWon())
            return true;


        return false;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
