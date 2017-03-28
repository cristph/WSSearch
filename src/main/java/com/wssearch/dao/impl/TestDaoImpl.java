package com.wssearch.dao.impl;

import com.wssearch.dao.TestDao;
import com.wssearch.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2017/3/24.
 */

@Repository
public class TestDaoImpl implements TestDao{

    @Resource
    protected SessionFactory sessionFactory;


    @Override
    public List<User> getAll() {
        Session session=sessionFactory.openSession();
        String hql="from User u";
        Query query=session.createQuery(hql);
        List<User> list=query.list();
        return list;
    }

    @Override
    public String test() {
        Session session=sessionFactory.openSession();
        String sql="from WsDsr w1,WsDsrQk w2,WsDsrQzcs w3";
        Query query=session.createSQLQuery(sql);
        query.list();
        return null;
    }
}
