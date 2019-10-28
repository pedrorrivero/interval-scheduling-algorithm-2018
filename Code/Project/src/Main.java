// import Interval_Scheduling.JobRandomizer;
import Interval_Scheduling.Scheduler;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    /* -------------------------------------------------- */
    /* -------------- PEDRO RIVERO RAMIREZ -------------- */
    /* -------------------------------------------------- */

    public static void main(String[] args) {

        // int n = 400;                        // Number of jobs
        // int m = 20;                         // Number of resources
        double startTime, elapsedTime;

        String inputPath = "./input.txt";
        String outputPath = "./output.txt";

        try {

            // JobRandomizer.randomJobInput(n,m,inputPath);

            startTime = (double) System.nanoTime();

            Scheduler intervalScheduler = new Scheduler(inputPath);
            intervalScheduler.saveSchedule(outputPath);

            // Print elapsed time
            elapsedTime = ((double)System.nanoTime()-startTime)/1000000000;
            System.out.println( "Elapsed time: " + elapsedTime + " seconds" );
        }

        catch (FileNotFoundException fnf) {
            System.out.println("File 'input.txt' not found at location of execution!"); }
        catch (IOException io) { System.out.println("IOException!"); }
    }
}
