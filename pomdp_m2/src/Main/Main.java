package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Guillaume Drouart
 * @author Hazar Zaoui
 */
public class Main {

    static Map<String, double[]> problem1 = new HashMap<>();
    static Map<String, double[]> problem2 = new HashMap<>();
    static Map<Integer, Map<Integer, Double>> mapAgentsMax = new HashMap<>();
    static Map<Integer, Map<Integer, Double>> mapAgentsMin = new HashMap<>();
//    static double lemax = Double.MIN_VALUE;
//    static double lemin = Double.MAX_VALUE;
//    static int agent1max;
//    static int agent2max;
//    static int agent1min;
//    static int agent2min;
    static List<List<Integer>> clusterList = new ArrayList<List<Integer>>();

    static String[] listOfAgent1 = {"Agent0", "Agent1", "Agent2", "Agent3"};
    static String[] listOfFeatures1 = {"Civile", "Militaire"};
    static double[][] listOfValue11 = {{0.6, 0.4}, {0.4, 0.6}, {0.85, 0.15}, {0.75, 0.25}};
    static double[][] listOfValue12 = {{0.8, 0.2}, {0.7, 0.3}, {0.95, 0.05}, {0.85, 0.15}};
    static double[][] listOfValue13 = {{0.98, 0.02}, {0.97, 0.03}, {0.99, 0.01}, {0.99, 0.01}};

    static String[] listOfAgent2 = {"Agent0", "Agent1", "Agent2", "Agent3", "Agent4"};
    static String[] listOfFeatures2 = {"Rouge", "Vert", "Bleu", "Blanc"};
    static double[][] listOfValue2 = {{0.5, 0.1, 0.3, 0.1}, {0.05, 0.5, 0.05, 0.4}, {0.1, 0.1, 0.5, 0.3}, {0.04, 0.01, 0.05, 0.95}, {0.1, 0.1, 0.1, 0.7}};

