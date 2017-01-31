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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "factory_job", catalog = "pool2", schema = "")
public class FactoryJob implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String directory;

	@Column(name = "match_id", length = 255)
	private String matchId;

	private String name;

	@Column(name = "stalite_image_provider")
	private int staliteImageProvider;

	private int status;
	
//	@OneToMany(cascade = CascadeType.DETACH, mappedBy = "factoryJobId", fetch = FetchType.LAZY)
//	private Collection<FactoryLotCount> factoryLotCountCollection;
	
	@JoinColumn(name = "checklist", referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private FactoryChecklist checklist;

	public FactoryJob() {
	}

	public FactoryJob(Long id) {
		this.id = id;
	}

	public FactoryJob(Long id, Date date, String directory, String matchId, String name, int staliteImageProvider,
			int status) {
		this.id = id;
		this.date = date;
		this.directory = directory;
		this.matchId = matchId;
		this.name = name;
		this.staliteImageProvider = staliteImageProvider;
		this.status = status;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FactoryJob)) {
			return false;
		}
		FactoryJob other = (FactoryJob) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.FactoryJob[ id=" + id + " ]";
	}

}
