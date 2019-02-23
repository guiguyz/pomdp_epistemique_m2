/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author guy
 */
public class GenereAlea {

    static double[][] listValeur;
    static String[] listOfAgent;
    static String[] listDeCroyance;
    int nbAgent;
    int nbCroyance;
    
    GenereAlea(int nbAgent, int nbCroyance) {
        this.nbAgent=nbAgent;
        this.nbCroyance=nbCroyance;
        genereTestAlea(nbAgent,nbCroyance);
        genereListAgent(nbAgent);
        genereListCroyance(nbCroyance);
    }
    
    /**
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
