package com.wssearch.service;

import com.wssearch.model.Vo.PfFjx;
import com.wssearch.model.WsXspjjgfz;
import com.wssearch.model.WsXspjjgpf;

import java.util.List;

/**
 * Created by cristph on 2017/3/29.
 */
public interface XSPJJGService {

    public List<WsXspjjgfz> getWsXspjjgfzList(String Ajxh);

    public List<WsXspjjgpf> getWsXspjjgpfList(String Ajxh, String Fzbh);

    public List<PfFjx> getPfFjxList(String Ajxh,String Fzbh);
}
