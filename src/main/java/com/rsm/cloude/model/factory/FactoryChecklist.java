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
@Table(name = "factory_checklist", catalog = "pool2", schema = "")
public class FactoryChecklist implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    
    @Column(name = "download_directory",length = 255)
    private String downloadDirectory;
    
    @Column(name = "file_name", length = 255)
    private String fileName;
    
    @Temporal(TemporalType.DATE)
    private Date month;
    
    private int records;
    
    private int status;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checklist", fetch = FetchType.LAZY)
//    private Collection<FactoryJob> factoryJobCollection;

    public FactoryChecklist() {
    }

    public FactoryChecklist(Long id) {
        this.id = id;
    }

    public FactoryChecklist(String fileName,int records) {
        this.fileName = fileName;
        this.records = records;
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
        if (!(object instanceof FactoryChecklist)) {
            return false;
        }
        FactoryChecklist other = (FactoryChecklist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FactoryChecklist[ id=" + id + " ]";
    }
    
}
