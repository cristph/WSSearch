package com.wssearch.service;

import com.wssearch.model.WsAjxxb;
import com.wssearch.util.Condition;
import com.wssearch.util.Sort;

import java.util.List;

/**
 * Created by cristph on 2017/3/26.
 */
public interface AJJBXXService {

    public List<WsAjxxb> searchByAh(String Ah);

    public int searchByAjxhCount(String Ah);

    public WsAjxxb searchByExactAh(String Ah);

    public WsAjxxb searchByAjxh(String Ajxh);

    public List<WsAjxxb> searchWsAjxxb(List<Condition> conditions, List<Sort> sorts, int beginIdex, int listNum);
}
