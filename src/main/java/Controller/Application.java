package Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import DataAccessObject.Beneficiary;
import DataAccessObject.Project;
import DataAccessObject.Resource;
import DataAccessObject.Role;
import DataAccessObject.Status;
import DataAccessObject.Task;
import DataAccessObject.User;



public class Application {
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("ExtraCreditProject");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		createDataBase();
		QueryOnProject();
		emf.close();
	
	}

	private static void QueryOnProject() {
		// TODO Auto-generated method stub
				EntityManager em = null;
				EntityTransaction tx = null;

				try {

					em = emf.createEntityManager();
					tx = em.getTransaction();
					tx.begin();
					
					Query Query1= em.createQuery("Select p from Project p");
					List<Project> projectList= Query1.getResultList();
					 for (Project project : projectList) {
							System.out.println("ProjectName: "+project.getProjectName());
					}
					
					 
					

					tx.commit();

				} catch (PersistenceException e) {
					if (tx != null) {
						// logger.error("Rolling back", e);
						tx.rollback();
					}
				} finally {
					if (em != null) {
						em.close();
					}
				}
		
	}

	private static void createDataBase() {
		// TODO Auto-generated method stub
		EntityManager em = null;
		EntityTransaction tx = null;

		try {

			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			insertRecords(em);

			// em.persist(flight1);

			tx.commit();

		} catch (PersistenceException e) {
			if (tx != null) {
				// logger.error("Rolling back", e);
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	private static void insertRecords(EntityManager em) {
		Project p = new Project();
		Beneficiary b1= new Beneficiary();
		Beneficiary b2= new Beneficiary();
		b1.setBeneficiaryName("Bene1");
		b2.setBeneficiaryName("Bene2");
		List<Beneficiary> listOfBeneficiaries = new ArrayList<Beneficiary>();
		p.setListOfBeneficiary(listOfBeneficiaries);
		
		Task t1 = new Task();
		Task t2 = new Task();
		
		Resource r1 = new Resource();
		Resource r2 = new Resource();
		Resource r3 = new Resource();
		r1.setResourceName("HR");
		r2.setResourceName("finance");
		r3.setResourceName("Management");
		
		t1.getListOfResources().add(r1);
		t1.getListOfResources().add(r2);
		t2.getListOfResources().add(r3);
		
		t1.setTaskStaus(Status.Cancelled);
		t2.setTaskStaus(Status.Completed);
		
		t1.setTaskStartDate(new Date());
		t2.setTaskStartDate(new Date());
		t1.setTaskEndDate(new Date());
		t2.setTaskEndDate(new Date());
		
		p.getListOfTasks().add(t1);
		p.getListOfTasks().add(t2);
		
		User u1 = new User();
		User u2 = new User();
		
		u1.setName("Pramita");
		u1.setHasRole(Role.ADMINISTRATOR);
		
		u2.setName("Rusina");
		u2.setHasRole(Role.USER);
		
		p.setDescription("Important Project");
		p.setEndDate(new Date());
		p.setStartDate(new Date());
		p.setProjectName("Good Project");
		p.setProjectStatus(Status.Ongoing);
		
		em.persist(p);
		
		
		
		
		
		
	}
}
	
