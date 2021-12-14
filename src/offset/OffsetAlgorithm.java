package offset;

import org.w3c.dom.ls.LSOutput;

public class OffsetAlgorithm {

    public static String encode(String message, int offset) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'а';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 32;
                char newCharacter = (char) ('а' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static String decode(String message, int offset){
        return encode(message, 32 - (offset % 32));
    }

    public static void dec1(String message, int offset){
        for(int i = 0;offset-i > -1; i++){
            System.out.println(offset+i + " => " + decode(message, offset+i));
            System.out.println(offset-i + " => " + decode(message, offset-i));
        }
    }

    public static void main(String[] args) {
        System.out.println(OffsetAlgorithm.encode("абвгд",4));
        System.out.println(OffsetAlgorithm.decode(OffsetAlgorithm.encode("абвгд",4),4));
    }


}
