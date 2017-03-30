package com.wssearch.dao.impl;

import com.wssearch.dao.XSPJJGDao;
import com.wssearch.model.WsXspjjgfjx;
import com.wssearch.model.WsXspjjgfz;
import com.wssearch.model.WsXspjjgpf;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2017/3/29.
 */

@Repository()
public class XSPJJGDaoImpl implements XSPJJGDao{

    @Resource
    SessionFactory sessionFactory;

    @Override
    public List<WsXspjjgfz> getWsXspjjgfzList(int Ajxh) {
        Session session=sessionFactory.openSession();
        String hql="from WsXspjjgfz where ajxh=:xh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
        List<WsXspjjgfz> list=query.list();
        session.close();
        return list;
    }

    @Override
    public List<WsXspjjgpf> getWsXspjjgpfList(int Ajxh, int Fzbh) {
        Session session=sessionFactory.openSession();
        String hql="from WsXspjjgpf where ajxh=:xh and fzbh=:bh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
        query.setInteger("bh",Fzbh);
        List<WsXspjjgpf> list=query.list();
        session.close();
        return list;
    }

    @Override
    public List<WsXspjjgfjx> getWsXspjjgfjxList(int Ajxh, int Fzbh, int pfbh) {
        Session session=sessionFactory.openSession();
        String hql="from WsXspjjgfjx where ajxh=:xh and fzbh=:bh and pfbh=:fbh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
        query.setInteger("bh",Fzbh);
        query.setInteger("fbh",pfbh);
        List<WsXspjjgfjx> list=query.list();
        session.close();
        return list;
    }
}
