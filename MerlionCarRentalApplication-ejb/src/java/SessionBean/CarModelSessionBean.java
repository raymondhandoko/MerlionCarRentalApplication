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
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
@Local(CarModelSessionBeanLocal.class)
@Remote(CarModelSessionBeanRemote.class)
public class CarModelSessionBean implements CarModelSessionBeanRemote, CarModelSessionBeanLocal {

    @PersistenceContext(unitName = "MerlionCarRentalApplication-ejbPU")
    private EntityManager em;

    @Override
    public Long createNewCarModel(CarModel newCarModel)
    {
        em.persist(newCarModel);
        em.flush();
        return newCarModel.getModelId();
    }
    
    @Override
     public List<CarModel> retrieveAllCarModels()
    {
        Query query = em.createQuery("SELECT c FROM CarModel c");
        return query.getResultList();
    }
     
    @Override
     public CarModel retrieveCarModelByModelId(Long modelId) throws CarModelNotFoundException
    {
        CarModel carModel = em.find(CarModel.class, modelId);
        if(carModel != null)
        {
            return carModel;
        } else 
        {
            throw new CarModelNotFoundException("modelId " + modelId + " does not exist!");
        }
    }
     
    @Override
     public CarModel retrieveCarModelByModelName(String modelName) throws CarModelNotFoundException
    {
        
        Query query = em.createQuery("SELECT c FROM CarModel c WHERE c.modelName = :inModelName");
        query.setParameter("inModelName", modelName);
        
         try
        {
            return (CarModel)query.getSingleResult();
        }
        catch(NoResultException | NonUniqueResultException ex)
        {
            throw new CarModelNotFoundException("modelName " + modelName + " is not registered in the system!");
        }
    }
     
    @Override
     public void deleteCarModel(Long modelId) throws CarModelNotFoundException, DeleteCarModelException
     {
         CarModel modelToRemove = retrieveCarModelByModelId(modelId);
         if(modelToRemove.getReservations().isEmpty())
         {
             em.remove(modelToRemove);
         } else 
         {
             modelToRemove.setIsDisabled(true);
             throw new DeleteCarModelException("CarModel " + modelId + " is used in reservation and cannot be deleted");
          
         }
     }
     
   
         
         

}
