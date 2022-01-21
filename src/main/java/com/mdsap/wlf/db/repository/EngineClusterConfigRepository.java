package com.mdsap.wlf.db.repository;

import com.mdsap.wlf.db.domain.EngineClusterConfig;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineClusterConfigRepository extends CrudRepository<EngineClusterConfig, Integer> {



    @Query(value="SELECT max(ServerConfigType) from  WLF.EngineClusterConfig where Server = ?1  ", nativeQuery = true)
    public  String  getServerConfigIdByServer(String server);

    @Query(value="SELECT max(ThreadNumber) from  WLF.EngineClusterConfig where Server = ?1  ", nativeQuery = true)
    public  Integer  getServerConfigThreadNumberByServer(String server);

}
