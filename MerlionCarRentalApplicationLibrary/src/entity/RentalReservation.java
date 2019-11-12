/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author raymond
 */
@Entity
public class RentalReservation implements Serializable {

   

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    @Column(nullable=false)
    private BigDecimal totalAmount;
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rentalStartDate;
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rentalEndDate;
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date paymentDate;
    private String creditCardCVVNumber;
    private Boolean isCancelled;
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(Boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
    
    @ManyToOne
    private CarCategory carCategory;
     
    @ManyToOne
    private CarModel carModel;
    
    @ManyToOne
    private Car car;
    
    @OneToOne
    private Outlet pickupOutlet;
    @OneToOne
    private Outlet returnOutlet;
    
     @ManyToOne
    private Partner partner;

    
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationId != null ? reservationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the reservationId fields are not set
        if (!(object instanceof RentalReservation)) {
            return false;
        }
        RentalReservation other = (RentalReservation) object;
        if ((this.reservationId == null && other.reservationId != null) || (this.reservationId != null && !this.reservationId.equals(other.reservationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RentalReservation[ id=" + reservationId + " ]";
    }
    
}
