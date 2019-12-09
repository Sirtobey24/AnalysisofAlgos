package Project2;

/**
 * @author Sean de Silva, Felipe de la Torre
 * @project Project 2
 * @date 12/1/2019
 */
public class Edges
{
    int vertices_i;
    int vertices_j;
    int weight;


    Edges(int vertices_i, int vertices_j, int weight)
    {
        this.vertices_i = vertices_i;
        this.vertices_j = vertices_j;
        this.weight = weight;
    }

//    void addEdge(int a, int b, int weight)
//    {
//        a = vertices_i;
//        b = vertices_j;
//        System.out.println("(" + vertices_i + ", " + vertices_j + ", " + weight + ")");
//        edges.add(a, b, weight);
//
//    }

    public int getVertices_i()
    {
        return vertices_i;
    }

    public void setVertices_i(int vertices_i)
    {
        this.vertices_i = vertices_i;
    }

    public int getVertices_j()
    {
        return vertices_j;
    }

    public void setVertices_j(int vertices_j)
    {
        this.vertices_j = vertices_j;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return ("(" + vertices_i + ", " + vertices_j + ", " + weight + ")");
    }


}
