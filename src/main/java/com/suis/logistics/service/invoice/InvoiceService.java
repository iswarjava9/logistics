package com.suis.logistics.service.invoice;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.web.booking.BookingDto;

@Transactional
public interface InvoiceService {

	public Invoice createDraftInvoice(BookingDto bookingDto);

}
