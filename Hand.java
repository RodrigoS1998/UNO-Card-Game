
package game;
//CS 2365 OOP Spring 2020 Section 002
//Jose Torres
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import game.Card;
import game.Deck;
/**
 *
 * @author josej
 */
public class Hand {
    Card [] draw7;
    public Hand(Card[] a){
        draw7 = a;
    }
    public Card[] sort(Card[] draw7){
        //sorts the colors
        for(int i = 0; i < draw7.length; i++){
            if(draw7[i] == null){
                break;
            }
            int temp1 = draw7[i].getColor();
            for(int l = 0; l < draw7.length; l++){
                if(draw7[l] == null){
                    break;
                }
                int temp2 = draw7[l].getColor();
                if(temp1 > temp2){
                    Card temp = new Card(draw7[l].getColor(),draw7[l].getNumber());
                    draw7[l] = draw7[i];
                    draw7[i] = temp;
                }
            }
        }
        //sorts the numbers and special cards
        for(int i = 0; i < draw7.length; i++){
            if(draw7[i] == null){
                break;
            }
            for(int l = 0; l < draw7.length; l++){
                if(draw7[l] == null){
                    break;
                }
                if(draw7[i].getNumber() < draw7[l].getNumber()){
                    Card temp = new Card(draw7[l].getColor(),draw7[l].getNumber());
                    draw7[l] = draw7[i];
                    draw7[i] = temp;
                }
            }
        }
        return draw7;
    }
    public int[] compute(Card[] draw7){
        int totalRed = 0;
        int totalBlue = 0;
        int totalGreen = 0;
        int totalYellow = 0;
        int totalBurp = 0;
        int sRed = 0;
        int sBlue = 0;
        int sGreen = 0;
        int sYellow = 0;
        int bRed = -1;
        int bBlue = -1;
        int bGreen = -1;
        int bYellow = -1;
        int rest = 0;
        
        int reps[] = new int[14];
        
        
        for(int i = 0; i < draw7.length; i++){
            if(draw7[i] == null){
                break;
            }
            int color = draw7[i].getColor();
            if(draw7[i].getNumber() == 0){//sees how many 0's
                rest++;
            }
            switch(color){
                case 1:
                    if(draw7[i].getNumber() >= 0){
                        totalYellow += draw7[i].getNumber();
                    }
                    break;
                case 4:
                    if(draw7[i].getNumber() >= 0){
                        totalBlue += draw7[i].getNumber();
                    }
                    break;
                case 2:
                    if(draw7[i].getNumber() >= 0){
                        totalRed += draw7[i].getNumber();
                    }
                    break;
                case 3:
                    if(draw7[i].getNumber() >= 0){
                        totalGreen += draw7[i].getNumber();
                    }
                    break;
                case 0:
                    totalBurp += 10;
                    break;
            }
        }
        for(int i = 0; i < draw7.length - 1; i++){
            if(draw7[i] == null){
                break;
            }
            int value = draw7[i].getNumber();
            int color = draw7[i].getColor();
            switch(value){
                case -3:
                    if(color == 1){
                        totalYellow = totalYellow * 0;
                    }
                    else if(color == 4){
                        totalBlue = totalBlue * 0;
                    }
                    else if(color == 2){
                        totalRed = totalRed * 0;
                    }
                    else{
                        totalGreen = totalGreen * 0;
                    }
                    for(int l = i + 1; l < draw7.length; l++){
                        if(draw7[l] == null){
                            break;
                        }
                        if(draw7[l].getColor() == color){
                            int val = draw7[l].getNumber();
                            if(color == 1){
                                sYellow += val;
                            }
                            else if(color == 4){
                                sBlue += val;
                            }
                            else if(color == 2){
                                sRed += val;
                            }
                            else
                                sGreen += val;
                        }
                    }
                    break;
                case -2:
                    if(color == 1){
                        totalYellow = totalYellow * 2;
                    }
                    else if(color == 4){
                        totalBlue = totalBlue * 2;
                    }
                    else if(color == 2){
                        totalRed = totalRed * 2;
                    }
                    else{
                        totalGreen = totalGreen * 2;
                    }
                    break;
                case -1:
                    if(color == 1){
                        totalYellow = totalYellow * 0;
                    }
                    else if(color == 4){
                        totalBlue = totalBlue * 0;
                    }
                    else if(color == 2){
                        totalRed = totalRed * 0;
                    }
                    else{
                        totalGreen = totalGreen * 0;
                    }
                    break;
                case 11:
                    if(color == 1){
                        totalYellow = totalYellow * 4;
                    }
                    else if(color == 4){
                        totalBlue = totalBlue * 4;
                    }
                    else if(color == 2){
                        totalRed = totalRed * 4;
                    }
                    else{
                        totalGreen = totalGreen * 4;
                    }
                    break;
            }
        }
        reps[0] = totalRed;
        reps[1] = totalBlue;
        reps[2] = totalGreen;
        reps[3] = totalYellow;
        reps[4] = totalBurp;
        reps[5] = sRed;
        reps[6] = sBlue;
        reps[7] = sGreen;
        reps[8] = sYellow;
        reps[9] = totalRed;
        reps[10] = totalBlue;
        reps[11] = totalGreen;
        reps[12] = totalYellow;
        reps[13] = rest;
        return reps;
    }
    
    
}
