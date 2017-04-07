package com.wssearch.service.impl;

import com.wssearch.dao.ComplexSearchDao;
import com.wssearch.model.Wssxb;
import com.wssearch.service.ComplexSearchService;
import com.wssearch.util.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cristph on 2017/4/7.
 */

@Transactional
@Service("complexSearchService")
public class ComplexSearchServiceImpl implements ComplexSearchService {

    @Resource
    ComplexSearchDao complexSearchDao;

    @Override
    public List<Wssxb> getWssxbList(HashMap<String, String> conditions, String ay, String fymc, String dsr, String beginDate, String endDate, List<Sort> sorts, int beginIdex, int listNum) {
        return complexSearchDao.getWssxbList(conditions,ay,fymc,dsr,beginDate,endDate,sorts,beginIdex,listNum);
    }
}
