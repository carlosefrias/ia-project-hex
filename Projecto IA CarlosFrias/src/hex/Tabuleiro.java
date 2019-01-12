package hex;
import java.util.Vector;
/**
 * Classe Tabuleiro
 * @author Carlos Frias
 */
public class Tabuleiro implements Cloneable{
    private static int LINHAS = 11, COLUNAS = 11;
    /**
     * tab - array bidimensional com as peças dos jogadores 1 ou 2
     * ou 0 para a ausencia de peça.
     */
    public int [][] tab;
    /**
     * Vector contendo os trilhos (peças visinhas da cor do jogador 1).
     * Os trilhos são vectores de pontos
     */
    public Vector trilhos_jog1;
    /**
     * Vector contendo os trilhos (peças visinhas da cor do jogador 2).
     * Os trilhos são vectores de pontos
     */
    public Vector trilhos_jog2;//vectores de vectores de Ponto's
    /**
     * Construtor por defeito
     */
    public Tabuleiro(){
        trilhos_jog1 = new Vector();
        trilhos_jog2 = new Vector();
        this.tab = restart();
    }
    /**
     * Método Clone: devolve uma instância de Tabuleiro idêntica
     */
    @Override
    public Object clone() {
        Tabuleiro t = new Tabuleiro();
        for (int i = 0; i < COLUNAS; i++){
            t.tab[i] = this.tab[i].clone();
        }
        t.trilhos_jog1 = (Vector) this.trilhos_jog1.clone();
        Vector v, vaux;
        for(int i = 0; i < this.trilhos_jog1.size(); i++){
            v = (Vector) this.trilhos_jog1.elementAt(i);
            vaux = (Vector) v.clone();
            t.trilhos_jog1.add(vaux);
        }
        for(int i = 0; i < this.trilhos_jog2.size(); i++){
            v = (Vector) this.trilhos_jog2.elementAt(i);
            vaux = (Vector) v.clone();
            t.trilhos_jog2.add(vaux);
        }
        return t;
    }
    /**
     * Método para reiniciar o array (tabuleiro) a zeros
     * simulando o início de um novo jogo
     * @return tab instanciado a zeros
     */
    public static int[][] restart(){
        int tab[][] = new int[LINHAS][COLUNAS];
        for (int i = 0; i < LINHAS; i++){
            for (int j = 0; j < COLUNAS; j++) tab[i][j] = 0;
        }
        return tab;
    }
    /**
     * Função que escreve o tabuleiro no output - apenas para realizar testes
     * @return String com o tabuleiro num dado momento.
     */
    @Override
    public String toString(){
        String s = "________________________\n#|A|B|C|D|E|F|G|H|I|J|K",
                g = "";
        int k = 0;
        for(int i = 0; i < COLUNAS; i++){
            g += "#";
            s += "|"+(k++)+"\n"+g;
            for(int j = 0; j < LINHAS; j++){
                s += "|" + letra(tab[i][j]);
            }
        }
        s += "|"+(k++);
        return s;
    }
    /**
     * Função que traduz num caracter o código do jogador
     * @param cod jogador 1 ou 2 (peça)
     * @return caracter correspondente
     */
    private String letra(int cod){
        String c;
        /**
         * 0 - espaço vazio
         * 1 - jogador um
         * 2 - jogador dois
         */
        switch (cod) {
            case 0:  c = " "; break;
            case 1:  c = "@"; break;
            case 2:  c = "O"; break;
            default: c = " "; break;
        }
        return c;
    }
    /**
     * Função que verifica se a jogada é possível
     * e executa a jogada
     * @param x - abcissa do tabuleiro em char
     * @param y - ordenada do tabulero
     * @param jogador número do jogador
     * @return true se for possivel a jogada e false caso contrário
     */
    public boolean setJogada(char x, int y, int jogador){
        int x1 = charToInt(x);
        return setJogada(x1, y-1, jogador);
    }
    /**
     * Função que verifica se a jogada é possível
     * e executa a jogada
     * @param x - abcissa do tabuleiro em int
     * @param y - ordenada do tabulero
     * @param jogador número do jogador
     * @return true se for possivel a jogada e false caso contrário
     */
    public boolean setJogada(int x, int y, int jogador){
        //x de 0 a 10 e y de 0 a 10
        if(jogador != 1 && jogador != 2) return false;
        if( tab[y][x] == 0) {
            tab[y][x] = jogador;
            acrescenta_trilhos(x, y, jogador);
            return true;
        }
        else return false;
    }
    /**
     * Procedimento que a cada jogada incrementa os trilhos actuais
     * @param x abcissa da jogada (0 a 10)
     * @param y ordenada da jogada (0 a 10)
     * @param jogador o jogador que efectuou a jogada
     */
    private void acrescenta_trilhos(int x, int y, int jogador){
        Vector visinhos = visinhos(x, y);
        boolean foi_acrescentado = false;
        Vector trilhos;
        if(jogador == 1) trilhos = trilhos_jog1;
        else trilhos = trilhos_jog2;
        int num = 0;//a quantos trilhos foi o elemento adicionado
        for(int i = 0; i < trilhos.size(); i++){                    //por cada trilho ja feito
            for(int j = 0; j < visinhos.size(); j++){               //e por cada visinho de xy
                Ponto p = (Ponto)(visinhos.elementAt(j));
                int x1 = charToInt(p.coluna);//abcissa do visinho.
                int y1 = p.linha - 1;//ordenada do visinho.
                if(((Vector)trilhos.elementAt(i)).contains(new Ponto(AbcissaToChar(x1), y1+1))){//se o visinho estiver no trilho
                    if(!((Vector)trilhos.elementAt(i)).contains(new Ponto(AbcissaToChar(x), y+1))){//se não contiver o xy
                        ((Vector)trilhos.elementAt(i)).add(new Ponto(AbcissaToChar(x), y+1));//adicionar ao trilho xy
                        foi_acrescentado = true;
                        num++;
                    }
                }
            }
        }
        if(!foi_acrescentado){//se não foi acrescentado a nenhum trilho criar um novo trilho com apenas esse elemento
            Vector v = new Vector();
            v.add(new Ponto(AbcissaToChar(x), y+1));
            trilhos.add(v);
        }
        //Efectuar a junção de trilhos.
        if(num > 1){//se o ponto foi acrescentado a mais que um trilho.
            Vector juncao = new Vector();//vamos juntar os trilhos.
            int i = 0;
            while(num > 0){//percorrer os trilhos e verificar quais têm xy
                if(((Vector)(trilhos.elementAt(i))).contains(new Ponto(AbcissaToChar(x), y + 1))){//se trilho i tem xy
                    ((Vector)trilhos.elementAt(i)).remove(new Ponto(AbcissaToChar(x), y + 1));//remover xy
                    juncao.addAll((Vector) trilhos.elementAt(i));//copiar para outro vec
                    trilhos.removeElementAt(i);//eliminar trilho i
                    num--;
                }
                else i++;
            }
            juncao.add(new Ponto(AbcissaToChar(x), y + 1));//adicionar xy ao outro vec
            trilhos.add(juncao);//adicionar o vec a trilhos
        }
    }
    /**
     * Função que averigua se um jogador venceu o jogo
     * @param jogador jogador (1 ou 2)
     * @return true se o jogador venceu, false caso contrário.
     */
    public boolean venceu(int jogador){
        boolean ganhou = false;
        Vector trilhos;
        if(jogador == 1) trilhos = trilhos_jog1; else trilhos = trilhos_jog2;
        int[][] lados = new int[COLUNAS][4];
        for(int i = 0; i < COLUNAS; i++){//preencher um array de 0's e 1´s nas casas com jogador na 1ª e ultima linhas / colunas
            if(tab[0][i] == jogador) lados[i][0] = 1; else lados[i][0] = 0;
            if(tab[10][i] == jogador) lados[i][1] = 1; else lados[i][1] = 0;
            if(tab[i][0] == jogador) lados[i][2] = 1; else lados[i][2] = 0;
            if(tab[i][10] == jogador) lados[i][3] = 1; else lados[i][3] = 0;
        }
        int x1, x2, y1, y2;
        for(int k = 0; k < 4; k += 2){
            for(int i = 0; i < COLUNAS; i++){
                if(lados[i][k] == 1){
                    for(int j = 0; j < COLUNAS; j++){
                        if(lados[j][k+1] == 1){
                            //por cada par (1ª e ultima) linha / ou coluna preenchida a 1
                            if(k == 0){x1 = i; y1 = 0; x2 = j; y2 = 10;}
                            else{x1 = 0; y1 = i; x2 = 10; y2 = j;}
                            for(int n = 0; n < trilhos.size(); n++){
                                if(((Vector)trilhos.elementAt(n)).size() < COLUNAS) continue;
                                //ver se existe um trilho que contenha as duas peças
                                if(((Vector)trilhos.elementAt(n)).contains(new Ponto(AbcissaToChar(x1), 1+y1))
                                    && ((Vector)trilhos.elementAt(n)).contains(new Ponto(AbcissaToChar(x2), 1+y2)))
                                    ganhou = true;
                            }
                        }
                    }
                }
            }
        }
        return ganhou;
    }
    /**
     * Função que retorna um vector com as casas (Pontos)
     * visinhas da casa (x1, y1)
     * @param x1 abcissa
     * @param y1 ordenada
     * @return Vector de Pontos visinhos
     */
    private Vector visinhos(int x1, int y1){
        Vector vec_vis = new Vector();
            //visinho esquerda
            int x_esq = x1 - 1, y_esq = y1;
            //visinho direita
            int x_dir = x1 + 1, y_dir = y1;
            //visinho cima
            int x_cim = x1, y_cim = y1 + 1;
            //visinho baixo
            int x_bai = x1, y_bai = y1 - 1;
            //visinho diagonal cima
            int x_dcim = x1 + 1, y_dcim = y1 - 1 ;
            //visinho diagonal baixo
            int x_dbai = x1 - 1, y_dbai = y1 + 1;
            int [] abcissas_visinhos = {x_esq, x_dir, x_cim, x_bai, x_dcim, x_dbai},
                    ordenadas_visinhos = {y_esq, y_dir, y_cim, y_bai, y_dcim, y_dbai};
            for(int i = 0; i < abcissas_visinhos.length; i++){
                if(abcissas_visinhos[i] >= 0 && abcissas_visinhos[i] < COLUNAS
                        && ordenadas_visinhos[i] >= 0 && ordenadas_visinhos[i] < LINHAS){
                        vec_vis.add(new Ponto(AbcissaToChar(abcissas_visinhos[i]), 1+ordenadas_visinhos[i]));
                }
            }
        return vec_vis;
    }
    /**
     * Função que transforma a abcissa (int) no char correspondente
     * @param x abcissa (int)
     * @return abcissa (char)
     */
    public static char AbcissaToChar(int x){
        char x1;
        switch(x){
            case 0: x1 = 'A';break;
            case 1: x1 = 'B';break;
            case 2: x1 = 'C';break;
            case 3: x1 = 'D';break;
            case 4: x1 = 'E';break;
            case 5: x1 = 'F';break;
            case 6: x1 = 'G';break;
            case 7: x1 = 'H';break;
            case 8: x1 = 'I';break;
            case 9: x1 = 'J';break;
            case 10: x1 = 'K';break;
            default: x1 = 'X';
        }
        return x1;
    }
    /**
     * Função que devolve o int correspondente à abcissa (char)
     * @param x abcissa (char)
     * @return abcissa (int)
     */
    public static int charToInt(char x){
      int x1;
        switch(x){
            case 'A': x1 = 0;break;
            case 'a': x1 = 0;break;
            case 'B': x1 = 1;break;
            case 'b': x1 = 1;break;
            case 'C': x1 = 2;break;
            case 'c': x1 = 2;break;
            case 'D': x1 = 3;break;
            case 'd': x1 = 3;break;
            case 'E': x1 = 4;break;
            case 'e': x1 = 4;break;
            case 'F': x1 = 5;break;
            case 'f': x1 = 5;break;
            case 'G': x1 = 6;break;
            case 'g': x1 = 6;break;
            case 'H': x1 = 7;break;
            case 'h': x1 = 7;break;
            case 'I': x1 = 8;break;
            case 'i': x1 = 8;break;
            case 'J': x1 = 9;break;
            case 'j': x1 = 9;break;
            case 'K': x1 = 10;break;
            case 'k': x1 = 10;break;
            default: x1 = 0;
        }
        return x1;
    }
    /**
     * Função de avaliação de um tabuleiro em relação a um jogador
     * @param jogador
     * @return avaliação (inteiro de -5 a 11) Quanto mais baixa melhor.
     */
    public int avaliaEstado(int jogador){
        /**
         * número mínimo de casas (em linha reta, horizontal ou vertical) a preencher para
         completar o caminho;//FEITO...
         * número mínimo de casas (em linha reta, horizontal ou vertical) a preencher para o
         adversário completar o caminho;//FEITO...
         * a eventual existência de pontes, isto é, caso uma jogada ligue dois caminhos e promova
         um menor número de casas a preencher para completar o caminho.//POR FAZER...
         */
        int dmin = distanciaMin(jogador);
        int dmin_adv = distanciaMin(adv(jogador));
        //Considera a sua melhor jogada, mas também tem em conta a avaliação do adversário.
        return dmin - dmin_adv / 2 ;
    }
    /**
     * Método que calcula a distência mínima (número de jogadas mínimo)
     * na vertical/horizontal/oblíqua, para que o jogador vença.
     * @param jogador
     * @return número minimo de jogadas.
     */
    private int distanciaMin(int jogador){
        /**
         * Calcular as distâncias à coluna A e à coluna K
         * somar as distâncias mínimas à coluna A e à coluna k
         * Calcular as diâncias à linha 1 e à linha 11
         * somar as distâncias mínimas à linha A e à linha 11
         * retornar o mínimo das duas somas
         */
        int dist_A, dist_K, dist_1, dist_11, x, y, w, z;
        int dist_comp_hor = COLUNAS, dist_comp_ver = LINHAS, dist_h, dist_v;
        Vector trilhos, trilho_actual;
        if(jogador == 1) trilhos = trilhos_jog1;
        else trilhos = trilhos_jog2;
        for(int i = 0; i < trilhos.size(); i++){
            trilho_actual = (Vector) trilhos.elementAt(i);
            dist_A = COLUNAS;
            dist_K = COLUNAS;
            dist_1 = LINHAS;
            dist_11 = LINHAS;
            //TODO contabilizar tb a distância na diagonal...
            for(int j = 0; j < trilho_actual.size(); j++){//por cada trilho
                Ponto p = (Ponto)trilho_actual.elementAt(j);
                boolean free = true;
                //verifica se do ponto actual até à 1ª linha na horizontal
                //não há posições ocupadas pelo outro jogador
                for(int k = 1; k < charToInt(p.coluna) + 1; k++){
                    if(tab[p.linha - 1][k-1] == adv(jogador)) free = false;
                }
                if(free){
                    x = p.coluna - 'A';
                    if(dist_A > x) dist_A = x;
                }
                free = true;
                for(int k = charToInt(p.coluna) + 2; k < COLUNAS + 1; k++){
                    if(tab[p.linha - 1][k-1] == adv(jogador)) free = false;
                }
                if(free){
                    y = 'K' - p.coluna;
                    if(dist_K > y) dist_K = y;
                }
                free = true;
                for(int k = 1; k < p.linha; k++){
                    if(tab[k-1][charToInt(p.coluna)] == adv(jogador)) free = false;
                }
                if(free){
                    w = p.linha - 1;
                    if(dist_1 > w) dist_1 = w;
                }
                free = true;
                for(int k = p.linha + 1; k < LINHAS+1; k++){
                    if(tab[k-1][charToInt(p.coluna)] == adv(jogador)) free = false;
                }
                if(free){
                    z = 11 - p.linha;
                    if(dist_11 > z) dist_11 = z;
                }
            }
            dist_h = dist_A + dist_K;
            if(dist_comp_hor > dist_h) dist_comp_hor = dist_h;
            dist_v = dist_1 + dist_11;
            if(dist_comp_ver > dist_v) dist_comp_ver = dist_v;
        }
        return Math.min(dist_comp_hor, dist_comp_ver);
    }
    /**
     * Função que retorna o adversário.
     * @param jogador
     * @return jogador adversário.
     */
    private int adv(int jogador) {
        return (2-jogador)+1;
    }
}