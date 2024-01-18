package designpatterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kapil Negi
 */

interface Student{
    String getFirstName();
    String getSurName();
    String getEmailAddress();
}
class CollegeStudent implements Student{
    private String firstName;
    private String surName;
    private String emailAddress;

    public CollegeStudent(String firstName, String surName, String emailAddress) {
        this.firstName = firstName;
        this.surName = surName;
        this.emailAddress = emailAddress;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getSurName() {
        return surName;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "CollegeStudent{" +
                "firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}

class SchoolStudent{
    private String firstName;
    private String lastName;
    private String emailAddress;

    public SchoolStudent(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "SchoolStudent{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
class SchoolStudentAdpater implements Student{
    SchoolStudent student;
    SchoolStudentAdpater(SchoolStudent schoolStudent) {
        this.student = schoolStudent;
    }

    @Override
    public String getFirstName() {
        return student.getFirstName();
    }

    @Override
    public String getSurName() {
        return student.getLastName();
    }

    @Override
    public String getEmailAddress() {
        return student.getEmailAddress();
    }

    @Override
    public String toString() {
        return "SchoolStudentAdpater{" +
                "student=" + student +
                '}';
    }
}
class StudentClient{
    public List<Student> getStudents(){
        List<Student> studentList = new ArrayList<>();
        CollegeStudent collegeStudent = new CollegeStudent("kapil", "negi", "kapil@gmail.com");
        SchoolStudent schoolStudent = new SchoolStudent("kapil", "negi", "kapil@gmail.com");
       SchoolStudentAdpater adpater = new SchoolStudentAdpater(schoolStudent);
        studentList.add(collegeStudent);
        studentList.add(adpater);
        return studentList;
    }

}
public class StudentAdapter {
    public static void main(String[] args) {
        StudentClient studentClient = new StudentClient();
        List<Student> studentList = studentClient.getStudents();
        for(Student student: studentList) {
            System.out.println(student);
        }
    }
}
