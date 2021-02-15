package game;

import game.models.Area;
import game.models.JogoController;
import game.models.item.PocaoCura;
import grafo.Aresta;
import grafo.Grafo;
import grafo.Navegacao;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        Area a = new Area("Lago Grimmauld", "Um lugar calmo e pacífico onde é possível ver ondas de até 8m de altura.");
        Area b = new Area("Travessa do Tranco", "Um local perigoso e cheio de olhares hostis e silenciosos.");
        Area c = new Area("Banco Gringotes", "O lugar mais seguro para guardar seu dinheiro.");
        Area d = new Area("Beco Diagonal", "Um lugar onde você pode encontrar de tudo.");
        Area e = new Area("Casa dos gritos", "Um lugar onde se pode ouvir gritos arrepiantes.");

        PocaoCura pocaoCuraSuperior = new PocaoCura("Poção de Cura Superior", "Uma poção que te cura.", 3, 15);

        a.addItem(pocaoCuraSuperior);

        grafo.addVertice(a);
        grafo.addVertice(b);
        grafo.addVertice(c);
        grafo.addVertice(d);
        grafo.addVertice(e);

        Aresta ab = grafo.addAresta(1.0, a, b);
        Aresta bc = grafo.addAresta(b, c);
        Aresta ac = grafo.addAresta(3.0, a, c);
        grafo.addAresta(b, e);
        grafo.addAresta(c, d);


        System.out.println("\n\n\n");

        testaNavegacao(grafo);
    }

    private static void testaNavegacao(Grafo grafo) {
        grafo.imprimeGrafo();
        JogoController game = JogoController.getJogo();
        //game.startGame("Caio", 15);

        Navegacao navegacao = new Navegacao();
        System.out.println("======= Navegação =======");
        navegacao.buscaEmLargura(grafo);
        System.out.println("=========================\n\n\n");

        grafo.resetVertices();

        Area areaEncontrada = (Area) navegacao.buscaVertice(grafo, "Banco Gringotes");
        if (areaEncontrada != null) {
            System.out.println("=========" + areaEncontrada.getNome() + "=========");
            System.out.println(areaEncontrada);
            System.out.println("==================================\n\n\n");

        } else {
            System.out.println("========= Beco Não Encontrado =========");
        }

        Area naoEncontrado = (Area) navegacao.buscaVertice(grafo, "Beco Diagon");
        if (naoEncontrado != null) {
            System.out.println("========= Encontrado =========");
            System.out.println(naoEncontrado);
        } else {
            System.out.println("========= Não Encontrado =========\n\n\n");
        }
    }
}
