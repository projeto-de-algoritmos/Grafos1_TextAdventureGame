package grafo;

import game.models.Area;
import game.models.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Navegacao {
    private List<Vertice> fila = new ArrayList<>();


    public void buscaEmLargura(Grafo grafo) {
        List<Vertice> vertices = grafo.getVertices();

        for (Vertice vertice : vertices) {
            if (!vertice.isVisitado()) {
                enfileirar(vertice);
                vertice.marcarComoVisitado();

                while (!fila.isEmpty()) {
                    Vertice verticeAtual = desenfileirar();

                    for (Aresta vizinho : verticeAtual.getAdjacencias()) {
                        Vertice destino = vizinho.getDestino();
                        if (!destino.isVisitado()) {
                            destino.marcarComoVisitado();

                            enfileirar(destino);
                        }
                    }
                }

            }
        }
    }

    public Vertice buscaVertice(Grafo grafo, String nome) {
        List<Vertice> vertices = grafo.getVertices();

        for (Vertice vertice : vertices) {
            if (!vertice.isVisitado()) {
                enfileirar(vertice);
                vertice.marcarComoVisitado();
                if (vertice.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    grafo.resetVertices();
                    return vertice;
                }

                while (!fila.isEmpty()) {
                    Vertice verticeAtual = desenfileirar();

                    for (Aresta vizinho : verticeAtual.getAdjacencias()) {
                        Vertice destino = vizinho.getDestino();
                        if (!destino.isVisitado()) {
                            destino.marcarComoVisitado();

                            if (destino.getNome().toLowerCase().contains(nome.toLowerCase())) {
                                grafo.resetVertices();
                                return destino;
                            }

                            enfileirar(destino);
                        }
                    }
                }
                grafo.resetVertices();
            }
        }

        return null;
    }

    private void enfileirar(Vertice vertice) {
        fila.add(vertice);
    }

    private Vertice desenfileirar() {
        if (!fila.isEmpty()) {
            return fila.remove(0);
        } else {
            return null;
        }
    }

    public Vertice getSalaFinal(Grafo grafo, String salaInicial, String salaFinal) {
        Vertice verticeInicial = buscaVertice(grafo, salaInicial);

        enfileirar(verticeInicial);
        verticeInicial.marcarComoVisitado();

        while (!fila.isEmpty()) {
            Vertice verticeAtual = desenfileirar();

            for (Aresta vizinho : verticeAtual.getAdjacencias()) {
                Vertice destino = vizinho.getDestino();
                if (!destino.isVisitado()) {
                    if (destino.getNome().toLowerCase().contains(salaFinal.toLowerCase())) {
                        grafo.resetVertices();
                        return destino;
                    }

                    destino.marcarComoVisitado();

                    enfileirar(destino);
                }
            }

            grafo.resetVertices();
        }

        return null;
    }

    public Vertice retornarAreaConectada(Area areaAtual, String areaDesejada) {
        for(Aresta areaConectada : areaAtual.getAdjacencias()){
            if (areaConectada.getDestino().getNome().toLowerCase().contains(areaDesejada.toLowerCase())) {
                return areaConectada.getDestino();
            }
        }

        return null;
    }
}