    static String[] listOfAgent3 = {"Agent0", "Agent1", "Agent2", "Agent3", "Agent4", "Agent5", "Agent6"};
    static String[] listOfFeatures3 = {"C1", "C2", "C3"};
    static double[][] listOfValue3 = {{0.98, 0.01, 0.01}, {0.01, 0.98, 0.01}, {0.01, 0.01, 0.98}, {0.33, 0.33, 0.34}, {0.34, 0.33, 0.33}, {0.33, 0.34, 0.34}, {0.25, 0.5, 0.25}};

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
     * @param q
     * @return
     */
    public static double divergenceKBL(double[] p, double[] q) {
        double sum = 0;
        for (int i = 0; i < q.length; i++) {
            sum += p[i] * Math.log(p[i] / q[i]);
        }
        return Math.abs(sum);
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
                if ("B".equals(typeDistance)) {
//                    if (i == j) {
//                        distance[i][j] = -1;
//                    }
                    distance[i][j] = distanceBattacharya(liste[i], liste[j]);

                }
                if ("H".equals(typeDistance)) {
                    distance[i][j] = distanceHellinger(liste[i], liste[j]);
                }
                if ("K".equals(typeDistance)) {
                    distance[i][j] = divergenceKBL(liste[i], liste[j]);
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
//        double maxi = Double.MIN_VALUE;
//        int agent1temp = 0;
//        int agent2temp = 0;
        for (int i = 0; i < v.length; i++) {
            if (i != a) {
                temp = v[i];
                if (temp > max) {
                    max = temp;
                    tempAgent = i;
                    maxVal.clear();
                }
                maxVal.put(tempAgent, max);
//                if (max > lemax) {
//                    lemax = max;
//                    agent1max = a;
//                    agent2max = i;
//                }

//                lemax = maxi;
//                agent1max = agent1temp;
//                agent2max = agent2temp;
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
//        double mini = Double.MAX_VALUE;
//        int agent1temp = 0;
//        int agent2temp = 0;
        for (int i = 0; i < v.length; i++) {
            if (i != a) {
                temp = v[i];
                if (temp < min) {
                    min = temp;
                    tempAgent = i;
                    minVal.clear();
                }
                minVal.put(tempAgent, min);
//                if (min < mini) {
//                    mini = min;
//                    agent1temp = a;
//                    agent2temp = i;
//                }
//                lemin = mini;
//                agent1min = agent1temp;
//                agent2min = agent2temp;

            }

        }

        return minVal;
    }

    /**
     *
     * @param mat
     */
    public static void averageDistanceBelieves(double[][] croyance) {
        for (int i = 0; i < croyance.length; i++) {
            for (int j = 0; j < croyance[i].length; j++) {

            }
        }
    }

    /**
     *
     * @param mat
     */
    public static void minMaxAgentsBelieves(double[][] mat) {
        int nbAgent = mat.length;
        for (int i = 0; i < nbAgent; i++) {
            mapAgentsMax.put(i, getMax(mat[i], i));
            mapAgentsMin.put(i, getMin(mat[i], i));
        }
    }

    /**
     *
     * @param maxv
     */
    public static void compareMax(Map<Integer, Map<Integer, Double>> maxv) {

        maxv.entrySet().forEach((Entry<Integer, Map<Integer, Double>> entry) -> {
//            System.out.println(entry.getKey() + " " + entry.getValue().keySet() + " " + (entry.getValue().values()));
            System.out.println(entry.getKey() + " " + entry.getKey().getClass().getName());
            System.out.println(entry.getValue().keySet() + " " + entry.getValue().keySet().getClass().getName());
            System.out.println(entry.getValue().values() + " " + entry.getValue().values().getClass().getName());
        });
    }

    /**
     *
     * @param mat
     * @param croyance
     */
    public static void initCluster(double[][] mat, double[][] croyance) {
//        averageDistanceBelieves(croyance);

//        int nbCroyance = croyance[0].length;
//        int nbAgents = mat.length;
//        int[] agentInCluster = new int[nbAgents];
//
//        List<Integer>[] cluster = new List[nbCroyance];
//        for (int i = 0; i < nbCroyance; i++) {
//            cluster[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < nbAgents; i++) {
//            agentInCluster[i] = i;
//        }
//        cluster[0].add(agent1max);
//        clusterList.add(0, cluster[0]);
//        agentInCluster[0]=0;
//        cluster[1].add(agent2max);
//        clusterList.add(1, cluster[1]);
//        agentInCluster[1]=0;
//        if (agent1min == agent1max) {
//            cluster[0].add(agent2min);
//            clusterList.add(0, cluster[0]);
//        }
//        if (agent2min == agent1max) {
//            cluster[0].add(agent1min);
//            clusterList.add(0, cluster[0]);
//        }
//        if (agent1min == agent2max) {
//            cluster[1].add(agent2min);
//            clusterList.add(1, cluster[1]);
//        }
//        if (agent2min == agent2max) {
//            cluster[1].add(agent1min);
//            clusterList.add(1, cluster[1]);
//        }
//        System.out.println(clusterList.get(1) + " " + clusterList.get(0));
        miseAJourCluster(mat, croyance);
        minMaxAgentsBelieves(mat);

    }

    /**
     *
     * @param matx
     * @param croyance
     */
    public static void miseAJourCluster(double[][] matx, double[][] croyance) {

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
        double[][] mat = matx;

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

//        supprimerIndiceMat(mat,agent1min);
//        System.out.println("a_i_min : " + agent1min + " , a_j_min : " + agent2min + " , min = " + min + "; a_i_max : " + agent1max + " , a_j_max : " + agent2max + " , max = " + max);
        cluster[0].add(agent1max);
//        clusterList.add(0, cluster[0]);
        cluster[1].add(agent2max);
//        clusterList.add(1, cluster[1]);
        nbAgent -= 2;
        if (agent1min == agent1max) {
            cluster[0].add(agent2min);
//            for (int i = 0; i < mat.length; i++) {
//                mat[agent2min][i] = -1;
//                mat[i][agent2min] = -1;
//            }
//            clusterList.add(0, cluster[0]);
        } else if (agent2min == agent1max) {
            cluster[0].add(agent1min);
//            for (int i = 0; i < mat.length; i++) {
//                mat[agent1min][i] = -1;
//                mat[i][agent1min] = -1;
//            }
//            clusterList.add(0, cluster[0]);
        } else if (agent1min == agent2max) {
            cluster[1].add(agent2min);
//            for (int i = 0; i < mat.length; i++) {
//                mat[agent2min][i] = -1;
//                mat[i][agent2min] = -1;
//            }
//            clusterList.add(1, cluster[1]);
        } else if (agent2min == agent2max) {
            cluster[1].add(agent1min);
//            for (int i = 0; i < mat.length; i++) {
//                mat[agent1min][i] = -1;
//                mat[i][agent1min] = -1;
//            }
//            clusterList.add(1, cluster[1]);
        } else {
            cluster[2].add(agent1min);
            cluster[2].add(agent2min);
        }

//        for (int i = 0; i < mat.length; i++) {
//            mat[agent1max][i] = -1;
//            mat[agent2max][i] = -1;
//            mat[i][agent1max] = -1;
//            mat[i][agent2max] = -1;
//        }
//        for (int i = 0; i < mat.length; i++) {
//            System.out.println(Arrays.toString(mat[i]));
//        }
        System.out.println("");
        for (List<Integer> cluster1 : cluster) {
            System.out.println(cluster1);

        }
        System.out.println("");

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
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

//        compareElementToList();
        for (String agent : listOfAgent1) {
            for (double[] val : listOfValue11) {
                problem1.put(agent, val);
            }
        }

        for (String agent : listOfAgent2) {
            for (double[] val : listOfValue2) {
                problem2.put(agent, val);
            }
        }

        System.out.println("Matrice de croyance :");
        System.out.println(Arrays.toString(listOfFeatures1));
        for (int i = 0; i < listOfValue11.length; i++) {
            System.out.println("Agent" + String.valueOf(i) + " " + Arrays.toString(listOfValue11[i]));
        }
        System.out.println("");
        double resBa11[][] = matriceDistanceAgents(listOfValue11, "B");
        System.out.println("Matrice de distance de Battacharia " + Arrays.toString(listOfFeatures1));
        System.out.println(Arrays.toString(listOfAgent1));
        for (double[] agent : resBa11) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster Battacharia : ");
        initCluster(resBa11, listOfValue11);
        System.out.println(" max ");
        System.out.println(mapAgentsMax.entrySet());
        System.out.println(" min ");
        System.out.println(mapAgentsMin.entrySet());
        System.out.println("");

        System.out.println("");
        double resHe11[][] = matriceDistanceAgents(listOfValue11, "H");
        System.out.println("Matrice de distance de Hellinger " + Arrays.toString(listOfFeatures1) + " :");
        System.out.println(Arrays.toString(listOfAgent1));
        for (double[] agent : resHe11) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster Hellinger : ");
        initCluster(resHe11, listOfValue11);
        System.out.println(" max ");
        System.out.println(mapAgentsMax.entrySet());
        System.out.println(" min ");
        System.out.println(mapAgentsMin.entrySet());
        System.out.println("");

        System.out.println("");
        double resK11[][] = matriceDistanceAgents(listOfValue11, "K");
        System.out.println("Matrice de divergence de KBL" + Arrays.toString(listOfFeatures1) + " :");
        System.out.println(Arrays.toString(listOfAgent1));
        for (double[] agent : resK11) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster divergence de KBL : ");
        initCluster(resK11, listOfValue11);
        System.out.println(" max ");
        System.out.println(mapAgentsMax.entrySet());
        System.out.println(" min ");
        System.out.println(mapAgentsMin.entrySet());
        System.out.println("");

        System.out.println("Nouveau test");
        System.out.println("");

        System.out.println("Matrice de croyance :");
        System.out.println(Arrays.toString(listOfFeatures2));
        for (int i = 0; i < listOfValue2.length; i++) {
            System.out.println("Agent" + String.valueOf(i) + " " + Arrays.toString(listOfValue2[i]));
        }

        System.out.println("");
        double resBa21[][] = matriceDistanceAgents(listOfValue2, "B");
        System.out.println("Matrice de distance de Battacharia " + Arrays.toString(listOfFeatures2) + " :");
        System.out.println(Arrays.toString(listOfAgent2));
        for (double[] agent : resBa21) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster Battacharia : ");
        initCluster(resBa21, listOfValue2);
        System.out.println(" max ");
        System.out.println(mapAgentsMax.entrySet());
        System.out.println(" min ");
        System.out.println(mapAgentsMin.entrySet());
        System.out.println("");

        double resHe21[][] = matriceDistanceAgents(listOfValue2, "H");
        System.out.println("Matrice de distance de Hellinger " + Arrays.toString(listOfFeatures2) + " :");
        System.out.println(Arrays.toString(listOfAgent2));
        for (double[] agent : resHe21) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster Hellinger : ");
        initCluster(resHe21, listOfValue2);
        System.out.println(" max ");
        System.out.println(mapAgentsMax.entrySet());
        System.out.println(" min ");
        System.out.println(mapAgentsMin.entrySet());
        System.out.println("");

        double resK21[][] = matriceDistanceAgents(listOfValue2, "K");
        System.out.println("Matrice de divergence de KBL " + Arrays.toString(listOfFeatures2) + " :");
        System.out.println(Arrays.toString(listOfAgent2));
        for (double[] agent : resK21) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster divergence de KBL : ");
        initCluster(resK21, listOfValue2);
        System.out.println(" max ");
        System.out.println(mapAgentsMax.entrySet());
        System.out.println(" min ");
        System.out.println(mapAgentsMin.entrySet());
        System.out.println("");
//        System.out.println("mapAgentsMax");
//        System.out.println("");
//        compareMax(mapAgentsMax);

        System.out.println("Nouveau test");
        System.out.println("");

        System.out.println("Matrice de croyance :");
        System.out.println(Arrays.toString(listOfFeatures3));
        for (int i = 0; i < listOfValue3.length; i++) {
            System.out.println("Agent" + String.valueOf(i) + " " + Arrays.toString(listOfValue3[i]));
        }

        System.out.println("");
        double resBa31[][] = matriceDistanceAgents(listOfValue3, "B");
        System.out.println("Matrice de distance de Battacharia " + Arrays.toString(listOfFeatures3) + " :");
        System.out.println(Arrays.toString(listOfAgent3));
        for (double[] agent : resBa31) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster Battacharia : ");
        initCluster(resBa31, listOfValue3);
        System.out.println(" max ");
        System.out.println(mapAgentsMax.entrySet());
        System.out.println(" min ");
        System.out.println(mapAgentsMin.entrySet());
        System.out.println("");

        double resHe31[][] = matriceDistanceAgents(listOfValue3, "H");
        System.out.println("Matrice de distance de Hellinger " + Arrays.toString(listOfFeatures2) + " :");
        System.out.println(Arrays.toString(listOfAgent3));
        for (double[] agent : resHe31) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster Hellinger : ");
        initCluster(resHe31, listOfValue3);
        System.out.println(" max ");
        System.out.println(mapAgentsMax.entrySet());
        System.out.println(" min ");
        System.out.println(mapAgentsMin.entrySet());
        System.out.println("");

        double resK31[][] = matriceDistanceAgents(listOfValue3, "K");
        System.out.println("Matrice de divergence de KBL " + Arrays.toString(listOfFeatures3) + " :");
        System.out.println(Arrays.toString(listOfAgent3));
        for (double[] agent : resK31) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        System.out.println("Cluster divergence de KBL : ");
        initCluster(resK31, listOfValue3);
        System.out.println(" max ");
        System.out.println(mapAgentsMax.entrySet());
        System.out.println(" min ");
        System.out.println(mapAgentsMin.entrySet());
        System.out.println("");
//        System.out.println("mapAgentsMax");
//        System.out.println("");
//        compareMax(mapAgentsMax);

    }
}
