package com.wssearch.dao;

import com.wssearch.model.WsCpfxgc;
import com.wssearch.model.WsCpfxgcFlft;
import com.wssearch.model.WsCpfxgcLxqj;

import java.util.List;

/**
 * Created by cristph on 2017/3/29.
 */
public interface CpfxgcDao {

    public WsCpfxgc getWsCpfxgc(int Ajxh);

    public List<WsCpfxgcFlft> getWsCpfxgcFlftList(int Ajxh);

    public List<WsCpfxgcLxqj> getWsCpfxgcLxqjList(int Ajxh);
}
