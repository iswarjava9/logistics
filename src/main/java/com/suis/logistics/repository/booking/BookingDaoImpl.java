package com.suis.logistics.repository.booking;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.suis.logistics.model.BookingDetail;
import com.suis.logistics.repository.BaseDao;

@Repository
public class BookingDaoImpl extends BaseDao implements BookingDao {

	@Override
	public BookingDetail createBooking(BookingDetail bookingDetail) {
		getCurrentSession().save(bookingDetail);
		return bookingDetail;
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
						.add(Projections.property("nvoccBookingNo"), "nvoccBookingNo")
						.add(Projections.property("forwarderRefNo"), "forwarderRefNo"))
				.setResultTransformer(Transformers.aliasToBean(BookingDetail.class));
		List<BookingDetail> list = cr.list();
		return list;
	}

	@Override
	public Integer getLastInsertedPrimaryKey() {
		Query query = getCurrentSession().getNamedQuery("BookingDetail.findLastPrimaryKey");
		Integer lastBookingId = (Integer) query.uniqueResult();
		return lastBookingId;
	}
}
