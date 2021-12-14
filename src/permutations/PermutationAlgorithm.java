package permutations;

import java.util.Arrays;

public class PermutationAlgorithm {

    public static String encode(String source, int digit) {
        StringBuilder charBox = new StringBuilder();
        int counter = 0;
        Character[][] matrix = new Character[source.length()/digit+1][digit];
        for (Character [] line: matrix) {
            Arrays.fill(line,'$');
        }

        for (int j = 0 ; j < source.length()/digit + 1; j++) {
            for (int i = 0; i < digit; i++) {
                if(digit * j + i < source.length())
                    matrix[j][i] = source.charAt(digit * j + i);
            }
        }
        for (int j = 0 ; j < digit; j++) {
            for (int i = 0; i < source.length()/digit + 1; i++) {
                charBox.append(matrix[i][j]);
            }
        }
        return charBox.toString().replaceAll("\\$","");
    }

    public static String decode(String source, int digit) {
        int num = digit - (source.length() % digit);
        for (int i = 0; i < num; i++) {
            source = new StringBuilder(source).insert(source.length()-(i*(source.length()/digit+1)), "$").toString();
        }
        return encode(source,source.length()/digit);
    }

    public static void dec(String source, int digit){
        for(int i = 0;digit-i > 0; i++){
            System.out.println(digit+i + " => " + decode(source, digit+i));
            System.out.println(digit-i + " => " + decode(source, digit-i));
        }
    }

    public static void main(String[] args) {
        String ss = "Папа решает-Антон сдает"; // исходное сообщение
        System.out.println(encode(ss,4));
        System.out.println(decode(encode(ss,4),4));// зашифрованное
//        dec(encode(ss,4),6);// зашифрованное
    }
}
