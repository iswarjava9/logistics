package com.suis.logistics.service.piecetype;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.suis.logistics.model.PieceType;
import com.suis.logistics.repository.piecetype.PieceTypeDao;

@Component
public class PieceTypeServiceImpl implements PieceTypeService {

	@Resource
	PieceTypeDao pieceTypeDao;

	@Override
	public Integer createPieceType(PieceType pieceType) {
		return pieceTypeDao.createPieceType(pieceType);
	}

	@Override
	public PieceType getPieceType(int id) {
		return pieceTypeDao.findById(id);
	}
}
