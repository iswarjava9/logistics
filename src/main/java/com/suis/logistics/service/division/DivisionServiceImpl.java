package com.suis.logistics.service.division;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.Division;
import com.suis.logistics.repository.division.DivisionDao;

@Component
public class DivisionServiceImpl implements DivisionService {
	@Resource
	DivisionDao divisionDao;

	@Override
	public Integer addDivision(Division division) {

		return divisionDao.createDivision(division);
	}
}
