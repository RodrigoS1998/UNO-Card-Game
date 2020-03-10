/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

// Author - Joshua Greenawalt
// This class makes the cards

//CS 2365 OOP Spring 2020 Section 002
//Matthew Uriegas
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author murie
 */
public class Card {
    
    private final static int SPECIAL = 0, 
            YELLOW = 1, RED = 2, GREEN = 3, BLUE = 4;
    private final static int SKIP = -3, 
            PLUS2 = -2, REVERSE = -1, WILD = 10, WILD4 = 11;   
//    private String cardcolor;//"Red", "Blue", "Green", "Yellow", "Special"
//    private int cardnum;// has to be between -5 and 9
    
    private final int cardColor;
    private final int value;
    
    public Card(int color, int num){
        this.cardColor = color;
        this.value = num;
    }
    public int getColor(){
        return cardColor;
    }
    public int getNumber(){
        return value; //11 - wild draw4, 10 - wild, -3 - skip, -1 - reverse, -2 - draw2
    }
        
    public String getColorString() {
            // Return a String representing the card's suit.
            // (If the card's suit is invalid, "??" is returned.)
        switch ( cardColor ) {
           case SPECIAL:    return "Special";
           case YELLOW:     return "Yellow";
           case RED:        return "Red";
           case GREEN:      return "Green";
           case BLUE:       return "Blue";
           default:       return "??";
        }
    }
    
    public String getValueString(){
        switch ( value ){
            case -3:    return "Skip";
            case -2:    return "Plus 2";
            case -1:    return "Reverse";
            case 0:     return "0";
            case 1:     return "1";
            case 2:     return "2";
            case 3:     return "3";
            case 4:     return "4";
            case 5:     return "5";
            case 6:     return "6";
            case 7:     return "7";
            case 8:     return "8";
            case 9:     return "9";
            case 10:    return "Wild";
            case 11:    return "Wild Plus 4";
            default:    return "??";
        }
    }
    
    @Override
    public String toString(){
        return getColorString() + " " + getValueString();
    }
    
    

}
