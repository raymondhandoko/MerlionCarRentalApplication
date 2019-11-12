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

public interface RentalRateSessionBeanLocal {

    public Long createRentalRate(RentalRate newRentalRate);

    public List<RentalRate> retrieveAllRentalRates();

    public RentalRate retrieveRentalRateByRentalId(Long rentalId) throws RentalRateNotFoundException;

    public void updateRentalRate(RentalRate rentalRate) throws RentalRateNotFoundException, UpdateRentalRateException;

    public void deleteRentalRate(Long rateId) throws RentalRateNotFoundException, DeleteRentalRateException;
    
}
