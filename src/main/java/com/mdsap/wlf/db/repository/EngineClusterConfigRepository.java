package com.mdsap.wlf.db.repository;

import com.mdsap.wlf.db.domain.EngineClusterConfig;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineClusterConfigRepository extends CrudRepository<EngineClusterConfig, Integer> {


    @Query(value="SELECT max(TopNTransaction) from  WLF.EngineClusterConfig where Server = ?1  ", nativeQuery = true)
    public  Integer  getMaxTopNTransactionByServer(String server);

    @Query(value="SELECT max(ServerConfigId) from  WLF.EngineClusterConfig where Server = ?1  ", nativeQuery = true)
    public  Integer  getServerConfigIdByServer(String server);
}