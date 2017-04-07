package com.wssearch.dao;

import com.wssearch.model.Wssxb;
import com.wssearch.util.Sort;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cristph on 2017/4/7.
 */
public interface ComplexSearchDao {

    public List<Wssxb> getWssxbList(HashMap<String,String> conditions,String ay,String fymc,String dsr,String beginDate,String endDate,
                                    List<Sort> sorts, int beginIdex, int listNum);
}
