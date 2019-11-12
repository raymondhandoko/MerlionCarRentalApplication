/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author raymond
 */
@Entity
public class TransitDispatchRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long transitDispatchRecordId;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(nullable = false)
    private Date dispatchTime;
    private Boolean isCompleted;
    @ManyToOne (optional = false)
    @JoinColumn( nullable = false)
    private Outlet destinatedOutlet; 
    @ManyToOne (optional = false)
    @JoinColumn( nullable = false)
    private Outlet currentOutlet;
    @ManyToOne (optional = false)
    @JoinColumn( nullable = false)
    private Employee employee; 

    public TransitDispatchRecord() {
    }

    public TransitDispatchRecord(Date dispatchTime, Boolean isCompleted, Outlet destinatedOutlet) {
        this();
        this.dispatchTime = dispatchTime;
        this.isCompleted = isCompleted;
        this.destinatedOutlet = destinatedOutlet;
    }
    


    public Long getTransitDispatchRecordId() {
        return transitDispatchRecordId;
    }

    public void setTransitDispatchRecordId(Long transitDispatchRecordId) {
        this.transitDispatchRecordId = transitDispatchRecordId;
    }

    public Date getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(Date dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Outlet getDestinatedOutlet() {
        return destinatedOutlet;
    }

    public void setDestinatedOutlet(Outlet destinatedOutlet) {
        this.destinatedOutlet = destinatedOutlet;
    }

    public Outlet getCurrentOutlet() {
        return currentOutlet;
    }

    public void setCurrentOutlet(Outlet currentOutlet) {
        this.currentOutlet = currentOutlet;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transitDispatchRecordId != null ? transitDispatchRecordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the transitDispatchRecordId fields are not set
        if (!(object instanceof TransitDispatchRecord)) {
            return false;
        }
        TransitDispatchRecord other = (TransitDispatchRecord) object;
        if ((this.transitDispatchRecordId == null && other.transitDispatchRecordId != null) || (this.transitDispatchRecordId != null && !this.transitDispatchRecordId.equals(other.transitDispatchRecordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TransitDispatchRecord[ id=" + transitDispatchRecordId + " ]";
    }
    
}
