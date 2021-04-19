package com.ss.uto.entity;

import java.io.Serializable;

/**
 * @author charvin patel
 *
 */

public class Flight implements Serializable{
	
	private static final long serialVersionUID = -987467238552914521L;
	private Integer id;
	private Route routeId = new Route();
	private Airplane airplaneId = new Airplane();
	private String departTime;
	private Integer reservedSeats;
	private double seatPrice;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Route getRouteId() {
		return routeId;
	}
	public void setRouteId(Route routeId) {
		this.routeId = routeId;
	}
	public Airplane getAirplaneId() {
		return airplaneId;
	}
	public void setAirplaneId(Airplane airplaneId) {
		this.airplaneId = airplaneId;
	}
	public String getDepartTime() {
		return departTime;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
	public Integer getReservedSeats() {
		return reservedSeats;
	}
	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	public double getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airplaneId == null) ? 0 : airplaneId.hashCode());
		result = prime * result + ((departTime == null) ? 0 : departTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((reservedSeats == null) ? 0 : reservedSeats.hashCode());
		result = prime * result + ((routeId == null) ? 0 : routeId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(seatPrice);
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
		Flight other = (Flight) obj;
		if (airplaneId == null) {
			if (other.airplaneId != null)
				return false;
		} else if (!airplaneId.equals(other.airplaneId))
			return false;
		if (departTime == null) {
			if (other.departTime != null)
				return false;
		} else if (!departTime.equals(other.departTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (reservedSeats == null) {
			if (other.reservedSeats != null)
				return false;
		} else if (!reservedSeats.equals(other.reservedSeats))
			return false;
		if (routeId == null) {
			if (other.routeId != null)
				return false;
		} else if (!routeId.equals(other.routeId))
			return false;
		if (Double.doubleToLongBits(seatPrice) != Double.doubleToLongBits(other.seatPrice))
			return false;
		return true;
	}
	
	
	
	
	
	

}
