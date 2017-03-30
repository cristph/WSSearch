package com.wssearch.dao.impl;

import com.wssearch.dao.AJJBXXDao;
import com.wssearch.model.WsAjxxb;
import com.wssearch.util.Condition;
import com.wssearch.util.Sort;
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
        String hql="from WsAjxxb where ah like :cd";
        Query query=session.createQuery(hql);
        String condition="%"+Ah+"%";
        query.setString("cd", condition);
        List<WsAjxxb> list=query.list();
        session.close();
        return list;
    }

    @Override
    public WsAjxxb searchByExactAh(String Ah) {
        Session session=sessionFactory.openSession();
        String hql="from WsAjxxb where ah = :a";
        Query query=session.createQuery(hql);
        query.setString("a", Ah);
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
        String hql="from WsAjxxb where ajxh = :xh";
        Query query=session.createQuery(hql);
        query.setInteger("xh",Ajxh);
        List<WsAjxxb> list=query.list();
        if(list.size()==1){
            return list.get(0);
        }
        session.close();
        return null;
    }

    @Override
    public int searchByAjxhCount(String Ah) {
        Session session=sessionFactory.openSession();
        String hql="select count(*) from WsAjxxb where ah like :h";
        Query query=session.createQuery(hql);
        query.setString("h","%"+Ah+"%");
        Long count=(Long)query.uniqueResult();
        session.close();
        return count.intValue();
    }

    @Override
    public List<WsAjxxb> searchWsAjxxb(List<Condition> conditions, List<Sort> sorts, int beginIdex, int listNum) {
        Session session=sessionFactory.openSession();
        String hql="from WsAjxxb where ";
        int i=0;
        for(Condition condition : conditions){
            hql+=condition.getSearchWord().getTypeName();
            hql+=" like ";
            hql+=(":"+condition.getSearchWord().getTypeName()+"value");
            if(i<conditions.size()-1){
                hql+=" and ";
                i++;
            }
        }
        if(sorts.size()>0){
            hql+=" order by ";
        }
        int j=0;
        for(Sort sort : sorts){
            hql+=sort.getSortClass().getTypeName();
            hql+=" ";
            hql+=sort.getSortType().getTypeName();
            if(j<sorts.size()-1){
                hql+=", ";
                j++;
            }
        }
        System.out.println("hql:"+hql);
        Query query=session.createQuery(hql);
        for(Condition condition : conditions){
            query.setString((condition.getSearchWord().getTypeName()+"value"),("%"+condition.getValue()+"%"));
        }
        query.setFirstResult(beginIdex);
        query.setMaxResults(listNum);
        System.out.println("begin:"+beginIdex+";sizez:"+listNum);
        List<WsAjxxb> list=query.list();
        return list;
    }
}
