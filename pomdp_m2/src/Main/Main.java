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
    static double lemax = Double.MIN_VALUE;
    static double lemin = Double.MAX_VALUE;
    static int agent1max;
    static int agent2max;
    static int agent1min;
    static int agent2min;
    static List<List<Integer>> clusterList = new ArrayList<List<Integer>>();

    static String[] listOfAgent1 = {"Agent0", "Agent1", "Agent2", "Agent3"};
    static String[] listOfFeatures1 = {"Civile", "Militaire"};
    static double[][] listOfValue11 = {{0.6, 0.4}, {0.4, 0.6}, {0.85, 0.15}, {0.75, 0.25}};
    static double[][] listOfValue12 = {{0.8, 0.2}, {0.7, 0.3}, {0.95, 0.05}, {0.85, 0.15}};
    static double[][] listOfValue13 = {{0.98, 0.02}, {0.97, 0.03}, {0.99, 0.01}, {0.99, 0.01}};

    static String[] listOfAgent2 = {"Agent0", "Agent1", "Agent2", "Agent3", "Agent4"};
    static String[] listOfFeatures2 = {"Rouge", "Vert", "Bleu", "Blanc"};
    static double[][] listOfValue2 = {{0.5, 0.1, 0.3, 0.1}, {0.05, 0.5, 0.05, 0.4}, {0.1, 0.1, 0.5, 0.3}, {0.04, 0.01, 0.05, 0.95}, {0.1, 0.1, 0.1, 0.7}};

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
        double maxi = Double.MIN_VALUE;
        int agent1temp = 0;
        int agent2temp = 0;
        for (int i = 0; i < v.length; i++) {
            if (i != a) {
                temp = v[i];
                if (temp > max) {
                    max = temp;
                    tempAgent = i;
                    maxVal.clear();
                }
                maxVal.put(tempAgent, max);
                if (max > lemax) {
                    lemax = max;
                    agent1max = a;
                    agent2max = i;
                }

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
        double mini = Double.MAX_VALUE;
        int agent1temp = 0;
        int agent2temp = 0;
        for (int i = 0; i < v.length; i++) {
            if (i != a) {
                temp = v[i];
                if (temp < min) {
                    min = temp;
                    tempAgent = i;
                    minVal.clear();
                }
                minVal.put(tempAgent, min);
                if (min < mini) {
                    mini = min;
                    agent1temp = a;
                    agent2temp = i;
                }
                lemin = mini;
                agent1min = agent1temp;
                agent2min = agent2temp;

            }

        }

        return minVal;
    }

    /**
     *
     * @param mat
     */
    public static void averageDistanceBelieves(double[][] mat) {
        int nbAgent = mat.length;
        for (int i = 0; i < nbAgent; i++) {
            mapAgentsMax.put(i, getMax(mat[i], i));
            mapAgentsMin.put(i, getMin(mat[i], i));
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

    public static void compareMax(Map<Integer, Map<Integer, Double>> maxv) {
        double temp;
        double maxi = Double.MIN_VALUE;
        double val;

        maxv.entrySet().forEach((Entry<Integer, Map<Integer, Double>> entry) -> {
            //            maxi=(Collections.max(entry.getValue()));
//            System.out.println(entry.getKey() + " " + entry.getValue().keySet() + " " + (entry.getValue().values()));
            for (int i = 0; i < entry.getValue().values().size(); i++) {
//                val = entry.getValue().values()[i];
//                System.out.println(entry.getValue().values().getClass().getName());

            }

//            System.out.println(entry.getKey().getClass().getName());
//            val[entry.getKey()]+=entry.getValue().values().toString();
        });
    }

    public static void initCluster(double[][] mat, double[][] croyance) {
        averageDistanceBelieves(mat);
        int nbCroyance = croyance[0].length;
        int nbAgents = mat.length;
        int[] agentInCluster = new int[nbAgents];

        List<Integer>[] cluster = new List[nbCroyance];
        for (int i = 0; i < nbCroyance; i++) {
            cluster[i] = new ArrayList<>();
        }

        for (int i = 0; i < nbAgents; i++) {
            agentInCluster[i] = i;
        }

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
    }

    public static void miseAJourCluster(double[][] mat, double[][] croyance) {

        int nbCroyance = croyance[0].length;
        int nbAgents = mat.length;
        double max = Double.MIN_VALUE;
        double tempMax = 0;
        double min = Double.MAX_VALUE;
        double tempMin = 0;
        int agent1min = 0;
        int agent2min = 0;
        int agent1max = 0;
        int agent2max = 0;

        List<Integer>[] cluster = new List[nbCroyance];
        for (int i = 0; i < nbCroyance; i++) {
            cluster[i] = new ArrayList<>();
        }

        for (int i = 0; i < nbAgents; i++) {
            for (int j = 0; j < nbAgents; j++) {

                if (i != j) {
                    tempMin = mat[i][j];
                    tempMax = mat[i][j];
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

        System.out.println("a_i_min : " + agent1min + " , a_j_min : " + agent2min + " , min = " + min + "; a_i_max : " + agent1max + " , a_j_max : " + agent2max + " , max = " + max);

        cluster[0].add(agent1max);
        clusterList.add(0, cluster[0]);
//        agentInCluster[0]=0;
        cluster[1].add(agent2max);
        clusterList.add(1, cluster[1]);
//        if (agent1max == agent1min) {
//            cluster[0].add(agent2min);
//            clusterList.add(0, cluster[0]);
//        }
//        if (agent2max == agent1min) {
//            cluster[0].add(agent2min);
//            clusterList.add(0, cluster[0]);
//        }
//        if (agent1max == agent2min) {
//            cluster[1].add(agent1min);
//            clusterList.add(1, cluster[1]);
//        }
//        if (agent2max == agent2min) {
//            cluster[1].add(agent1min);
//            clusterList.add(1, cluster[1]);
//        }
//        for (List<Integer> list : cluster) {
//            for (int j = 0; j < list.size(); j++) {
//                if (agent1min == list.get(j)) {
//                    list.add(j, agent2min);
//
//                }
//                if (agent2min == list.get(j)) {
//                    list.add(j, agent1min);
//
//                }
//
//            }
//        }

        System.out.println(clusterList.get(1) + " " + clusterList.get(0));

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
        double resBa1[][] = matriceDistanceAgents(listOfValue11, "B");
        System.out.println("Matrice de distance de Battacharia " + Arrays.toString(listOfFeatures1));
        System.out.println(Arrays.toString(listOfAgent1));
        for (double[] agent : resBa1) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        double resHe1[][] = matriceDistanceAgents(listOfValue11, "H");
        System.out.println("Matrice de distance de Hellinger " + Arrays.toString(listOfFeatures1) + " :");
        System.out.println(Arrays.toString(listOfAgent1));
        for (double[] agent : resHe1) {
            System.out.println(Arrays.toString(agent));
        }

        System.out.println("");
        double resK1[][] = matriceDistanceAgents(listOfValue11, "K");
        System.out.println("Matrice de divergence de KBL" + Arrays.toString(listOfFeatures1) + " :");
        System.out.println(Arrays.toString(listOfAgent1));
        for (double[] agent : resK1) {
            System.out.println(Arrays.toString(agent));
        }
        System.out.println("");
        System.out.println(" Cluster ba : ");
        initCluster(resBa1, listOfValue11);
//        System.out.println(" max ");
//        System.out.println(mapAgentsMax.entrySet());
//        System.out.println(lemax + " " + agent1max + " " + agent2max);
//        System.out.println(" min ");
//        System.out.println(mapAgentsMin.entrySet());
//        System.out.println(lemin + " " + agent1min + " " + agent2min);
        System.out.println("");
        System.out.println(" Cluster he : ");
        initCluster(resHe1, listOfValue11);
//        System.out.println(" max ");
//        System.out.println(mapAgentsMax.entrySet());
//        System.out.println(lemax + " " + agent1max + " " + agent2max);
//        System.out.println(" min ");
//        System.out.println(mapAgentsMin.entrySet());
//        System.out.println(lemin + " " + agent1min + " " + agent2min);
        System.out.println("");
        System.out.println(" Cluster ku : ");
        initCluster(resK1, listOfValue11);
//        System.out.println(" max ");
//        System.out.println(mapAgentsMax.entrySet());
//        System.out.println(lemax + " " + agent1max + " " + agent2max);
//        System.out.println(" min ");
//        System.out.println(mapAgentsMin.entrySet());
//        System.out.println(lemin + " " + agent1min + " " + agent2min);

        System.out.println("");
        System.out.println("");

        System.out.println("Matrice de croyance :");
        System.out.println(Arrays.toString(listOfFeatures2));
        for (int i = 0; i < listOfValue2.length; i++) {
            System.out.println("Agent" + String.valueOf(i) + " " + Arrays.toString(listOfValue2[i]));
        }
        System.out.println("");
        double resBa2[][] = matriceDistanceAgents(listOfValue2, "B");
        System.out.println("Matrice de distance de Battacharia " + Arrays.toString(listOfFeatures2) + " :");
        System.out.println(Arrays.toString(listOfAgent2));
        for (double[] agent : resBa2) {
            System.out.println(Arrays.toString(agent));
        }
        System.out.println("");
        double resHe2[][] = matriceDistanceAgents(listOfValue2, "H");
        System.out.println("Matrice de distance de Hellinger " + Arrays.toString(listOfFeatures2) + " :");
        System.out.println(Arrays.toString(listOfAgent2));
        for (double[] agent : resHe2) {
            System.out.println(Arrays.toString(agent));
        }
        System.out.println("");
        double resK2[][] = matriceDistanceAgents(listOfValue2, "K");
        System.out.println("Matrice de divergence de KBL " + Arrays.toString(listOfFeatures2) + " :");
        System.out.println(Arrays.toString(listOfAgent2));
        for (double[] agent : resK2) {
            System.out.println(Arrays.toString(agent));
        }
//        System.out.println("");
//        System.out.println(" Cluster ba : ");
//        initCluster(resBa2, listOfValue2);
//        System.out.println(" max ");
//        System.out.println(mapAgentsMax.entrySet());
//        System.out.println(lemax + " " + agent1max + " " + agent2max);
//        System.out.println(" min ");
//        System.out.println(mapAgentsMin.entrySet());
//        System.out.println(lemin + " " + agent1min + " " + agent2min);
        System.out.println("");
        System.out.println(" Cluster Ba : ");
        initCluster(resBa2, listOfValue2);
                System.out.println("");
        System.out.println(" Cluster He : ");
        initCluster(resHe2, listOfValue2);
                System.out.println("");
        System.out.println(" Cluster Ku : ");
        initCluster(resK2, listOfValue2);

    }
}
