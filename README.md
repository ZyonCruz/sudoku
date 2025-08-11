# Jogo de Sudoku em Java

Este projeto é uma implementação de um jogo de Sudoku interativo, desenvolvido em Java. A aplicação é executada via linha de comando (terminal) e permite que o usuário jogue Sudoku, inserindo e removendo números, visualizando o estado do tabuleiro e verificando a situação do jogo.

O tabuleiro inicial é fornecido através dos argumentos de linha de comando, permitindo diferentes desafios. A aplicação utiliza Programação Orientada a Objetos (POO) com classes como `Cell` (para representar cada célula do tabuleiro) e `SudokuBoard` (para gerenciar a lógica do jogo).

## Funcionalidades

O jogo oferece um menu interativo com as seguintes opções:

1.  **Iniciar um novo jogo**: Reinicia o tabuleiro para o estado inicial, conforme os argumentos fornecidos.
2.  **Colocar um novo número**: Permite que o usuário insira um número em uma célula vazia (não fixa).
3.  **Remover um número**: Remove um número inserido pelo usuário, deixando a célula vazia.
4.  **Visualizar a situação atual do jogo**: Exibe o tabuleiro de Sudoku no terminal.
5.  **Verificar status do jogo**: Analisa o tabuleiro e informa se está completo, incompleto, com erros ou sem erros.
6.  **Limpar o tabuleiro**: Remove todos os números inseridos pelo usuário, mantendo apenas os fixos.
7.  **Finalizar o jogo**: Permite que o usuário encerre a aplicação. A finalização só é possível se o tabuleiro estiver completo e sem erros.

## Como Compilar e Executar

Siga os passos abaixo para rodar a aplicação a partir do terminal.

1.  **Compilação:** Certifique-se de que o seu terminal está no diretório raiz do projeto e execute o seguinte comando para compilar os arquivos Java.
    ```bash
    javac -sourcepath src -d bin -encoding UTF-8 src/Main.java
    ```

2.  **Execução:** Após a compilação, execute o programa com a string de argumentos que define o tabuleiro inicial.
    ```bash
    java -cp bin Main "0,0;4,false" "1,0;7,false" "2,0;9,true" "3,0;5,false" "4,0;8,true" "5,0;6,true" "6,0;2,true" "7,0;3,false" "8,0;1,false" "0,1;1,false" "1,1;3,true" "2,1;5,false" "3,1;4,false" "4,1;7,true" "5,1;2,false" "6,1;8,false" "7,1;9,true" "8,1;6,true" "0,2;2,false" "1,2;6,true" "2,2;8,false" "3,2;9,false" "4,2;1,true" "5,2;3,false" "6,2;7,false" "7,2;4,false" "8,2;5,true" "0,3;5,true" "1,3;1,false" "2,3;3,true" "3,3;7,false" "4,3;6,false" "5,3;4,false" "6,3;9,false" "7,3;8,true" "8,3;2,false" "0,4;8,false" "1,4;9,true" "2,4;7,false" "3,4;1,true" "4,4;2,true" "5,4;5,true" "6,4;3,false" "7,4;6,true" "8,4;4,false" "0,5;6,false" "1,5;4,true" "2,5;2,false" "3,5;3,false" "4,5;9,false" "5,5;8,false" "6,5;1,true" "7,5;5,false" "8,5;7,true" "0,6;7,true" "1,6;5,false" "2,6;4,false" "3,6;2,false" "4,6;3,true" "5,6;9,false" "6,6;6,false" "7,6;1,true" "8,6;8,false" "0,7;9,true" "1,7;8,true" "2,7;1,false" "3,7;6,false" "4,7;4,true" "5,7;7,false" "6,7;5,false" "7,7;2,true" "8,7;3,false" "0,8;3,false" "1,8;2,false" "2,8;6,true" "3,8;8,true" "4,8;5,true" "5,8;1,false" "6,8;4,true" "7,8;7,false" "8,8;9,false"
    ```
    (Obs.: A string de argumentos de inicialização pode ser longa, mas é fundamental para o jogo.)

## Estrutura do Projeto

* `src/`: Contém os arquivos de código-fonte (`.java`).
* `bin/`: Diretório de saída para os arquivos compilados (`.class`).