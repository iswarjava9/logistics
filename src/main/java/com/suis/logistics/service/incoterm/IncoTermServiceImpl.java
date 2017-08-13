package com.suis.logistics.service.incoterm;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.IncoTerm;
import com.suis.logistics.repository.incoterm.IncoTermDao;

@Component
public class IncoTermServiceImpl implements IncoTermService {
	@Resource
	IncoTermDao incoTermDao;

	@Override
	public Integer createIncoTerm(IncoTerm incoTerm) {
		return incoTermDao.createIncoTerm(incoTerm);
	}

	@Override
	public IncoTerm getIncoTerm(int id) {
		return incoTermDao.findById(id);
	}
}
