package grafo;

import java.util.ArrayList;
import java.util.List;

public abstract class Vertice {
	
	private String nome;
	private List<Aresta> adjacencias;
	
	public Vertice(String nome){
		this.nome = nome;
		adjacencias = new ArrayList<>();
	}
	
	public void addAdjacencias(Aresta aresta) {
		adjacencias.add(aresta);
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Aresta> getAdjacencias() {
		return adjacencias;
	}

}
