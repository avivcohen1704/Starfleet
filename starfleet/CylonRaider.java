package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends myAbstFigher{

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		int res = super.getAnnualMaintenanceCost();
		res = res + 3500;
		res = res + this.getCrewMembers().size()*500;
		res = (int) (res + this.getMaximalSpeed()*1200);
		return res;
	}
}
