package com.wssearch.dao;

import com.wssearch.model.Vo.Dsr;
import com.wssearch.model.WsDsr;
import com.wssearch.model.WsDsrQk;

import java.util.List;

/**
 * Created by cristph on 2017/3/27.
 */
public interface DsrDao {

    public List<Dsr> getDsrList(int Ajxh);

    public List<WsDsr> getWsDsrList(int Ajxh);

    public List<WsDsrQk> getWsDsrQkList(int Ajxh,int Dsrbh);
}
