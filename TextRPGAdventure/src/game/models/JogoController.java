package game.models;

public final class JogoController {

    private static JogoController jogo;
    private static Jogador jogador;

    public void startGame(String nome, Integer vida){
        jogador = new Jogador(nome, vida);

        //Andamento do jogo - Só para no fim do jogo;
        while(true){
            // 1 - verifica e executa ação desejada
            // 2 - verifica se está em batalha
            // 3 - verifica se o jogo acabou
            // 4 - verificações de itens e outras coisas
            jogador.verificarItensEsgotadosOuQuebrados();
        }
    }

    public static JogoController getJogo() {
        if (jogo == null) {
            jogo = new JogoController();
        }

        return jogo;
    }

    public static Jogador getJogador(){
        return jogador;
    }

    public static void removerVida(Integer quantidade){
        Integer vidaAtual = jogador.getVida();
        jogador.setVida(vidaAtual - quantidade);
    }

    public static void adicionarVida(Integer quantidade){
        Integer vidaAtual = jogador.getVida();
        jogador.setVida(vidaAtual + quantidade);
    }
}
