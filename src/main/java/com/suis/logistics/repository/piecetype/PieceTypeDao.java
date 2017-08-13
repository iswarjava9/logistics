package com.suis.logistics.repository.piecetype;

import com.suis.logistics.model.PieceType;

public interface PieceTypeDao {
	public Integer createPieceType(PieceType pieceType);

	public PieceType findById(int id);
}
