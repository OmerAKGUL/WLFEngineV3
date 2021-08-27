package com.mdsap.wlf.db.repository;


import com.mdsap.wlf.db.domain.MEConfig;
import org.hibernate.mapping.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MEConfigRepository extends CrudRepository<MEConfig, Integer> {



}
