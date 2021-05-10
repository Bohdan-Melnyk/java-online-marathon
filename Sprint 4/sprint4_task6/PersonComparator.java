package sprint4_task6;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	@Override
    public int compare(Person o1, Person o2) {
        int comparingNames = o1.getName().compareTo(o2.getName());
        if(comparingNames == 0){
            if(o1.getAge() == o2.getAge()){
                return 0;
            }
            if(o1.getAge() > o2.getAge()){
                return 1;
            }
            return -1;
        }
        return comparingNames;
    }

}

class EmployeeComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        int comparingPerson = new PersonComparator().compare(o1, o2);
        if(comparingPerson == 0){
            if(o1.getSalary() == o2.getSalary()){
                return 0;
            }
            if(o2.getSalary() > o2.getSalary()){
                return 1;
            }
            return -1;
        }
        return comparingPerson;
    }
}

class DeveloperComparator implements Comparator<Developer>{
    @Override
    public int compare(Developer o1, Developer o2) {
        int comparingEmployee = new EmployeeComparator().compare(o1, o2);
        if(comparingEmployee == 0){
            return o1.getLevel().compareTo(o2.getLevel());
        }
        return comparingEmployee;
    }
	
}