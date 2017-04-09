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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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

    @Override
    public List<Wssxb> getWssxList(HashMap<String, String> preciseConditions, HashMap<String, String> ambiguousConditions, String ay, String fymc, String dsr, String beginDate, String endDate, HashMap<String,String> sorts, int beginIdex, int listNum) {
        Session session=sessionFactory.openSession();
        String sql="select * from Wssxb where ";
        int i=0;
        boolean andsign=false;
        int size=preciseConditions.size();
        for(String key: preciseConditions.keySet()){
            sql+=(key+" = "+ preciseConditions.get(key));
            if(i<size-1){
                sql+=" and ";
                i++;
            }
        }

        i=0;
        size=ambiguousConditions.size();
        for(String key: ambiguousConditions.keySet()){
            sql+=(key+" like '%"+ ambiguousConditions.get(key)+"%'");
            if(i<size-1){
                sql+=" and ";
                i++;
            }
        }

        if(ay.length()>0){
            sql+=("(yjaymc like '%"+ay+"%' or ejaymc like '%"+ay+"%' or sjaymc like '%"+ay+"%' or sijaymc like '%"+ay+"%') and ");
        }
        if(fymc.length()>0){
            sql+=("(gymc like '%"+fymc+"%' or zymc like '%"+fymc+"%' or jcymc like '%"+fymc+"%') and ");
        }
        if(dsr.length()>0){
            sql+=("(yghzgsr like '%"+dsr+"%' or bg like '%"+dsr+"%') and ");
        }
        if(beginDate.length()>0){
            sql+=" cprq >=:bdate and ";
        }
        if(endDate.length()>0){
            sql+=" cprq <=:edate ";
        }
        sql=sql.trim();
        sql=sql.substring(0,sql.length()-3);

        i=0;
        size=sorts.size();
        sql+=" order by ";
        for(String key: sorts.keySet()){
            sql+=key+" "+sorts.get(key)+" ";
            if(i<size-1){
                sql+=',';
            }
        }

        sql+="limit "+beginIdex+","+listNum;
        Query query=session.createSQLQuery(sql);
        List list=query.list();
        session.close();
        List<Wssxb> res=new ArrayList<>();
        for(int j=0;j<list.size();j++){
            Object[] objects=(Object[]) list.get(i);
            Wssxb wssxb=new Wssxb();
            wssxb.setWsid((int)objects[0]);
            wssxb.setWsah((String)objects[1]);
            wssxb.setWsmc((String)objects[2]);
            wssxb.setWslx((String)objects[3]);
            wssxb.setXmlName((String)objects[4]);
            wssxb.setXmlPath((String)objects[5]);
            wssxb.setDocName((String)objects[6]);
            wssxb.setDocPath((String)objects[7]);
            wssxb.setAjlb((String)objects[8]);
            wssxb.setAycj((int)objects[9]);
            wssxb.setYjaymc((String)objects[10]);
            wssxb.setYjaydm((String)objects[11]);
            wssxb.setEjaymc((String)objects[12]);
            wssxb.setEjaydm((String)objects[13]);
            wssxb.setSjaymc((String)objects[14]);
            wssxb.setSjaydm((String)objects[15]);
            wssxb.setSijaymc((String)objects[16]);
            wssxb.setSijaydm((String)objects[17]);
            wssxb.setFycj((int)objects[18]);
            wssxb.setGymc((String)objects[19]);
            wssxb.setZymc((String)objects[20]);
            wssxb.setJcymc((String)objects[21]);
            wssxb.setCprq((Date)objects[22]);
            wssxb.setCpnf((String)objects[23]);
            wssxb.setSpcx((String)objects[24]);
            wssxb.setSpry((String)objects[25]);
            wssxb.setYghzgsr((String)objects[26]);
            wssxb.setBg((String)objects[27]);
            wssxb.setYgsfct((String)objects[28]);
            wssxb.setBgsfct((String)objects[29]);
            wssxb.setLsmc((String)objects[30]);
            wssxb.setLsxm((String)objects[31]);
            wssxb.setFlyj((String)objects[32]);
            res.add(wssxb);
        }
        return res;
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
