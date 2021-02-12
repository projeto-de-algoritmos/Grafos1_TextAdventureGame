package game.models.item;

public class ItemConsumivel extends Item{

    private Integer cargas;

    public ItemConsumivel(String nome, String descricao, Integer cargas){
        super(nome, descricao);
        this.cargas = cargas;
    }

    public Integer getCargas() {
        return cargas;
    }

    public void setCargas(Integer cargas) {
        this.cargas = cargas;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + getNome() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargas='" + cargas + '\'' +
                '}';
    }
}
