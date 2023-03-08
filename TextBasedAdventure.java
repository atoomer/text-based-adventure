import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class TextBasedAdventure {
    boolean hasSword = false;
    boolean hasGoggles = false;
    Scanner keyboardInput = new Scanner(System.in);

    public void execute() {
        System.out.println("Welcome to Escape from the Cave! Press enter when you are ready to start...");
        keyboardInput.nextLine();
        System.out.println("You are trapped in a cave!");
        start();
    }

    public void start() {
        System.out.println("You find yourself in a large room. What would you like to do?\n1. Go left \n2. Go right \n3. Go straight");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            goLeft();
        }
        else if (input == 2) {
            goRight();
        }
        else if (input == 3) {
            goStraight();
        }
    }

    public void goLeft() {
        System.out.println("Oh no! You run into a giant! Fight or flight?\n1. Fight \n2. Flight");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            fight();
        }
        else if (input == 2) {
            start();
        }  
    }

    public void goRight() {
        if (!hasSword && !hasGoggles) {
            System.out.println("You find a sword on the ground!");
            hasSword = true;
        }
        else if(hasSword && !hasGoggles){
            System.out.println("This is where you found the sword. There is nothing else here...that you can see...");
        }
        else if(!hasSword && hasGoggles){
            System.out.println("You find a sword on the ground!");
            hasSword = true;
            System.out.println("Using your nightvision goggles you find a cave painting of Professor Alex!");
        }
        else {
            System.out.println("Using your nightvision goggles you find a cave painting of Professor Alex!");
        }
        start();
    }

    public void goStraight() {
        if (!hasGoggles) {
            System.out.println("You find nightvision goggles on the ground!");
            hasGoggles = true;
        }
        else {
            System.out.println("This is where you found the nightvision goggles. There is nothing else here.");
        }
        start();
    }

    public void fight() {
        if (hasSword) {
            System.out.println("You defeat the giant with your sword and run out of the cave!");
        } else {
            System.out.println("You get stomped by the giant and red stuff goes everywhere.");
        }
    }

    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}