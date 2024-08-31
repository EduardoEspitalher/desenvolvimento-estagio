package org.example;

import java.util.Scanner;

public class InverterString {
    public static void main(String[] args) {
        // Solicitar entrada do usuário
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string para inverter: ");
        String original = scanner.nextLine();
        scanner.close();

        // Inicializar uma variável para armazenar a string invertida
        String invertida = "";

        // Percorrer a string original de trás para frente
        for (int i = original.length() - 1; i >= 0; i--) {
            invertida += original.charAt(i);
        }

        // Exibir a string invertida
        System.out.println("String invertida: " + invertida);
    }
}