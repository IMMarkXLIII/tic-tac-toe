package com.tic.tac.toe;

import java.util.Arrays;
import java.util.Scanner;

public class BoardManager {

    private Board board;
    private Player player1;
    private Player player2;

    private Player currentPlayer;

    public BoardManager() {
        player1 = new Player();
        player2 = new Player();
        board = new Board();
    }

    private String lastInput;

    public void startGame(){
        Scanner scanner = new Scanner(System.in);

        int moveCount=0;
        boolean isEnd = false;

        while(!isEnd && moveCount<2){
            Move move;
            if(moveCount%2 == 0){ //player 1

                String input = scanner.nextLine();
                String inputArr[] = input.split("<");

                player1.setId(inputArr[0]);

                move = new Move(Integer.parseInt(inputArr[1]
                        .split("[,]")[0]), Integer.parseInt(inputArr[1].split(",")[1]));
                player1.setMove(move);

                currentPlayer = player1;

            }else{ //player 2
                String input = scanner.nextLine();
                String inputArr[] = input.split("<");

                player2.setId(inputArr[0]);

                move = new Move(Integer.parseInt(inputArr[1].split("[,]")[0]), Integer.parseInt(inputArr[1].split(",")[1]));
                player2.setMove(move);

                currentPlayer = player2;
            }

// TODO: check for last input(better model)

//            System.out.println(player1.getId() +"," +move.getX());

            if(!validateLastMove(currentPlayer.getId())){
                System.out.println("This move is same as the last move! Please retry!");
                moveCount--;
            }

            if(board.checkIfAlreadyOccupied(move)){
                System.out.println("The cell is already occupied! Please try again!");
                moveCount--;
            }


            currentPlayer.play(board);

            lastInput = currentPlayer.getId();
            moveCount++;
        }
    }

    public boolean validateLastMove(String id){

        if(lastInput == null)
            return true;
        if(lastInput.equals(id))
            return false;
        return true;

    }

    public static void main(String[] args) {
        new BoardManager().startGame();
    }

}
