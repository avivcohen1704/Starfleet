package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public abstract class myAbstSpaceship implements Spaceship {
    public String name;
    public int commissionYear;
    public float maximalSpeed;
    public int firePower;
    public Set<CrewMember> crewMembers;
    public int annualMaintenanceCost;

    public myAbstSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers) {
        this.name = name;
        this.commissionYear = commissionYear;
        this.maximalSpeed = maximalSpeed;
        this.crewMembers = (Set<CrewMember>) crewMembers;
        this.firePower = 10;
        this.annualMaintenanceCost = 0;
    }

    public String toString(){
        String res = "";
        res = this.getClass().getSimpleName() + "\n" +
                "\t" + "Name=" + this.getName() +"\n" +
                "\t" + "CommissionYear=" + this.getCommissionYear() +"\n" +
                "\t" + "MaximalSpeed=" + this.getMaximalSpeed() +"\n" +
                "\t" + "FirePower=" +this.getFirePower() + "\n" +
                "\t" + "CrewMembers=" + this.getCrewMembers().size()  + "\n" +
                "\t" + "AnnualMaintenanceCost=" + this.getAnnualMaintenanceCost();
        return res;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCommissionYear() {
        return this.commissionYear;
    }

    @Override
    public float getMaximalSpeed() {
        return this.maximalSpeed;
    }

    @Override
    public int getFirePower() {
        return this.firePower;
    }

    @Override
    public Set<CrewMember> getCrewMembers() {
        return this.crewMembers;
    }

    @Override
    public int getAnnualMaintenanceCost() {
        return this.annualMaintenanceCost;
    }

}
