import java.util.Scanner;
import java.lang.Math;

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
        System.out.println("You find yourself in a large room. What would you like to do?\n1. Go left \n2. Go right \n3. Go straight \n4. Go backwards");
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
        else if (input == 4) {
            goBackwards();
        }
    }

    public void goLeft() {  
        if (!hasSword) {
            System.out.println("Oh no! You run into a giant! Fight or flight?\n1. Fight \n2. Flight \n3. Find a weapon!");
            int input = keyboardInput.nextInt();
        if (input == 1) {
            fight();
            }
        else if (input == 2) {
            start();
            } 

        else if (input == 3) {
            start();
            }
        } else if (hasSword) {
            System.out.println("Oh no! You run into a giant! Fight or flight?\n1. Fight \n2. Flight");
            int input = keyboardInput.nextInt();
        if (input == 1) {
            fight();
            }
        else if (input == 2) {
            start();
            } 
        }
    

        
    }

    public void goRight() {
        if (!hasSword && !hasGoggles) {
            System.out.println("Theres an old man in front of you holding a sword.  He says, 'It's dangerous to go alone...take this!");
            hasSword = true;
        }
        else if(hasSword && !hasGoggles){
            System.out.println("This is where you found the sword. There is nothing else here...that you can see...");
        }
        else if(!hasSword && hasGoggles){
            System.out.println("Theres an old man in front of you holding a sword.  He says, 'It's dangerous to go alone...take this!");
            hasSword = true;
            System.out.println("Using your nightvision goggles you find a cave painting of Professor Alex!");
        }
        else {
            System.out.println("Using your nightvision goggles you find a cave painting of Professor Alex!");
        }
        start();
    }

    public void goBackwards() {
        if (!hasGoggles) {
            System.out.println("You find nightvision goggles on the ground!");
            hasGoggles = true;
        }
        else {
            System.out.println("This is where you found the nightvision goggles. There is nothing else here.");
        }
        start();
    }

    public void goStraight()
    {
        System.out.println("You find a flight of stairs, do you climb them?\n1. Yes \n2. No");
        int input = keyboardInput.nextInt();
        if(input == 1)
        {
            System.out.println("Congrats! You found daylight and escaped!");
            daylight();
        }
        else if(input == 2)
        {
            start();
        }
    }

    public void fight() {
        double chance = (Math.random() * 101);
        String weapon;
        if (hasSword)
            weapon = "sword";
        else
            weapon = "fists";
        String victoryMessage = "You defeat the giant with your "+ weapon +" and run out of the cave!";
        String deathMessage = "You get stomped by the giant and red stuff goes everywhere.";

        if (hasSword) {
            if (chance > 25.0)
                System.out.println(victoryMessage);
            else
                System.out.println(deathMessage);
        } else {
            if (chance < 10)
                System.out.println(victoryMessage);
            else
                System.out.println(deathMessage);
        }
    }

    public void daylight()
    {
        System.out.println("Now that you escaped, will you tell others of your adventure?\n1. Yes \n2. No");
        int input = keyboardInput.nextInt();
        if(input == 1)
        {
            System.out.println("You will become the greatest hero of the land.");
        }
        else if(input == 2)
        {
            System.out.println("That's lame.");
        }
    }

    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}