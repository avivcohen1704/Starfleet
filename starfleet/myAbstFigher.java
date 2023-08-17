package il.ac.tau.cs.sw1.ex9.starfleet;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.List;
import java.util.Set;

public abstract class myAbstFigher extends myAbstSpaceship{
    public List<Weapon> weapons;

    public myAbstFigher(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons) {
        super(name, commissionYear, maximalSpeed, crewMembers);
        this.weapons = weapons;
    }

    public int getFirePower() {
        int res = 10;
        for (Weapon i : this.getWeapon()) {
            res = res + i.getFirePower();
        }
        return res;
    }

    public List<Weapon> getWeapon() {
        return this.weapons;
    }

    @Override
    public int getAnnualMaintenanceCost() {
        int res = super.annualMaintenanceCost;
        for (Weapon i : this.weapons) {
            res = res + i.getAnnualMaintenanceCost();
        }
        return res;
    }

    @Override
    public String toString() {
        String res = super.toString();
        res = res + "\n" +
                "\t" + "WeaponArray=" + this.getWeapon().toString();
        return res;
    }
}
