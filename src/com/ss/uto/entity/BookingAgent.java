/**
 * 
 */
package com.ss.uto.entity;

import java.io.Serializable;

/**
 * @author charvin patel
 *
 */
public class BookingAgent implements Serializable{

	private static final long serialVersionUID = -266165594865596774L;
	private Booking bookingId = new Booking();
	private User agentId = new User();
	public Booking getBookingId() {
		return bookingId;
	}
	public void setBookingId(Booking bookingId) {
		this.bookingId = bookingId;
	}
	public User getAgentId() {
		return agentId;
	}
	public void setAgentId(User agentId) {
		this.agentId = agentId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agentId == null) ? 0 : agentId.hashCode());
		result = prime * result + ((bookingId == null) ? 0 : bookingId.hashCode());
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
		BookingAgent other = (BookingAgent) obj;
		if (agentId == null) {
			if (other.agentId != null)
				return false;
		} else if (!agentId.equals(other.agentId))
			return false;
		if (bookingId == null) {
			if (other.bookingId != null)
				return false;
		} else if (!bookingId.equals(other.bookingId))
			return false;
		return true;
	}
	
	
}
