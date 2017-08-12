package com.suis.logistics.repository.incoterm;

import com.suis.logistics.model.IncoTerm;

public interface IncoTermDao {
	public Integer createIncoTerm(IncoTerm incoTerm);

	public IncoTerm findById(int incoTerm);
}
