package game.models;

import game.models.item.Arma;
import game.models.item.Item;
import game.models.item.ItemConsumivel;

import java.util.ArrayList;
import java.util.List;

public class Jogador extends Personagem{

    private String areaAtual;

    public Jogador(String nome, Integer vida, String areaAtual){
        super(nome, vida);
        this.areaAtual = areaAtual;
    }

    public void verificarItensEsgotadosOuQuebrados(){
        for(Item item : getItens()){
            if(item instanceof ItemConsumivel) {
                if(((ItemConsumivel) item).getCargas() <= 0){
                    getItens().remove(item);
                }
            } else if(item instanceof Arma) {
                if(((Arma) item).getDurabilidade() <= 0){
                    getItens().remove(item);
                }
            }
        }
    }

    public String getAreaAtual() {
        return areaAtual;
    }

    public void setAreaAtual(String areaAtual) {
        this.areaAtual = areaAtual;
    }
}
