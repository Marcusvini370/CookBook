package com.letscode.cookBook.domain;

import com.letscode.cookBook.enums.TipoRendimento;

public class Rendimento {
    private final int quantidade;
    private final TipoRendimento tipoRendimento;

    public Rendimento(int quantidade, TipoRendimento tipoRendimento) {
        this.quantidade = quantidade;
        this.tipoRendimento = tipoRendimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public TipoRendimento getTipoRendimento() {
        return tipoRendimento;
    }

    @Override
    public String toString() {
        return String.format("%2d %s", quantidade, tipoRendimento);
    }
}
