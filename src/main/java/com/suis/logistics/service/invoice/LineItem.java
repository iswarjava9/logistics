package com.suis.logistics.service.invoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class LineItem {

	private String	item_id;
	private String	project_id;
	private String	expense_id;
	private String	salesorder_item_id;
	private String	account_id;
	private String	name;
	private String	description;
	private int		item_order;
	private double	rate;
	private String	unit;
	private double	quantity;
	private double	discount;
	private String	tax_id;
	private double	purchase_rate;

	public double getPurchase_rate() {
		return purchase_rate;
	}

	public void setPurchase_rate(double purchase_rate) {
		this.purchase_rate = purchase_rate;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public String getExpense_id() {
		return expense_id;
	}

	public void setExpense_id(String expense_id) {
		this.expense_id = expense_id;
	}

	public String getSalesorder_item_id() {
		return salesorder_item_id;
	}

	public void setSalesorder_item_id(String salesorder_item_id) {
		this.salesorder_item_id = salesorder_item_id;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getItem_order() {
		return item_order;
	}

	public void setItem_order(int item_order) {
		this.item_order = item_order;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getTax_id() {
		return tax_id;
	}

	public void setTax_id(String tax_id) {
		this.tax_id = tax_id;
	}
}
