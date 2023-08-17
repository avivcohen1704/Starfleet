package il.ac.tau.cs.sw1.ex9.starfleet;

import jdk.nashorn.internal.runtime.Source;

public abstract class myAbstCrewMember implements CrewMember {
    public String name;
    public int age;
    public int yearsInService;

    public myAbstCrewMember(int age, int yearsInService, String name) {
        this.name = name;
        this.age = age;
        this.yearsInService = yearsInService;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public int getYearsInService() {
        return this.yearsInService;
    }
}
