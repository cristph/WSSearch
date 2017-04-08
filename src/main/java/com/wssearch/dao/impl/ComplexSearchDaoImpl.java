package com.wssearch.dao.impl;

import com.wssearch.dao.ComplexSearchDao;
import com.wssearch.model.Wssxb;
import com.wssearch.util.Sort;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cristph on 2017/4/7.
 */

@Repository
public class ComplexSearchDaoImpl implements ComplexSearchDao {

    @Resource
    protected SessionFactory sessionFactory;


    @Override
    public List<Wssxb> getWssxbList(HashMap<String, String> conditions, String ay,int fycj,String fymc,String dsr,String beginDate,String endDate,
                                    List<Sort> sorts, int beginIdex, int listNum) {
        Session session=sessionFactory.openSession();
        String hql="from Wssxb where ";
        int i=0;
        boolean andsign=false;
        for(String key:conditions.keySet()){
            hql+=(key+" like '%"+conditions.get(key)+"%'");
            if(i<conditions.size()-1){
                hql+=" and ";
                i++;
            }
            andsign=true;
        }

        if(fycj>0){
            if(andsign){
                hql+=" and ";
            }
            hql+=("fycj ="+fycj+" ");
            andsign=true;
        }

        if(ay.length()>0){
            if(andsign){
                hql+=" and ";
            }
            hql+=("(yjaymc like '%"+ay+"%' or ejaymc like '%"+ay+"%' or sjaymc like '%"+ay+"%' or sijaymc like '%"+ay+"%') ");
            andsign=true;
        }
        if(fymc.length()>0){
            if(andsign){
                hql+=" and ";
            }
            hql+=("(gymc like '%"+fymc+"%' or zymc like '%"+fymc+"%' or jcymc like '%"+fymc+"%')");
            andsign=true;
        }
        if(dsr.length()>0){
            if(andsign){
                hql+=" and ";
            }
            hql+=("(yghzgsr like '%"+dsr+"%' or bg like '%"+dsr+"%')");
            andsign=true;
        }
        if(beginDate.length()>0){
            if(andsign){
                hql+=" and ";
            }
            hql+="cprq >=:bdate";
            andsign=true;
        }
        if(endDate.length()>0){
            if(andsign){
                hql+=" and ";
            }
            hql+="cprq <=:edate";
            andsign=true;
        }
        System.out.println("getWssxbListhql:"+hql);
        Query query=session.createQuery(hql);
        if(beginDate.length()>0){
            query.setDate("bdate",Date.valueOf(beginDate));
        }
        if(endDate.length()>0){
            query.setDate("edate",Date.valueOf(endDate));
        }
        query.setFirstResult(beginIdex);
        query.setMaxResults(listNum);
        List<Wssxb> list=query.list();
        session.close();
        return list;
    }

    @Override
    public int getWssxbListNum(HashMap<String, String> conditions, String ay, int fycj, String fymc, String dsr, String beginDate, String endDate) {
        Session session=sessionFactory.openSession();
        String hql="select count(*) from Wssxb where ";
        int i=0;
        boolean andsign=false;
        for(String key:conditions.keySet()){
            hql+=(key+" like '%"+conditions.get(key)+"%'");
            if(i<conditions.size()-1){
                hql+=" and ";
                i++;
            }
            andsign=true;
        }
        if(fycj>0){
            if(andsign){
                hql+=" and ";
            }
            hql+=("fycj ="+fycj+" ");
            andsign=true;
        }
        if(ay.length()>0){
            if(andsign){
                hql+=" and ";
            }
            hql+=("(yjaymc like '%"+ay+"%' or ejaymc like '%"+ay+"%' or sjaymc like '%"+ay+"%' or sijaymc like '%"+ay+"%') ");
            andsign=true;
        }
        if(fymc.length()>0){
            if(andsign){
                hql+=" and ";
            }
            hql+=("(gymc like '%"+fymc+"%' or zymc like '%"+fymc+"%' or jcymc like '%"+fymc+"%')");
            andsign=true;
        }
        if(dsr.length()>0){
            if(andsign){
                hql+=" and ";
            }
            hql+=("(yghzgsr like '%"+dsr+"%' or bg like '%"+dsr+"%')");
            andsign=true;
        }
        if(beginDate.length()>0){
            if(andsign){
                hql+=" and ";
            }
            hql+="cprq >=:bdate";
            andsign=true;
        }
        if(endDate.length()>0){
            if(andsign){
                hql+=" and ";
            }
            hql+="cprq <=:edate";
            andsign=true;
        }
        System.out.println("getWssxbListNumhql:"+hql);
        Query query=session.createQuery(hql);
        if(beginDate.length()>0){
            query.setDate("bdate",Date.valueOf(beginDate));
        }
        if(endDate.length()>0){
            query.setDate("edate",Date.valueOf(endDate));
        }
        Long count=(Long)query.uniqueResult();
        session.close();
        return count.intValue();
    }

    public List<Wssxb> getAll(){
        Session session=sessionFactory.openSession();
        String hql="select w from Wssxb w";
        Query query=session.createQuery(hql);
        List<Wssxb> list=query.list();
        session.close();
        System.out.println("size:"+list.size());
        for(Wssxb wssxb:list){
            System.out.println(wssxb.toString());
        }
        return list;
    }
}
