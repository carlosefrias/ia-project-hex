package hex;
/**
 * Classe Ponto
 * @author Carlos Frias
 */
public class Ponto implements Cloneable{
    public char coluna;
    public int linha;
    /**
     * Construtor da classe Ponto
     * @param coluna letra A até K
     * @param linha inteiro 1 a 11
     */
    public Ponto(char coluna, int linha){
        this.linha = linha;
        this.coluna = coluna;
    }
    /**
     * Função toString para poder imprimir
     * instâncias da classe Ponto
     */
    @Override
    public String toString(){
        return "" + coluna + linha;
    }
    /**
     * Função equals que testa se um dado objecto
     * é igual ao Ponto actual
     * @param obj objecto a comparar
     * @return true se iguais, false caso contrário
     */
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Ponto &&
                ((Ponto)obj).coluna == this.coluna &&
                ((Ponto)obj).linha == this.linha) return true;
        else return false;
    }
    /**
     * Função hashCode que devolve
     * o código hash do objecto Ponto
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.coluna;
        hash = 89 * hash + this.linha;
        return hash;
    }
    /**
     * Método Clone.
     * @return uma cópia do objecto actual
     */
    @Override
    public Object clone(){
        return new Ponto(this.coluna, this.linha);
    }
}
