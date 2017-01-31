package com.rsm.cloude.model.factory;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
*
* @author Thamira
*/
@Entity
@Getter
@Setter
@Table(catalog = "pool2", schema = "")
public class Ticker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    
    
    private String name;
    
    @Column(name = "first_quarter_end_date")
    @Temporal(TemporalType.DATE)
    private Date firstQuarterEndDate;
    
   
    private String description;
    
    @Column(name = "min_cars")
    private int minCars;
    
    
    private int type;
    
   
    private int weight;
    
    
    private int gap;
    
    @Column(name = "max_cars")
    private int maxCars;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tickerId", fetch = FetchType.LAZY)
    private Collection<Factory> factoryCollection;

    public Ticker() {
    }

    public Ticker(Long id) {
        this.id = id;
    }

    public Ticker(Long id, String name, Date firstQuarterEndDate, String description, int minCars, int type, int weight, int gap, int maxCars) {
        this.id = id;
        this.name = name;
        this.firstQuarterEndDate = firstQuarterEndDate;
        this.description = description;
        this.minCars = minCars;
        this.type = type;
        this.weight = weight;
        this.gap = gap;
        this.maxCars = maxCars;
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
        if (!(object instanceof Ticker)) {
            return false;
        }
        Ticker other = (Ticker) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ticker[ id=" + id + " ]";
    }
    
}
