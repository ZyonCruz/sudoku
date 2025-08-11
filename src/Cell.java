/**
 * Representa uma célula individual do tabuleiro de Sudoku.
 * Cada célula armazena um valor numérico e um status que indica se o número é fixo.
 */
public class Cell {
    private int value;
    private boolean isFixed;

    /**
     * Construtor para inicializar uma célula.
     * @param value O valor numérico (1-9) ou 0 para célula vazia.
     * @param isFixed Indica se a célula é parte do tabuleiro inicial e não pode ser alterada.
     */
    public Cell(int value, boolean isFixed) {
        this.value = value;
        this.isFixed = isFixed;
    }

    // Getters e Setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        // Permite alterar o valor apenas se a célula não for fixa.
        if (!this.isFixed) {
            this.value = value;
        }
    }

    public boolean isFixed() {
        return isFixed;
    }

    /**
     * Limpa o valor da célula, se ela não for fixa, definindo-o para 0.
     */
    public void clear() {
        if (!this.isFixed) {
            this.value = 0;
        }
    }
}