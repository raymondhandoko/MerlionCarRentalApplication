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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author raymond
 */
@Entity
public class RentalRate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rateId;
    @Column(nullable=false)
    private String rateName;
    @Column(nullable=false)
    private BigDecimal ratePerDay;
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rateValidityStartDate;
    @Column(nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date rateValidityEndDate;
    
    @JoinColumn(nullable=false)
    @ManyToOne(optional=false)
    private CarCategory carCategory;

    public RentalRate(String rateName, BigDecimal ratePerDay, Date rateValidityStartDate, Date rateValidityEndDate) {
        this.rateName = rateName;
        this.ratePerDay = ratePerDay;
        this.rateValidityStartDate = rateValidityStartDate;
        this.rateValidityEndDate = rateValidityEndDate;
    }

    public RentalRate() {
    }
    

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rateId != null ? rateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the rateId fields are not set
        if (!(object instanceof RentalRate)) {
            return false;
        }
        RentalRate other = (RentalRate) object;
        if ((this.rateId == null && other.rateId != null) || (this.rateId != null && !this.rateId.equals(other.rateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RentalRate[ id=" + rateId + " ]";
    }
    
}
