/**
 * 
 */
package com.ss.uto.entity;

import java.io.Serializable;

/**
 * @author charvin
 *
 */
//public class Route implements Serializable {

	/**
	 * 
	 */
	/*private static final long serialVersionUID = 7980104437530706609L;
	private Integer id;
	private Airport originAirport = new Airport();
	private Airport desAirport = new Airport();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Airport getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(Airport originAirport) {
		this.originAirport = originAirport;
	}
	public Airport getDesAirport() {
		return desAirport;
	}
	public void setDesAirport(Airport desAirport) {
		this.desAirport = desAirport;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desAirport == null) ? 0 : desAirport.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((originAirport == null) ? 0 : originAirport.hashCode());
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
		Route other = (Route) obj;
		if (desAirport == null) {
			if (other.desAirport != null)
				return false;
		} else if (!desAirport.equals(other.desAirport))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (originAirport == null) {
			if (other.originAirport != null)
				return false;
		} else if (!originAirport.equals(other.originAirport))
			return false;
		return true;
	}
	
	
}*/

public class Route implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7980104437530706609L;
	private Integer id;
	private String originAirport;
	private String desAirport;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}
	public String getDesAirport() {
		return desAirport;
	}
	public void setDesAirport(String desAirport) {
		this.desAirport = desAirport;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desAirport == null) ? 0 : desAirport.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((originAirport == null) ? 0 : originAirport.hashCode());
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
		Route other = (Route) obj;
		if (desAirport == null) {
			if (other.desAirport != null)
				return false;
		} else if (!desAirport.equals(other.desAirport))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (originAirport == null) {
			if (other.originAirport != null)
				return false;
		} else if (!originAirport.equals(other.originAirport))
			return false;
		return true;
	}
	
	
	
}
