package com.suis.logistics.service.piecetype;

import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.PieceType;

@Transactional
public interface PieceTypeService {

	public Integer createPieceType(PieceType pieceType);
	public PieceType getPieceType(int id);
}
