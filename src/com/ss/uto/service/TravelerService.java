/**
 * 
 */
package com.ss.uto.service;

import java.sql.Connection;
import java.sql.SQLException;
import com.ss.uto.dao.TicketDao;
import com.ss.uto.entity.Ticket;

/**
 * @author charvin patel
 *
 */
public class TravelerService {

	ConnectionUtil connUtil = new ConnectionUtil();


	public void addTicket(Ticket ticket) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			TicketDao ticketDao = new TicketDao(conn);
			ticketDao.addTicket(ticket);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}


	public void updateTicket(Ticket ticket) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			TicketDao ticketDao = new TicketDao(conn);
			ticketDao.updateTicket(ticket);
			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}





}
