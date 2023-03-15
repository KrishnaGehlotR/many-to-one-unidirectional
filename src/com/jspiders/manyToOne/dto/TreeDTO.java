package com.jspiders.manyToOne.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tree_table")
public class TreeDTO implements Serializable {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "tree_id")
	private int treeId;
	@Column(name = "t_name")
	private String name;
	@Column(name = "t_height")
	private double height;
	@Column(name = "t_years")
	private double years;
	
	@OneToMany(mappedBy = "treeDTO", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<LeafDTO> leafDTOList;

	public int getTreeId() {
		return treeId;
	}

	public void setTreeId(int treeId) {
		this.treeId = treeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getYears() {
		return years;
	}

	public void setYears(double years) {
		this.years = years;
	}

	public List<LeafDTO> getLeafDTOList() {
		return leafDTOList;
	}

	public void setLeafDTOList(List<LeafDTO> leafDTOList) {
		this.leafDTOList = leafDTOList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((leafDTOList == null) ? 0 : leafDTOList.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + treeId;
		temp = Double.doubleToLongBits(years);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeDTO other = (TreeDTO) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (leafDTOList == null) {
			if (other.leafDTOList != null)
				return false;
		} else if (!leafDTOList.equals(other.leafDTOList))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (treeId != other.treeId)
			return false;
		if (Double.doubleToLongBits(years) != Double.doubleToLongBits(other.years))
			return false;
		return true;
	}

}
