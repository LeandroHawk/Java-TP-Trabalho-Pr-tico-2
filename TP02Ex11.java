// Leandro e Joao Marcos
// 11. Entrar com uma matriz de ordem MxM, onde a ordem tambem sera escolhida pelo usuario, sendo que no maximo sera de ordem 10 e quadratica. Apos a digitacao dos elementos, calcular e exibir determinante da matriz.
import java.util.Scanner;

public class TP02Ex11 {
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

        // Calcula o determinante da matriz
        double determinante = calcularDeterminante(matriz);

        // Exibe o determinante da matriz
        System.out.println("Determinante da matriz: " + determinante);
    }

    // Metodo para calcular o determinante da matriz usando o metodo de Laplace
    private static double calcularDeterminante(double[][] matriz) {
        int ordem = matriz.length;

        if (ordem == 1) {
            return matriz[0][0];
        }

        double determinante = 0;
        int sinal = 1;

        for (int i = 0; i < ordem; i++) {
            double[][] submatriz = new double[ordem - 1][ordem - 1];
            for (int j = 1; j < ordem; j++) {
                for (int k = 0, col = 0; k < ordem; k++) {
                    if (k == i) continue;
                    submatriz[j - 1][col++] = matriz[j][k];
                }
            }
            determinante += sinal * matriz[0][i] * calcularDeterminante(submatriz);
            sinal *= -1;
        }

        return determinante;
    }
}

