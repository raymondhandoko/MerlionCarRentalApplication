/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import entity.Car;
import exception.CarNotFoundException;
import exception.DeleteCarException;
import exception.UpdateCarException;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local(CarSessionBeanLocal.class)
@Remote(CarSessionBeanRemote.class)
public class CarSessionBean implements CarSessionBeanRemote, CarSessionBeanLocal {

    @PersistenceContext(unitName = "MerlionCarRentalApplication-ejbPU")
    private EntityManager em;
    
    @Override
    public Long createNewCar(Car newCar)
    {
        em.persist(newCar);
        em.flush();
        return newCar.getCarId();
    }
    
    @Override
    public List<Car> retrieveAllCars()
    {
        Query query = em.createQuery("SELECT c FROM Car c");
        return query.getResultList();
    }
    
    @Override
    public Car retrieveCarByCarId(Long carId) throws CarNotFoundException
    {
        Car car = em.find(Car.class, carId);
        if(car != null)
        {
            return car;
        } else 
        {
            throw new CarNotFoundException("CarId " + carId + " does not exist!");
        }
    }
    
    @Override
    public Car retrieveCarByCarPlateNumber(String licensePlate) throws CarNotFoundException
    {
        Query query = em.createQuery("SELECT c FROM Car c WHERE c.licensePlate = :inLicensePlate");
        query.setParameter("inLicensePlate", licensePlate);
        
        try
        {
            return (Car)query.getSingleResult();
        }
        catch(NoResultException | NonUniqueResultException ex)
        {
            throw new CarNotFoundException("licensePlate " + licensePlate + " is not registered in the system!");
        }
    }
    
    @Override
    public void updateCar(Car car) throws CarNotFoundException, UpdateCarException
    {
        if(car!=null && car.getCarId()!=null)
        {
            Car carToUpdate = retrieveCarByCarId(car.getCarId());
            
            if(carToUpdate.getLicensePlate().equals(car.getLicensePlate()))
            {
                carToUpdate.setColour(car.getColour());
                carToUpdate.setCarModel(car.getCarModel());
                carToUpdate.setOutlet(car.getOutlet());
               
            } 
            else 
            {
                throw new UpdateCarException("License Plate of car record to be update does not match existing record");
            }
        }
    }
    
    @Override
    public void deleteCar(Long carId) throws CarNotFoundException, DeleteCarException
    {
        Car carToRemove = retrieveCarByCarId(carId);
        if(carToRemove.getReservations().isEmpty()){
            em.remove(carToRemove);
        } else {
            carToRemove.setIsDisabled(true);
            throw new DeleteCarException("Car" + carId + "is used in reservation and cannot be deleted");
        }
    }
   

   
}
