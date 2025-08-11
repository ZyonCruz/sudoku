import java.util.Scanner;

/**
 * Classe principal para o jogo de Sudoku.
 * Gerencia o menu interativo e a interação com o usuário.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Erro: Forneça os dados iniciais do tabuleiro como argumentos.");
            return;
        }

        SudokuBoard gameBoard = new SudokuBoard(args);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Jogo de Sudoku ---");
            System.out.println("1. Iniciar um novo jogo");
            System.out.println("2. Colocar um novo número");
            System.out.println("3. Remover um número");
            System.out.println("4. Visualizar a situação atual do jogo");
            System.out.println("5. Verificar status do jogo");
            System.out.println("6. Limpar o tabuleiro (remover jogadas do usuário)");
            System.out.println("7. Finalizar o jogo");
            System.out.print("Escolha uma opção: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer após ler o número
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer do scanner
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\nIniciando um novo jogo...");
                    gameBoard = new SudokuBoard(args); // Reinicia o tabuleiro
                    gameBoard.displayBoard();
                    break;
                case 2:
                    try {
                        System.out.print("Digite a linha, coluna e valor (ex: 0 0 5): ");
                        int row = scanner.nextInt();
                        int col = scanner.nextInt();
                        int value = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer
                        if (row >= 0 && row < 9 && col >= 0 && col < 9 && value >= 1 && value <= 9) {
                            gameBoard.placeNumber(row, col, value);
                        } else {
                            System.out.println("Entrada inválida. Linha e coluna devem ser de 0 a 8 e o valor de 1 a 9.");
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Formato de entrada inválido. Digite três números inteiros separados por espaço.");
                        scanner.nextLine(); // Limpa o buffer em caso de erro
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Digite a linha e coluna do número a ser removido (ex: 0 0): ");
                        int row = scanner.nextInt();
                        int col = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer
                        if (row >= 0 && row < 9 && col >= 0 && col < 9) {
                            gameBoard.removeNumber(row, col);
                        } else {
                            System.out.println("Entrada inválida. Linha e coluna devem ser de 0 a 8.");
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Formato de entrada inválido. Digite dois números inteiros separados por espaço.");
                        scanner.nextLine(); // Limpa o buffer em caso de erro
                    }
                    break;
                case 4:
                    gameBoard.displayBoard();
                    break;
                case 5:
                    System.out.println(gameBoard.getGameStatus());
                    break;
                case 6:
                    gameBoard.clearBoard();
                    gameBoard.displayBoard();
                    break;
                case 7:
                    if (gameBoard.isComplete() && !gameBoard.checkErrors()) {
                        System.out.println("\nParabéns! O jogo foi finalizado com sucesso!");
                        running = false;
                    } else {
                        System.out.println("\nErro: O jogo não está completo ou contém erros. Não é possível finalizar.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Escolha um número de 1 a 7.");
            }
        }
        scanner.close();
    }
}