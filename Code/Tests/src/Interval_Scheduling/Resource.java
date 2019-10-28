package Interval_Scheduling;

import java.util.ArrayList;
import java.util.Iterator;

public class Resource {

    /* -------------------------------------------------- */
    /* -------------- PEDRO RIVERO RAMIREZ -------------- */
    /* -------------------------------------------------- */

    /* ------------- FIELDS ------------- */

    private ArrayList<Job> schedule;
    private int availableTime;

    /* ---------- CONSTRUCTORS ---------- */

    public Resource() {
        this.schedule = new ArrayList();    // ArrayList of jobs scheduled for the resource
        this.availableTime = 0;             // Time at which the resource becomes available again
    }

    /* ------------ METHODS ------------- */

    public int getAvailableTime() { return availableTime; }

    public void addJob(Job job) {
        this.schedule.add(job);
        if (this.availableTime < job.getFinish()) { this.availableTime = job.getFinish(); }
    }

    @Override
    public String toString() {
        
        String schedule = new String();             // Output variable
        Iterator it = this.schedule.iterator();     // Iterator for ArrayList
        
        while (it.hasNext()) {
            schedule += Integer.toString( ((Job)it.next()).getJobID() ) + " ";
        }
        
        return schedule;                    // Outputs a sequence of scheduled jobIDs
    }
}
