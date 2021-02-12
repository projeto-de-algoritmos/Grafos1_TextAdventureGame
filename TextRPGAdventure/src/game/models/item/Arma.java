package game.models.item;

public class Arma extends Item{

    private Integer dano;
    private Integer durabilidade;

    public Arma(String nome, String descricao, Integer dano, Integer durabilidade){
        super(nome, descricao);
        this.dano = dano;
        this.durabilidade = durabilidade;
    }

    public Integer getDano() {
        return dano;
    }

    public void setDano(Integer dano) {
        this.dano = dano;
    }

    public Integer getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(Integer durabilidade) {
        this.durabilidade = durabilidade;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + getNome() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", dano='" + dano + '\'' +
                ", durabilidade='" + durabilidade + '\'' +
                '}';
    }
}
