package com.mdsap.wlf.db.repository;


import com.mdsap.wlf.db.domain.MEConfig;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdsap.wlf.db.domain.ITXTxnQueue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITXTxnQueueRepository extends CrudRepository<ITXTxnQueue, Integer> {

    @Query(value="SELECT * from  WLF.VTopITXTxnQueue   ", nativeQuery = true)
    public  List<ITXTxnQueue> getQueue();

    @Query(value="SELECT TOP ?1 * from  WLF.ITXTxnQueue   where id >  ?2", nativeQuery = true)
    public  List<ITXTxnQueue> getQueueByTopN(Integer topN,Integer byId);


    public List<ITXTxnQueue> findByIdGreaterThan(Integer id);

}
