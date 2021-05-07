import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyUtils3 {
	public List<Person> maxDuration(List<Person> persons) {
//		List<Student> students = new ArrayList<>();
//        List<Worker> workers = new ArrayList<>();
//        
//        for (Person person : persons){
//            if (person instanceof Student){
//                students.add((Student) person);
//            }
//            if (person instanceof Worker){
//                workers.add((Worker) person);
//            }
//        }
//        students.removeIf(s -> s.studyYears <= 10);
//        workers.removeIf(w -> w.experianceYears <=10);
//        List<Person> res = new ArrayList<>();
//        res.add((Person) students);
//        res.add((Person) workers);
//        return res;
		 List<Person> max_persons = new ArrayList<>();

	        int max_student = 0;
	        int max_worker = 0;

	        for (Person person : persons) {
	            if (person instanceof Student) {
	                Student student = (Student)person;
	                if (max_student < student.getStudyYears()) {
	                    max_student = student.getStudyYears();
	                }
	            } else if (person instanceof Worker) {
	                Worker worker = (Worker)person;
	                if (max_worker < worker.getExperianceYears()) {
	                    max_worker = worker.getExperianceYears();
	                }
	            }
	        }

	        for (Person person : persons) {
	            if (person instanceof Student) {
	                Student student = (Student)person;
	                if (student.getStudyYears() == max_student && !max_persons.contains(person)) {
	                    max_persons.add(person);
	                }
	            } else if (person instanceof Worker) {
	                Worker worker = (Worker)person;
	                if (worker.getExperianceYears() == max_worker && !max_persons.contains(person)) {
	                    max_persons.add(person);
	                }
	            }
	        }

	        return max_persons;
    }
}
