package game;

import game.models.Area;
import game.models.item.Item;
import game.models.item.ItemConsumivel;
import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

public class Principal {

    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        Area a = new Area("Lago Grimmauld", "Um lugar calmo e pacífico onde é possível ver ondas de até 8m de altura.");
        Area b = new Area("Travessa do Tranco", "Um local perigoso e cheio de olhares hostis e silenciosos.");
        Area c = new Area("Banco Gringotes", "O lugar mais seguro para guardar seu dinheiro.");

        Item pocaoHp = new ItemConsumivel("Poção de Cura", "Uma poção que te cura.", 3);

        a.addItem(pocaoHp);

        grafo.addVertice(a);
        grafo.addVertice(b);
        grafo.addVertice(c);

        Aresta ab = grafo.addAresta(1.0, a, b);
        Aresta bc = grafo.addAresta(b, c);
        Aresta ac = grafo.addAresta(3.0, a, c);

        grafo.imprimeGrafo();
        System.out.println("\n\n\n");


    }
}
