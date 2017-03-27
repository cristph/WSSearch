package com.wssearch.dao.impl;

import com.wssearch.dao.AJJBXXDao;
import com.wssearch.model.WsAjxxb;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2017/3/26.
 */

@Repository
public class AJJBXXDaoImpl implements AJJBXXDao {

    @Resource
    protected SessionFactory sessionFactory;

    @Override
    public List<WsAjxxb> searchByAh(String Ah) {
        Session session=sessionFactory.openSession();
        String hql="from WsAjxxb where ah like ?";
        Query query=session.createQuery(hql);
        String condition="%"+Ah+"%";
        query.setString(0, condition);
        List<WsAjxxb> list=query.list();
        session.close();
        return list;
    }

    @Override
    public WsAjxxb searchByExactAh(String Ah) {
        Session session=sessionFactory.openSession();
        String hql="from WsAjxxb where ah = ?";
        Query query=session.createQuery(hql);
        query.setString(0, Ah);
        List<WsAjxxb> list=query.list();
        if(list.size()==1){
            return list.get(0);
        }
        session.close();
        return null;
    }

    @Override
    public WsAjxxb searchByAjxh(int Ajxh) {
        Session session=sessionFactory.openSession();
        String hql="from WsAjxxb where ajxh = ?";
        Query query=session.createQuery(hql);
        query.setInteger(0,Ajxh);
        List<WsAjxxb> list=query.list();
        if(list.size()==1){
            return list.get(0);
        }
        session.close();
        return null;
    }
}
