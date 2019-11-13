/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import entity.Customer;
import entity.RentalReservation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local(RentalReservationSessionBeanLocal.class)
@Remote(RentalReservationSessionBeanRemote.class)
public class RentalReservationSessionBean implements RentalReservationSessionBeanRemote, RentalReservationSessionBeanLocal {

    @EJB(name = "CarSessionBeanLocal")
    private CarSessionBeanLocal carSessionBeanLocal;

    @PersistenceContext(unitName = "MerlionCarRentalApplication-ejbPU")
    private EntityManager em;
    

    public RentalReservationSessionBean() {
    }

    public Long reserveCar(RentalReservation reservation){
        
        em.persist(reservation);
        em.flush();
        return reservation.getReservationId();      
    }
    
//    public List<RentalReservation> retrieveAllRentalReservationsForCurrentDatePickup(){
//        Date date = new Date();  
//        
////        Query query = em.createQuery("SELECT r FROM RentalReservation r WHERE r.rentalStartDate==date")
//    }
    
    public void cancelReservation(Long reservationId){
        
        RentalReservation rentalReservation = em.find(RentalReservation.class, reservationId);
        rentalReservation.setIsCancelled(true);
        int days = 0;
        BigDecimal currentAmount = rentalReservation.getTotalAmount();
        BigDecimal twenty = new BigDecimal ("0.2");
        BigDecimal fifty = new BigDecimal ("0.5");
        BigDecimal seventy = new BigDecimal ("0.7");
        if(days  >= 14 ){
            rentalReservation.setTotalAmount(new BigDecimal ("0"));
        } else if (days < 14 && days >= 7){
            rentalReservation.setTotalAmount(currentAmount.multiply(twenty));
        } else if(days < 7 && days >= 3){
            rentalReservation.setTotalAmount(currentAmount.multiply(fifty));
        } else if(days > 3){
            rentalReservation.setTotalAmount(currentAmount.multiply(seventy));
        }
        
    }
    
    public RentalReservation viewReservationDetails(Long reservationId){
        
        return em.find(RentalReservation.class, reservationId);
        
    }

   public List <RentalReservation> viewAllMyReservation(Long customerId){
       
       Customer customer = em.find(Customer.class, customerId);
       List<RentalReservation> list = new ArrayList<>();
       //list = customer.getReservationList();
       return list;
   }
}
