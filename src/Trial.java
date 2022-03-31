
public class Trial {

    private int maxPoints;
    private int minPairs;

    public Trial(Lemming[] line1, Lemming[] line2, int numOfLemmingsInLine1, int numOfLemmingsInLine2) {

        //a minha ideia para minPairs é fazer uma nova tabela com o mesmo tamanho e guardar o numero de pares em cada celula e heredita da mesma forma
            //quando chegas a um novo par fazer +1, agora obviamente que heredita o power maior mas se o power for igual basta escolher o numero de para mais pequeno
            //Cumprimentos
            //Lá está né

        int[][] lemmingTable = new int[numOfLemmingsInLine1+1][numOfLemmingsInLine2+1];

        for (int i = 0; i <= numOfLemmingsInLine1; i++) // Column 0: base case, line1=()
            lemmingTable[i][0] = 0;

        for (int j = 0; j <= numOfLemmingsInLine2; j++) // Line 0: base case, line2=()
            lemmingTable[0][j] = 0;

        for (int j = 1; j <= numOfLemmingsInLine2; j++) {

            for (int i = 1; i <= numOfLemmingsInLine1; i++) {

                lemmingTable[i][j] = Math.max(lemmingTable[i - 1][j],
                        Math.max(lemmingTable[i][j - 1], lemmingTable[i - 1][j - 1]));
                        
                if(line1[i-1].tribe() == line2[j-1].tribe())
                    lemmingTable[i][j] += (line1[i-1].power() + line2[j-1].power());
            }

        }

        maxPoints = lemmingTable[numOfLemmingsInLine1][numOfLemmingsInLine2];
        minPairs = 0;

        // Processar cada linha numa matriz
        /**
         * -começa se por encher a primeira linha e primeira coluna
         * -depois pecorremos a matriz linha a linha
         * -cada entrada séra igual ao maximo entre a entrada à sua esquerda, a entrada
         * em cima , a entrada na sua diagonal esquerda (para cima)
         * mais a soma do power dos lemmings se foram da mesmo tribo
         * -assim quando chegarmos ao final da tabela a ultima entrada será a pontuação
         * maxima
         * -acho eu neh para dizer a verdade fazia bue sentido quando estava a testar em
         * papel mas agora que estou a escrever isto parece que nao é bem assim
         * lá está né
         */

    }

    @Override
    public String toString() {
        return maxPoints + " " + minPairs;
    }

}
