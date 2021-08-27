package com.mdsap.wlf.db.repository;

import com.mdsap.wlf.db.domain.ITXTxnQueueId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITXTxnQueueIdRepository extends CrudRepository<ITXTxnQueueId, Integer> {
}

