package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;

import static il.ac.tau.cs.sw1.ex9.starfleet.OfficerRank.*;

public class myRankComperator implements Comparator<Officer> {
    public int Rank(OfficerRank i) {
        if (i == Ensign) {
            return 1;
        }
        if (i == Lieutenant) {
            return 2;
        }
        if (i == LieutenantCommander) {
            return 3;
        }
        if (i == Commander) {
            return 4;
        }
        return 5;
    }
    @Override
    public int compare(Officer o1, Officer o2) {
        return Integer.compare(Rank(o1.getRank()) , Rank(o2.getRank()));
    }
}
