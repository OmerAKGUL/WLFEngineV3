package com.mdsap.wlf.db.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.mdsap.wlf.db.domain.MEMatchResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MEMatchResultRepository extends CrudRepository<MEMatchResult, Integer> {

}
