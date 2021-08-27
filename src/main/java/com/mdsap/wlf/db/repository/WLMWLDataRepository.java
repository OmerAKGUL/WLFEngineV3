package com.mdsap.wlf.db.repository;
 
 
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.mdsap.wlf.db.domain.WLMWLData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WLMWLDataRepository extends CrudRepository<WLMWLData, Integer> {

}
