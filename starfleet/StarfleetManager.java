package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.*;

import static il.ac.tau.cs.sw1.ex9.starfleet.OfficerRank.*;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<String> res1 = new ArrayList<>();
		List<Spaceship> res2 = new ArrayList<>();
		for (Spaceship i : fleet) {
			res2.add(i);
		}
		Comparator<Spaceship> c = new mySpaceshipComperator();
		res2.sort(c);
		for (int i=0; i<res2.size(); i++) {
			res1.add(i, res2.get(i).toString());
		}
		return res1;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> res = new HashMap<>();
		Iterator<Spaceship> it = fleet.iterator();
		while (it.hasNext()) {
			Spaceship i = it.next();
			if (res.containsKey(i.getClass().getSimpleName())) {
				res.replace(i.getClass().getSimpleName() , res.get(i.getClass().getSimpleName())+1);
			}
			else {
				res.put(i.getClass().getSimpleName(),1);
			}
		}
		return res;

	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int res =0;
		Iterator<Spaceship> it = fleet.iterator();
		while (it.hasNext()) {
			Spaceship i = it.next();
			res = res + i.getAnnualMaintenanceCost();
		}
		return res;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> res = new HashSet<>();
		for (Spaceship i : fleet) {
			if (!i.getClass().getSimpleName().equals("TransportShip")) {
				myAbstFigher j = (myAbstFigher) i;
				List<Weapon> now = j.getWeapon();
				for (Weapon m : now) {
					res.add(m.getName());
				}
			}

		}
		return res;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int res = 0;
		for (Spaceship i : fleet) {
			res = res + i.getCrewMembers().size();
		}
		return res;

	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		List<Officer> offlist = new ArrayList<>();
		float res = 0;
		for (Spaceship i : fleet) {
			List<CrewMember> now = new ArrayList<>(i.getCrewMembers());
			for (CrewMember j : now) {
				if (j.getClass().getSimpleName().equals("Officer")) {
					offlist.add((Officer) j);
				}
			}
		}
		int numOfOf = offlist.size();
		for (Officer i : offlist) {
			res = res + i.getAge();
		}
		res = res / numOfOf;
		return res;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		myRankComperator c = new myRankComperator();
		Map<Officer,Spaceship> res = new HashMap<>();
		for (Spaceship i : fleet) {
			List<Officer> allRank = new ArrayList<>();
			for (CrewMember j : i.getCrewMembers()) {
				if (j.getClass().getSimpleName().equals("Officer")) {
					allRank.add((Officer) j);
				}
			}
			if (allRank.size() == 0) {
				continue;
			}
			allRank.sort(c);
			int indx = allRank.size()-1;
			Officer topRank = allRank.get(indx);
			res.put(topRank , i);
			}
		return res;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Comparator<Map.Entry<OfficerRank, Integer>> c = new myMapComperator();
		Map<OfficerRank, Integer> map = new HashMap<>();
		for (Spaceship i : fleet) {
			for (CrewMember j : i.getCrewMembers()) {
				if (j.getClass().getSimpleName().equals("Officer")) {
					Officer l = (Officer) j;
					if (map.containsKey(l.getRank())) {
						map.replace(l.getRank(), map.get(l.getRank()), map.get(l.getRank()) + 1);
					}
					else {
						map.put(l.getRank(),1);
					}
				}
			}
		}
		List<Map.Entry<OfficerRank, Integer>> res = new ArrayList<Map.Entry<OfficerRank, Integer>>();
		for (Map.Entry i : map.entrySet() ) {
			res.add(res.size(),i);
		}
		for (Map.Entry<OfficerRank,Integer> i : res) {
			if (i.getValue() == 0) {
				res.remove(res.indexOf(i));
		    }
		}
		res.sort(c);
		return res;
	}

}
