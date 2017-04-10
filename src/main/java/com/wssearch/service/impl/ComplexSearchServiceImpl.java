package com.wssearch.service.impl;

import com.wssearch.dao.ComplexSearchDao;
import com.wssearch.model.Wssxb;
import com.wssearch.service.ComplexSearchService;
import com.wssearch.util.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
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

//    @Override
//    public List<Wssxb> getWssxbList(HashMap<String, String> conditions, String ay, int fycj, String fymc, String dsr, String beginDate, String endDate, List<Sort> sorts, int beginIdex, int listNum) {
//        return complexSearchDao.getWssxbList(conditions,ay,fycj,fymc,dsr,beginDate,endDate,sorts,beginIdex,listNum);
//    }

//    @Override
//    public int getWssxbListNum(HashMap<String, String> conditions, String ay, int fycj, String fymc, String dsr, String beginDate, String endDate) {
//        return complexSearchDao.getWssxbListNum(conditions,ay,fycj,fymc,dsr,beginDate,endDate);
//    }

    @Override
    public List<Wssxb> getWssxList(HashMap<String, String> preciseConditions, HashMap<String, String> ambiguousConditions, String ay, String fymc, String dsr, String beginDate, String endDate, HashMap<String, String> sorts, int beginIdex, int listNum) throws SQLException {
        return complexSearchDao.getWssxList(preciseConditions, ambiguousConditions, ay, fymc, dsr, beginDate, endDate, sorts, beginIdex, listNum);
    }

    @Override
    public int getWssxListNum(HashMap<String, String> preciseConditions, HashMap<String, String> ambiguousConditions, String ay, String fymc, String dsr, String beginDate, String endDate) throws SQLException {
        return complexSearchDao.getWssxListNum(preciseConditions,ambiguousConditions,ay,fymc,dsr,beginDate,endDate);
    }

    @Override
    public List<Wssxb> getAll() {
        return complexSearchDao.getAll();
    }
}
