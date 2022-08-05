package javabootcamp.helloworld;

/**
 * @author Samir Krishna
 */

import java.util.Scanner;

public class GuessingGame {
    public static void main(String... args) {
        boolean isPlay=true;
        Scanner sc = new Scanner(System.in);
        while(isPlay){
            Umpire u = new Umpire();
            String winner = u.getWinner();
            System.out.println(winner + " is winner");

            System.out.println("Do you want to play again?. yes/no");
            String play = sc.next();
            if(play.equals("yes")){
                isPlay = true;
            }else{
                isPlay = false;
            }
            System.out.println("Thank you! Play Again");
        }
    }
}


class Guesser {

    public int guessANumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Guesser Guess a number");
        int guessedNumber = sc.nextInt();
        return guessedNumber;
    }
}

class Player {

    public int playerAnswer(int playerNo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player"+playerNo+ " Guess a number");
        int playerAnswer = sc.nextInt();
        return playerAnswer;
    }
}

class Umpire {
    int guessedNumber;
    int player1Answer;
    int player2Answer;
    int player3Answer;

    public Umpire() {
        Guesser guesser = new Guesser();
        guessedNumber = guesser.guessANumber();

        Player p = new Player();
        player1Answer = p.playerAnswer(1);
        player2Answer = p.playerAnswer(2);
        player3Answer = p.playerAnswer(3);
    }

    public String getWinner() {
        if (guessedNumber == player1Answer)
            return "Player 1";
        else if (guessedNumber == player2Answer)
            return "Player 2";
        else if (guessedNumber == player3Answer)
            return "Player 3";
        else
            return "No Winner";
    }
}