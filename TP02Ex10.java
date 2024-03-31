// Leandro e Joao Marcos
// 10. Entrar com uma matriz de ordem MxM, onde a ordem também será escolhida pelo usuário, sendo que no máximo será de ordem 10 e quadrática. Após a digitação dos elementos, calcular e exibir a matriz inversa. Exibir as matrizes na tela, sob a forma matricial (linhas x colunas).
import java.util.Scanner;

public class TP02Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a ordem da matriz (MxM, maximo 10): ");
        int ordem = scanner.nextInt();

        // Verifica se a ordem da matriz esta dentro dos limites
        if (ordem < 1 || ordem > 10) {
            System.out.println("A ordem da matriz deve ser um numero entre 1 e 10.");
            return;
        }

        // Entrada dos elementos da matriz
        double[][] matriz = new double[ordem][ordem];
        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                System.out.print("Elemento [" + (i+1) + "][" + (j+1) + "]: ");
                matriz[i][j] = scanner.nextDouble();
            }
        }

        // Calculo da matriz inversa
        double[][] inversa = calcularMatrizInversa(matriz);

        // Exibicao da matriz inversa
        System.out.println("Matriz Inversa:");
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                System.out.printf("%.2f\t", inversa[i][j]);
            }
            System.out.println();
        }
    }

    // Metodo para calcular a matriz inversa
    private static double[][] calcularMatrizInversa(double[][] matriz) {
        int ordem = matriz.length;
        double[][] identidade = new double[ordem][ordem];
        double[][] matrizEstendida = new double[ordem][ordem * 2];

        // Criando uma matriz identidade
        for (int i = 0; i < ordem; i++) {
            identidade[i][i] = 1;
        }

        // Criando uma matriz estendida (matriz | identidade)
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                matrizEstendida[i][j] = matriz[i][j];
                matrizEstendida[i][j + ordem] = identidade[i][j];
            }
        }

        // Realizando operacoes de eliminacao de Gauss-Jordan
        for (int i = 0; i < ordem; i++) {
            double pivot = matrizEstendida[i][i];
            for (int j = 0; j < ordem * 2; j++) {
                matrizEstendida[i][j] /= pivot;
            }
            for (int k = 0; k < ordem; k++) {
                if (k != i) {
                    double factor = matrizEstendida[k][i];
                    for (int j = 0; j < ordem * 2; j++) {
                        matrizEstendida[k][j] -= factor * matrizEstendida[i][j];
                    }
                }
            }
        }

        // Retornando a parte direita da matriz estendida (a parte que deveria ser a inversa)
        double[][] inversa = new double[ordem][ordem];
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                inversa[i][j] = matrizEstendida[i][j + ordem];
            }
        }
        return inversa;
    }
}
