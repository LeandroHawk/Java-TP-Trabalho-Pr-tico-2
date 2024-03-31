// Leandro e João Marcos
// 8. Entrar via teclado com doze valores e armazená-los em uma matriz de ordem 3x4. Após adigitação dos valores solicitar uma constante multiplicativa, que deverá multiplicar cada valor matriz e armazenar o resultado em outra matriz de mesma ordem, nas posições correspondentes. Exibir as matrizes na tela, sob a forma matricial, ou seja, linhas por colunas.

import java.util.Scanner;

public class TP02Ex08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definindo a matriz 3x4 para armazenar os valores digitados
        int[][] matriz = new int[3][4];

        // Entrada dos valores via teclado
        System.out.println("Digite os doze valores para a matriz 3x4:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Criando outra matriz para armazenar o resultado da multiplicacao
        int[][] matrizResultado = new int[3][4];

        // Solicitar a constante multiplicativa
        System.out.println("Digite a constante multiplicativa:");
        int constante = scanner.nextInt();

        // Multiplicar cada valor da matriz pela constante e armazenar no matrizResultado
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrizResultado[i][j] = matriz[i][j] * constante;
            }
        }

        // Exibindo a matriz original
        System.out.println("Matriz original (3x4):");
        exibirMatriz(matriz);

        // Exibindo a matriz resultante
        System.out.println("Matriz resultante (apos multiplicacao pela constante):");
        exibirMatriz(matrizResultado);

        scanner.close();
    }

    // Metodo para exibir uma matriz
    public static void exibirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
