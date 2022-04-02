
public class Trial {

    private int maxPoints;
    private int minPairs;

    public Trial(Lemming[] line1, Lemming[] line2, int numOfLemmingsInLine1, int numOfLemmingsInLine2) {

        // a minha ideia para minPairs é fazer uma nova tabela com o mesmo tamanho e
        // guardar o numero de pares em cada celula e heredita da mesma forma
        // quando chegas a um novo par fazer +1, agora obviamente que heredita o power
        // maior mas se o power for igual basta escolher o numero de para mais pequeno
        // Cumprimentos
        // Lá está né

        int[][] score = new int[numOfLemmingsInLine1 + 1][numOfLemmingsInLine2 + 1];
        int[][] pairs = new int[numOfLemmingsInLine1 + 1][numOfLemmingsInLine2 + 1];

        for (int i = 0; i <= numOfLemmingsInLine1; i++) { // Column 0: base case, line1=()
            score[i][0] = 0;
            pairs[i][0] = 0;
        }

        for (int j = 0; j <= numOfLemmingsInLine2; j++) {// Line 0: base case, line2=()
            score[0][j] = 0;
            pairs[0][j] = 0;
        }

        int leftScore, upScore, leftPairs, upPairs;

        for (int j = 1; j <= numOfLemmingsInLine2; j++) {

            for (int i = 1; i <= numOfLemmingsInLine1; i++) {

                leftScore = score[i - 1][j];
                upScore = score[i][j - 1];

                leftPairs = pairs[i - 1][j];
                upPairs = pairs[i][j - 1];

                score[i][j] = Math.max(leftScore, upScore);

                if(leftScore == upScore)
                    pairs[i][j] = Math.min(leftPairs, upPairs);
                else if(leftScore > upScore)
                    pairs[i][j] = leftPairs;
                else
                    pairs[i][j] = upPairs;

                if (line1[i - 1].tribe() == line2[j - 1].tribe()) {
                    score[i][j] += (line1[i - 1].power() + line2[j - 1].power());
                    pairs[i][j]++;
                }
            }

        }

        maxPoints = score[numOfLemmingsInLine1][numOfLemmingsInLine2];
        minPairs = pairs[numOfLemmingsInLine1][numOfLemmingsInLine2];

        // Processar cada linha numa matriz
        /**
         * -começa se por encher a primeira linha e primeira coluna
         * -depois pecorremos a matriz linha a linha
         * -cada entrada séra igual ao maximo entre a entrada à sua esquerda, a entrada
         * em cima , a entrada na sua diagonal esquerda (para cima)
         * mais a soma do power dos score se foram da mesmo tribo
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
