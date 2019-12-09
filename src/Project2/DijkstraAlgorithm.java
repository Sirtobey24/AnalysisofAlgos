package Project2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Sean de Silva, Felipe De La Torre
 * @project AnalysisofAlgos Project 2
 * @date 12/5/2019
 */
public class DijkstraAlgorithm
{
    public static ArrayList<Edges> edgelist = new ArrayList<>();
    public static ArrayList nodes = new ArrayList<String>();
    public static Random r = new Random();
    public static Scanner input = new Scanner(System.in);
    public static int holder = -1;
    public static int source = -1;
    public static boolean flag = false;

    public static void main(String[] args)
    {
        GraphSize();
    }

    public static void GraphSize()
    {

        Integer numofnodes = null;
        do
        {
            System.out.print("Please enter a positive integer for the desired number of nodes: ");
            String n = input.nextLine();

            try
            {
                numofnodes = Integer.parseInt(n) + 1;
                if (numofnodes > 0)
                {
                    flag = true;
                }

                GraphCreation(numofnodes);

            }
            // catch if the user input is not an integer
            catch (NumberFormatException e)
            {
                System.out.println("Input was not a positive integer, please try again.");
            }
            // catch if the user input was a negative number
            catch (NegativeArraySizeException e)
            {
                System.out.println("Input was not a positive integer, please try again.");
            }
        } while (!flag);
        System.out.println();
    }

    public static void GraphCreation(int numofnodes)
    {
        int[][] Graph = new int[numofnodes][numofnodes];
        int weight;
        int prob;

        for (int i = 1; i < numofnodes; i++)
        {
            for (int j = i + 1; j < numofnodes; j++)
            {
                prob = r.nextInt(100);

                if ((prob >= 25) && (i != j))
                {
                    weight = r.nextInt((numofnodes * 5) + 1);
                    if (weight != 0 && Graph[j][i] == 0 && Graph[i][j] == 0)
                    {
                        Graph[j][i] = weight;
                        Graph[i][j] = weight;
                        Edges list = new Edges(i, j, weight);
                        edgelist.add(list);
                    }
                }
            }

            if (edgelist.isEmpty())
            {
                System.out.println("No edges were made.");
                break;
            }
        }


        GraphOutput(numofnodes);
        NodeInput(Graph, numofnodes);
    }

    public static void GraphOutput(int numofnodes)//Output of Nodes and Edges
    {
        System.out.print("Node list: ");
        for (int n = 1; n < numofnodes; n++)
        {
            nodes.add(n);
        }
        System.out.println(nodes.toString().replace("[", "{").replace("]", "}"));
        System.out.print("Edge list: ");
        System.out.println(edgelist.toString().replace("[", "{").replace("]", "}"));
    }


    public static void NodeInput(int[][] Graph, int numofnodes) //Gets Userinput for source and destination
    {
        System.out.print("Please enter an integer for the desired source node: ");
        int sourceNode = input.nextInt(); // get user input for user desired source node
        System.out.println();
        System.out.print("Please enter an integer for the desired destination node: ");
        int destinationNode = input.nextInt();  // get user input for desired destination node
        System.out.println();

        shortestPath(Graph, sourceNode, destinationNode, numofnodes);
        widestPath(Graph, sourceNode, destinationNode, numofnodes);
    }


