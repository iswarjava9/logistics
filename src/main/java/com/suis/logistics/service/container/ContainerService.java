package com.suis.logistics.service.container;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.suis.logistics.model.ContainerDetail;

@Component
@Transactional
public interface ContainerService {

	public Integer createContainer(ContainerDetail containerDetail);

}
