/**
 * 
 */
package com.ss.uto.entity;

import java.io.Serializable;

/**
 * @author charvin
 *
 */
public class Booking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -18397514081743619L;
	private Integer id;
	private Integer bookingActive;
	private String confirmCode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBookingActive() {
		return bookingActive;
	}
	public void setBookingActive(Integer bookingActive) {
		this.bookingActive = bookingActive;
	}
	public String getConfirmCode() {
		return confirmCode;
	}
	public void setConfirmCode(String confirmCode) {
		this.confirmCode = confirmCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingActive == null) ? 0 : bookingActive.hashCode());
		result = prime * result + ((confirmCode == null) ? 0 : confirmCode.hashCode());
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
		Booking other = (Booking) obj;
		if (bookingActive == null) {
			if (other.bookingActive != null)
				return false;
		} else if (!bookingActive.equals(other.bookingActive))
			return false;
		if (confirmCode == null) {
			if (other.confirmCode != null)
				return false;
		} else if (!confirmCode.equals(other.confirmCode))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
