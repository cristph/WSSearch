package com.wssearch.service.impl;

import com.wssearch.dao.SSJLDao;
import com.wssearch.model.Vo.ZkjlZm;
import com.wssearch.model.WsSsjl;
import com.wssearch.model.WsSsjlCtr;
import com.wssearch.service.SSJLService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2017/3/29.
 */

@Transactional
@Service("ssjlService")
public class SSJLServiceImpl implements SSJLService {

    @Resource
    SSJLDao ssjlDao;

    @Override
    public WsSsjl getWsSsjl(String Ajxh) {
        return ssjlDao.getWsSsjl(Integer.valueOf(Ajxh));
    }

    @Override
    public List<WsSsjlCtr> getWsSsjlCtrList(String Ajxh) {
        return ssjlDao.getWsSsjlCtrList(Integer.valueOf(Ajxh));
    }

    @Override
    public List<ZkjlZm> getZkjlZmList(String Ajxh) {
        return ssjlDao.getZkjlZmList(Integer.valueOf(Ajxh));
    }
}
