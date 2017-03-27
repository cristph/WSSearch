package com.wssearch.dao.impl;

import com.wssearch.dao.DsrDao;
import com.wssearch.model.Vo.Dsr;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2017/3/27.
 */

@Repository
public class DsrDaoImpl implements DsrDao{

    @Resource
    SessionFactory sessionFactory;

    @Override
    public List<Dsr> getDsrList(int Ajxh) {
        Session session=sessionFactory.openSession();
        String hql="select Dsr(w1.ajxh,w1.dsrbh,w1.ssdw,w1.ysssdw,w1.dsrlb,w1.xm,w1.xb,w1.mz,w1.gj,w1.whcd,w1.zjlx,w1.zjhm,w1.zw,w1.dz,w1.sfzh,w1.tshy,w1.jgdbr,w1.dwxz,w1.xzflgxzt,w1.xzglfw,w1.bglx,w1.zzjgdm,w1.sfbhr,w1.zrrsf,w1.hjszd,w1.xjycs,w1.xszrnl,w1.sfct,w1.xw,w1.zzmm," +
                "w2.qkbh,w2.qklb,w2.cftime,w2.cfyy,w2.cfdw,w2.cfxs,w2.cfxq,w2.xmsfsj," +
                "w3.qzcsbh,w3.zl,w3.zxsj,w3.dw,w3.yy,w3.sfdb,w3.dbrq) " +
                "from WsDsr w1,WsDsrQk w2,WsDsrQzcs w3 " +
                "where w1.ajxh=? and w2.ajxh=? and w3.ajxh=? " +
                "and w1.dsrbh=w2.dsrbh and w2.dsrbh=w3.dsrbh";
        Query query=session.createQuery(hql);
        query.setInteger(0,Ajxh);
        query.setInteger(1,Ajxh);
        query.setInteger(2,Ajxh);
        List<Dsr> list=query.list();
        session.close();
        return list;
    }
}
