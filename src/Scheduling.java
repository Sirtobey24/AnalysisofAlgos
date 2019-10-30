import java.util.ArrayList;
/*
 * @author Sean de Silva and Alejandro Cruz
 * @project AnalysisofAlgos
 * @date 10/26/2019
 */


public class Scheduling extends Heaps
{
    Scheduling(int id, int s_time, int e_time)
    {
        super(id, s_time, e_time);
        this.id = id;
        this.s_time = s_time;
        this.e_time = e_time;
    }

   /* public int intervalScheduling(ArrayList<Interval> A, int s_time, int e_time)
    {
        Heaps obj = new Heaps(0,0,0);
        obj.Heapsort(e_time); //use this to sort

        double ninfinity = Double.NEGATIVE_INFINITY;
       // A.Heapsort(e_time);
        int S = 0;
        double prev_finish = ninfinity;
        for (int j = 1; j <= e_time; i++)
        {
            if (A.contains(j) >= prev_finish)
            {
                A.add(S) = j;
                prev_finish = e_time(i);
            }
        }
        return S;

    }

    public void intervalPartition(ArrayList<Interval> A, int s_time, int e_time)
    {
        Heaps obj = new Heaps(0,0,0);
        obj.Heapsort(s_time); //use this to sort
        //A.Heapsort(s_time);
        int d = 1;

        for (int j = 1; j > s_time; j++)
        {
            if (s_time >= j){
                
            }
        }
    }*/

}
