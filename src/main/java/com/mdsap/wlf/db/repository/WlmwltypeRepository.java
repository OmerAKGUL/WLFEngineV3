package com.mdsap.wlf.db.repository;

import com.mdsap.wlf.db.domain.WLMWLData;
import com.mdsap.wlf.db.domain.Wlmwltype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WlmwltypeRepository extends CrudRepository<Wlmwltype, Integer> {


}
