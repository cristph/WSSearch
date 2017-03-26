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
    public WsAjxxb searchByAh(String Ah) {
        Session session=sessionFactory.openSession();
        String hql="from WsAjxxb where ajxh=?";
        Query query=session.createQuery(hql);
        query.setInteger(0,Integer.valueOf(Ah));
        List<WsAjxxb> list=query.list();
        session.close();
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
