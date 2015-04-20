package improvedrle;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Ilkin Abdullayev
 */
public class Main {    
    static StringBuilder encodeString = new StringBuilder();

    public void doCompress(String words) {
        words = words.replace(" ", "");

        int wordLength = words.length();
        int k = 0;
        for (int i = 0; i < wordLength; i++) {
            char currentCharacter = words.charAt(i);
            String currentConcatedWord = null;
            if (i == 0) {
                k++;
                currentConcatedWord = currentCharacter + "" + k;
                encodeString.append(currentConcatedWord);               
            } else if (i == wordLength - 1) {
                char previousCharacter = words.charAt(i - 1);

                String lastConcatedWord = previousCharacter + "" + k;
                int indexConcateWord = encodeString.length() - lastConcatedWord.length();

                if (currentCharacter == previousCharacter) {
                    k++;
                    currentConcatedWord = currentCharacter + "" + k;
                    encodeString.replace(indexConcateWord, encodeString.length(), currentConcatedWord);                  
                } else {
                    if (k == 1) {
                        currentConcatedWord = previousCharacter + "" + currentCharacter + "" + k;
                        encodeString.replace(indexConcateWord, encodeString.length(), currentConcatedWord);                    
                    } else {
                        k = 0;
                        k++;
                        currentConcatedWord = currentCharacter + "" + k;
                        encodeString.append(currentConcatedWord);                        
                    }
                }
            } else {
                char previousCharacter = words.charAt(i - 1);
                char nextCharacter = words.charAt(i + 1);

                String lastConcatedWord = previousCharacter + "" + k;
                int indexConcateWord = encodeString.length() - lastConcatedWord.length();

                if (currentCharacter == previousCharacter) {
                    k++;
                    currentConcatedWord = currentCharacter + "" + k;
                    encodeString.replace(indexConcateWord, encodeString.length(), currentConcatedWord);                   
                } else if (currentCharacter == nextCharacter) {
                    k = 0;
                    k++;
                    currentConcatedWord = currentCharacter + "" + k;
                    encodeString.append(currentConcatedWord);                   
                } else {
                    if (k == 1) {
                        currentConcatedWord = previousCharacter + "" + currentCharacter + "" + k;
                        encodeString.replace(indexConcateWord, encodeString.length(), currentConcatedWord);                       
                    } else {
                        k = 0;
                        k++;
                        currentConcatedWord = currentCharacter + "" + k;
                        encodeString.append(currentConcatedWord);                       
                    }
                }
            }
        }

    }

    public static void main(String[] args) {        
        Scanner scanner=new Scanner(System.in);
        String enteringStringLine=scanner.nextLine();        
        
        Main improvedRLE = new Main();
        improvedRLE.doCompress(enteringStringLine);
        
        System.out.println(encodeString);
    }

}
