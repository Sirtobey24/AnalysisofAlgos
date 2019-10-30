import java.util.ArrayList;

/*
 * @author Sean de Silva and Alejandro Cruz
 * @project AnalysisofAlgos
 * @date 10/26/2019
 */
public class Heaps extends Interval
{

    Heaps(int id, int s_time, int e_time)
    {
        super(id, s_time, e_time);
        this.id = id;
        this.s_time = s_time;
        this.e_time = e_time;
    }

    public void Max_Heapify(ArrayList<Interval> A, int i)
    {

        int l = 2 * i;
        int r = 2 * i + 1;
        int largest = 0;


        if (l <= A.size() && (l > largest))//Error Here "operator > cannot be applied to Interval, Interval
        {
            largest = l;
        }
        else
            largest = i;
        if (r <= A.size() && (r > largest))//Error Here "operator > cannot be applied to Interval, Interval
            largest = r;

        if (largest != i)
        {
            Interval exchange = A.get(i);
            A.set(i, A.get(largest));
            A.set(largest, exchange);
            Max_Heapify(A, largest);

        }

    }

    public void Max_Heap(ArrayList<Interval> A)
    {
        int n = A.size();
        for (int i = n / 2 - 1; i >= 0; i--)
        {
            Max_Heapify(A, i);
        }
    }

    /*public void Insert(ArrayList<Interval> A, int key)
    {
        double inf = Double.POSITIVE_INFINITY;
        A.size() = A.size() + 1;
        A[A.size()] = inf;
    }*/

    /*public void Increase_Key(ArrayList<Interval> A, int i, int key)
    {

        if (key < A.indexOf(i))
        {
            A.get(i) = key;
            while ((i > 1) && (A.get(i/2) < A.get(i))){
            Interval exchange = A.get(i/2);
            A.set(i/2,A.get(i));
            A.set(i,A.get(i/2));
        }
        }
    }*/

    public void Heapsort(ArrayList<Interval> A)
    {
        Max_Heap(A);
        int n = A.size();
        for (int i = n - 2; i >= 0; i--)
        {
            Interval exchange = A.get(1);
            A.set(1, A.get(i));
            A.set(i, exchange);
            n = n - 1;
            Max_Heapify(A, 1);
        }
    }

}
