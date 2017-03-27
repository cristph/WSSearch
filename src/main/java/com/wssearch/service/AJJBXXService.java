package com.wssearch.service;

import com.wssearch.model.WsAjxxb;

import java.util.List;

/**
 * Created by cristph on 2017/3/26.
 */
public interface AJJBXXService {

    public List<WsAjxxb> searchByAh(String Ah);

    public WsAjxxb searchByExactAh(String Ah);

    public WsAjxxb searchByAjxh(String Ajxh);
}
