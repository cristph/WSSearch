package com.wssearch.dao;

import com.wssearch.model.WsXspjjgfz;
import com.wssearch.model.WsXspjjgpf;

import java.util.List;

/**
 * Created by cristph on 2017/3/29.
 */
public interface XSPJJGDao {

    public List<WsXspjjgfz> getWsXspjjgfzList(int Ajxh);

    public List<WsXspjjgpf> getWsXspjjgpfList(int Ajxh,int Fzbh);
}
