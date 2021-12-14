package main;

import gammir.GammirAlgorithm;
import offset.OffsetAlgorithm;
import permutations.PermutationAlgorithm;

import java.util.Scanner;

public class ApplicationClass {
    public static void main(String[] args) {
        String exit = "exit";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Что планируете сделать(введите число): шифровать(1), дешифровать(2)");
            String var = scanner.next();
            System.out.println("Выберете алгоритм: сдвиг(1), перестановка(2), гаммирование(3)");
            String var2 = scanner.next();
            System.out.println("Введите текст");
            String text = scanner.next();
            System.out.println("Введите ключ");
            String key = scanner.next();
            if (var.equals("1") && var2.equals("1")) {
                System.out.println(OffsetAlgorithm.encode(text, Integer.valueOf(key)));
            } else if (var.equals("1") && var2.equals("2")) {
                System.out.println(PermutationAlgorithm.encode(text.toString(), Integer.valueOf(key)));
            } else if (var.equals("1") && var2.equals("3")) {
                System.out.println(new GammirAlgorithm().encode(text.toString(), key));
            } else if (var.equals("2") && var2.equals("1")) {
                System.out.println(OffsetAlgorithm.decode(text.toString(), Integer.valueOf(key)));
            } else if (var.equals("2") && var2.equals("2")) {
                System.out.println(PermutationAlgorithm.decode(text.toString(), Integer.valueOf(key)));
            } else if (var.equals("2") && var2.equals("3")) {
                System.out.println(new GammirAlgorithm().decode(text.toString(), key));
            } else if (var.equals("exit") || var2.equals("exit")) {
                System.exit(0);
            } else {
                System.out.println("Please enter correct variant");
            }
        }
    }
}
