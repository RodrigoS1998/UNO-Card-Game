package game;
/*Player class for project 2
Author: Razan Alnaber 
*/
import java.util.Scanner;
//A class that defines functions & decisions of the player
public class Player {
   
    String playerName;
  
    //Asks user for player name
public Player() {
}

 
   
    //Returns the player's name
    public String returnName() {
       
        return playerName;
       
    }
      
    //Asks user for number of decks to use in this game (1-3 decks allowed)
    //then returns that number
    public int numberOfDecks (){
        Scanner d= new Scanner (System.in);
        System.out.println("Enter the number of decks for this game: ");
        int numberDecks = d.nextInt();
        //Checks to make sure user picks # between 1-3
        while (numberDecks < 1 || numberDecks > 3){
            System.out.println("Error: Please enter a number between 1-3!");
            numberDecks = d.nextInt();
        }
    
        return numberDecks;
   
    }
   
    //Asks user if they want to play with or without special cards
    //and returns the user's input
    public boolean UseOfSpecial (){
        Scanner s= new Scanner (System.in);
        System.out.println("Would you like to play with special cards? [Y/N]");
        String useSpecial = s.nextLine().trim();
        while(!useSpecial.toLowerCase().equals("y") && !useSpecial.toLowerCase().equals("n")){
             System.out.println("Error: Please enter a valid answer!");
             useSpecial = s.nextLine().trim();
        }

        if(useSpecial.toLowerCase().equals("n")){
             return false;
        }

        return true;
    }

    
   // This lets the user decide whether to shuffle multiple decks together 
    // or separately 
     public boolean shuffleCards(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 1 to shuffle individually or 2 to shuffle the decks together: ");
        int a = s.nextInt();
        switch(a){
            case 1:
                return true;
            case 2:
                return false;
        }
        return true;
     }
   } 

