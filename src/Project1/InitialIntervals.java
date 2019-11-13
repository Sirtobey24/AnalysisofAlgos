package Project1;

import java.util.*;

/*
 * @author Sean de Silva, Alejandro Cruz
 * @project AnalysisofAlgos
 * @date 10/13/2019
 */
public class InitialIntervals extends Interval
{
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Interval> Intervals = new ArrayList<>();

    private InitialIntervals(int id, int s_time, int e_time)
    {
        super(id, s_time, e_time);
    }

    private void initialintervals()
    {
        int start_time;
        int end_time;
        int numofintervals;
        Random num = new Random();

        do
        {
            System.out.println("Please enter the number of intervals");
            numofintervals = sc.nextInt();

            System.out.println("Please enter the start time of intervals:");
            start_time = sc.nextInt();

            System.out.println("Please enter the end time of intervals: ");
            end_time = sc.nextInt();

            System.out.println("\nInitial Intervals:\n");

            for (int i = 0; i < numofintervals; i++)
            {
                id = i;
                s_time = num.nextInt(end_time - start_time) + start_time;
                e_time = num.nextInt(end_time - s_time + 1) + s_time;

                Intervals.add(i, new Interval(id, s_time, e_time));

                System.out.println(Intervals.get(i));
            }

        } while (!sc.nextLine().equals(""));

    }


    public String toString()
    {
        return "[" + "id=" + ", " + "intervals= " + "[" + "[" + id + s_time + "," + e_time + "]" + "]";
    }


    public static void main(String[] args)
    {
        InitialIntervals obj = new InitialIntervals(0, 0, 0);
        obj.initialintervals();

    }

}

