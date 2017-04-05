package com.wssearch.service.impl;

import com.wssearch.dao.JBQKDao;
import com.wssearch.model.Vo.Nr;
import com.wssearch.model.WSAjjbqkxses;
import com.wssearch.model.WsAjjbqkmsxz;
import com.wssearch.model.WsAjjbqkxsys;
import com.wssearch.service.JBQKService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2017/4/5.
 */

@Transactional
@Service("jbqkService")
public class JBQKServiceImpl implements JBQKService {

    @Resource
    JBQKDao jbqkDao;


    @Override
    public WsAjjbqkmsxz getWsAjjbqkmsxz(String Ajxh) {
        return jbqkDao.getWsAjjbqkmsxz(Integer.valueOf(Ajxh));
    }

    @Override
    public WSAjjbqkxses getWSAjjbqkxses(String Ajxh) {
        return jbqkDao.getWSAjjbqkxses(Integer.valueOf(Ajxh));
    }

    @Override
    public WsAjjbqkxsys getWsAjjbqkxsys(String Ajxh) {
        return jbqkDao.getWsAjjbqkxsys(Integer.valueOf(Ajxh));
    }

    @Override
    public List<Nr> getNrList(String Ajxh, String fromTable) {
        return jbqkDao.getNrList(Integer.valueOf(Ajxh),fromTable);
    }
}
