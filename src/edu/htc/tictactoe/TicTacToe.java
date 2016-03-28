package edu.htc.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    char board[] = {'1','2','3','4','5','6','7','8','9'};
    GameBoard Game = new GameBoard(board);
    Scanner scanner = new Scanner(System.in);
    Player player1 = new Player("Brian", 'X');
    Player player2 = new Player("Player2", 'O');
    public void playerVictory(int playerNumber)
    {
        if (playerNumber == 1)
        {
            Game.display();
            player1.addWin();
            System.out.println(player1.getName() + " wins!");
            System.out.println(player1.getName() + ": " + player1.getWinCount());
            System.out.println(player2.getName() + ": " + player2.getWinCount());
        }
        if (playerNumber == 2)
        {
            player2.addWin();
            System.out.println(player2.getName() + " wins!");
            System.out.println(player2.getName() + ": " + player2.getWinCount());
            System.out.println(player1.getName() + ": " + player1.getWinCount());
        }
    }
  public void playGame()
  {
      int turn = 0;
      System.out.println("Player 1 Name: " + player1.getName());
      System.out.println("Player 1 Marker: " + player1.getMarker());
      System.out.println("Player 1 Win Count: " + player1.getWinCount());
      System.out.println("Player 2 Name: " + player2.getName());
      System.out.println("Player 2 Marker: " + player2.getMarker());
      System.out.println("Player 2 Win Count: " + player2.getWinCount());

      while (1 == 1)
      {
          Game.display();
          System.out.println(player1.getName() + "'s turn, their marker is " + player1.getMarker());
          turn = turn + 1;
          Game.updateSquare(player1.getMove(), 'X');
          if (Game.isGameWon())
          {
              playerVictory(1);
              break;
          }
          if (Game.getOpenSquares().length == 0)
          {
              Game.display();
              System.out.println("Tie Game!");
              break;
          }
          Game.display();
          System.out.println(player2.getName() + "'s turn, their marker is " + player2.getMarker());
          turn = turn + 1;
          Game.updateSquare(player2.getMove(), 'O');
          if (Game.isGameWon())
          {
              Game.display();
              playerVictory(2);
              break;
          }
          if (Game.getOpenSquares().length == 0)
          {
              Game.display();
              System.out.println("Tie Game!");
              System.out.println(player1.getName() + ": " + player1.getWinCount());
              System.out.println(player2.getName() + ": " + player2.getWinCount());
              break;
          }
      }
  }
}
