package com.letscode.cookBook.domain;

import com.letscode.cookBook.enums.Categoria;

import java.util.List;

public class Receita {
    private String nome;
    private Categoria categoria;
    private int tempoPreparo;
    private Rendimento rendimento;
    private List<Ingrediente> ingredientes;
    private List<String> modoPreparo;

    public Receita(String nome, Categoria categoria, int tempoPreparo, Rendimento rendimento,
                   List<Ingrediente> ingredientes, List<String> modoPreparo) {
        this.nome = nome.toUpperCase();
        this.categoria = categoria;
        this.tempoPreparo = tempoPreparo;
        this.rendimento = rendimento;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
    }

    public Receita(String nome, Categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receita receita = (Receita) o;

        return nome.equals(receita.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    @Override
    public String toString() {
        int minutos = tempoPreparo  < 60 ? tempoPreparo : tempoPreparo % 60;
        int horas = tempoPreparo >= 60 ? tempoPreparo / 60 : 0;
        String tempo = horas > 0 ? horas + " horas " : "";
        tempo += minutos > 0 ? minutos + " minutos " : "";
        StringBuilder ingredientes  = new StringBuilder();
        if (this.ingredientes != null) {
            for (Ingrediente ingrediente : this.ingredientes) {
                ingredientes.append(" ").append(ingrediente.toString());
            }
        }

        StringBuilder modoPreparo = new StringBuilder();
        if (this.modoPreparo != null) {
            for (String modo : this.modoPreparo) {
                modoPreparo.append(" ").append(modo).append("\n");
            }
        }

        return String.format("%s%n\t%s%n%nRendimento: %s%nTempo: %s%nIngredientes:%n%sModo de preparo:%n%s", nome, categoria, rendimento, tempo, ingredientes, modoPreparo);
    }
}
