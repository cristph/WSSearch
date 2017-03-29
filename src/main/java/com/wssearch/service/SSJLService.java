package com.wssearch.service;

import com.wssearch.model.Vo.ZkjlZm;
import com.wssearch.model.WsSsjl;
import com.wssearch.model.WsSsjlCtr;

import java.util.List;

/**
 * Created by cristph on 2017/3/29.
 */
public interface SSJLService {

    public WsSsjl getWsSsjl(String Ajxh);

    public List<WsSsjlCtr> getWsSsjlCtrList(String Ajxh);

    public List<ZkjlZm> getZkjlZmList(String Ajxh);
}
