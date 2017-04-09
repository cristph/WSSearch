package com.wssearch.service;

import com.wssearch.model.Wssxb;
import com.wssearch.util.Sort;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cristph on 2017/4/7.
 */
public interface ComplexSearchService {
    public List<Wssxb> getWssxbList(HashMap<String,String> conditions,String ay,int fycj,String fymc,String dsr,String beginDate,String endDate,
                                    List<Sort> sorts, int beginIdex, int listNum);

    public int getWssxbListNum(HashMap<String,String> conditions,String ay,int fycj,String fymc,String dsr,String beginDate,String endDate);


    public List<Wssxb> getWssxList(HashMap<String,String> preciseConditions, HashMap<String,String> ambiguousConditions,
                                   String ay, String fymc, String dsr, String beginDate, String endDate,
                                   HashMap<String,String> sorts, int beginIdex, int listNum);

    public List<Wssxb> getAll();
}
