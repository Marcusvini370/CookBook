package com.letscode.cookBook.domain;

import com.letscode.cookBook.enums.TipoMedida;

public class Ingrediente {
    private final String nome;
    private final double quantidade;
    private final TipoMedida tipoQuantidade;

    public Ingrediente(String nome, double quantidade, TipoMedida tipoQuantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipoQuantidade = tipoQuantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public TipoMedida getTipoQuantidade() {
        return tipoQuantidade;
    }

    @Override
    public String toString() {
        return String.format("%.3f %s %s", quantidade, tipoQuantidade, nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingrediente that = (Ingrediente) o;

        return nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }
}
