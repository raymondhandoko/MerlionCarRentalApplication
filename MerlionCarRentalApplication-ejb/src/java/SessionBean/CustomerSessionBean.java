/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import entity.Customer;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
@Local(CustomerSessionBeanLocal.class)
@Remote(CustomerSessionBeanRemote.class)
public class CustomerSessionBean implements CustomerSessionBeanRemote, CustomerSessionBeanLocal {

    @PersistenceContext(unitName = "MerlionCarRentalApplication-ejbPU")
    private EntityManager em;

    public CustomerSessionBean() {
    }

    public Long registerCustomer (Customer customer){
        em.persist(customer);
        em.flush();
        return customer.getCustomerId();
                
    }
    
    //public Long customerLogin(String username, String password){
    
    //}
    
   
}
