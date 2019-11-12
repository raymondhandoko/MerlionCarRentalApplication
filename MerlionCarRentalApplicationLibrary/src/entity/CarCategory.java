/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author raymond
 */
@Entity
public class CarCategory implements Serializable {

    /**
     * @return the rentalRates
     */
    public List<RentalRate> getRentalRates() {
        return rentalRates;
    }

    /**
     * @param rentalRates the rentalRates to set
     */
    public void setRentalRates(List<RentalRate> rentalRates) {
        this.rentalRates = rentalRates;
    }

    /**
     * @return the models
     */
    public List<CarModel> getModels() {
        return models;
    }

    /**
     * @param models the models to set
     */
    public void setModels(List<CarModel> models) {
        this.models = models;
    }

    /**
     * @return the reservations
     */
    public List<RentalReservation> getReservations() {
        return reservations;
    }

    /**
     * @param reservations the reservations to set
     */
    public void setReservations(List<RentalReservation> reservations) {
        this.reservations = reservations;
    }

   

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(nullable=false)
    private String categoryName;
    @OneToMany(mappedBy = "carCategory")
    private List<RentalRate> rentalRates; 
    
    @OneToMany(mappedBy = "carCategory")
    private List<CarModel> models;
    
    @OneToMany(mappedBy = "carCategory")
    private List<RentalReservation> reservations;

    public CarCategory() {
        rentalRates = new ArrayList<>();
        models = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public CarCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    
    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the categoryId fields are not set
        if (!(object instanceof CarCategory)) {
            return false;
        }
        CarCategory other = (CarCategory) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CarCategory[ id=" + categoryId + " ]";
    }
    
}
