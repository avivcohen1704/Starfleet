package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myAbstFigher{

	public Fighter(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);

	}

	@Override
	public int getAnnualMaintenanceCost() {
		int res = super.getAnnualMaintenanceCost() + 2500;
		res = (int) (res + 1000 * this.maximalSpeed);
		return res;
	}
}
