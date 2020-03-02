/**
 * .stream()
 * .filter()
 * .map()
 * .collect()
 * .sorted()
 * .reversed()
 * .min()
 * .max()
 * .get()
 * .concat()
 * .forEach()
 * .toArray
 */
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream; 
import java.util.stream.Stream; 

public class StreamStudent{
    public static void main(String[] args) {
        
        List<Student> students = new ArrayList<>();
        students.add(new Student("john", 75));
        students.add(new Student("james", 43));
        students.add(new Student("alex", 38));
        students.add(new Student("zenith", 90));
        students.add(new Student("freeda", 34));
        System.out.println("All Students:" + students + "\n");

        List<Student> passedStudents = students.stream()
        .filter(s -> s.marks >= 40 )
        .collect(Collectors.toList());
        System.out.println("Passed students: " + passedStudents  + "\n");

        List<Student> failedStudents = students.stream()
        .filter(s -> s.marks < 40)
        .collect(Collectors.toList());

        Integer countOfFailedStudents = (int)failedStudents.stream().count();
        System.out.println("Failed students: " + failedStudents);
        System.out.println("Count of failed Students: " + countOfFailedStudents  + "\n");

        List<Student> passedWithGrace = students.stream()
        .filter(s -> s.marks < 40)
        .map(s -> new Student(s.name, s.marks + 5))
        .filter(s -> s.marks >= 40)
        .collect(Collectors.toList());
        
        System.out.println("Passed with grace: " + passedWithGrace  + "\n");

        List<Student> allPassedStudents = Stream.concat( 
            passedStudents.stream(), 
            passedWithGrace.stream() )
        .collect(Collectors.toList());
        System.out.println("All passed Students" + allPassedStudents  + "\n");

        List<Student> allPassedStudentSortedByMarks = allPassedStudents.stream()
        .sorted()
        .collect(Collectors.toList());
        System.out.println("All passed Students Sorted" + allPassedStudentSortedByMarks  + "\n");

        List<Student> allPassedStudentSortedByMarks2 = allPassedStudents.stream()
        .sorted(Comparator.comparingInt(Student::getMarks)
                .reversed())
        .collect(Collectors.toList());
        System.out.println("All passed Students Sorted Appraoch 2" + allPassedStudentSortedByMarks2  + "\n");

        List<Student> allPassedStudentSortedByMarks3 = allPassedStudents.stream()
        .sorted((s1,s2) -> s1.getMarks() > s2.getMarks() ? -1 : 0)
        .collect(Collectors.toList());
        System.out.println("All passed Students Sorted Appraoch 3" + allPassedStudentSortedByMarks3  + "\n");
    
        Student topper = allPassedStudents.stream().max((s1,s2) -> s2.compareTo(s1)).get();
        System.out.println("Topper" + topper  + "\n");

        Student last = allPassedStudents.stream().min((s1,s2) -> s2.compareTo(s1)).get();
        System.out.println("Topper" + last  + "\n");

        allPassedStudents.stream().forEach(System.out::println);
    }
       
}

class Student implements Comparable{

    String name;
    Integer marks;

    public Student(String n, int m){
        this.name = n;
        this.marks = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student :{"+ name + "," + marks +"} ";
    }
    
    @Override
    public int compareTo(Object o) {
        Student that = (Student) o;
        return (this.marks < that.marks) ? 1 : (this.marks > that.marks) ? -1 : this.name.compareTo(that.name);
    }

}