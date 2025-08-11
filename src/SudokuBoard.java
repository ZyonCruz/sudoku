/**
 * Gerencia o tabuleiro 9x9 do Sudoku, incluindo sua inicialização,
 * exibição e a lógica para verificar o estado do jogo.
 */
public class SudokuBoard {
    private Cell[][] board;

    public SudokuBoard(String[] args) {
        this.board = new Cell[9][9];
        initializeBoard(args);
    }

    /**
     * Inicializa o tabuleiro a partir dos argumentos de linha de comando.
     * @param args Argumentos de linha de comando com os dados do tabuleiro inicial.
     */
    private void initializeBoard(String[] args) {
        // Inicializa todas as células como vazias.
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                this.board[row][col] = new Cell(0, false);
            }
        }

        // Processa os argumentos para preencher as células fixas.
        for (String arg : args) {
            String[] parts = arg.split(";");
            String[] coords = parts[0].split(",");
            String[] data = parts[1].split(",");

            int row = Integer.parseInt(coords[0]);
            int col = Integer.parseInt(coords[1]);
            int value = Integer.parseInt(data[0]);
            boolean isFixed = Boolean.parseBoolean(data[1]);

            this.board[row][col] = new Cell(value, isFixed);
        }
    }

    /**
     * Exibe o tabuleiro de Sudoku no terminal de forma formatada.
     */
    public void displayBoard() {
        System.out.println("-------------------------");
        for (int row = 0; row < 9; row++) {
            System.out.print("| ");
            for (int col = 0; col < 9; col++) {
                int value = board[row][col].getValue();
                if (value == 0) {
                    System.out.print(". "); // Exibe um ponto para células vazias
                } else {
                    System.out.print(value + " ");
                }
                if ((col + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((row + 1) % 3 == 0) {
                System.out.println("-------------------------");
            }
        }
    }
    
    /**
     * Tenta colocar um número em uma célula.
     * @param row Linha da célula.
     * @param col Coluna da célula.
     * @param value O número a ser inserido.
     * @return Verdadeiro se a operação foi bem-sucedida, falso caso contrário.
     */
    public boolean placeNumber(int row, int col, int value) {
        // Verifica se a célula é válida e não está fixa.
        if (board[row][col].isFixed()) {
            System.out.println("Erro: Não é possível alterar um número fixo do jogo.");
            return false;
        }

        // Atualiza o valor da célula.
        board[row][col].setValue(value);
        return true;
    }
    
    /**
     * Tenta remover um número de uma célula.
     * @param row Linha da célula.
     * @param col Coluna da célula.
     * @return Verdadeiro se a operação foi bem-sucedida, falso caso contrário.
     */
    public boolean removeNumber(int row, int col) {
        // Verifica se a célula pode ser removida (se não for fixa).
        if (board[row][col].isFixed()) {
            System.out.println("Erro: Não é possível remover um número fixo do jogo.");
            return false;
        }

        // Limpa o valor da célula.
        board[row][col].clear();
        return true;
    }
    
    /**
     * Limpa todos os números inseridos pelo usuário, mantendo apenas os fixos.
     */
    public void clearBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board[row][col].clear();
            }
        }
        System.out.println("Tabuleiro limpo. Apenas os números fixos permaneceram.");
    }

    /**
     * Verifica o status completo do jogo, incluindo completude e erros.
     * @return Uma string descrevendo o status do jogo.
     */
    public String getGameStatus() {
        boolean hasErrors = checkErrors();
        boolean isComplete = isComplete();

        if (hasErrors) {
            if (isComplete) {
                return "Status: Completo, mas com Erros";
            } else {
                return "Status: Incompleto e com Erros";
            }
        } else {
            if (isComplete) {
                return "Status: Completo e sem Erros";
            } else {
                return "Status: Incompleto e sem Erros";
            }
        }
    }
    
    /**
     * Verifica se o tabuleiro está totalmente preenchido.
     * @return Verdadeiro se todas as células têm um valor diferente de 0.
     */
    public boolean isComplete() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col].getValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Verifica se o tabuleiro contém algum erro (números duplicados).
     * @return Verdadeiro se houver erros, falso caso contrário.
     */
    public boolean checkErrors() {
        // Verifica linhas, colunas e subgrids por duplicatas
        for (int i = 0; i < 9; i++) {
            if (hasDuplicate(getRow(i)) || hasDuplicate(getCol(i))) {
                return true;
            }
        }
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (hasDuplicate(getSubgrid(row, col))) {
                    return true;
                }
            }
        }
        return false;
    }

    // Métodos auxiliares para checar erros
    private boolean hasDuplicate(int[] values) {
        boolean[] seen = new boolean[10];
        for (int val : values) {
            if (val != 0) {
                if (seen[val]) {
                    return true;
                }
                seen[val] = true;
            }
        }
        return false;
    }
    private int[] getRow(int row) {
        int[] result = new int[9];
        for (int i = 0; i < 9; i++) {
            result[i] = board[row][i].getValue();
        }
        return result;
    }
    private int[] getCol(int col) {
        int[] result = new int[9];
        for (int i = 0; i < 9; i++) {
            result[i] = board[i][col].getValue();
        }
        return result;
    }
    private int[] getSubgrid(int startRow, int startCol) {
        int[] result = new int[9];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[index++] = board[startRow + i][startCol + j].getValue();
            }
        }
        return result;
    }
}