package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends myAbstFigher {



	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}
	public String toString() {
		String res = super.toString();

		return res;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		int res = super.getAnnualMaintenanceCost();
		res = res + 4000;
		res = res + this.getCrewMembers().size()*500;
		res = (int) (res + this.getMaximalSpeed()*500);
		return res;
	}
}
