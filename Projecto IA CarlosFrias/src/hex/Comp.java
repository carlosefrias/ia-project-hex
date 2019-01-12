package hex;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;
/**
 * Classe Comp
 * @author Carlos Frias
 */
public class Comp {
    private Tabuleiro tab;
    private int jogador;
    private int LINHAS = 11, COLUNAS = 11;
    private static Vector posVazias;
    /**
     * Construtor da classe Comp
     * @param t tabuleiro
     * @param jog Jogador
     */
    public Comp(Tabuleiro t, int jog){
        this.tab = t;
        this.jogador = jog;
        posVazias = new Vector();
        actualiza_posVazias();
    }
    /**
     * Método que actualiza um vector com as posições onde ainda é possível jogar.
     * Portanto, actualiza as posições vazias.
     */
    private void actualiza_posVazias(){
        posVazias.removeAllElements();
        for(int i = 0; i < COLUNAS; i++){
            for (int j = 0; j < LINHAS; j++){
                if(tab.tab[j][i] == 0){
                    posVazias.add(new Ponto(Tabuleiro.AbcissaToChar(i), j + 1));
                }
            }
        }
        //Para que a primeira jogada em cada modo não seja sempre a mesma em cada execusão.
        Collections.shuffle(posVazias);
    }
    /**
     * Jogada completamente ao acaso
     * @return Ponto do tabuleiro
     */
    public Ponto jogadaAleatoria(){
        actualiza_posVazias();
        Random gerador = new Random();
        int i = gerador.nextInt(posVazias.size());
        Ponto p = (Ponto) posVazias.elementAt(i);
        tab.setJogada(Tabuleiro.charToInt(p.coluna), p.linha -1 , jogador);
        posVazias.remove(i);//remove a jogada das jogadas possíveis.
        return p;
    }
    /**
     * Função que retorna a jogada com melhor avaliação a cada momento.
     * @return
     */
    public Ponto jogadaGulosa(){
        Ponto p, best_move = null;
        int melhorAval = 12, indice = 0, aval;
        actualiza_posVazias();//para que a jogada do adversário seja actualizada
        Vector pv = (Vector) posVazias.clone();
        Tabuleiro tabaux;
        //percorre todas as posições vazias e descobre a melhor jogada.
        for(int i = 0; i < pv.size(); i++){
            p = (Ponto) pv.elementAt(i);
            //Simula jogada.
            tabaux = (Tabuleiro) tab.clone();
            tabaux.setJogada(Tabuleiro.charToInt(p.coluna), p.linha -1 , jogador);
            aval = tabaux.avaliaEstado(jogador);
            if(aval < melhorAval && aval != -1){
                melhorAval = aval;
                best_move = p;
                indice = i;
            }
        }
        System.out.println("melhor jogada: " + best_move + " com avaliação: " + melhorAval);
        posVazias.remove(indice);
        return best_move;
    }
     
