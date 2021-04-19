package com.ss.uto.entity;

import java.io.Serializable;

/**
 * @author charvin patel
 *
 */
public class SeatAvailability implements Serializable{
	 
	private static final long serialVersionUID = -9169930158468540156L;
	private Integer id;
	private Flight flightId = new Flight();
	private Integer firstClass;
	private Integer businessClass;
	private Integer economyClass;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Flight getFlightId() {
		return flightId;
	}
	public void setFlightId(Flight flightId) {
		this.flightId = flightId;
	}
	public Integer getFirstClass() {
		return firstClass;
	}
	public void setFirstClass(Integer firstClass) {
		this.firstClass = firstClass;
	}
	public Integer getBusinessClass() {
		return businessClass;
	}
	public void setBusinessClass(Integer businessClass) {
		this.businessClass = businessClass;
	}
	public Integer getEconomyClass() {
		return economyClass;
	}
	public void setEconomyClass(Integer economyClass) {
		this.economyClass = economyClass;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessClass == null) ? 0 : businessClass.hashCode());
		result = prime * result + ((economyClass == null) ? 0 : economyClass.hashCode());
		result = prime * result + ((firstClass == null) ? 0 : firstClass.hashCode());
		result = prime * result + ((flightId == null) ? 0 : flightId.hashCode());
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
		SeatAvailability other = (SeatAvailability) obj;
		if (businessClass == null) {
			if (other.businessClass != null)
				return false;
		} else if (!businessClass.equals(other.businessClass))
			return false;
		if (economyClass == null) {
			if (other.economyClass != null)
				return false;
		} else if (!economyClass.equals(other.economyClass))
			return false;
		if (firstClass == null) {
			if (other.firstClass != null)
				return false;
		} else if (!firstClass.equals(other.firstClass))
			return false;
		if (flightId == null) {
			if (other.flightId != null)
				return false;
		} else if (!flightId.equals(other.flightId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	



}
