package com.wssearch.dao;

import com.wssearch.model.Vo.Nr;
import com.wssearch.model.WSAjjbqkxses;
import com.wssearch.model.WsAjjbqkmsxz;
import com.wssearch.model.WsAjjbqkxsys;

import java.util.List;

/**
 * Created by cristph on 2017/4/5.
 */
public interface JBQKDao {

    public WsAjjbqkmsxz getWsAjjbqkmsxz(int Ajxh);

    public WSAjjbqkxses getWSAjjbqkxses(int Ajxh);

    public WsAjjbqkxsys getWsAjjbqkxsys(int Ajxh);

    public List<Nr> getNrList(int Ajxh, String fromTable);

}
