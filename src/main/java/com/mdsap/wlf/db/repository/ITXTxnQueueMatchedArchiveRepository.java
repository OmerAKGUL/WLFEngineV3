package com.mdsap.wlf.db.repository;

import com.mdsap.wlf.db.domain.ITXTxnQueueMatchedArchive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITXTxnQueueMatchedArchiveRepository extends CrudRepository<ITXTxnQueueMatchedArchive, Integer> {
}

