package com.wssearch.service.impl;

import com.wssearch.dao.AJJBXXDao;
import com.wssearch.model.WsAjxxb;
import com.wssearch.service.AJJBXXService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2017/3/26.
 */

@Transactional
@Service("ajjbxxService")
public class AJJBXXServiceImpl implements AJJBXXService {

    @Resource
    AJJBXXDao ajjbxxDao;

    @Override
    public List<WsAjxxb> searchByAh(String Ah) {
        return ajjbxxDao.searchByAh(Ah);
    }

    @Override
    public WsAjxxb searchByExactAh(String Ah) {
        return ajjbxxDao.searchByExactAh(Ah);
    }

    @Override
    public WsAjxxb searchByAjxh(String Ajxh) {
        return ajjbxxDao.searchByAjxh(Integer.valueOf(Ajxh));
    }
}
