package com.mdsap.wlf.db.repository;

import com.mdsap.wlf.db.domain.ITXTxnQueue;
import com.mdsap.wlf.db.domain.ITXTxnQueueId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITXTxnQueueIdRepository extends CrudRepository<ITXTxnQueueId, Integer> {


    //public ITXTxnQueueId findTopByServerOrderById(String server);

    @Query(value="SELECT max(ITXTxnQueueId) from  WLF.ITXTxnQueueId where Server = ?1  ", nativeQuery = true)
    public  Integer  getMaxIdByServer(String server);

}

