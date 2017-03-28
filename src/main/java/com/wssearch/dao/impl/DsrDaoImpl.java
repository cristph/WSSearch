package com.wssearch.dao.impl;

import com.wssearch.dao.DsrDao;
import com.wssearch.model.Vo.Dsr;
import com.wssearch.model.WsDsr;
import com.wssearch.model.WsDsrQk;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        String hql="from WsDsr where ajxh=:xh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
//        System.out.println("before list"+Ajxh);
        List<WsDsr> list=query.list();
        session.close();
        return new ArrayList<Dsr>();
    }

    @Override
    public List<WsDsr> getWsDsrList(int Ajxh) {
        Session session=sessionFactory.openSession();
        String hql="from WsDsr where ajxh=:xh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
//        System.out.println("before list"+Ajxh);
        List<WsDsr> list=query.list();
        session.close();
        return list;
    }

    @Override
    public List<WsDsrQk> getWsDsrQkList(int Ajxh, int Dsrbh) {
        Session session=sessionFactory.openSession();
        String hql="from WsDsrQk where ajxh=:xh and dsrbh=:bh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
        query.setInteger("bh",Dsrbh);
        List<WsDsrQk> list=query.list();
        session.close();
        return list;
    }


}
