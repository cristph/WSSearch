package com.wssearch.dao.impl;

import com.wssearch.dao.SSJLDao;
import com.wssearch.model.Vo.ZkjlZm;
import com.wssearch.model.WsSsjl;
import com.wssearch.model.WsSsjlCtr;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristph on 2017/3/29.
 */

@Repository
public class SSJLDaoImpl implements SSJLDao {

    @Resource
    SessionFactory sessionFactory;

    @Override
    public WsSsjl getWsSsjl(int Ajxh) {
        Session session=sessionFactory.openSession();
        String hql="from WsSsjl where ajxh=:xh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
        List<WsSsjl> list=query.list();
        session.close();
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<WsSsjlCtr> getWsSsjlCtrList(int Ajxh) {
        Session session=sessionFactory.openSession();
        String hql="from WsSsjlCtr where ajxh=:xh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
        List<WsSsjlCtr> list=query.list();
        return list;
    }

    @Override
    public List<ZkjlZm> getZkjlZmList(int Ajxh) {
        Session session=sessionFactory.openSession();
        String sql="select w1.AJXH,w1.ZKJLBH,w1.XGR,w2.ZMBH,w2.ZM,w2.ZMDM,w2.WZZM " +
                "from WS_SSJL_ZKJL w1, WS_SSJL_ZKJL_ZM w2 " +
                "where w1.AJXH=:xh and w1.AJXH=w2.AJXH and w1.ZKJLBH=w2.ZKJLBH";
        Query query=session.createSQLQuery(sql);
        query.setInteger("xh",Ajxh);
        List list=query.list();
        List<ZkjlZm> res=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Object[] objects=(Object[]) list.get(i);
            ZkjlZm zkjlZm=new ZkjlZm();
            zkjlZm.setAjxh((int)objects[0]);
            zkjlZm.setZkjlbh((int)objects[1]);
            zkjlZm.setXgr((String)objects[2]);
            zkjlZm.setZmbh((int)objects[3]);
            zkjlZm.setZm((String)objects[4]);
            zkjlZm.setZmdm((String)objects[5]);
            zkjlZm.setWzzm((String)objects[6]);
            res.add(zkjlZm);
        }
        for(ZkjlZm zkjlZm:res){
            System.out.println(zkjlZm.toString());
        }
        return res;
    }
}
