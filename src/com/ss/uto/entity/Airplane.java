package com.ss.uto.entity;

import java.io.Serializable;

/**
 * @author charvin patel
 *
 */

public class Airplane implements Serializable {

	private static final long serialVersionUID = 2700885453075229481L;
	private Integer id;
	private AirplaneType airplaneTypeId = new AirplaneType();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public AirplaneType getAirplaneTypeId() {
		return airplaneTypeId;
	}
	public void setAirplaneTypeId(AirplaneType airplaneTypeId) {
		this.airplaneTypeId = airplaneTypeId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airplaneTypeId == null) ? 0 : airplaneTypeId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Airplane other = (Airplane) obj;
		if (airplaneTypeId == null) {
			if (other.airplaneTypeId != null)
				return false;
		} else if (!airplaneTypeId.equals(other.airplaneTypeId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}
