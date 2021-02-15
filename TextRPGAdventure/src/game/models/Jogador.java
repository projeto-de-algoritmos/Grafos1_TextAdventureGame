package game.models;

import game.models.item.Arma;
import game.models.item.Item;
import game.models.item.ItemConsumivel;

import java.util.ArrayList;
import java.util.List;

public class Jogador extends Personagem{

    private List<Item> itensColetados;

    public Jogador(String nome, Integer vida){
        super(nome, vida);
        itensColetados = new ArrayList<>();
    }

    public List<Item> getItensColetados() {
        return itensColetados;
    }

    public void addItem(Item e){
        this.itensColetados.add(e);
    }

    public void verificarItensEsgotadosOuQuebrados(){
        for(Item item : getItensColetados()){
            if(item instanceof ItemConsumivel) {
                if(((ItemConsumivel) item).getCargas() <= 0){
                    getItensColetados().remove(item);
                }
            } else if(item instanceof Arma) {
                if(((Arma) item).getDurabilidade() <= 0){
                    getItensColetados().remove(item);
                }
            }
        }
    }
}
