package manytomanym4.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytomanym4.dto.Course;

public class CoursesDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public void saveCourses(Course course) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(course);
		entityTransaction.commit();
	}

	public void findCourses(int id) {
		EntityManager entityManager = getEntityManager();
		Course dbCourse = entityManager.find(Course.class, id);
		if (dbCourse != null) {
			System.out.println(dbCourse);

		} else {
			System.out.println("Sorry that id is not present");
		}

	}
	public void deleteCourses(int id) {
		EntityManager entityManager = getEntityManager();
		Course dbCourse = entityManager.find(Course.class, id);
		if (dbCourse != null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbCourse);
			entityTransaction.commit();
		} else {
			System.out.println("Sorry that id is not present");
		}
	}
	
	public void updateCourses(int id,Course course) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Course dbCourse=entityManager.find(Course.class, id);
		if(dbCourse!=null) {
//			id is present then i can update the data
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			course.setId(id);
			entityManager.merge(course);
			entityTransaction.commit();
		}else {
//			id is not present
			System.out.println("Sorry id is not present");
		}
	}
	
	
	
	
	public void findAllCourses() {
		EntityManager  entityManager=getEntityManager();
		Query query=entityManager.createQuery("Select c from Course c");
		
		List<Course> list=query.getResultList();
		
		System.out.println(list);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
