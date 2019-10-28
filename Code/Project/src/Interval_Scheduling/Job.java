package Interval_Scheduling;

public class Job {

    /* -------------------------------------------------- */
    /* -------------- PEDRO RIVERO RAMIREZ -------------- */
    /* -------------------------------------------------- */

    /* ------------- FIELDS ------------- */

    private int start;                      // Starting time of the job
    private int finish;                     // Finishing time of the job
    private int jobID;                      // ID number of the job according to input file

    /* ---------- CONSTRUCTORS ---------- */

    public Job () {
        this.start = 0;
        this.finish = 0;
        this.jobID = 0;
    }

    /* ------------ METHODS ------------- */

    public int getStart() { return start; }
    public int getFinish() { return finish; }
    public int getJobID() { return jobID; }

    public void setStart(int start) { this.start = start; }
    public void setFinish(int finish) { this.finish = finish; }
    public void setJobID(int jobID) { this.jobID = jobID; }

    @Override
    public String toString() {
        return "Job{" +
                "jobID=" + jobID +
                ", start=" + start +
                ", finish=" + finish +
                '}';
    }
}
