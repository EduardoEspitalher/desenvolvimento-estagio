package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Faturamento {
    public static void main(String[] args) {
        try {
            // Carregar o JSON de faturamento
            ObjectMapper mapper = new ObjectMapper();
            JsonNode faturamento = mapper.readTree(new File("/home/eduardo/desenvolvimento-estagio/codigos_estagio/src/main/java/org/example/faturamento.json"));

            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double soma = 0;
            int diasComFaturamento = 0;
            List<Double> valores = new ArrayList<>();

            // Iterar sobre os dias e calcular menor, maior, e soma para a média
            for (JsonNode dia : faturamento) {
                double valor = dia.get("valor").asDouble();

                if (valor > 0) { // Ignorar dias sem faturamento
                    if (valor < menorValor) {
                        menorValor = valor;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }
                    soma += valor;
                    diasComFaturamento++;
                    valores.add(valor);
                }
            }

            double mediaMensal = soma / diasComFaturamento;

            // Contar dias com faturamento acima da média
            int diasAcimaDaMedia = 0;
            for (double valor : valores) {
                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            // Exibir resultados
            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
