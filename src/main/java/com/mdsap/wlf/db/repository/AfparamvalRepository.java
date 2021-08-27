package com.mdsap.wlf.db.repository;

import com.mdsap.wlf.db.domain.Afparamval;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AfparamvalRepository extends CrudRepository<Afparamval, Integer> {

    List<Afparamval> findByParamgrpnameAndValue(String paramgrpname,String value);
    List<Afparamval> findByParamgrpnameOrderByValueDesc(String paramgrpname);
    List<Afparamval> findByParamgrpnameAndCode(String paramgrpname,String code);
}
