package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Guillaume Drouart
 * @author Hazar Zaoui
 */
public class Main {

    static Map<Integer, Map<Integer, Double>> mapAgentsMax = new HashMap<>();
    static Map<Integer, Map<Integer, Double>> mapAgentsMin = new HashMap<>();
    static List<List<Integer>> clusterList = new ArrayList<List<Integer>>();

    static String[] listOfAgent1 = {"Agent0", "Agent1", "Agent2", "Agent3"};
    static String[] listOfFeatures1 = {"Civile", "Militaire"};
    static double[][] listOfValue11 = {{0.6, 0.4}, {0.4, 0.6}, {0.85, 0.15}, {0.75, 0.25}};
    static double[][] listOfValue12 = {{0.8, 0.2}, {0.7, 0.3}, {0.95, 0.05}, {0.85, 0.15}};//{0.8,0.2}
    static double[][] listOfValue13 = {{0.98, 0.02}, {0.97, 0.03}, {0.99, 0.01}, {0.96, 0.04}};

    static String[] listOfAgent2 = {"Agent0", "Agent1", "Agent2", "Agent3", "Agent4"};
    static String[] listOfFeatures2 = {"Rouge", "Vert", "Bleu", "Blanc"};
    static double[][] listOfValue2 = {{0.5, 0.1, 0.3, 0.1}, {0.05, 0.5, 0.05, 0.4}, {0.1, 0.1, 0.5, 0.3}, {0.04, 0.01, 0.05, 0.95}, {0.1, 0.1, 0.1, 0.7}};

    static String[] listOfAgent3 = {"Agent0", "Agent1", "Agent2", "Agent3", "Agent4", "Agent5", "Agent6"};
    static String[] listOfFeatures3 = {"C1", "C2", "C3"};
    static double[][] listOfValue3 = {{0.98, 0.01, 0.01}, {0.01, 0.98, 0.01}, {0.01, 0.01, 0.98}, {0.34, 0.33, 0.33}, {0.33, 0.34, 0.33}, {0.33, 0.33, 0.34}, {0.25, 0.5, 0.25}};

    static String[] listOfAgent4 = {"Agent0", "Agent1", "Agent2", "Agent3"};
    static String[] listOfFeatures4 = {"C1", "C2", "C3"};
    static double[][] listOfValue4 = {{1, 0, 0}, {0.34, 0.33, 0.33}, {0.33, 0.34, 0.33}, {0.33, 0.33, 0.34}};

    static String[] listOfAgent5 = {"Agent0", "Agent1", "Agent2"};
    static String[] listOfFeatures5 = {"C1", "C2", "C3"};
    static double[][] listOfValue5 = {{0.34, 0.33, 0.33}, {0.33, 0.34, 0.33}, {0.33, 0.33, 0.34}};

    static String[] listOfAgent6 = {"Agent0", "Agent1", "Agent2"};
    static String[] listOfFeatures6 = {"C1", "C2"};
    static double[][] listOfValue6 = {{0.49, 0.51}, {0.51, 0.49}, {0.5, 0.5}};
    
    static String[] listOfAgent71 = {"Robot0", "Robot1", "Robot2", "Robot3"};
    static String[] listOfFeatures71 = {"Porte_ouverte", "Porte_fermée"};
    static double[][] listOfValue71 = {{0.99, 0.01}, {0.75, 0.25}, {0.25, 0.75}, {0.5, 0.5}};
    
    static String[] listOfAgent72 = {"Robot0", "Robot1", "Robot2", "Robot3"};
    static String[] listOfFeatures72 = {"Porte_ouverte", "Porte_fermée"};
    static double[][] listOfValue72 = {{0.99, 0.01}, {0.95, 0.05}, {0.49, 0.51}, {0.49, 0.51}};
    
    static String[] listOfAgent73 = {"Robot0", "Robot1", "Robot2", "Robot3"};
    static String[] listOfFeatures73 = {"Porte_ouverte", "Porte_fermée"};
    static double[][] listOfValue73 = {{0.99, 0.01}, {0.97, 0.03}, {0.95, 0.05}, {0.89, 0.11}};

    /**
     *
     * @param p
     * @param q
     * @return
     */
    public static double BC(double[] p, double[] q) {
        double sum = 0;
        for (int i = 0; i < q.length; i++) {
            sum += Math.sqrt(Math.abs(q[i] * p[i]));
        }
        return sum;
    }

