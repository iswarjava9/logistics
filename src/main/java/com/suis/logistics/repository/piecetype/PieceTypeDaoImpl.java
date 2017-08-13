package com.suis.logistics.repository.piecetype;

import org.springframework.stereotype.Repository;

import com.suis.logistics.model.PieceType;
import com.suis.logistics.repository.BaseDao;

@Repository
public class PieceTypeDaoImpl extends BaseDao implements PieceTypeDao {

	@Override
	public Integer createPieceType(PieceType pieceType) {
		getCurrentSession().save(pieceType);
		return pieceType.getId();
	}

	@Override
	public PieceType findById(int id) {
		return getCurrentSession().load(PieceType.class, id);
	}
}
