package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends myAbstFigher {
	public int numberOfTechnicians;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}

	public int getNumberOfTechnicians() {
		return this.numberOfTechnicians;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		int res = super.getAnnualMaintenanceCost();
		res = res * (10-this.getNumberOfTechnicians())/10;
		res = res + 5000;
		return res;
	}

	@Override
	public String toString() {
		String res = super.toString();
		res = res + "\n" +
				"\t" + "NumberOfTechnicians=" + this.numberOfTechnicians;
		return res;
	}
}