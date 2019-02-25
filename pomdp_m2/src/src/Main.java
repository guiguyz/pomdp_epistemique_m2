package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe principale
 *
 * @author Guillaume Drouart 21009341
 * @author Hazar Zaoui 21104595
 */
public class Main {

    static Map<Integer, Map<Integer, Double>> mapAgentsMax = new HashMap<>();
    static Map<Integer, Map<Integer, Double>> mapAgentsMin = new HashMap<>();
    static List<List<Integer>> clusterList = new ArrayList<List<Integer>>();

    static String[] listOfAgent1 = {"Agent0", "Agent1", "Agent2", "Agent3"};
    static String[] listOfFeatures1 = {"Civile", "Militaire"};
    static double[][] listOfValue11 = {{0.6, 0.4}, {0.4, 0.6}, {0.85, 0.15}, {0.75, 0.25}};
    static double[][] listOfValue12 = {{0.8, 0.2}, {0.7, 0.3}, {0.95, 0.05}, {0.85, 0.15}};
    static double[][] listOfValue13 = {{0.98, 0.02}, {0.97, 0.03}, {0.99, 0.01}, {0.96, 0.04}};

    static String[] listOfAgent20 = {"Agent0", "Agent1", "Agent2", "Agent3", "Agent4"};
    static String[] listOfFeatures20 = {"Rouge", "Vert", "Bleu", "Blanc"};
    static double[][] listOfValue20 = {{0.5, 0.1, 0.3, 0.1}, {0.05, 0.5, 0.05, 0.4}, {0.1, 0.1, 0.5, 0.3}, {0.04, 0.01, 0.05, 0.95}, {0.1, 0.1, 0.1, 0.7}};

    static String[] listOfAgent21 = {"Agent0", "Agent1", "Agent2", "Agent3", "Agent4"};
    static String[] listOfFeatures21 = {"Rouge", "Vert", "Bleu", "Blanc"};
    static double[][] listOfValue21 = {{0.13, 0.01, 0.01, 0.85}, {0.01, 0.01, 0.03, 0.95}, {0.01, 0, 0, 0.99}, {0.04, 0, 0, 0.96}, {0.01, 0.01, 0.01, 0.97}};
    
    static String[] listOfAgent22 = {"Agent0", "Agent1", "Agent2", "Agent3", "Agent4", "Agent5", "Agent5", "Agent7", "Agent8", "Agent9"};
    static String[] listOfFeatures22 = {"Rouge", "Vert", "Bleu", "Blanc"};
    static double[][] listOfValue22 = {{0.99, 0, 0, 0.01}, {0.99, 0, 0, 0.01}, {0.99, 0, 0, 0.01}, {0.99, 0, 0, 0.01}, {0.99, 0, 0, 0.01},
    {0.99, 0, 0, 0.01}, {0.99, 0, 0, 0.01}, {0.99, 0, 0, 0.01}, {0.99, 0, 0, 0.01}, {0.4, 0, 0, 0.6}};

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

    static String[] listOfAgent70 = {"Robot0", "Robot1", "Robot2", "Robot3"};
    static String[] listOfFeatures70 = {"Porte_ouverte", "Porte_fermée"};
    static double[][] listOfValue70 = {{0.9, 0.1}, {0.75, 0.25}, {0.25, 0.75}, {0.5, 0.5}};

    static String[] listOfAgent71 = {"Robot0", "Robot1", "Robot2", "Robot3"};
    static String[] listOfFeatures71 = {"Porte_ouverte", "Porte_fermée"};
    static double[][] listOfValue71 = {{0.99, 0.01}, {0.75, 0.25}, {0.25, 0.75}, {0.5, 0.5}};

    static String[] listOfAgent72 = {"Robot0", "Robot1", "Robot2", "Robot3"};
    static String[] listOfFeatures72 = {"Porte_ouverte", "Porte_fermée"};
    static double[][] listOfValue72 = {{0.99, 0.01}, {0.95, 0.05}, {0.49, 0.51}, {0.49, 0.51}};

    static String[] listOfAgent73 = {"Robot0", "Robot1", "Robot2", "Robot3"};
    static String[] listOfFeatures73 = {"Porte_ouverte", "Porte_fermée"};
    static double[][] listOfValue73 = {{0.99, 0.01}, {0.97, 0.03}, {0.95, 0.05}, {0.89, 0.11}};

    static String[] listOfAgent8 = {"Robot0", "Robot1"};
    static String[] listOfFeatures8 = {"C1", "C2"};
    static double[][] listOfValue8 = {{0.5, 0.5}, {0.5, 0.5}};

    static String[] listOfAgent9 = {"Robot0", "Robot1"};
    static String[] listOfFeatures9 = {"C1", "C2"};
    static double[][] listOfValue9 = {{0, 1}, {1, 0}};

    /**
     * Coefficient de Bhattacharyya
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
     * Distance de Battacharya
     *
     * @param p
     * @param q
     * @return
     */
    public static double distanceBattacharya(double[] p, double[] q) {
        return Math.abs(-Math.log(BC(p, q)));
    }

