package com.wssearch.service.impl;

import com.wssearch.dao.DsrDao;
import com.wssearch.model.Vo.Dsr;
import com.wssearch.service.DsrService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2017/3/27.
 */
@Transactional
@Service("dsrService")
public class DsrServiceImpl  implements DsrService {

    @Resource
    DsrDao dsrDao;

    @Override
    public List<Dsr> getDsrList(int Ajxh) {
        return dsrDao.getDsrList(Ajxh);
    }
}
