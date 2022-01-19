package com.mdsap.wlf.db.repository;
 
 
import com.mdsap.wlf.db.domain.ITXTxnQueue;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdsap.wlf.db.domain.WLMWLData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WLMWLDataRepository extends CrudRepository<WLMWLData, Integer> {


    @Query(value="SELECT * from  WLF.VTopWLMWLData  where id%2 =0 ", nativeQuery = true)
    public  List<WLMWLData> getQueueV1();

    @Query(value="SELECT * from  WLF.VTopWLMWLData  where id%2 =1 ", nativeQuery = true)
    public  List<WLMWLData> getQueueV2();


}
