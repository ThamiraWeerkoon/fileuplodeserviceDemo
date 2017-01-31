package com.rsm.cloude.model.factory;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
*
* @author Thamira
*/
@Entity
@Getter
@Setter
@Table(name = "factory_lot_count", catalog = "pool2", schema = "")
public class FactoryLotCount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    
   
    private int cars;
    
    
    private int comment;
    
    
    private int containers;
    
    @Column(name = "production_cars")
    private int productionCars;
    
   
    private int status;
    
    
    private int trucks;
    
    @Column(name = "completed_user_id")
    private long completedUserId;
    
    @Column(name = "qc_cars")
    private int qcCars;
    
    @Column(name = "qc_containers")
    private int qcContainers;
    
    @Column(name = "qc_production_cars")
    private int qcProductionCars;
    
    @Column(name = "qc_trucks")
    private int qcTrucks;
    
    @Column(name = "qcd_user_id")
    private long qcdUserId;
    @JoinColumn(name = "factory_job_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FactoryJob factoryJobId;
    @JoinColumn(name = "factory_lot_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FactoryLot factoryLotId;

    public FactoryLotCount() {
    }

    public FactoryLotCount(Long id) {
        this.id = id;
    }

    public FactoryLotCount(Long id, int cars, int comment, int containers, int productionCars, int status, int trucks, long completedUserId, int qcCars, int qcContainers, int qcProductionCars, int qcTrucks, long qcdUserId) {
        this.id = id;
        this.cars = cars;
        this.comment = comment;
        this.containers = containers;
        this.productionCars = productionCars;
        this.status = status;
        this.trucks = trucks;
        this.completedUserId = completedUserId;
        this.qcCars = qcCars;
        this.qcContainers = qcContainers;
        this.qcProductionCars = qcProductionCars;
        this.qcTrucks = qcTrucks;
        this.qcdUserId = qcdUserId;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactoryLotCount)) {
            return false;
        }
        FactoryLotCount other = (FactoryLotCount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FactoryLotCount[ id=" + id + " ]";
    }
    
}