    //generate the shortest path for desired user input in generated graph
    public static void shortestPath(int[][] Graph, int sourceNode, int destinationNode, int numofnodes)//Shortest Path
    {
        boolean[] visitedList = new boolean[numofnodes];
        int[] shortestDistances = new int[numofnodes];

        for (int nodeIndex = 0; nodeIndex < numofnodes; nodeIndex++)
        {
            shortestDistances[nodeIndex] = Integer.MAX_VALUE;
            visitedList[nodeIndex] = false;
        }
        shortestDistances[sourceNode] = 0;
        int[] parentNodes = new int[numofnodes];
        parentNodes[sourceNode] = source;

        for (int i = 1; i < numofnodes; i++)
        {
            int closestNode = holder;
            int shortestDistance = Integer.MAX_VALUE;
            for (int nodeIndex = 0; nodeIndex < numofnodes; nodeIndex++)
            {
                if (!visitedList[nodeIndex] && shortestDistances[nodeIndex] < shortestDistance)
                {
                    closestNode = nodeIndex;
                    shortestDistance = shortestDistances[nodeIndex];
                }
            }
            visitedList[closestNode] = true;
            for (int j = 0; j < numofnodes; j++)
            {
                int edgeDistance = Graph[closestNode][j];

                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[j]))
                {
                    parentNodes[j] = closestNode;
                    shortestDistances[j] = shortestDistance + edgeDistance;
                }
            }
        }
        shortestPathOutput(sourceNode, destinationNode, shortestDistances, parentNodes);
    }

    // method to print out shortest path
    public static void shortestPathOutput(int sourceNode, int destinationNode, int[] distance, int[] parent)
    {
        for (int i = 0; i < distance.length; i++)
        {
            if ((i != sourceNode) && (i == destinationNode))
            {
                System.out.print("The shortest path: ");
                printPath(i, parent);
                System.out.print(" with the path weight (edge weight sum) of " + distance[i] + ".");
            }
        }
    }


    //generate the widest path for desired user input in generated graph
    private static void widestPath(int[][] Graph, int sourceNode, int destinationNode, int numofnodes)//Widest Path
    {
        boolean[] visitedList = new boolean[numofnodes];
        int[] widestPaths = new int[numofnodes];

        for (int nodeIndex = 0; nodeIndex < numofnodes; nodeIndex++)
        {
            widestPaths[nodeIndex] = Integer.MIN_VALUE;
            visitedList[nodeIndex] = false;
        }
        widestPaths[sourceNode] = 0;
        int[] parentNodes = new int[numofnodes];
        parentNodes[sourceNode] = source;

        System.out.println();
        for (int i = 1; i < numofnodes; i++)
        {
            int farthestNode = holder;
            int mostMinMax = Integer.MIN_VALUE;

            for (int nodeIndex = 0; nodeIndex < numofnodes; nodeIndex++)
            {
                if (!visitedList[nodeIndex] && widestPaths[nodeIndex] > mostMinMax)
                {
                    farthestNode = nodeIndex;
                    mostMinMax = widestPaths[nodeIndex];
                }
            }
            visitedList[farthestNode] = true;

            for (int nodeIndex = 0; nodeIndex < numofnodes; nodeIndex++)
            {
                int edgeDistance = Graph[farthestNode][nodeIndex];

                if ((edgeDistance) >= widestPaths[nodeIndex] && !visitedList[nodeIndex])
                {
                    if (nodeIndex != sourceNode)
                    {
                        parentNodes[nodeIndex] = farthestNode;
                        widestPaths[nodeIndex] = Math.max(edgeDistance, widestPaths[nodeIndex]);
                    }

                }
            }
        }

        int minVal = Integer.MAX_VALUE;

        int index = destinationNode;
        while (index != -1)
        {
            int widestIndex = index;
            if (widestPaths[widestIndex] < minVal && widestPaths[widestIndex] != 0)
                minVal = widestPaths[widestIndex];
            index = parentNodes[index];
        }

        widestPathOutput(sourceNode, destinationNode, widestPaths, parentNodes, minVal);
    }

    // method to print out widest path
    private static void widestPathOutput(int sourceNode, int destinationNode, int[] widestPaths, int[] parent, int min)
    {


        for (int nodeIndex = 0; nodeIndex < widestPaths.length; nodeIndex++)
        {
            if ((nodeIndex != sourceNode) && (nodeIndex == destinationNode))
            {
                System.out.println();
                System.out.print("Widest Path is: ");
                printPath(nodeIndex, parent); // call method to print out path numbers
                System.out.print(" , with a bottleneck value of " + min + ".");
            }
        }
    }

    // prints out path for either widest or shortest path
    public static void printPath(int currentNode, int[] parent)
    {
        if (currentNode == source)
            return;
        printPath(parent[currentNode], parent);
        System.out.print(currentNode);
        if (currentNode != source)
            System.out.print(" - ");
    }

}


