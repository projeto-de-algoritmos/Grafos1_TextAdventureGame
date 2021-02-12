package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	List<Vertice> vertices;
	List<Aresta> arestas;
	
	public Grafo(){
		vertices = new ArrayList<Vertice>();
		arestas = new ArrayList<Aresta>();
	}
	
	public Vertice addVertice(String nome){
		Vertice vertice = new Vertice(nome);
		vertices.add(vertice);

		return vertice;
	}

	public Aresta addAresta(Vertice origem, Vertice destino){
		Aresta aresta = new Aresta(1.0, origem, destino);
		origem.addAdjacencias(aresta);
		arestas.add(aresta);

		return aresta;
	}

	public Aresta addAresta(Double peso, Vertice origem, Vertice destino) {
		Aresta aresta = new Aresta(peso, origem, destino);
		origem.addAdjacencias(aresta);
		arestas.add(aresta);

		return aresta;
	}

	public void imprimeGrafo(){
		for(Vertice vertice : this.vertices){
			System.out.print(vertice.nome);
			System.out.println(" ----> ");
			for(Aresta aresta : vertice.adjacencias){
				System.out.print("\t\t\t");
				System.out.print(aresta.destino.nome);
				System.out.print(" - ");
				System.out.println("Peso:" + aresta.peso);
			}
		}
	}
	
	public List<Vertice> getVertices() {
		return vertices;
	}
	
	public List<Aresta> getArestas() {
		return arestas;
	}
}
