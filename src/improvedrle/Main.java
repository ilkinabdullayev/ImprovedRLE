package improvedrle;

import java.util.Scanner;

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

            char previousCharacter = ' ';
            char nextCharacter = ' ';

            String lastConcatedWord = previousCharacter + "" + k;
            int indexConcateWord = encodeString.length() - lastConcatedWord.length();

            if ((i != 0) && (currentCharacter == (previousCharacter=words.charAt(i - 1)))) {
                k++;
                currentConcatedWord = currentCharacter + "" + k;
                encodeString.replace(indexConcateWord, encodeString.length(), currentConcatedWord);
            } else if ((i != wordLength - 1) && (currentCharacter == (nextCharacter=words.charAt(i + 1)))) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String enteringStringLine = scanner.nextLine();

        Main improvedRLE = new Main();
        improvedRLE.doCompress(enteringStringLine);

        System.out.println(encodeString);
    }

}
