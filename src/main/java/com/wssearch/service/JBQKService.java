package com.wssearch.service;

import com.wssearch.model.Vo.Nr;
import com.wssearch.model.WSAjjbqkxses;
import com.wssearch.model.WsAjjbqkmsxz;
import com.wssearch.model.WsAjjbqkxsys;

import java.util.List;

/**
 * Created by cristph on 2017/4/5.
 */
public interface JBQKService {

    public WsAjjbqkmsxz getWsAjjbqkmsxz(String Ajxh);

    public WSAjjbqkxses getWSAjjbqkxses(String Ajxh);

    public WsAjjbqkxsys getWsAjjbqkxsys(String Ajxh);

    public List<Nr> getNrList(String Ajxh, String fromTable);
}
