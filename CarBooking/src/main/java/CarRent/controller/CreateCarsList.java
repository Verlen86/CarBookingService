package CarRent.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import CarRent.dao.CarRentDao;
import CarRent.dao.impl.CarDaoJsonImpl;
import CarRent.entity.CarData;
import CarRent.entity.BookingData;

public class CreateCarsList {
	public static void main(String []args){
		BookingData carRent=new BookingData("Online Booking Service");
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("primary");
		EntityManager manager=factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(new CarData("Mercedes","GLK 222", true, false, true));
		manager.getTransaction().commit();

		manager.getTransaction().begin();		
		manager.persist(new CarData("Mercedes","GLK 100", true, false, true));	
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		manager.persist(new CarData("BMW","X5", false, true, false));
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		manager.persist(new CarData("Renault","Clio", false, true, false));
		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		manager.persist(new CarData("Lamborgini","Murcielago", false, true, false));
		manager.getTransaction().commit();

		/*CarRentDao saveCarList=new CarDaoJsonImpl();
		saveCarList.saveCarList(carRent);*/
		manager.close();
		factory.close();
	}
}
