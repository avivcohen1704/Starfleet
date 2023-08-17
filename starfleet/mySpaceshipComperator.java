package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;
import java.util.Objects;

public class mySpaceshipComperator implements Comparator<Spaceship> {
    @Override
    public int compare(Spaceship o1, Spaceship o2) {
        if (o1.getFirePower() != o2.getFirePower()) {
            return -Integer.compare(o1.getFirePower(), o2.getFirePower());
        }
        if (o1.getCommissionYear() != o2.getCommissionYear()) {
            return -Integer.compare(o1.getCommissionYear(), o2.getCommissionYear());
        }
        return o1.getName().compareTo(o2.getName());

    }
}


