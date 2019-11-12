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
    


    public Long getTransitDispatchRecordId() {
        return transitDispatchRecordId;
    }

    public void setTransitDispatchRecordId(Long transitDispatchRecordId) {
        this.transitDispatchRecordId = transitDispatchRecordId;
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
