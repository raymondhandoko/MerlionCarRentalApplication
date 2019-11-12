/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import entity.Employee;
import entity.Outlet;
import entity.TransitDispatchRecord;
import enumeration.TransitStatus;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local(TransitDispatchSessionBeanLocal.class)
@Remote(TransitDispatchSessionBeanRemote.class)
public class TransitDispatchSessionBean implements TransitDispatchSessionBeanRemote, TransitDispatchSessionBeanLocal {

    @PersistenceContext(unitName = "MerlionCarRentalApplication-ejbPU")
    private EntityManager em;

    public TransitDispatchSessionBean() {
    }
    
    public List <TransitDispatchRecord> viewTransitDispatchRecords (Long outletId){
        Outlet outlet = em.find(Outlet.class, outletId);
        return outlet.getTransitDispatchRecords();
        
    } 
    
    public Long assignDriver(Long employeeId, Long transitRecordId){
        Employee employee = em.find(Employee.class, employeeId);
        TransitDispatchRecord transitDispatchRecord = em.find(TransitDispatchRecord.class,transitRecordId);
        transitDispatchRecord.setEmployee(employee);
        employee.getTransitRecords().add(transitDispatchRecord);
        employee.setTransitStatus(TransitStatus.INTRANSIT);
        return transitDispatchRecord.getTransitDispatchRecordId();
    }
    
    public void UpdateTransitAsComplete(Long employeeId, Long transitRecordId){
        Employee employee = em.find(Employee.class, employeeId);
        TransitDispatchRecord transitDispatchRecord = em.find(TransitDispatchRecord.class,transitRecordId);
        employee.setTransitStatus(TransitStatus.AVAILABLE);
        Outlet destinatedOutlet = transitDispatchRecord.getDestinatedOutlet();
        employee.setOutlet(destinatedOutlet);
        transitDispatchRecord.setIsCompleted(Boolean.TRUE);
    
    }
    
}
