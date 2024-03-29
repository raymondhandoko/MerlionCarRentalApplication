/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import enumeration.EmployeeRole;
import enumeration.TransitStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author raymond
 */
@Entity
public class Employee implements Serializable {

    @OneToOne(mappedBy = "employee")
    private TransitDispatchRecord transitDispatchRecord;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column(length = 20, nullable = false)
    private String employeeName;
    @Column(length = 20, nullable = false)
    private String password;
    @Column(length = 20, nullable = false, unique = true)
    private String username;
    @Enumerated(EnumType.STRING)
    private TransitStatus transitStatus;
    @ManyToOne
    private Outlet outlet;
    @OneToMany(mappedBy = "employee")
    private List <TransitDispatchRecord> transitRecords; 
    
    private EmployeeRole role;

    public Employee() {
        transitRecords = new ArrayList<>();
    }

    public Employee(String employeeName, Outlet outlet, EmployeeRole role) {
        this();
        this.employeeName = employeeName;
        this.role = role;
        this.outlet = outlet;
    }

    public TransitDispatchRecord getTransitDispatchRecord() {
        return transitDispatchRecord;
    }

    public void setTransitDispatchRecord(TransitDispatchRecord transitDispatchRecord) {
        this.transitDispatchRecord = transitDispatchRecord;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TransitStatus getTransitStatus() {
        return transitStatus;
    }

    public void setTransitStatus(TransitStatus transitStatus) {
        this.transitStatus = transitStatus;
    }

    public Outlet getOutlet() {
        return outlet;
    }

    public void setOutlet(Outlet outlet) {
        this.outlet = outlet;
    }

    public List<TransitDispatchRecord> getTransitRecords() {
        return transitRecords;
    }

    public void setTransitRecords(List<TransitDispatchRecord> transitRecords) {
        this.transitRecords = transitRecords;
    }
    
    
  
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the employeeId fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Employee[ id=" + employeeId + " ]";
    }
    
}
