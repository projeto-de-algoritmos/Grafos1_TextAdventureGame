package grafo;

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
                System.out.println(vertice.getNome());

                while (!fila.isEmpty()) {
                    Vertice verticeAtual = desenfileirar();

                    for (Aresta vizinho : verticeAtual.getAdjacencias()) {
                        Vertice destino = vizinho.getDestino();
                        if (!destino.isVisitado()) {
                            destino.marcarComoVisitado();
                            System.out.println(destino.getNome());

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
                if (vertice.getNome().equals(nome)) {
                    grafo.resetVertices();
                    return vertice;
                }

                while (!fila.isEmpty()) {
                    Vertice verticeAtual = desenfileirar();

                    for (Aresta vizinho : verticeAtual.getAdjacencias()) {
                        Vertice destino = vizinho.getDestino();
                        if (!destino.isVisitado()) {
                            destino.marcarComoVisitado();

                            if (destino.getNome().equals(nome)) {
                                grafo.resetVertices();
                                return vertice;
                            }

                            enfileirar(destino);
                        }
                    }
                }

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
}
