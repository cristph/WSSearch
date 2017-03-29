package com.wssearch.service.impl;

import com.wssearch.dao.CpfxgcDao;
import com.wssearch.model.WsCpfxgc;
import com.wssearch.model.WsCpfxgcFlft;
import com.wssearch.model.WsCpfxgcLxqj;
import com.wssearch.service.CpfxgcService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2017/3/29.
 */

@Transactional
@Service("cpfxgcService")
public class CpfxgcServiceImpl implements CpfxgcService {

    @Resource
    CpfxgcDao cpfxgcDao;


    @Override
    public WsCpfxgc getWsCpfxgc(String Ajxh) {
        return cpfxgcDao.getWsCpfxgc(Integer.valueOf(Ajxh));
    }

    @Override
    public List<WsCpfxgcFlft> getWsCpfxgcFlftList(String Ajxh) {
        return cpfxgcDao.getWsCpfxgcFlftList(Integer.valueOf(Ajxh));
    }

    @Override
    public List<WsCpfxgcLxqj> getWsCpfxgcLxqjList(String Ajxh) {
        return cpfxgcDao.getWsCpfxgcLxqjList(Integer.valueOf(Ajxh));
    }

}
