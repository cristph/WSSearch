package com.wssearch.dao;

import com.wssearch.model.Vo.ZkjlZm;
import com.wssearch.model.WsSsjl;
import com.wssearch.model.WsSsjlCtr;

import java.util.List;

/**
 * Created by cristph on 2017/3/29.
 */
public interface SSJLDao {

    public WsSsjl getWsSsjl(int Ajxh);

    public List<WsSsjlCtr> getWsSsjlCtrList(int Ajxh);

    public List<ZkjlZm> getZkjlZmList(int Ajxh);
}
