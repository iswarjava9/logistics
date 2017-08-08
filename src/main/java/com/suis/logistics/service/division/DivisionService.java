package com.suis.logistics.service.division;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.Division;
@Transactional
public interface DivisionService {

	public Integer addDivision(Division division);
}
