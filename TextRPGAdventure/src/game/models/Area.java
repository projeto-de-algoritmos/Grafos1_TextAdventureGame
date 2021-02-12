package game.models;

import game.models.item.Item;
import grafo.Vertice;

import java.util.ArrayList;
import java.util.List;

public class Area extends Vertice {

    private String descricao;
    private List<Item> itens;
    private List<Inimigo> inimigos;

    public Area(String nome, String descricao){
        super(nome);
        this.descricao = descricao;
        this.itens = new ArrayList<>();
        this.inimigos = new ArrayList<>();
    }

    public Area(String nome, String descricao, List<Item> itens, List<Inimigo> inimigos){
        super(nome);
        this.descricao = descricao;
        this.itens = itens;
        this.inimigos = inimigos;
    }

    public void addItem(Item item){
        this.itens.add(item);
    }

    public void addInimigo(Inimigo inimigo){
        this.inimigos.add(inimigo);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Inimigo> getInimigos() {
        return inimigos;
    }

    public List<Item> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "Area{" +
                "nome='" + getNome() + '\'' +
                ", descricao='" + descricao + '\'' +
                ", itens=" + itens +
                ", inimigos=" + inimigos +
                '}';
    }
}
