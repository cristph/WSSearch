package com.wssearch.service.impl;

import com.wssearch.dao.XSPJJGDao;
import com.wssearch.model.WsXspjjgfz;
import com.wssearch.model.WsXspjjgpf;
import com.wssearch.service.XSPJJGService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2017/3/29.
 */

@Transactional
@Service("xspjjgService")
public class XSPJJGServiceImpl implements XSPJJGService {

    @Resource
    XSPJJGDao xspjjgDao;


    @Override
    public List<WsXspjjgfz> getWsXspjjgfzList(String Ajxh) {
        return xspjjgDao.getWsXspjjgfzList(Integer.valueOf(Ajxh));
    }

    @Override
    public List<WsXspjjgpf> getWsXspjjgpfList(String Ajxh, String Fzbh) {
        return xspjjgDao.getWsXspjjgpfList(Integer.valueOf(Ajxh),Integer.valueOf(Fzbh));
    }
}
