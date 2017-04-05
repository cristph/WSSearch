package com.wssearch.dao.impl;

import com.wssearch.dao.JBQKDao;
import com.wssearch.model.Vo.Nr;
import com.wssearch.model.WSAjjbqkxses;
import com.wssearch.model.WsAjjbqkmsxz;
import com.wssearch.model.WsAjjbqkxsys;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristph on 2017/4/5.
 */

@Repository
public class JBQKDaoImpl implements JBQKDao {

    @Resource
    SessionFactory sessionFactory;

    @Override
    public WsAjjbqkmsxz getWsAjjbqkmsxz(int Ajxh) {
        Session session=sessionFactory.openSession();
        String hql="from WsAjjbqkmsxz where ajxh=:xh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
        List<WsAjjbqkmsxz> list=query.list();
        session.close();
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public WSAjjbqkxses getWSAjjbqkxses(int Ajxh) {
        Session session=sessionFactory.openSession();
        String hql="from WSAjjbqkxses where ajxh=:xh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
        List<WSAjjbqkxses> list=query.list();
        session.close();
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public WsAjjbqkxsys getWsAjjbqkxsys(int Ajxh) {
        Session session=sessionFactory.openSession();
        String hql="from WsAjjbqkxsys where ajxh=:xh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
        List<WsAjjbqkxsys> list=query.list();
        session.close();
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Nr> getNrList(int Ajxh, String fromTable) {
        Session session=sessionFactory.openSession();
        String hql="select t.ajxh,t.bh,t.nr from "+fromTable+" as t where t.ajxh=:xh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
        List list=query.list();
        session.close();
        List<Nr> res=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Object[] objects=(Object[]) list.get(i);
            Nr nr=new Nr();
            nr.setAjxh((int)objects[0]);
            nr.setBh((int)objects[1]);
            nr.setNr((String)objects[2]);
            res.add(nr);
        }
        return res;
    }
}
