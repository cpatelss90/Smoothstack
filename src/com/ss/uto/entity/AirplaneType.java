package com.ss.uto.entity;

import java.io.Serializable;

public class AirplaneType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2051318208399892900L;
	private Integer id;
	private Integer maxCapacity;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((maxCapacity == null) ? 0 : maxCapacity.hashCode());
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
		AirplaneType other = (AirplaneType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maxCapacity == null) {
			if (other.maxCapacity != null)
				return false;
		} else if (!maxCapacity.equals(other.maxCapacity))
			return false;
		return true;
	}



}
