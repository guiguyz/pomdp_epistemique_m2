package src;

/**
 * Classe GenereAlea pour generer des croyances aléatoires
 *
 * @author Guillaume Drouart 21009341
 * @author Hazar Zaoui 21104595
 */
public class GenereAlea {

    static double[][] listValeur;
    static String[] listOfAgent;
    static String[] listDeCroyance;
    int nbAgent;
    int nbCroyance;
    
    /**
     * Constructeur
     *
     * @param nbAgent
     * @param nbCroyance
     */
    GenereAlea(int nbAgent, int nbCroyance) {
        this.nbAgent=nbAgent;
        this.nbCroyance=nbCroyance;
        genereTestAlea(nbAgent,nbCroyance);
        genereListAgent(nbAgent);
        genereListCroyance(nbCroyance);
    }
    
    /**
     * Generer les valeurs aléatoires des croyances
     *
     * @param nbAgent
     * @param nbCroyance
     * @return
     */
    public static double[][] genereTestAlea(int nbAgent, int nbCroyance) {
        listValeur = new double[nbAgent][nbCroyance];
        for (double[] listValeur1 : listValeur) {
            double val = 0;
            for (int j = 0; j < listValeur1.length; j++) {
                double rand=Math.random();
                listValeur1[j] = rand;
                val+=rand;
            }
            for (int j = 0; j < listValeur1.length; j++) {
                listValeur1[j] = listValeur1[j]/val;
            }
        }
        return listValeur;
    }

    /**
     * Generer la liste des agents
     *
     * @param nbAgent
     * @return
     */
    public static String[] genereListAgent(int nbAgent) {
        listOfAgent = new String[nbAgent];

        for (int i = 0; i < listOfAgent.length; i++) {
            listOfAgent[i] = "Agent_" + i;
        }
        return listOfAgent;
    }

    /**
     * Generer la liste des croyances
     *
     * @param nbCroyance
     * @return
     */
    public static String[] genereListCroyance(int nbCroyance) {
        listDeCroyance = new String[nbCroyance];

        for (int i = 0; i < listDeCroyance.length; i++) {
            listDeCroyance[i] = "Croyance_" + i;
        }
        return listDeCroyance;
    }
    
}
