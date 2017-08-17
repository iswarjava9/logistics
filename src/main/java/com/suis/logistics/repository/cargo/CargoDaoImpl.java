 package com.suis.logistics.repository.cargo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.suis.logistics.model.Cargo;
import com.suis.logistics.model.ContainerDetail;
import com.suis.logistics.repository.BaseDao;

@Repository
public class CargoDaoImpl extends BaseDao implements CargoDao {

	@Override
	public Integer createCargo(Cargo cargo) {
		getCurrentSession().save(cargo);
		return cargo.getId();
	}

	@Override
	public Cargo findById(int id) {
		return getCurrentSession().load(Cargo.class, id);
	}

	@Override
	public void loadCargoAndAttachToContainerDetail(ContainerDetail containerDetail) {
		List<Cargo> cargoList = containerDetail.getCargos();
		List<Cargo> cargoPersistList = new ArrayList();
		if(!CollectionUtils.isEmpty(cargoList)){
			for(Cargo cargo : cargoList){
				Cargo cargoPersist =  getCurrentSession().load(Cargo.class, cargo.getId());
				cargoPersistList.add(cargoPersist);

			}
		}
		containerDetail.setCargos(cargoPersistList);

	}


}
