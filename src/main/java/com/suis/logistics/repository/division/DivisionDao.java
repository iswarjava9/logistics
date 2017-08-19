package com.suis.logistics.repository.division;

import java.util.List;

import com.suis.logistics.model.Division;

public interface DivisionDao {

	public Integer createDivision(Division division);
	public Division findById(int id);
	public List<Division> getAllDivisions();
}
