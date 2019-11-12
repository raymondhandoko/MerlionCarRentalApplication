/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import entity.CarModel;
import exception.CarModelNotFoundException;
import exception.DeleteCarModelException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author raymond
 */
@Local
public interface CarModelSessionBeanLocal {

    public Long createNewCarModel(CarModel newCarModel);

    public List<CarModel> retrieveAllCarModels();

    public CarModel retrieveCarModelByModelId(Long modelId) throws CarModelNotFoundException;

    public CarModel retrieveCarModelByModelName(String modelName) throws CarModelNotFoundException;

    public void deleteCarModel(Long modelId) throws CarModelNotFoundException, DeleteCarModelException;
    
}
