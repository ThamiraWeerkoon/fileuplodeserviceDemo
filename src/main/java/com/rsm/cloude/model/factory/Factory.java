package com.rsm.cloude.model.factory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Thamira
 */
@Entity
@Getter
@Setter
public class Factory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    
    
    private String address;
    
    
    private int comment;
    
    
    private String directory;
    
   
    private double latitude;
    
   
    private double longitude;
    
    
    private long zip;
    
    @Column(name = "zone_offset")
    private int zoneOffset;
    
    @Column(name = "state_id")
    private int stateId;
    
    @Column(name = "factory_id")
    private int factoryId;
    @JoinColumn(name = "ticker_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ticker tickerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factoryId", fetch = FetchType.LAZY)
    private Collection<FactoryLot> factoryLotCollection;

    public Factory() {
    }

    public Factory(Long id) {
        this.id = id;
    }

    public Factory(Long id, String address, int comment, String directory, double latitude, double longitude, long zip, int zoneOffset, int stateId, int factoryId) {
        this.id = id;
        this.address = address;
        this.comment = comment;
        this.directory = directory;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zip = zip;
        this.zoneOffset = zoneOffset;
        this.stateId = stateId;
        this.factoryId = factoryId;
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
        if (!(object instanceof Factory)) {
            return false;
        }
        Factory other = (Factory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Factory[ id=" + id + " ]";
    }
    
}
