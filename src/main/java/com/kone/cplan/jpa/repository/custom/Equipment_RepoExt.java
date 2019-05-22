package com.kone.cplan.jpa.repository.custom;

import com.kone.cplan.jpa.entity.Equipment;
import com.kone.cplan.jpa.filter.EquipmentFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Equipment_RepoExt {

	Page<Equipment> findByFilter(EquipmentFilter filter, Pageable pageRequest, boolean getRecordsCount);
}
