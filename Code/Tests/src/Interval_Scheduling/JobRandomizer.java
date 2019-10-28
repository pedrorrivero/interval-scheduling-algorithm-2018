package Interval_Scheduling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public abstract class JobRandomizer {

    /* -------------------------------------------------- */
    /* -------------- PEDRO RIVERO RAMIREZ -------------- */
    /* -------------------------------------------------- */
    /* This abstract class provides randomization method  */
    /* -------------------------------------------------- */
    /*  Their function is to create the input files with  */
    /* the jobs that will have to be scheduled.           */
    /*  The longest time duration of any interval will be */
    /* of 20 units of time.                               */
    /*  Jobs will be scheduled along 100000 units of time.*/
    /*  The parameters n and m will be inputted as        */
    /* arguments in its method.
    /* -------------------------------------------------- */
    /* -------------------------------------------------- */

    /* ------------- FIELDS ------------- */

    private static int MAX_SPAN = 100000;   // Maximum time span
    private static int MAX_DURATION = 20;   // Maximum duration

    /* ------------ METHODS ------------- */

    public static void randomJobInput (int n, int m, String inputPath) throws IOException {

        Random rand = new Random();         // Random integer generator
        int start, duration;                // Starting time and duration

        BufferedWriter bw = new BufferedWriter(new FileWriter(inputPath));

        bw.write(Integer.toString(n) + " " + Integer.toString(m));
        bw.newLine();

        for (int i=0; i<n; i++) {

            start = rand.nextInt(MAX_SPAN - MAX_DURATION + 1);
            duration = rand.nextInt(MAX_DURATION) + 1;

            bw.write(Integer.toString(start) + " " + Integer.toString(start + duration));
            bw.newLine();

        }

        bw.flush();
        bw.close();
    }
}
