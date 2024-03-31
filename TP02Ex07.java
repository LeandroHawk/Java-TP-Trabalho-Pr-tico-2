import java.util.Scanner;
// Leandro e João Marcos
// 7. Calcular e exibir a média geométrica de dois valores quaisquer que serão digitados.
public class TP02Ex07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definindo a matriz 3x4 para armazenar os valores
        int[][] matriz = new int[3][4];

        // Entrada dos valores via teclado
        System.out.println("Digite os doze valores:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Solicitar a constante multiplicativa
        System.out.println("Digite a constante multiplicativa:");
        int constante = scanner.nextInt();

        // Multiplicar cada valor da matriz pela constante
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] *= constante;
            }
        }

        // Exibir a matriz com os valores multiplicados
        System.out.println("Matriz resultante:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
