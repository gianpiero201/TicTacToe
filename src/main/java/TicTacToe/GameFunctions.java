/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TicTacToe;

import java.util.Arrays;

/**
 *
 * @author gian_
 */
public class GameFunctions {

    private int[] X = new int[9];
    private int[] O = new int[9];
    private int[] velha = new int[9];
    int[] quadradoMagico = {4, 9, 2, 3, 5, 7, 8, 1, 6};
    private int jogadas = 0;
    private int jogadorAtual = 1;

    public String Play(int posicao) {
        boolean teste = this.campoJaSelecionado(posicao);
        if (teste) {
            return null;
        }

        String retorno;

        if (this.jogadas % 2 == 0) {
            this.jogadorAtual = 1;
            retorno = "X";
        } else {
            this.jogadorAtual = 0;
            retorno = "O";
        }
        this.setSelectedField(posicao);

        int temGanhador = this.TemGanhador();
        if (temGanhador != -1) {
            if (temGanhador == 1) {
                return "1";
            } else if (temGanhador == 0) {
                return "0";
            } else {
                return "velha";
            }
        }

        this.jogadas++;

        return retorno;
    }

    private void setSelectedField(int posicao) {
        if (this.jogadorAtual == 1) {
            this.X[posicao - 1] = 1;
            this.velha[posicao - 1] = 1;
        } else {
            this.O[posicao - 1] = 1;
            this.velha[posicao - 1] = 1;
        }

    }

    private boolean campoJaSelecionado(int position) {
        return this.X[position - 1] == 1 || this.O[position - 1] == 1;
    }

    private int TemGanhador() {
        int temGanhador = -1;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (i != j && i != k && j != k) {
                        if (this.X[i] == 1 && this.X[j] == 1 && this.X[k] == 1) {
                            if (this.quadradoMagico[i] + this.quadradoMagico[j] + this.quadradoMagico[k] == 15) {
                                temGanhador = 1;
                            }
                        }
                        if (this.O[i] == 1 && this.O[j] == 1 && this.O[k] == 1) {
                            if (this.quadradoMagico[i] + this.quadradoMagico[j] + this.quadradoMagico[k] == 15) {
                                temGanhador = 0;
                            }
                        }
                    }
                }
            }
        }

        if (Arrays.stream(this.velha).allMatch(v -> v == 1)) {
            temGanhador = 2;
        }

        return temGanhador;
    }
}
