package Project1;

/*
 * @author Sean de Silva and Alejandro Cruz
 * @project AnalysisofAlgos
 * @date 10/26/2019
 */

public class PriorityQueue extends Heaps
{
    PriorityQueue(int id, int s_time, int e_time)
    {
        super(id, s_time, e_time);
        this.id = id;
        this.s_time = s_time;
        this.e_time = e_time;
    }

   /* public void Maximum(ArrayList<Interval> A)
    {
        return A.add(1, Interval);
    }

    public void ExtractMax(ArrayList<Interval> A)
    {
        if (A.size() < 1)
        {
            int max = A.indexOf(1);
            A.indexOf(1) = A[A.size()];
            A.size() = A.size() - 1;
            Max_Heapify(A, 1);


        }
        return A;
    }
*/

}
