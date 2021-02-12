package game;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

public class Principal {

    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        Vertice a = grafo.addVertice("Sala A");
        Vertice b = grafo.addVertice("Sala B");
        Vertice c = grafo.addVertice("Sala C");

        Aresta ab = grafo.addAresta(1.0, a, b);
        Aresta bc = grafo.addAresta(b, c);
        Aresta ac = grafo.addAresta(3.0, a, c);

        grafo.imprimeGrafo();
    }
}
