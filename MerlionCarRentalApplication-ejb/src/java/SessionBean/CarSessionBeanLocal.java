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

public interface CarSessionBeanLocal {

    public Long createNewCar(Car newCar);

    public List<Car> retrieveAllCars();

    public Car retrieveCarByCarId(Long carId) throws CarNotFoundException;

    public Car retrieveCarByCarPlateNumber(String licensePlate) throws CarNotFoundException;

    public void updateCar(Car car) throws CarNotFoundException, UpdateCarException;

    public void deleteCar(Long carId) throws CarNotFoundException, DeleteCarException;

 
}
