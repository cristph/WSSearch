package com.wssearch.service;

import com.wssearch.model.Vo.ZkjlZm;
import com.wssearch.model.WsCpfxgc;
import com.wssearch.model.WsCpfxgcFlft;
import com.wssearch.model.WsCpfxgcLxqj;
import com.wssearch.model.WsSsjlCtr;

import java.util.List;

/**
 * Created by cristph on 2017/3/29.
 */
public interface CpfxgcService {
    public WsCpfxgc getWsCpfxgc(String Ajxh);

    public List<WsCpfxgcFlft> getWsCpfxgcFlftList(String Ajxh);

    public List<WsCpfxgcLxqj> getWsCpfxgcLxqjList(String Ajxh);
}
