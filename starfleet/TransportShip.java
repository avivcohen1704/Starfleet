package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends myAbstSpaceship{

	public int cargoCapacity;
	public int passengetCapacity;

	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity) {
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengetCapacity = passengerCapacity;
	}

	public int getCargoCapacity() {
		return cargoCapacity;
	}

	public int getPassengerCapacity() {
		return passengetCapacity;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return this.annualMaintenanceCost + 3000 + 5*this.cargoCapacity + 3*this.passengetCapacity;
	}
	@Override
	public String toString() {
		String res = super.toString();
		res = res + "\n" +
				"\t" + "CargoCapacity=" + this.cargoCapacity +"\n" +
				"\t" + "PassengerCapacity=" +this.passengetCapacity;
		return res;
	}
}
