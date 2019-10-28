import Interval_Scheduling.JobRandomizer;
import Interval_Scheduling.Scheduler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    /* -------------------------------------------------- */
    /* -------------- PEDRO RIVERO RAMIREZ -------------- */
    /* -------------------------------------------------- */

    public static void main(String[] args) {

        int N = 40000;                      // Number of jobs
        int M = 2000;                        // Number of resources
        double startTime, elapsedTime;

        String inputPath = "./tmp/input.txt";
        String outputPath = "./tmp/output.txt";

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("./nTest_m200.txt"));

            for (int n=400; n<N+1; n=n+99) {
                int m = M/10;

                JobRandomizer.randomJobInput(n,m,inputPath);

                startTime = (double) System.nanoTime();

                Scheduler intervalScheduler = new Scheduler(inputPath);
                intervalScheduler.saveSchedule(outputPath);

                // Print elapsed time
                elapsedTime = ((double)System.nanoTime()-startTime)/1000000000;
                System.out.println( "n = " + n + " & m = " + m + " -- Elapsed time: " + elapsedTime + " seconds" );

                bw.write(Integer.toString(n) + " " + Double.toString(elapsedTime/0.04));
                bw.newLine();

            }

            bw.flush();
            bw.close();

            BufferedWriter wb = new BufferedWriter(new FileWriter("./mTest_n4000.txt"));

            for (int m=1; m<M+1; m=m+5) {
                int n = N/10;

                JobRandomizer.randomJobInput(n,m,inputPath);

                startTime = (double) System.nanoTime();

                Scheduler intervalScheduler = new Scheduler(inputPath);
                intervalScheduler.saveSchedule(outputPath);

                // Print elapsed time
                elapsedTime = ((double)System.nanoTime()-startTime)/1000000000;
                System.out.println( "n = " + n + " & m = " + m + " -- Elapsed time: " + elapsedTime + " seconds" );

                wb.write(Integer.toString(m) + " " + Double.toString(elapsedTime/0.004));
                wb.newLine();

            }

            wb.flush();
            wb.close();

        }

        catch (IOException io) {
            System.out.println("File not found!");
        }
    }
}