    /**
     * Distance de Hellinger
     *
     * @param p
     * @param q
     * @return
     */
    public static double distanceHellinger(double[] p, double[] q) {
        return Math.sqrt(1 - BC(p, q));
    }

    /**
     * Entropie de shannon
     *
     * @param p
     * @return
     */
    public static double entropieShannon(double[] p) {
        double sum = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] != 0) {
                sum += (p[i] * Math.log(1 / p[i]));
            }
        }
        return sum;
    }

    /**
     * Entropie de shannon
     *
     * @param p
     * @return
     */
    public static double croyanceMoyenne(double[] p) {
        double sum = 0;
        for (int i = 0; i < p.length; i++) {
            sum += p[i];
        }
        return sum;
    }

    /**
     * Divergence de Kullbak-Leibler
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
     * Distance de Itakura-Saito
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
     * Distance de Mahalanobis
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
     * Calcule les matrices de distances en fonction du parametre typeDistance
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
     * Retourne la map de tout les agents j qui sont en max avec les agents i
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
     * Retourne la map de tout les agents j qui sont en min avec les agents i
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
     * Retourne l'agent j qui est en min avec un agent i
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
     * Création des map de valeur d'agents en max et en min entre eux
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
     * Création des clusters
     *
     * @param matx
     * @param croyance
     * @param listDeCroyance
     */
    public static void creationCluster(double[][] matx, double[][] croyance, String[] listDeCroyance) {

        // On calcule les map de min et de max des agents
        // pour une meilleur comprehension à l'affichage
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
        boolean seuilAtteint = false;

        // On transpose la matrice des croyances
        // pour que les croyances soit sur les lignes
        // afin de pouvoir calculer leur entropie et leur valeur moyenne
        double[][] resSha = new double[croyance[0].length][croyance.length];
        for (int i = 0; i < croyance.length; i++) {
            for (int j = 0; j < croyance[i].length; j++) {
                resSha[j][i] = croyance[i][j];
            }
        }

        System.out.println("");
        double[] sommeMoyVal = new double[resSha.length];
        double[] resShannon = new double[resSha.length];
        for (int i = 0; i < resSha.length; i++) {
            // Pour chaque croyance on calcule son entropie
            resShannon[i] = entropieShannon(resSha[i]);
            // Pour chaque croyance on calcule sa valeur moyenne
            sommeMoyVal[i] = croyanceMoyenne(resSha[i]);
            sommeMoyVal[i] /= nbAgent;
            // On teste si le seuil d'une croyance est atteint
            if (sommeMoyVal[i] > 0.9) {
                seuilAtteint = true;
            }
            System.out.println("Croyance " + listDeCroyance[i] + " d'entropie " + resShannon[i] + " et de valeur moyenne " + sommeMoyVal[i]);
        }

        // Pour tester si des agents sont dans des clusters
        int[] agentClust = new int[nbAgent];
        for (int i = 0; i < nbAgent; i++) {
            agentClust[i] = i;
        }

        // On crée les clusters sur le nombre de croyance
        List<Integer>[] cluster = new List[nbCroyance];
        for (int i = 0; i < nbCroyance; i++) {
            cluster[i] = new ArrayList<>();
        }

        // On cherche les agents max et min
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

        // Si le seuil est atteint alors 
        // tous les agents sont dans le même cluster
        if (seuilAtteint) {
            for (int i = 0; i < nbAgent; i++) {
                cluster[0].add(i);
                // On indique que les agents i sont dans un cluster
                agentClust[i] = -1;
            }
        } else {
            // Sinon on applique la méthode voulu
            // Les deux agents en max dans deux clusters différents
            cluster[0].add(agent1max);
            cluster[1].add(agent2max);
            agentClust[agent1max] = -1;
            agentClust[agent2max] = -1;
            // On verifie si un ou les deux des autres agents qui sont en min
            // soit en min avec un des agents max
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
                // Sinon on mets les deux agents min ensemble dans un cluster
                // à part si le nombre de croyance est supérieur à 2
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
                    // Sinon le nombre de croyance est égale à 2
                    // alors on cherche l'agent le plus proche
                    // dans les clusters existant
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
        }

        // Tant qu'il reste des agents non clusterisé
        while (testAgentClust(agentClust)) {
            // Pour chaque agents
            for (int i = 0; i < agentClust.length; i++) {
                // Si l'agent i n'est pas clusterisé
                if (agentClust[i] != -1) {
                    // On récupère l'agent j avec qui il est en min
                    int agentMinJ = getMinJ(matx[agentClust[i]], agentClust[i]);
                    // Pour tout les groupes de cluster
                    for (List<Integer> cluster1 : cluster) {
                        // Pour chaque cluster
                        for (int k = 0; k < cluster1.size(); k++) {
                            // Si l'agent j est dans un cluster
                            if (agentMinJ == cluster1.get(k)) {
                                // On ajoute l'agent i avec lui
                                cluster1.add(agentClust[i]);
                                // On indique que l'agent i est désormais clusterisé 
                                agentClust[i] = -1;
                                // On stop la condition pour allez voir les autres agents
                                break;
                            }
                        }
                    }
                }
            }
        }

        nomCluster(cluster, croyance, listDeCroyance, resShannon);

    }

    /**
     * Mettre le nom de la croyance correspondant au cluster Indiquer la valeur
     * moyenne correspondant au cluster Calculer et indiqué l'entropie de
     * shannon de la croyance correspondant au cluster Afficher les clusters,
     * leur valeurs et leur entropie
     *
     * @param cluster
     * @param croyance
     * @param listDeCroyance
     * @param resShannon
     */
    public static void nomCluster(List<Integer>[] cluster, double[][] croyance, String[] listDeCroyance, double[] resShannon) {

        double[][] valCluster = new double[cluster.length][croyance[0].length];

        double[] sommeMoyValCluster = new double[croyance[0].length];

        
        // Pour chaque cluster
        for (int i = 0; i < cluster.length; i++) {
            if (!cluster[i].isEmpty()) {
                for (int j = 0; j < cluster[i].size(); j++) {
                    // On calcule la valeur moyenne des croyances  
                    // de chaque cluster non vide
                    for (int l = 0; l < croyance[cluster[i].get(j)].length; l++) {
                        valCluster[i][l] += croyance[cluster[i].get(j)][l];
                    }
                }
            }
        }

        // Initialisation de la liste des indices de force de croyance
        int[] indexList = new int[cluster.length];
        for (int i = 0; i < indexList.length; i++) {
            indexList[i] = -1;
        }
        
        // On indice une liste sur la croyance la plus forte
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

        // Pour chaque cluster
        for (int i = 0; i < cluster.length; i++) {
            // Si le cluster n'est pas vide
            if (!cluster[i].isEmpty()) {
                // On calcule la moyenne des clusters 
                // en fonction de l'indice de la croyance la plus forte
                for (int j = 0; j < cluster[i].size(); j++) {
                    sommeMoyValCluster[i] += croyance[cluster[i].get(j)][indexList[i]];
                }
            }
        }

        System.out.println("");
        // On ne garde que trois cluster au max à l'affichage
        // Car il n'y aura jamais plus de trois cluster utilisé
        double tailleCluster = Math.min(3, cluster.length);
        // Afficher les clusters, leur valeurs et leur entropie
        for (int i = 0; i < tailleCluster; i++) {
            sommeMoyValCluster[i] = sommeMoyValCluster[i] / cluster[i].size();
            // On affiche les clusters et leurs valeurs 
            // si ils ne sont pas vide
            if (!cluster[i].isEmpty()) {
                System.out.println(cluster[i] + " cluster de croyance " + listDeCroyance[indexList[i]] + " de valeur moyenne "
                        + sommeMoyValCluster[i] + " et d'entropie de shannon de valeur " + resShannon[indexList[i]]);
            } else {
                System.out.println(cluster[i]);
            }
        }
        System.out.println("");
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
     * Affichage des résultats
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
        System.out.println("Matrice de distance de Itakura-Saito " + Arrays.toString(listFeatures) + " :");
        System.out.println(Arrays.toString(listAgent));
        for (double[] agent : resI) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster de distance de Itakura-Saito : ");
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

        // Civile
//        affichage(listOfAgent1, listOfFeatures1, listOfValue11);
//        affichage(listOfAgent1, listOfFeatures1, listOfValue12);
//        affichage(listOfAgent1, listOfFeatures1, listOfValue13);
        // Couleur
//        affichage(listOfAgent20, listOfFeatures20, listOfValue20);
//        affichage(listOfAgent21, listOfFeatures21, listOfValue21);
        affichage(listOfAgent22, listOfFeatures22, listOfValue22);
        // Extreme
//        affichage(listOfAgent3, listOfFeatures3, listOfValue3);
//        affichage(listOfAgent4, listOfFeatures4, listOfValue4);
//        affichage(listOfAgent5, listOfFeatures5, listOfValue5);
//        affichage(listOfAgent6, listOfFeatures6, listOfValue6);
//        affichage(listOfAgent8, listOfFeatures8, listOfValue8);
//        affichage(listOfAgent9, listOfFeatures9, listOfValue9);
        // Robots
//        affichage(listOfAgent70, listOfFeatures70, listOfValue70);
//        affichage(listOfAgent71, listOfFeatures71, listOfValue71);
//        affichage(listOfAgent72, listOfFeatures72, listOfValue72);
//        affichage(listOfAgent73, listOfFeatures73, listOfValue73);
        // Aleatoire
//        GenereAlea genereAlea = new GenereAlea(3, 5000);
//        affichage(genereAlea.listOfAgent, genereAlea.listDeCroyance, genereAlea.listValeur);
    }
}
