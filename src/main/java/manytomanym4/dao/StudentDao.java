package manytomanym4.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanym4.dto.Course;
import manytomanym4.dto.Student;

public class StudentDao {
public EntityManager getEntityManager() {
	return Persistence.createEntityManagerFactory("vinod").createEntityManager();
}
public void saveStudent(Student student) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();
}
public void findStudent(int id) {
	EntityManager entityManager = getEntityManager();
	Student dbStudent = entityManager.find(Student.class, id);
	if (dbStudent != null) {
		System.out.println(dbStudent);
	} else {
		System.out.println("Sorry that id is not present");
	}

}

public void deleteStudent(int id) {
	EntityManager entityManager = getEntityManager();
	Student dbStudent = entityManager.find(Student.class, id);
	if (dbStudent != null) {
//		present then i can delete the data
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(dbStudent);
		entityTransaction.commit();
	} else {
		System.out.println("Sorry that id is not present");
	}
}
public void updateStudent(int id,Student student) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
    EntityManager  entityManager=entityManagerFactory.createEntityManager();
    Student dbStudent=entityManager.find(Student.class, id);
     if(dbStudent!=null) {
    	 EntityTransaction entityTransaction=entityManager.getTransaction();
    	 entityTransaction.begin();
    	 
    	 student.setId(id);
    	 student.setCourses(dbStudent.getCourses());
    	 
    	 entityManager.merge(student);
    	 entityTransaction.commit();
     }else {
    	 System.out.println("Sorry id is not present");
     }
}











}
