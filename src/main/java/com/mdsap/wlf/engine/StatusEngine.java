package com.mdsap.wlf.engine;

import com.mdsap.wlf.db.config.MeConfigParams;
import com.mdsap.wlf.db.domain.MEConfig;
import com.mdsap.wlf.db.repository.MEConfigRepository;
import lombok.Data;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class StatusEngine {

    @Autowired
    private MEConfigRepository repoMEConfig;
    private List<MEConfig> meConfigList;


    private static Logger log  = Logger.getLogger(StatusEngine.class);

    public Boolean checkStatus() {

        if(!loadMEConfig()) return false;

        log.info("MeConfig Status !!!");

        log.info("Status : "+meConfigList.get(0).getWfState()+" so start...");

        if(!meConfigList.get(0).getWfState().trim().matches( MeConfigParams.STARTED)) {

            log.info("Engine Status is not  'Start' !!!");

            if(meConfigList.get(0).getWfState().matches( MeConfigParams.STOPPING))
             updateMEConfig(meConfigList.get(0));

            try {
                Thread.sleep(MeConfigParams.WAIT_TIME);
            } catch (InterruptedException e) {
                log.error("Status Engine Thread Wait Time : "+e.toString());
                return false;
            }

            return false;
        }

        return true;

    }


    public Boolean loadMEConfig()
    {
        try {
            log.info("Reading MEConfig list from database.");


            meConfigList = (List<MEConfig>)repoMEConfig.findAll();

        }catch (Exception e) {
            // TODO: handle exception
            log.error("Error reading MEConfig list from database : "+e.toString());
            return false;
        }

        return true;
    }


    public Boolean updateMEConfig(MEConfig newMeConfig)
    {
        try {
            log.info("MEConfig is Updating.");

            newMeConfig.setWfState(MeConfigParams.STOPPED);

            repoMEConfig.save(newMeConfig);

        }catch (Exception e) {
            // TODO: handle exception
            log.error("Error updating of MEConfig : "+e.toString());
            return false;
        }

        return true;
    }
}
