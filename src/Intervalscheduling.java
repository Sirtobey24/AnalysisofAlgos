import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Sean de Silva
 * @project AnalysisofAlgos
 * @date 10/13/2019
 */
public class Intervalscheduling extends Interval
{
    public static void MaxHeap
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Interval> Intervals = new ArrayList<>();

    public Intervalscheduling(int id, int s_time, int e_time)
    {
        super(id, s_time, e_time);
    }

    private static void heapify(int[] intervals, int i)
    {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < intervals.length && intervals[left] > intervals[max])

        {
            max = left;

        }

        if (right < intervals.length && intervals[right] > intervals[max])

        {
            max = right;

        }
        if (max != i)
        {
            int temp = intervals[i];
            intervals[i] = intervals[max];
            heapify(intervals, i);
        }

    }

    static void schedule(Interval[] intervals)
    {

        Arrays.sort(intervals, Interval::compareTo);
//        ArrayList<Interval> sortedintervals = new ArrayList<>();
//        sortedintervals.add(intervals[0]);
         int n = intervals.length;
         int k =0;

        for (int i = 0; i < n - 1; i++)
        {
            if (Intervals.isEmpty())
            {
                Intervals.add(intervals[i]);
                k++;
            }

            if(intervals[i] >= Intervals.get(k-1))

        }

    }


    void initialintervals()
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
        } while (!sc.nextLine().equals(""));
        System.out.println("\nInitial Intervals:\n");

        for (int i = 0; i < numofintervals; i++)
        {
            id = i;
            s_time = num.nextInt(end_time - start_time) + start_time;
            e_time = num.nextInt(end_time - start_time) + start_time;

            Intervals.add(new Interval(id, s_time, e_time));
            System.out.println(Intervals.get(i));

        }

    }

    public void sort(int[] intervals)
    {
        int n = intervals.length;
        for (int i = n / 2 - 1; i > 0; i--)
        {
            heapify(intervals, i);
        }

        for (int i = n - 1; i >= 0; i--)
        {
            int temp = intervals[0];
            intervals[0] = intervals[i];
            intervals[i] = temp;

            heapify(intervals, i);
        }
    }

    public String toString()
    {
        return "[" + "id=" + ", " + "intervals= " + "[" + "[" + id + s_time + "," + e_time + "]" + "]";
    }

}

