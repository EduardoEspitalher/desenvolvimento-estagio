package org.example;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();
        scanner.close();

        if (MetFibonacci(numero)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }
    }

    public static boolean MetFibonacci(int numero) {
        if (numero == 0 || numero == 1) {
            return true;
        }

        int a = 0, b = 1, c = 1;
        while (c < numero) {
            c = a + b;
            a = b;
            b = c;
        }
        return c == numero;
    }
}
