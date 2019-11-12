/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Temporal;


/**
 *
 * @author raymond
 */
@Entity
public class Outlet implements Serializable {

  

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long outletId;
    @Column(length = 50, nullable = false)
    private String outletName;
    @Column(length = 50, nullable = false)
    private String outletAddress;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date openingTime;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date closingTime;
    @OneToOne(mappedBy = "pickupOutlet")
    private RentalReservation rentalReservation;
      @OneToMany(mappedBy = "outlet")
    private List<Employee> employees;

    @OneToMany(mappedBy = "destinatedOutlet")
    private List<TransitDispatchRecord> transitDispatchRecords;

    public Outlet() {
        employees = new ArrayList<>();
        transitDispatchRecords = new ArrayList<>();
    }

    public Outlet(String outletName, String outletAddress, Date openingTime, Date closingTime) {
        this();
        this.outletName = outletName;
        this.outletAddress = outletAddress;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }
    
    
    public Long getOutletId() {
        return outletId;
    }

    public void setOutletId(Long outletId) {
        this.outletId = outletId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (outletId != null ? outletId.hashCode() : 0);
        return hash;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getOutletAddress() {
        return outletAddress;
    }

    public void setOutletAddress(String outletAddress) {
        this.outletAddress = outletAddress;
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Date getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Date closingTime) {
        this.closingTime = closingTime;
    }

    public RentalReservation getRentalReservation() {
        return rentalReservation;
    }

    public void setRentalReservation(RentalReservation rentalReservation) {
        this.rentalReservation = rentalReservation;
    }

    public List<TransitDispatchRecord> getTransitDispatchRecords() {
        return transitDispatchRecords;
    }

    public void setTransitDispatchRecords(List<TransitDispatchRecord> transitDispatchRecords) {
        this.transitDispatchRecords = transitDispatchRecords;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the outletId fields are not set
        if (!(object instanceof Outlet)) {
            return false;
        }
        Outlet other = (Outlet) object;
        if ((this.outletId == null && other.outletId != null) || (this.outletId != null && !this.outletId.equals(other.outletId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Outlet[ id=" + outletId + " ]";
    }
    
}
