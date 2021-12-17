package com.letscode.cookBook.view;

import com.letscode.cookBook.controller.Catalogo;
import com.letscode.cookBook.domain.Receita;
import com.letscode.cookBook.enums.Categoria;

import java.util.Scanner;

public class CatalogoView {
    private final Receita NONE_FOUND = new Receita("Nenhuma receita encontrada", Categoria.PRATO_UNICO);
    private Receita receita;
    private int curIndex = -1;
    Catalogo controller = new Catalogo();

    private void showHeader() {
        ScreenUtil.printTextLine("", 80, true, '=');
        ScreenUtil.printTextLine("#### #### #### #  #  ###  #### #### #  #", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # # #   #  # #  # #  # # # ", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # ##    ###  #  # #  # ##  ", 80, true, ' ');
        ScreenUtil.printTextLine("#    #  # #  # # #   #  # #  # #  # # # ", 80, true, ' ');
        ScreenUtil.printTextLine("#### #### #### #  #  ###  #### #### #  #", 80, true, ' ');
        ScreenUtil.printTextLine("", 80, true, '=');
    }

    private void showReceita(Receita receita) {
        System.out.println(receita.toString());
    }

    private void showAnterior() {
        if (curIndex > 0) {
            Receita receitaAnterior = controller.getReceita(curIndex - 1);
            if (receitaAnterior != null) {
                this.receita = receitaAnterior;
                curIndex--;
            }
        }
    }

    private void showSeguinte() {
        this.receita = controller.getReceita(curIndex + 1);
        if (receita != null) curIndex++;
    }

    private void add() {

        //TODO: Implement Add

        Receita novaReceita = new NovaReceitaView().nova();
        if (curIndex < 0) {
            controller.add(novaReceita);
            this.receita = novaReceita;
            curIndex++;
        } else {
            controller.add(novaReceita);
        }

       /* NovaReceitaView novaReceita = new NovaReceitaView();
        novaReceita.askNome();
        novaReceita.askCategoria();
        for (int i = 0; i < 100; ++i) {
            System.out.println();
        }
        show();*/



    }

    private void del() {
        if (curIndex == 0) {
            if (controller.getReceita(curIndex + 1) != null) {
                controller.del(receita.getNome());
                this.receita = controller.getReceita(curIndex);
            } else {
                controller.del(receita.getNome());
                this.receita = null;
                curIndex = -1;
            }
        } else if (curIndex > 0) {
            if (controller.getReceita(curIndex + 1) != null) {
                controller.del(receita.getNome());
                this.receita = controller.getReceita(curIndex);
            } else if (controller.getReceita(curIndex - 1) != null) {
                controller.del(receita.getNome());
                curIndex--;
                this.receita = controller.getReceita(curIndex);
            }
        } else if (curIndex == -1) {
            System.out.println("Catálogo vazio!");
        }
    }

    public void show() {
        showHeader();
        showReceita(receita == null ? NONE_FOUND : receita);
        ScreenUtil.printTextLine("", 80, true, '=');
        ScreenUtil.printTextLine("P: Receita anterior", 80, true);
        ScreenUtil.printTextLine("N: Receita seguinte", 80, true);
        ScreenUtil.printTextLine("+: Adicionar nova receita", 80, true);
        ScreenUtil.printTextLine("-: Remover receita", 80, true);
        ScreenUtil.printTextLine("S: Pesquisar receita", 80, true);
        ScreenUtil.printTextLine("", 80, true, '=');
        ScreenUtil.printTextLine("#: ", 80);
        String option;
        do {
            option = new Scanner(System.in).next();
            switch (option.toUpperCase()) {
                case "P":
                    showAnterior();
                    break;
                case "N":
                    showSeguinte();
                    break;
                case "+":
                    add();
                    break;
                case "-":
                    del();
                    break;
                case "S":
                    //TODO: Implement Search
                    break;
                default:
                    ScreenUtil.printTextLine("Opção inválida", 80);
                    ScreenUtil.printTextLine("#: ", 80);
            }
            show();
        } while (true);
    }
}
