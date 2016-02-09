import java.util.*;

public class PriorityQueueExample
{  
    public static void main (String[ ] args)
    {
        new PriorityQueueExample().run();
    } // method main
    
    public void run()
    {
        final int DEFAULT_INITIAL_CAPACITY = 11;
        final String PROMPT1 = "Please enter student’s name and GPA, or " ;
        final String PROMPT2 = " to quit: ";
        final String SENTINEL = "***";
        final String RESULTS1 = "\nHere are the student names and GPAs, " +
            "in increasing order of GPAs:";
        final String RESULTS2 = "\nHere are the student names and GPAs, " +
            "in alphabetical order of names:";
        
        PriorityQueue<Student> pq1 = new PriorityQueue<Student>(),
                               pq2 = new PriorityQueue<Student>
                                          (DEFAULT_INITIAL_CAPACITY, new ByName());
        
        Scanner sc = new Scanner (System.in);
        
        String line;
        while (true)
        {
            System.out.print (PROMPT1 + SENTINEL + PROMPT2);
            line = sc.nextLine();
            if (line.equals (SENTINEL))
                break;
            pq1.add (new Student (line));
            pq2.add (new Student (line));
        } // while
        System.out.println (RESULTS1);
        while (!pq1.isEmpty())
            System.out.println (pq1.remove());
        System.out.println (RESULTS2);
        while (!pq2.isEmpty())
            System.out.println (pq2.remove());
    } // method run
} // class PriorityQueueExample


