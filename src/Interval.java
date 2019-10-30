/*
 * @author Sean de Silva, Alejandro Cruz
 * @project AnalysisofAlgos
 * @date 10/12/2019
 */
public class Interval
{
    public int id;
    public int s_time;
    public int e_time;

    Interval(int id, int s_time, int e_time)
    {
        this.id = id;
        this.s_time = s_time;
        this.e_time = e_time;
    }

    @Override
    public String toString()
    {
        return "[" + id + ", " + "[" + s_time + "," + e_time + "]" + "]";
    }

}
