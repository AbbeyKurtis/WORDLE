
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author abbey
 */

public class WORDLECLASS {
    private String player1Word;

    public WORDLECLASS(String player1Word) {
        this.player1Word = player1Word.toLowerCase();
    }

    public int[] checkPlayer2Word(String player2Word) {
        player2Word = player2Word.toLowerCase();
        int[] result = new int[player2Word.length()];
        ArrayList re = new ArrayList<Integer>();
        for (int i = 0; i<6;i++){
            re.add(0);
                    }
        boolean[] checkedPlayer1Word = new boolean[player1Word.length()];
        boolean[] checkedPlayer2Word = new boolean[player2Word.length()];

        // First pass: Check for correct position
        for (int i = 0; i < player1Word.length(); i++) {
            if (player1Word.substring(i,i+1).equals(player2Word.substring(i,i+1))) {
                re.set(i,3);
                checkedPlayer2Word[i] = true;
            }
        }

        // Second pass: Check for correct letter but wrong position
        for (int i = 0; i < player2Word.length(); i++) {
            if (!checkedPlayer2Word[i]) {
                for (int j = 0; j < player1Word.length(); j++) {
                    if (!checkedPlayer1Word[j] && player2Word.charAt(i) == player1Word.charAt(j)) {
                        re.set(i,2);
                        checkedPlayer2Word[i] = true;
                        break;
                    }
                }
            }
        }

        // Third pass: All remaining are wrong letters
        for (int i = 0; i < player2Word.length(); i++) {
            if (!checkedPlayer2Word[i]) {
                re.set(i,1);
            }
        }
            for (int i = 0;i<player1Word.length(); i++){
                result[i] = (int)(re.get(i));
            }
            
 
        return result;
    }

} 

