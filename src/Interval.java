/**
 * @author Sean de Silva, Alejandro Cruz
 * @project AnalysisofAlgos
 * @date 10/12/2019
 */
public class Interval implements Comparable<Interval>
{
    public static int id;
    public static int s_time;
    public static int e_time;

    Interval(int id, int s_time, int e_time)
    {
        Interval.id = id;
        Interval.s_time = s_time;
        Interval.e_time = e_time;
    }

    public int getS_time()
    {
        return s_time;
    }

    public int getE_time()
    {
        return e_time;
    }


    @Override
    public int compareTo(Interval interval)

    {
        return this.getE_time() - interval.getE_time();
    }

    @Override
    public String toString()
    {
        return "[" + id + ", " + "[" + s_time + "," + e_time + "]" + "]";
    }

}
