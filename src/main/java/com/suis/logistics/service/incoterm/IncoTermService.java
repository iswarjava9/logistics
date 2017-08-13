package com.suis.logistics.service.incoterm;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.IncoTerm;

@Transactional
public interface IncoTermService {

	public Integer createIncoTerm(IncoTerm incoTerm);
	public IncoTerm getIncoTerm(int id);
}
