package main.controllers;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.view.DisplayPane;
import main.view.SelectionType;

public class AllCustomHandlers {
    private static SelectionType playerChoice;


    public static class chooseRock implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent e) {
            selectedChoice(SelectionType.ROCK);
        }
    }
    public static class choosePaper implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent e) {
            selectedChoice(SelectionType.PAPER);
        }
    }
    public static class chooseScissors implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent e) {
            selectedChoice(SelectionType.SCISSORS);
        }
    }
    public static class fightAction implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent arg0) {
            try {
                fight();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



    private static void selectedChoice(SelectionType s){
        playerChoice=s;
        DisplayPane.displayLabel.setText("You choose "+s+". Press 'Fight!' to attack.");        
    }

    private static void fight() throws InterruptedException{
        if(playerChoice==null){      //when clicked fight without choosing
            DisplayPane.displayLabel.setText("Please choose the item.");
            // wait(3000);
            // DisplayPane.displayLabel.setText("Welcome to Rock, Paper, Scissors Game.");
            return;
        }

        Random random=new Random();     //pick random choice for bot
        SelectionType botChoice=SelectionType.values()[random.nextInt(SelectionType.values().length)];
        /*Explaination
         * SEeclctionTypes.values() return enum valus as array
         * so we use [] to pick index, and use Random to choose random
         */

         //fight
        String winner = findWinner(playerChoice, botChoice);
        DisplayPane.displayLabel.setText(winner+"\nYou choose : "+playerChoice+"\nBot choose: "+botChoice);        
         
         playerChoice=null;     //reset player choice
    }

    private static String findWinner(SelectionType player, SelectionType bot){
        if(player==bot){
            return "Draw!";
        }
        switch (player) {
            case ROCK:
                return (bot==SelectionType.SCISSORS)? "You Win!" : "You Lose!";
            case PAPER:
                return (bot==SelectionType.ROCK)? "You Win!" : "You Lose!";
            case SCISSORS:
                return (bot==SelectionType.PAPER)? "You Win!" : "You Lose!";
        }
        return "Error!";
    }
}
