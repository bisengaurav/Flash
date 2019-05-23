package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.Equipment;
import com.kone.cplan.jpa.filter.EquipmentFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Equipment_RepoExt {

	List<Equipment> findByFilter(EquipmentFilter filter, Pageable pageRequest);
}
