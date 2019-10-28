package Interval_Scheduling;

import java.util.Comparator;

public class JobComparator implements Comparator<Job> {

    /* -------------------------------------------------- */
    /* -------------- PEDRO RIVERO RAMIREZ -------------- */
    /* -------------------------------------------------- */

    @Override
    public int compare(Job o1, Job o2) {
        if ( o1.getFinish() < o2.getFinish() ) return -1;
        else if ( o1.getFinish() == o2.getFinish() ) return 0;
        else return 1;
    }
}
