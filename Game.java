/*
Game class for project 2
Author: Rodrigo Sanchez-Marentes
 */
package game;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Rodri
 */
public class Game{

     /**
     * @param args the command line arguments
     */
       static int totalRed = 0;
       static int totalBlue = 0;
       static int totalGreen = 0;
       static int totalYellow = 0;
       static int totalBurp = 0;
       static int skipped = 0;
       static int rest = 0;
       static int sRed = 0;
       static int sBlue = 0;
       static int sGreen = 0;
       static int sYellow = 0;
       static int bRed = 0;
       static int bBlue = 0;
       static int bGreen = 0;
       static int bYellow = 0;

    
   public static void main(String[] args) throws FileNotFoundException {
           try (PrintWriter out = new PrintWriter("test.html") // this will write an html file
           ) {
               String playerName;
               Scanner n= new Scanner(System.in);  // Create a Scanner object
               System.out.println("Enter player name: "); //ask user for input
               playerName = n.nextLine(); //user input
               
               Player thePlayer = new Player();
               int decksUsed = thePlayer.numberOfDecks();
               
               Boolean UseOfSpecial = thePlayer.UseOfSpecial();
               
               Deck setDeck = new Deck(decksUsed, UseOfSpecial, false);
               Card[] draw7 = new Card[7];
               Hand makeHand = new Hand(draw7);
               String html = "<div><h1 style=\"font-size:700%;\" >UNO EXERCISE GAME</h1></div>" + //start of the html file
        " <style>" +
        "h1 {" +
        "text-align:center;" +
        "}" +
        " th, td, tr {" +
        " padding: 15px;" +
        " border: 3px solid black;" +
        " font-size: 20px " +
        "    }" +
        " </style>" +
        "<TABLE  BGCOLOR=\"WHITE\" BORDER=\"10\" WIDTH=\"100%\" CELLPADDING=\"4\" CELLSPACING=\"3\">\n" +  // just playing around with how to format tables in HTML dont judge
        "   <TR>\n" +
        "      <TH COLSPAN=\"19\">\n" +
        "         <H3 style=\"font-size:150%;\" ><BR>" + "Player Name: "  + playerName +
        "  -  Number of decks used: " + decksUsed +
        "  -  Using special cards: " + UseOfSpecial +
        "</H3>\n" +
        "      </TH>\n" +
        "   </TR>\n";
out.println(html);
               
               int counter = 1; //counter keeps track of the round the game is on
               
               while(!setDeck.isEmpty()) {
                Card[] handI = new Card[7];
                for(int i = 0; i< handI.length; i++){
                    handI[i] = setDeck.draw();
                    out.println("<TD>" + handI[i] + "</TD>\n"); //for loop to pint out the hand
                }

                handI = makeHand.sort(handI);
                int[] intarr = new int[14];
                intarr = makeHand.compute(handI);
    
                totalRed += intarr[0];
                totalBlue += intarr[1];
                totalGreen += intarr[2];
                totalYellow += intarr[3];
                totalBurp += intarr[4];
                sRed += intarr[5];
                sBlue += intarr[6];
                sGreen += intarr[7];
                sYellow += intarr[8];
                if(intarr[9] > bRed){
                    bRed = intarr[9];
                }
                if(intarr[10] > bBlue){
                    bBlue = intarr[10];
                }
                if(intarr[11] > bGreen){
                    bGreen = intarr[11];
                }
                if(intarr[12] > bYellow){
                    bYellow = intarr[12];
                }
//                Card[] handII = new Card[7];
//                int ind = 0;
//                for(int i = 0; i < handI.length; i++){
//                    int color;
//                    if(handI[i] == null)
//                        break;
//                    if(handI[i].getNumber() == -1){
//                        color = handI[i].getColor();
//                        for(int j = 0; j < handI.length; j++){
//                            if(handI[j] == null){
//                                break;
//                            }
//                            if(handI[j].getColor() == color){
//                                handII[ind] = handI[j];
//                                ind++;
//                            }
//                        }
//                    }
//                }
//                ind = 0;
//                for(int i = 0; i < handII.length; i++){
//                    if(handII[i] == null){
//                        break;
//                    }
//                    setDeck.reInsert(handII[i]);
//                }
                    out.println("<TD> Round: " + counter + "</TD>\n");
                    out.println("<TD> Number of cards left on pile: " + setDeck.cardsLeft() + "</TD>\n");
                    
                        
                
                    out.println("<TD> Situps to be done: " + intarr[0] + "</TD>\n");
                    out.println("<TD> Pushups to be done: " + intarr[1] + "</TD>\n");
                    out.println("<TD> Lunges to be done: " + intarr[2] + "</TD>\n");
                    out.println("<TD> Squats to be done: " + intarr[3] + "</TD>\n");
                    out.println("<TD> Burpees to be done: " + intarr[4] + "</TD>\n");
                    out.println("<TD> Skipped situps to be done: " + intarr[5] + "</TD>\n");
                    out.println("<TD> Skipped pushups to be done: " + intarr[6] + "</TD>\n");
                    out.println("<TD> Skipped lunges to be done: " + intarr[7] + "</TD>\n");
                    out.println("<TD> Skipped squats to be done: " + intarr[8] + "</TD>\n");
                    out.println("<TD> Rest time " + intarr[13] + "</TD>\n");
                     
                    
                    counter++;
                    out.println("<TR> </TR>");
               }


out.println("</TABLE>"); 

out.println("<div><TABLE  BGCOLOR=\"WHITE\" BORDER=\"10\" WIDTH=\"50%\" CELLPADDING=\"4\" CELLSPACING=\"3\">\n");
//makes another table with the end of the game results 
out.println("<TR> <TD> Total number of repetitions for situps: " + totalRed + "</TD> </TR>\n");
out.println("<TR> <TD> Total number of repetitions for pushups: " + totalBlue + "</TD> </TR>\n");
out.println("<TR> <TD> Total number of repetitions for lunges: " + totalGreen + "</TD> </TR>\n");
out.println("<TR> <TD> Total number of repetitions for squats: " + totalYellow + "</TD> </TR>\n");

out.println("<TR> <TD> Total number of repetitions skipped for situps : " + sRed + "</TD> </TR>\n");
out.println("<TR> <TD> Total number of repetitions skipped for pushups : " + sBlue + "</TD> </TR>\n");
out.println("<TR> <TD> Total number of repetitions skipped for lunges : " + sGreen + "</TD> </TR>\n");
out.println("<TR> <TD> Total number of repetitions skipped for squats : " + sYellow + "</TD> </TR>\n");

out.println("<TR> <TD> Biggest number of repetitions for situps : " + bRed + " </TD> </TR>\n");
out.println("<TR> <TD> Biggest number of repetitions for pushups : " + bBlue + " </TD> </TR>\n");
out.println("<TR> <TD> Biggest number of repetitions for lunges : " + bGreen + " </TD> </TR>\n");
out.println("<TR> <TD> Biggest number of repetitions for squats : " + bYellow + " </TD> </TR>\n");

out.println("</TABLE> </div>"); //end of the html 

           }
           
      }

   }


