package com.suis.logistics.repository.booking;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.repository.BaseDao;

@Repository
public class BookingDaoImpl extends BaseDao implements BookingDao {

	@Override
	public Integer createBooking(BookingDetail bookingDetail) {
		getCurrentSession().save(bookingDetail);
		return bookingDetail.getId();
	}

	@Override
	public BookingDetail findById(int bookingId) {

		return getCurrentSession().load(BookingDetail.class, bookingId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookingDetail> getBookingList() {
		Criteria cr = getCurrentSession().createCriteria(BookingDetail.class)
				.setProjection(Projections.projectionList().add(Projections.property("id"), "id")
						.add(Projections.property("carrierBookingNo"), "carrierBookingNo")
						.add(Projections.property("shipperRefNo"), "shipperRefNo")
						.add(Projections.property("nvoccBookingNo"), "nvoccBookingNo"))
				.setResultTransformer(Transformers.aliasToBean(BookingDetail.class));
		List<BookingDetail> list = cr.list();
		return list;
	}
}