    /**
     *
     * @param p
     * @param q
     * @return
     */
    public static double distanceBattacharya(double[] p, double[] q) {
        return Math.abs(-Math.log(BC(p, q)));
    }

    /**
     *
     * @param p
     * @param q
     * @return
     */
    public static double distanceHellinger(double[] p, double[] q) {
        return Math.sqrt(1 - BC(p, q));
    }

    /**
     *
     * @param p
     * @return
     */
    public static double entropieShannon(double[] p) {
        double sum = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] != 0) {
                sum += (p[i] * Math.log(1/p[i]));
            }
        }
        return sum;
    }

    /**
     *
     * @param p
     * @param q
     * @return
     */
    public static double divergenceKBL(double[] p, double[] q) {
        double sum = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] != 0) {
                sum += p[i] * Math.log(p[i] / q[i]);
            }
        }
        return Math.abs(sum);
    }

    /**
     *
     * @param p
     * @param q
     * @return
     */
    public static double itakuraSaito(double[] p, double[] q) {
        double sum = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] != 0) {
                sum += (p[i] / q[i] - Math.log(p[i] / q[i]) - 1);
            }
        }
        return Math.abs(sum);
    }

    /**
     *
     * @param p
     * @param q
     * @return
     */
    public static double distanceMahalanobis(double[] p, double[] q) {
        double sum = 0;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < q.length; j++) {
                if (i != j) {
                    sum += ((p[i] - q[i]) * (p[j] - q[j]));
                }
            }
        }
        return Math.abs(sum / 2);
    }

    /**
     *
     * @param liste
     * @param typeDistance
     * @return
     */
    public static double[][] matriceDistanceAgents(double[][] liste, String typeDistance) {
        int nbAgent = liste.length;
        double[][] distance = new double[nbAgent][nbAgent];
        for (int i = 0; i < liste.length; i++) {
            for (int j = 0; j < liste.length; j++) {
                if (i != j) {
                    if ("B".equals(typeDistance)) {
                        distance[i][j] = distanceBattacharya(liste[i], liste[j]);
                    }
                    if ("H".equals(typeDistance)) {
                        distance[i][j] = distanceHellinger(liste[i], liste[j]);
                    }
                    if ("K".equals(typeDistance)) {
                        distance[i][j] = divergenceKBL(liste[i], liste[j]);
                    }
                    if ("I".equals(typeDistance)) {
                        distance[i][j] = itakuraSaito(liste[i], liste[j]);
                    }
                    if ("M".equals(typeDistance)) {
                        distance[i][j] = distanceMahalanobis(liste[i], liste[j]);
                    }
                }
            }
        }
        return distance;
    }

    /**
     *
     * @param v
     * @param a
     * @return
     */
    public static Map<Integer, Double> getMax(double[] v, int a) {
        Map<Integer, Double> maxVal = new HashMap<>();
        double max = Double.MIN_VALUE;
        double temp;
        int tempAgent = 0;
        for (int i = 0; i < v.length; i++) {
            if (i != a) {
                temp = v[i];
                if (temp > max) {
                    max = temp;
                    tempAgent = i;
                    maxVal.clear();
                }
                maxVal.put(tempAgent, max);
            }
        }
        return maxVal;
    }

    /**
     *
     * @param v
     * @param a
     * @return
     */
    public static Map<Integer, Double> getMin(double[] v, int a) {
        Map<Integer, Double> minVal = new HashMap<>();
        double min = Double.MAX_VALUE;
        double temp;
        int tempAgent = 0;
        for (int i = 0; i < v.length; i++) {
            if (i != a) {
                temp = v[i];
                if (temp < min) {
                    min = temp;
                    tempAgent = i;
                    minVal.clear();
                }
                minVal.put(tempAgent, min);
            }
        }
        return minVal;
    }

    /**
     *
     * @param v
     * @param a
     * @return
     */
    public static int getMinJ(double[] v, int a) {
        double min = Double.MAX_VALUE;
        double temp;
        int tempAgent = 0;
        int agentJ = 0;
        for (int i = 0; i < v.length; i++) {
            if (i != a) {
                temp = v[i];
                if (temp < min) {
                    min = temp;
                    tempAgent = i;
                }
                agentJ = tempAgent;
            }
        }
        return agentJ;
    }

    /**
     *
     * @param cluster
     * @param croyance
     * @param listDeCroyance
     */
    public static void nomCluster(List<Integer>[] cluster, double[][] croyance, String[] listDeCroyance) {

        double[][] valCluster = new double[cluster.length][croyance[0].length];

        double[] sommeMoyValCluster = new double[croyance[0].length];

        for (int i = 0; i < cluster.length; i++) {
            if (!cluster[i].isEmpty()) {
                for (int j = 0; j < cluster[i].size(); j++) {
                    for (int l = 0; l < croyance[cluster[i].get(j)].length; l++) {
                        valCluster[i][l] += croyance[cluster[i].get(j)][l];

                    }
                }
            }
        }

        int[] indexList = new int[cluster.length];
        for (int i = 0; i < indexList.length; i++) {
            indexList[i] = -1;
        }
        for (int i = 0; i < valCluster.length; i++) {
            int maxIndex = -1;
            double max = Double.NEGATIVE_INFINITY;
            if (!cluster[i].isEmpty()) {
                for (int j = 0; j < valCluster[i].length; j++) {
                    if (valCluster[i][j] > max) {
                        max = valCluster[i][j];
                        maxIndex = j;
                    }
                    indexList[i] = maxIndex;
                }
            }
        }

        for (int i = 0; i < cluster.length; i++) {
            if (!cluster[i].isEmpty()) {
                for (int j = 0; j < cluster[i].size(); j++) {
                    sommeMoyValCluster[i] += croyance[cluster[i].get(j)][indexList[i]];
                }
            }
        }

        double[][] resSha = new double[croyance[0].length][croyance.length];
        for (int i = 0; i < croyance.length; i++) {
            for (int j = 0; j < croyance[i].length; j++) {
                resSha[j][i] = croyance[i][j];
            }
        }

        System.out.println("");
        double[] resShannon = new double[croyance.length];
        for (int i = 0; i < resSha.length; i++) {
            resShannon[i] = entropieShannon(resSha[i]);
            System.out.println("Croyance " + listDeCroyance[i] + " d'entropie " + resShannon[i]);
        }

        System.out.println("");
        for (int i = 0; i < cluster.length; i++) {
            sommeMoyValCluster[i] = sommeMoyValCluster[i] / cluster[i].size();
            if (indexList[i] != -1) {
                System.out.println(cluster[i] + " cluster de croyance " + listDeCroyance[indexList[i]] + " de valeur moyenne "
                        + sommeMoyValCluster[i] + " et d'entropie de shannon de valeur " + resShannon[indexList[i]]);
            } else {
                System.out.println(cluster[i]);
            }
        }
        System.out.println("");
    }

    /**
     *
     * @param mat
     */
    public static void minMaxAgentsCroyance(double[][] mat) {
        int nbAgent = mat.length;
        for (int i = 0; i < nbAgent; i++) {
            mapAgentsMax.put(i, getMax(mat[i], i));
            mapAgentsMin.put(i, getMin(mat[i], i));
        }
    }

    /**
     *
     * @param mat
     * @param croyance
     * @param listDeCroyance
     */
    public static void initCluster(double[][] mat, double[][] croyance, String[] listDeCroyance) {

        creationCluster(mat, croyance, listDeCroyance);

    }

    /**
     *
     * @param matx
     * @param croyance
     * @param listDeCroyance
     */
    public static void creationCluster(double[][] matx, double[][] croyance, String[] listDeCroyance) {

        minMaxAgentsCroyance(matx);

        int nbAgent = matx[0].length;
        int nbCroyance = croyance[0].length;
        double max = Double.MIN_VALUE;
        double tempMax = 0;
        double min = Double.MAX_VALUE;
        double tempMin = 0;
        int agent1min = 0;
        int agent2min = 0;
        int agent1max = 0;
        int agent2max = 0;

        int[] agentClust = new int[nbAgent];
        for (int i = 0; i < nbAgent; i++) {
            agentClust[i] = i;
        }

        List<Integer>[] cluster = new List[nbCroyance];
        for (int i = 0; i < nbCroyance; i++) {
            cluster[i] = new ArrayList<>();
        }

        for (int i = 0; i < matx.length; i++) {
            for (int j = 0; j < matx[i].length; j++) {

                if (i != j) {
                    tempMin = matx[i][j];
                    tempMax = matx[i][j];
                    if (tempMin < min) {
                        min = tempMin;
                        agent1min = i;
                        agent2min = j;
                    }
                    if (tempMax > max) {
                        max = tempMax;
                        agent1max = i;
                        agent2max = j;
                    }
                }
            }
        }

        cluster[0].add(agent1max);
        cluster[1].add(agent2max);
        agentClust[agent1max] = -1;
        agentClust[agent2max] = -1;
        if (agent1min == agent1max && !(cluster[1].contains(agent2min))) {
            cluster[0].add(agent2min);
            agentClust[agent2min] = -1;
        } else if (agent2min == agent1max && !(cluster[1].contains(agent1min))) {
            cluster[0].add(agent1min);
            agentClust[agent1min] = -1;
        } else if (agent1min == agent2max && !(cluster[0].contains(agent2min))) {
            cluster[1].add(agent2min);
            agentClust[agent2min] = -1;
        } else if (agent2min == agent2max && !(cluster[0].contains(agent1min))) {
            cluster[1].add(agent1min);
            agentClust[agent1min] = -1;
        } else {
            if (nbCroyance > 2) {
                if (!(cluster[0].contains(agent2min)) && !(cluster[1].contains(agent2min))) {
                    cluster[2].add(agent2min);
                    agentClust[agent2min] = -1;
                }
                if (!(cluster[0].contains(agent1min)) && !(cluster[1].contains(agent1min))) {
                    cluster[2].add(agent1min);
                    agentClust[agent1min] = -1;
                }
            } else {
                if (matx[agent1min][agent1max] < matx[agent1min][agent2max] && !(cluster[1].contains(agent1min))) {
                    cluster[0].add(agent1min);
                    agentClust[agent1min] = -1;
                }
                if (matx[agent1min][agent1max] > matx[agent1min][agent2max] && !(cluster[0].contains(agent1min))) {
                    cluster[1].add(agent1min);
                    agentClust[agent1min] = -1;
                }
                if (matx[agent2min][agent1max] < matx[agent2min][agent2max] && !(cluster[1].contains(agent2min))) {
                    cluster[0].add(agent2min);
                    agentClust[agent2min] = -1;
                }
                if (matx[agent2min][agent1max] > matx[agent2min][agent2max] && !(cluster[0].contains(agent2min))) {
                    cluster[1].add(agent2min);
                    agentClust[agent2min] = -1;
                }
            }
        }

        while (testAgentClust(agentClust)) {
            for (int i = 0; i < agentClust.length; i++) {
                if (agentClust[i] != -1) {
                    int agentMinJ = getMinJ(matx[agentClust[i]], agentClust[i]);
                    for (List<Integer> cluster1 : cluster) {
                        for (int k = 0; k < cluster1.size(); k++) {
                            if (agentMinJ == cluster1.get(k)) {
                                cluster1.add(agentClust[i]);
                                agentClust[i] = -1;
                                break;
                            }
                        }
                    }
                }
            }
        }

        nomCluster(cluster, croyance, listDeCroyance);

    }

    /**
     * Tester si un agent est dans un cluster
     *
     * @param agentClust
     * @return boolean
     */
    public static boolean testAgentClust(int[] agentClust) {
        for (int i = 0; i < agentClust.length; i++) {
            if (agentClust[i] != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param tableau
     * @param index
     * @return
     */
    public static double[][] supprimerIndiceMat(double[][] tableau, int index) {
        int nRows = tableau.length;
        int nColumns = tableau[0].length;

        if (index >= nRows || index >= nColumns) {
            // Return exception ?
            return new double[0][0];
        }

        double[][] newTab = new double[nRows - 1][nColumns - 1];
        int newTabRow = 0;
        int newTabCol = 0;

        for (int i = 0; i < nRows; ++i) {
            if (i != index) {
                for (int j = 0; j < nColumns; ++j) {
                    if (j != index) {
                        newTab[newTabRow][newTabCol] = tableau[i][j];
                        ++newTabCol;
                    }
                }
                ++newTabRow;
                newTabCol = 0;
            }
        }
        return newTab;
    }

    @FunctionalInterface
    public interface InterfaceDistance {

        double distance(double[] p, double[] q);
    }

    /**
     *
     * @param X
     * @param distanceFun
     * @param maxIter
     * @param eps
     * @param k
     */
    public void kmeans(double[][] X, InterfaceDistance distanceFun, int maxIter, double eps, int k) {
        // distanceFun.distance(a, b);
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public double euclidianDistance(double[] a, double[] b) {
        // kmeans(X, (a, b) -> euclidianDistance(a, b), 1000, 1e-3)
        return 0.;
    }

    /**
     *
     * @param listAgent
     * @param listFeatures
     * @param listValues
     */
    public static void affichage(String[] listAgent, String[] listFeatures, double[][] listValues) {

        System.out.println("Nouveau Test");
        System.out.println("");
        System.out.println("Matrice de croyance :");
        System.out.println(Arrays.toString(listFeatures));
        for (int i = 0; i < listAgent.length; i++) {
            System.out.println(listAgent[i] + " " + Arrays.toString(listValues[i]));//String.valueOf(i) + 
        }
        System.out.println("");
        double resBa[][] = matriceDistanceAgents(listValues, "B");
        System.out.println("Matrice de distance de Battacharia " + Arrays.toString(listFeatures));
        System.out.println(Arrays.toString(listAgent));
        for (double[] agent : resBa) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster Battacharia : ");
        creationCluster(resBa, listValues, listFeatures);
        System.out.println("Liste max ");
        System.out.println(mapAgentsMax.entrySet());
        System.out.println("Liste min ");
        System.out.println(mapAgentsMin.entrySet());
        System.out.println("");

        System.out.println("");
        double resHe[][] = matriceDistanceAgents(listValues, "H");
        System.out.println("Matrice de distance de Hellinger " + Arrays.toString(listFeatures) + " :");
        System.out.println(Arrays.toString(listAgent));
        for (double[] agent : resHe) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster Hellinger : ");
        creationCluster(resHe, listValues, listFeatures);
        System.out.println("Liste max ");
        System.out.println(mapAgentsMax.entrySet());
        System.out.println("Liste min ");
        System.out.println(mapAgentsMin.entrySet());
        System.out.println("");

        System.out.println("");
        double resK[][] = matriceDistanceAgents(listValues, "K");
        System.out.println("Matrice de divergence de Kullback-Leibler " + Arrays.toString(listFeatures) + " :");
        System.out.println(Arrays.toString(listAgent));
        for (double[] agent : resK) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster divergence de Kullback-Leibler : ");
        creationCluster(resK, listValues, listFeatures);
        System.out.println("Liste max ");
        System.out.println(mapAgentsMax.entrySet());
        System.out.println("Liste min ");
        System.out.println(mapAgentsMin.entrySet());
        System.out.println("");

        System.out.println("");
        double resI[][] = matriceDistanceAgents(listValues, "I");
        System.out.println("Matrice de distance de Itakuro-Saito " + Arrays.toString(listFeatures) + " :");
        System.out.println(Arrays.toString(listAgent));
        for (double[] agent : resI) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster de distance de Itakuro-Saito : ");
        creationCluster(resI, listValues, listFeatures);
        System.out.println("Liste max ");
        System.out.println(mapAgentsMax.entrySet());
        System.out.println("Liste min ");
        System.out.println(mapAgentsMin.entrySet());
        System.out.println("");

        System.out.println("");
        double resM[][] = matriceDistanceAgents(listValues, "M");
        System.out.println("Matrice de distance de Mahalanobis " + Arrays.toString(listFeatures) + " :");
        System.out.println(Arrays.toString(listAgent));
        for (double[] agent : resM) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster distance de Mahalanobis : ");
        creationCluster(resM, listValues, listFeatures);
        System.out.println("Liste max ");
        System.out.println(mapAgentsMax.entrySet());
        System.out.println("Liste min ");
        System.out.println(mapAgentsMin.entrySet());
        System.out.println("");

    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

//        affichage(listOfAgent1, listOfFeatures1, listOfValue11);
//        affichage(listOfAgent1, listOfFeatures1, listOfValue12);
//        affichage(listOfAgent1, listOfFeatures1, listOfValue13);
//        affichage(listOfAgent2, listOfFeatures2, listOfValue2);
//        affichage(listOfAgent3, listOfFeatures3, listOfValue3);
//        affichage(listOfAgent4, listOfFeatures4, listOfValue4);
//        affichage(listOfAgent5, listOfFeatures5, listOfValue5);
//        affichage(listOfAgent6, listOfFeatures6, listOfValue6);
        affichage(listOfAgent71, listOfFeatures71, listOfValue71);
        affichage(listOfAgent72, listOfFeatures72, listOfValue72);
        affichage(listOfAgent73, listOfFeatures73, listOfValue73);

//        GenereAlea genereAlea = new GenereAlea(5, 2);
//        affichage(genereAlea.listOfAgent, genereAlea.listDeCroyance, genereAlea.listValeur);
    }
}
