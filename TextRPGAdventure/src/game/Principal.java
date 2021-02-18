package game;

import game.models.Area;
import game.models.JogoController;
import game.models.item.ItemDecorativo;
import game.models.item.ItemLegivel;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {

        JogoController jogo = JogoController.getJogo();

        Area quartoEscuro = new Area("Quarto Escuro", "Você se encontra em um quarto repleto de sombras e pouca iluminação. Suas mãos encontram-se machucadas e você sente o chão frio sob seus pés.");

        ItemDecorativo espelho = new ItemDecorativo("Espelho", "Um espelho quebrado que te mostra seu reflexo borrado.");

        List<String> textosDiario = new ArrayList<>();

        textosDiario.add("Ao abrir o diário, você consegue ler entre as folhas sujas e amassadas, a seguinte passagem: ");
        textosDiario.add("'Estou aqui a mais ou menos 128 dias. Não sei mais se consigo escapar. O carrasco deixa água e restos de comida, e sai. Eu nem ao menos tenho força para tentar enfrentá-lo.'");

        ItemLegivel diario = new ItemLegivel("Diário Velho", "Um velho diário gasto pelo tempo.", textosDiario);

        quartoEscuro.addItem(espelho);
        quartoEscuro.addItem(diario);

        jogo.addArea(quartoEscuro);

        System.out.println("\n\n\n");

        jogo.iniciarJogo("Caio", 15, "Quarto Escuro");

    }

}
