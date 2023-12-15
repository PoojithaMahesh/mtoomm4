package manytomanym4.controller;

import java.util.ArrayList;
import java.util.List;

import manytomanym4.dao.CoursesDao;
import manytomanym4.dao.StudentDao;
import manytomanym4.dto.Course;
import manytomanym4.dto.Student;

public class StudentCourseCont {
public static void main(String[] args) {
	Course course1=new Course();
	course1.setId(1);
	course1.setName("Java");
	course1.setFees(5000);

    Course course2=new Course();
    course2.setId(2);
    course2.setName("advancejava");
    course2.setFees(50000);
    
    Course course3=new Course();
    course3.setId(3);
    course3.setName("Sql");
    course3.setFees(10000);
    
    
    Student student1=new Student();
    student1.setId(1);
    student1.setName("prathamesh");
    student1.setAddress("Pune");
    
    List<Course> courses=new ArrayList<Course>();
    courses.add(course1);
    courses.add(course2);
    courses.add(course3);
    
    student1.setCourses(courses);
    
    
    
    Student student2=new Student();
    student2.setId(2);
    student2.setName("Aanib");
    student2.setAddress("Chennai");
    
    List<Course> courses1=new ArrayList<Course>();
    courses1.add(course1);
    courses1.add(course2);
    
    student2.setCourses(courses1);
    
//    
    CoursesDao coursesDao=new CoursesDao();
    
    
    coursesDao.findAllCourses();
    
//    coursesDao.saveCourses(course1);
//    coursesDao.saveCourses(course3);
//    coursesDao.saveCourses(course2);
//    
//    StudentDao studentDao=new StudentDao();
//    studentDao.saveStudent(student1);
//    studentDao.saveStudent(student2);
    
    
    
    
    
    
    
    
    
    

}
}

