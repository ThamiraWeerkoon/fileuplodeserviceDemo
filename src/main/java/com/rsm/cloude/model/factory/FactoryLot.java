package com.rsm.cloude.model.factory;

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
@Table(name = "factory_lot", catalog = "pool2", schema = "")
public class FactoryLot implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;

	private int comment;

	@Column(name = "factory_lot_number")
	private Integer factoryLotNumber;

	private int spaces;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "factoryLotId", fetch = FetchType.LAZY)
	private Collection<FactoryLotCount> factoryLotCountCollection;
	@JoinColumn(name = "factory_id", referencedColumnName = "id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Factory factoryId;

	public FactoryLot() {
	}

	public FactoryLot(Long id) {
		this.id = id;
	}

	public FactoryLot(Long id, int comment, int spaces) {
		this.id = id;
		this.comment = comment;
		this.spaces = spaces;
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
		if (!(object instanceof FactoryLot)) {
			return false;
		}
		FactoryLot other = (FactoryLot) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.FactoryLot[ id=" + id + " ]";
	}

}
