package com.wssearch.dao.impl;

import com.wssearch.dao.CpfxgcDao;
import com.wssearch.model.WsCpfxgc;
import com.wssearch.model.WsCpfxgcFlft;
import com.wssearch.model.WsCpfxgcLxqj;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2017/3/29.
 */

@Repository
public class CpfxgcDaoImpl implements CpfxgcDao {

    @Resource
    SessionFactory sessionFactory;

    @Override
    public WsCpfxgc getWsCpfxgc(int Ajxh) {
        Session session=sessionFactory.openSession();
        String hql="from WsCpfxgc where ajxh=:xh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
        List<WsCpfxgc> list=query.list();
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<WsCpfxgcFlft> getWsCpfxgcFlftList(int Ajxh) {
        Session session=sessionFactory.openSession();
        String hql="from WsCpfxgcFlft where ajxh=:xh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
        List<WsCpfxgcFlft> list=query.list();
        return list;
    }

    @Override
    public List<WsCpfxgcLxqj> getWsCpfxgcLxqjList(int Ajxh) {
        Session session=sessionFactory.openSession();
        String hql="from WsCpfxgcLxqj where ajxh=:xh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
        List<WsCpfxgcLxqj> list=query.list();
        return list;
    }
}
