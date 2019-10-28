package Interval_Scheduling;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Scheduler {

    /* -------------------------------------------------- */
    /* -------------- PEDRO RIVERO RAMIREZ -------------- */
    /* -------------------------------------------------- */
    /* This class provides objects called Schedulers.     */
    /* -------------------------------------------------- */
    /*  Their function is to schedule a series of jobs    */
    /* defined by starting and finishing times.           */
    /*  Times will be assumed to be non-negative integer  */
    /* numbers.                                           */
    /*  Jobs will be scheduled for a chosen number of     */
    /* resources.                                         */
    /* -------------------------------------------------- */
    /* -------------------------------------------------- */

    /* ------------- FIELDS ------------- */

    private int n, m;                       // Number of jobs and resources respectively
    private Job[] jobs;                     // Starting and finishing times for all jobs
    private int scheduled;                  // Keeps track of the number of jobs scheduled
    private Resource[] resources;           // Array holding all resources

    /* ---------- CONSTRUCTORS ---------- */

    public Scheduler (String inputPath) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(inputPath));
        this.n = sc.nextInt();
        this.m = sc.nextInt();

        this.jobs = new Job[this.n];

        for (int i=0; i<n; i++) {
            this.jobs[i] = new Job();
            this.jobs[i].setStart(sc.nextInt());
            this.jobs[i].setFinish(sc.nextInt());
            this.jobs[i].setJobID(i+1);
        }

        JobComparator jc = new JobComparator(); // Creates comparator for Job objects
        Arrays.sort(jobs, jc);                  // Sorts jobs array by finishing time

        this.scheduled = 0;
        this.resources = new Resource[this.m];

        for (int j=0; j<m; j++) {
            this.resources[j] = new Resource();
        }

        buildSchedule();                        // Assigns jobs to the resources optimally
        sc.close();
    }

    /* ------------ METHODS ------------- */

    private void buildSchedule () {         // Simple assignation of jobs to resources

        for (int i=0; i<n; i++) {

            int k = 0;
            boolean discard = true;
            boolean condition;

            for (int j=0; j<m; j++) {

                condition = jobs[i].getStart()>=resources[j].getAvailableTime() &&
                        (discard || resources[k].getAvailableTime()<resources[j].getAvailableTime());

                if (condition) {
                    k = j;
                    discard = false;
                }
            }

            if (!discard) {
                resources[k].addJob(jobs[i]);
                scheduled++;
            }
        }
    }


    public void saveSchedule (String outputPath) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));

        bw.write(Integer.toString(scheduled));
        bw.newLine();

        for (int i=0; i<this.m; i++) {
            bw.write(resources[i].toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
