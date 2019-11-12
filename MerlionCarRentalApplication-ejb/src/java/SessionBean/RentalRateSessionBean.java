/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import entity.RentalRate;
import exception.DeleteRentalRateException;
import exception.RentalRateNotFoundException;
import exception.UpdateRentalRateException;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local(RentalRateSessionBeanLocal.class)
@Remote(RentalRateSessionBeanRemote.class)
public class RentalRateSessionBean implements RentalRateSessionBeanRemote, RentalRateSessionBeanLocal {

    @PersistenceContext(unitName = "MerlionCarRentalApplication-ejbPU")
    private EntityManager em;

    @Override
    public Long createRentalRate(RentalRate newRentalRate)
    {
        em.persist(newRentalRate);
        em.flush();
        return newRentalRate.getRateId();
    }
    
    @Override
    public List<RentalRate> retrieveAllRentalRates(){
        Query query = em.createQuery("SELECT r FROM RentalRate r");
        return query.getResultList();
    }
    
    @Override
    public RentalRate retrieveRentalRateByRentalId(Long rentalId) throws RentalRateNotFoundException    
    {
        RentalRate rentalRate = em.find(RentalRate.class, rentalId);
        if(rentalRate != null)
        {
            return rentalRate;
        }
        else
        {
            throw new RentalRateNotFoundException("Rental Rate ID" + rentalId + " does not exist!");
        }
    }
    
    @Override
    public void updateRentalRate(RentalRate rentalRate) throws RentalRateNotFoundException, UpdateRentalRateException
    {
        if(rentalRate != null && rentalRate.getRateId() != null)
        {
            RentalRate rentalRateToUpdate = retrieveRentalRateByRentalId(rentalRate.getRateId());
            
            if(rentalRateToUpdate.getRateName().equals(rentalRate.getRateName()))
            {
                rentalRateToUpdate.setRateName(rentalRate.getRateName());
                rentalRateToUpdate.setRatePerDay(rentalRate.getRatePerDay());
                rentalRateToUpdate.setRateValidityEndDate(rentalRate.getRateValidityEndDate());
                rentalRateToUpdate.setRateValidityStartDate(rentalRate.getRateValidityStartDate());
            } else {
                throw new UpdateRentalRateException("RentalRate name to be updated does not match existing record");           
            }
           
        }
        else 
        {
            throw new RentalRateNotFoundException("Rental ID not provided for RentalRate to be updated");
        }
    }
    
    @Override
    public void deleteRentalRate(Long rateId) throws RentalRateNotFoundException, DeleteRentalRateException
    {
        RentalRate rentalRateToRemove = retrieveRentalRateByRentalId(rateId);
        if(rentalRateToRemove.getCarCategory().getReservations().isEmpty())
        {
            em.remove(rentalRateToRemove);
        }
        else
        {
            rentalRateToRemove.setIsDisabled(true);
            throw new DeleteRentalRateException("RentalRateId " + rateId + " is used in reservation and cannot be deleted");       
        }
    }
    
}
