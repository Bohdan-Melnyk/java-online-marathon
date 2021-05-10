package sprint4_task2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
	private int id;
    private String name;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
		Set<Student> newSet = new HashSet<>();
		if (!list1.contains(list2)) {
			
			for (Student s1 : list1) {
				for (Student s2 : list2) {
					
					if (s1.getId() == s2.getId()) {
						if (s1.getName().equals(s2.getName())) {
							newSet.add(s1);
						}
					}
				}
			}
		}
        return newSet;
    }
}
