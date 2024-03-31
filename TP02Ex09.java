// Leandro e João Marcos
// 9. Entrar com uma matriz de ordem MxN, onde a ordem também será escolhida pelo usuário, sendo que no máximo 10x10. A matriz não precisa ser quadrática. Após a digitação dos elementos, calcular e exibir a matriz transposta. 

import java.util.Scanner;

public class TP02Ex09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada da ordem da matriz pelo usuario (MxN)
        System.out.println("Digite o numero de linhas (M): ");
        int linhas = scanner.nextInt();
        System.out.println("Digite o numero de colunas (N): ");
        int colunas = scanner.nextInt();

        // Verificar se a ordem e valida (no maximo 10x10)
        if (linhas <= 0 || linhas > 10 || colunas <= 0 || colunas > 10) {
            System.out.println("Ordem invalida! As dimensoes devem estar entre 1 e 10.");
            return;
        }

        // Criar a matriz com as dimensoes especificadas
        int[][] matriz = new int[linhas][colunas];

        // Preencher a matriz com os valores fornecidos pelo usuario
        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Exibir a matriz original
        System.out.println("Matriz original:");
        exibirMatriz(matriz);

        // Calcular e exibir a matriz transposta
        int[][] transposta = calcularTransposta(matriz);
        System.out.println("Matriz transposta:");
        exibirMatriz(transposta);

        scanner.close();
    }

    // Metodo para calcular a matriz transposta
    public static int[][] calcularTransposta(int[][] matriz) {
        int linhas = matriz.length;
        int colunas = matriz[0].length;
        int[][] transposta = new int[colunas][linhas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                transposta[j][i] = matriz[i][j];
            }
        }

        return transposta;
    }

    // Metodo para exibir uma matriz
    public static void exibirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
