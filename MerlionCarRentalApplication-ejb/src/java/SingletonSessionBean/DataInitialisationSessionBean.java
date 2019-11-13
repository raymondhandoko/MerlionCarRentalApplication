/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingletonSessionBean;

import entity.Car;
import entity.CarCategory;
import entity.CarModel;
import entity.Employee;
import entity.Outlet;
import entity.Partner;
import entity.RentalRate;
import enumeration.CarStatus;
import enumeration.EmployeeRole;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Singleton
@LocalBean
@Startup
public class DataInitialisationSessionBean {
    
  @PersistenceContext(unitName = "MerlionCarRentalApplication-ejbPU")
    private EntityManager em;

    public DataInitialisationSessionBean() {
    }
   
    @PostConstruct
    public void postConstruct(){
       
    }
    
    private void initialiseData(){
         /*Initialising Outlets*/
        Outlet outletA = new Outlet("Outlet A", null, null);
        em.persist(outletA);
        em.flush();
        
        Outlet outletB = new Outlet("Outlet B", null, null);
        em.persist(outletB);
        em.flush();
        
        Outlet outletC = new Outlet("Outlet C", null, null);
        em.persist(outletC);
        em.flush();
        
        
        /*Initialising Employees*/
        Employee employee = new Employee("Employee A1", outletA, EmployeeRole.SALES_MANAGER);
        em.persist(employee);
        em.flush();
        employee = new Employee("Employee A2", outletA, EmployeeRole.OPERATIONS_MANAGER);
        em.persist(employee);
        em.flush();
        employee = new Employee("Employee A3", outletA, EmployeeRole.CS_EXECUTIVE);
        em.persist(employee);
        em.flush();
        employee = new Employee("Employee A4", outletA, EmployeeRole.EMPLOYEE);
        em.persist(employee);
        em.flush();
        employee = new Employee("Employee A5", outletA, EmployeeRole.EMPLOYEE);
        em.persist(employee);
        em.flush();
        
        employee = new Employee("Employee B1", outletB, EmployeeRole.SALES_MANAGER);
        em.persist(employee);
        em.flush();
        employee = new Employee("Employee B2", outletB, EmployeeRole.OPERATIONS_MANAGER);
        em.persist(employee);
        em.flush();
        employee = new Employee("Employee B3", outletB, EmployeeRole.CS_EXECUTIVE);
        em.persist(employee);
        em.flush();
        
        employee = new Employee("Employee C1", outletB, EmployeeRole.SALES_MANAGER);
        em.persist(employee);
        em.flush();
        employee = new Employee("Employee C2", outletB, EmployeeRole.OPERATIONS_MANAGER);
        em.persist(employee);
        em.flush();
        employee = new Employee("Employee C3", outletB, EmployeeRole.CS_EXECUTIVE);
        em.persist(employee);
        em.flush();
        
        /*Initialising Category*/
        CarCategory stdSedan = new CarCategory("Standard Sedan");
        em.persist(stdSedan);
        em.flush();
        CarCategory famSedan = new CarCategory("Family Sedan");
        em.persist(famSedan);
        em.flush();
        CarCategory luxSedan = new CarCategory("Luxury Sedan");
        em.persist(luxSedan);
        em.flush();
        CarCategory suvMinivan = new CarCategory("SUV and Minivan");
        em.persist(suvMinivan);
        em.flush();
        
        
        /*Initialising Model*/
        CarModel toyotaCorolla = new CarModel("Toyota", "Corolla", stdSedan);
        em.persist(toyotaCorolla);
        em.flush();
        CarModel hondaCivic = new CarModel("Honda", "Civic", stdSedan);
        em.persist(hondaCivic);
        em.flush();
        CarModel nissanSunny = new CarModel("Nissan", "Sunny", stdSedan);
        em.persist(nissanSunny);
        em.flush();
        CarModel mercedesEClass = new CarModel("Mercedes", "E Class", luxSedan);
        em.persist(mercedesEClass);
        em.flush();
        CarModel bmw5Series = new CarModel("BMW", "5 Series", luxSedan);
        em.persist(bmw5Series);
        em.flush();
        CarModel audiA6 = new CarModel("Audi", "A6", luxSedan);
        em.persist(audiA6);
        em.flush();
        
        /*Initialising Car*/
        Car car = new Car("SS00A1TC", toyotaCorolla, CarStatus.AVAILABLE, outletA);
        em.persist(car);
        em.flush();
        car = new Car("SS00A2TC", toyotaCorolla, CarStatus.AVAILABLE, outletA);
        em.persist(car);
        em.flush();
        car = new Car("SS00A3TC", toyotaCorolla, CarStatus.AVAILABLE, outletA);
        em.persist(car);
        em.flush();
        car = new Car("SS00B1HC", hondaCivic, CarStatus.AVAILABLE, outletB);
        em.persist(car);
        em.flush();
        car = new Car("SS00B2HC", hondaCivic, CarStatus.AVAILABLE, outletB);
        em.persist(car);
        em.flush();
        car = new Car("SS00B3HC", hondaCivic, CarStatus.AVAILABLE, outletB);
        em.persist(car);
        em.flush();
        car = new Car("SS00C1NS", nissanSunny, CarStatus.AVAILABLE, outletC);
        em.persist(car);
        em.flush();
        car = new Car("SS00C2NS", nissanSunny, CarStatus.AVAILABLE, outletC);
        em.persist(car);
        em.flush();
        car = new Car("SS00C3NS", nissanSunny, CarStatus.REPAIR, outletC);
        em.persist(car);
        em.flush();
        car = new Car("LS00A4ME", mercedesEClass, CarStatus.AVAILABLE, outletA);
        em.persist(car);
        em.flush();
        car = new Car("LS00A4ME", bmw5Series, CarStatus.AVAILABLE, outletB);
        em.persist(car);
        em.flush();
        car = new Car("LS00A4ME", audiA6, CarStatus.AVAILABLE, outletC);
        em.persist(car);
        em.flush();
        
         /*Initialising Rental*/
         RentalRate rate = new RentalRate("Standard Sedan - Default", stdSedan, new BigDecimal(100), null, null);
         em.persist(rate);
         em.flush();
         rate = new RentalRate("Standard Sedan - Weekend Promo", stdSedan, new BigDecimal(80), new Date(6, 11, 2019, 12, 0), new Date(8, 11, 2019, 0, 0));
         em.persist(rate);
         em.flush();
         rate = new RentalRate("Family Sedan - Default", famSedan, new BigDecimal(200), null, null);
         em.persist(rate);
         em.flush();
         rate = new RentalRate("Luxury Sedan- Monday", luxSedan, new BigDecimal(310), new Date(2, 11, 2019, 0, 0), new Date(2, 12, 2019, 23, 59));
         em.persist(rate);
         em.flush();
         rate = new RentalRate("Luxury Sedan - Tuesday", luxSedan, new BigDecimal(320), new Date(3, 11, 2019, 0, 0), new Date(3, 12, 2019, 23, 59));
         em.persist(rate);
         em.flush();
         rate = new RentalRate("Luxury Sedan - Wednesday", luxSedan, new BigDecimal(330), new Date(4, 11, 2019, 0, 0), new Date(4, 11, 2019, 23, 59));
         em.persist(rate);
         em.flush();
         rate = new RentalRate("Luxury Sedan - Tuesday", luxSedan, new BigDecimal(250), new Date(4, 11, 2019, 0, 0), new Date(5, 12, 2019, 23, 59));
         em.persist(rate);
         em.flush();
         
         /*Initialising Partner*/
         Partner partner = new Partner("Holiday.com");
         
         
         
        
        
        
        
        
       
    }
    
    
    
    
}