     /*      MiniMax Com cortes alfa-beta // Pseudo-código.
      *      Determinar se o nível é : topo OU profundidade limite OU maximizador OU minimizador
      *
      *      SE nível = topo ENTÃO alfa = -MAXINT e beta = MAXINT
      *      SE nível = profundidade máxima ENTÃO computar função de avaliação
      *                  RETORNA resultado V
      * 
      *      SE nível = maximizador ENTÃO
      *          ENQUANTO (todos os sucessores não forem examinados com Minimaxab E alfa < beta) FAZER
      *              alfa é o maior dos valores seguintes: % Actualiza alfa
      *                  valor herdado do nível anterior e resultado v de Minimax ab aplicado aos sucessores
      *              Aplique ao próximo sucessor já os novos valores de alfa e beta
      *              SE alfa < beta RETORNE v = alfa SENÃO RETORNE v = beta  % Corte beta
      *      
      *      SE nível = minimizador ENTÃO
      *      ENQUANTO (todos os sucessores não forem examinados E  alfa < beta) FAZER
      *          beta é o menor dos valores seguintes: % Actualiza beta
      *          valor herdado do nível anterior e resultado v de Minimaxab dos sucessores
      *          Aplique ao próximo sucessor já os novos valores de alfa e beta
      *      SE alfa < beta RETORNE v = beta SENÃO RETORNE v = alfa % Corte alfa
      */
    /**
     * Variável utilizada para guardar a melhor jogada de acordo com o
     * algoritmo minimax com cortes alfa-beta.
     */
    public Ponto jogadaMinMax;
    /**
     * Método recursivo que realiza o algorítmo MiniMax com cortes alfa-beta
     * @param jogador Jogador 1 ou 2
     * @param nivel Nivel de pesquisa na árvore (de 0 a PROF_MAX)
     * @param tab Tabuleiro a cada momento.
     * @return avaliação do primeiro nó de acordo com o minimaxAlfaBeta
     */
    public int minimaxAlfaBeta(int jogador, int nivel, Tabuleiro tab){
        Tabuleiro tabaux;
        Ponto p;
        //SE nível = topo ENTÃO alfa = -MAXINT e beta = MAXINT
        if (nivel == 0){
         actualiza_posVazias();
         alfa = Integer.MIN_VALUE;
         beta = Integer.MAX_VALUE;
         System.out.println("nível: " + nivel + " alfa: " + alfa + " beta: " + beta);
        }
        //SE nível = profundidade máxima ENTÃO computar função de avaliação
        //               RETORNA resultado V
        if(nivel == PROF_MAX || tab.venceu(jogador) || tab.venceu(adv(jogador))){
         System.out.println("nível: " + nivel + " alfa: " + alfa + " beta: " + beta);
         return tab.avaliaEstado(jogador);
        }
        //Se resto da divisão de nivel por 2 igual a um entao nivel maximizador
        //Senão nível minimizador
        //SE nível = maximizador ENTÃO
        //ENQUANTO (todos os sucessores não forem examinados com Minimaxab E alfa < beta) FAZER
        //  alfa é o maior dos valores seguintes: % Actualiza alfa
        //  valor herdado do nível anterior e resultado v de Minimax ab aplicado aos sucessores
        //  Aplique ao próximo sucessor já os novos valores de alfa e beta
        //  SE alfa < beta RETORNE v = alfa SENÃO RETORNE v = beta  % Corte beta
        if((nivel % 2) == 1){
            Vector pv = (Vector) posVazias.clone();
            tabaux = (Tabuleiro) tab.clone();
            int jogada = 0;
            for(int i = 0; i < pv.size() && alfa < beta; i++){
                //alfa = VALOR HERDADDO DO NÍVEL ANTERIOR
                p = (Ponto) pv.elementAt(i);
                tabaux.setJogada(Tabuleiro.charToInt(p.coluna), p.linha -1 , jogador);
                int aval = minimaxAlfaBeta(adv(jogador), nivel + 1, (Tabuleiro) tabaux.clone());
                if(aval > alfa) {
                    alfa = aval;
                    jogada = i;
                    if(nivel == PROF_MAX - 1) jogadaMinMax = (Ponto) pv.elementAt(jogada);
                    }
            }
            System.out.println("nível: " + nivel + " alfa: " + alfa + " beta: " + beta);
            System.out.println("jogada: "+(Ponto) pv.elementAt(jogada)+ " no nível "+nivel);
            return alfa < beta ? alfa : beta;//corte alfa...
        }
//       SE nível = minimizador ENTÃO
//            ENQUANTO (todos os sucessores não forem examinados E  alfa < beta) FAZER
//                beta é o menor dos valores seguintes: % Actualiza beta
//                valor herdado do nível anterior e resultado v de Minimaxab dos sucessores
//                Aplique ao próximo sucessor já os novos valores de alfa e beta
//            SE alfa < beta RETORNE v = beta SENÃO RETORNE v = alfa % Corte alfa
         else//nível minimizador.
         {
             Vector pv = (Vector) posVazias.clone();
             tabaux = (Tabuleiro) tab.clone();
             int jogada = 0;
             for(int i = 0; i < pv.size() && alfa < beta; i++){
                   //alfa = VALOR HERDADDO DO NÍVEL ANTERIOR
                 p = (Ponto) pv.elementAt(i);
                 tabaux.setJogada(Tabuleiro.charToInt(p.coluna), p.linha -1 , jogador);
                 int aval = minimaxAlfaBeta(adv(jogador), nivel + 1, (Tabuleiro) tabaux.clone());
                 if(aval < beta) {
                     beta = aval;
                     jogada = i;
                     if (nivel == PROF_MAX-1) jogadaMinMax = (Ponto) pv.elementAt(jogada);
                 }
             }
             System.out.println("nível: " + nivel + " alfa: " + alfa + " beta: " + beta);
             System.out.println("jogada: "+(Ponto) pv.elementAt(jogada)+ " no nível "+nivel);
             return alfa < beta ? beta : alfa;//corte beta.
         }
     }
    /**
     * Variáveis para guardar os valores de alfa e de beta.
     */
    private int alfa, beta;
    /**
     * Profundidade Máxima para árvore de pesquisa no algorítmo minimax com cortes alfa-beta.
     * Duração da pesquisa:
     * Profundidade = 6: 1 segundo;
     * Profundidade = 7: 3 segundos;
     * Profundidade = 8: 13 segundos;
     * Profundidade = 9: 1 minuto e 15 segundos.
     */
    private int PROF_MAX = 6;
    /**
     * Método que devolve o adversário.
     * @param jogador 1 ou 2
     * @return adversário 2 ou 1
     */
    private int adv(int jogador){
        return 1+(2-jogador);
    }
}