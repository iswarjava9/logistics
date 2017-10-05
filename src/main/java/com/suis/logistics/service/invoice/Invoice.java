package com.suis.logistics.service.invoice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.suis.logistics.model.CustomField;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Invoice {

	private String				invoice_id;
	private String				customer_id;
	private List<String>		contact_persons;
	private String				invoice_number;
	private String				place_of_supply;
	private String				gst_treatment;
	private String				gst_no;
	private String				reference_number;
	private String				template_id;
	private String				date;					// "2013-11-17",
	private Integer				payment_terms;
	private String				payment_terms_label;
	private String				due_date;				// "2013-12-03",
	private Integer				discount;
	private Boolean				is_discount_before_tax;
	private String				discount_type;
	private Boolean				is_inclusive_tax;
	private Double				exchange_rate;
	private String				recurring_invoice_id;
	private String				invoiced_estimate_id;
	private String				salesperson_name;
	// private Map<String,String> custom_fields;
	private Integer				project_id;
	private List<LineItem>		line_items;
	// private "payment_options":
	private Boolean				allow_partial_payments;
	private String				custom_body;
	private String				custom_subject;
	private String				notes;
	private String				terms;
	private Integer				shipping_charge;
	private Integer				adjustment;
	private String				adjustment_description;
	private List<CustomField>	custom_fields;

	// Setters and getters
	public String getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(String invoice_id) {
		this.invoice_id = invoice_id;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public List<String> getContact_persons() {
		return contact_persons;
	}

	public void setContact_persons(List<String> contact_persons) {
		this.contact_persons = contact_persons;
	}

	public String getInvoice_number() {
		return invoice_number;
	}

	public void setInvoice_number(String invoice_number) {
		this.invoice_number = invoice_number;
	}

	public String getPlace_of_supply() {
		return place_of_supply;
	}

	public void setPlace_of_supply(String place_of_supply) {
		this.place_of_supply = place_of_supply;
	}

	public String getGst_treatment() {
		return gst_treatment;
	}

	public void setGst_treatment(String gst_treatment) {
		this.gst_treatment = gst_treatment;
	}

	public String getGst_no() {
		return gst_no;
	}

	public void setGst_no(String gst_no) {
		this.gst_no = gst_no;
	}

	public String getReference_number() {
		return reference_number;
	}

	public void setReference_number(String reference_number) {
		this.reference_number = reference_number;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getPayment_terms() {
		return payment_terms;
	}

	public void setPayment_terms(Integer payment_terms) {
		this.payment_terms = payment_terms;
	}

	public String getPayment_terms_label() {
		return payment_terms_label;
	}

	public void setPayment_terms_label(String payment_terms_label) {
		this.payment_terms_label = payment_terms_label;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Boolean getIs_discount_before_tax() {
		return is_discount_before_tax;
	}

	public void setIs_discount_before_tax(Boolean is_discount_before_tax) {
		this.is_discount_before_tax = is_discount_before_tax;
	}

	public String getDiscount_type() {
		return discount_type;
	}

	public void setDiscount_type(String discount_type) {
		this.discount_type = discount_type;
	}

	public Boolean getIs_inclusive_tax() {
		return is_inclusive_tax;
	}

	public void setIs_inclusive_tax(Boolean is_inclusive_tax) {
		this.is_inclusive_tax = is_inclusive_tax;
	}

	public Double getExchange_rate() {
		return exchange_rate;
	}

	public void setExchange_rate(Double exchange_rate) {
		this.exchange_rate = exchange_rate;
	}

	public String getRecurring_invoice_id() {
		return recurring_invoice_id;
	}

	public void setRecurring_invoice_id(String recurring_invoice_id) {
		this.recurring_invoice_id = recurring_invoice_id;
	}

	public String getInvoiced_estimate_id() {
		return invoiced_estimate_id;
	}

	public void setInvoiced_estimate_id(String invoiced_estimate_id) {
		this.invoiced_estimate_id = invoiced_estimate_id;
	}

	public String getSalesperson_name() {
		return salesperson_name;
	}

	public void setSalesperson_name(String salesperson_name) {
		this.salesperson_name = salesperson_name;
	}

	public Integer getProject_id() {
		return project_id;
	}

	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}

	public List<LineItem> getLine_items() {
		return line_items;
	}

	public void setLine_items(List<LineItem> line_items) {
		this.line_items = line_items;
	}

	public Boolean getAllow_partial_payments() {
		return allow_partial_payments;
	}

	public void setAllow_partial_payments(Boolean allow_partial_payments) {
		this.allow_partial_payments = allow_partial_payments;
	}

	public String getCustom_body() {
		return custom_body;
	}

	public void setCustom_body(String custom_body) {
		this.custom_body = custom_body;
	}

	public String getCustom_subject() {
		return custom_subject;
	}

	public void setCustom_subject(String custom_subject) {
		this.custom_subject = custom_subject;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public Integer getShipping_charge() {
		return shipping_charge;
	}

	public void setShipping_charge(Integer shipping_charge) {
		this.shipping_charge = shipping_charge;
	}

	public Integer getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(Integer adjustment) {
		this.adjustment = adjustment;
	}

	public String getAdjustment_description() {
		return adjustment_description;
	}

	public void setAdjustment_description(String adjustment_description) {
		this.adjustment_description = adjustment_description;
	}

	public List<CustomField> getCustom_fields() {
		return custom_fields;
	}

	public void setCustom_fields(List<CustomField> custom_fields) {
		this.custom_fields = custom_fields;
	}
}
