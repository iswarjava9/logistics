package com.suis.logistics.repository.billoflading;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.BillOfLading;
import com.suis.logistics.repository.BaseDao;
import com.suis.logistics.repository.booking.BookingNotFoundException;
import com.suis.logistics.repository.booking.CreateBookingFailedException;
import com.suis.logistics.repository.booking.UpdateBookingFailedException;

@Repository
public class BillOfLadingDaoImpl  extends BaseDao implements BillOfLadingDao {
	@Autowired
	Environment env;

	@Override
	public BillOfLading createBillOfLading(BillOfLading billOfLading) {
		try {
			getCurrentSession().save(billOfLading);
			// bookingDetail.getUser().getId();// simulate booking creation
			// exception scenario
		} catch (Exception e) {
			// bookingDetail.getUser().getId(); // Simulate unknown error
			throw new CreateBookingFailedException(e, env);
		}
		return billOfLading;
	}

	@Override
	public BillOfLading updateBillOfLading(BillOfLading billOfLading) {
		try {
			getCurrentSession().update(billOfLading);
		} catch (Exception e) {
			throw new UpdateBookingFailedException(e, env);
		}
		return billOfLading;
	}

	@Override
	public BillOfLading findById(int bilId) {
		BillOfLading billOfLading = null;
		try {
			billOfLading = getCurrentSession().load(BillOfLading.class, bilId);
			billOfLading.getId();
		} catch (ObjectNotFoundException e) {
			throw new BookingNotFoundException(e, env);
		}
		return billOfLading;
	}

}
