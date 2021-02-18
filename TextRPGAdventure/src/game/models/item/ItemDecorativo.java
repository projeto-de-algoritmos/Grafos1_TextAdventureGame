package game.models.item;

public class ItemDecorativo extends Item{

    public ItemDecorativo(String nome, String descricao){
        super(nome, descricao);
    }

    @Override
    public void usar() {
        System.out.println(getDescricao());
    }
}
