package com.wssearch.dao.impl;

import com.wssearch.dao.ComplexSearchDao;
import com.wssearch.model.Wssxb;
import com.wssearch.util.JDBCUtil;
import com.wssearch.util.Sort;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.*;
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


//    @Override
//    public List<Wssxb> getWssxbList(HashMap<String, String> conditions, String ay,int fycj,String fymc,String dsr,String beginDate,String endDate,
//                                    List<Sort> sorts, int beginIdex, int listNum) {
//        Session session=sessionFactory.openSession();
//        String hql="from Wssxb where ";
//        int i=0;
//        boolean andsign=false;
//        for(String key:conditions.keySet()){
//            hql+=(key+" like '%"+conditions.get(key)+"%'");
//            if(i<conditions.size()-1){
//                hql+=" and ";
//                i++;
//            }
//            andsign=true;
//        }
//
//        if(fycj>0){
//            if(andsign){
//                hql+=" and ";
//            }
//            hql+=("fycj ="+fycj+" ");
//            andsign=true;
//        }
//
//        if(ay.length()>0){
//            if(andsign){
//                hql+=" and ";
//            }
//            hql+=("(yjaymc like '%"+ay+"%' or ejaymc like '%"+ay+"%' or sjaymc like '%"+ay+"%' or sijaymc like '%"+ay+"%') ");
//            andsign=true;
//        }
//        if(fymc.length()>0){
//            if(andsign){
//                hql+=" and ";
//            }
//            hql+=("(gymc like '%"+fymc+"%' or zymc like '%"+fymc+"%' or jcymc like '%"+fymc+"%')");
//            andsign=true;
//        }
//        if(dsr.length()>0){
//            if(andsign){
//                hql+=" and ";
//            }
//            hql+=("(yghzgsr like '%"+dsr+"%' or bg like '%"+dsr+"%')");
//            andsign=true;
//        }
//        if(beginDate.length()>0){
//            if(andsign){
//                hql+=" and ";
//            }
//            hql+="cprq >=:bdate";
//            andsign=true;
//        }
//        if(endDate.length()>0){
//            if(andsign){
//                hql+=" and ";
//            }
//            hql+="cprq <=:edate";
//            andsign=true;
//        }
//        System.out.println("getWssxbListhql:"+hql);
//        Query query=session.createQuery(hql);
//        if(beginDate.length()>0){
//            query.setDate("bdate",Date.valueOf(beginDate));
//        }
//        if(endDate.length()>0){
//            query.setDate("edate",Date.valueOf(endDate));
//        }
//        query.setFirstResult(beginIdex);
//        query.setMaxResults(listNum);
//        List<Wssxb> list=query.list();
//        session.close();
//        return list;
//    }
//
//    @Override
//    public int getWssxbListNum(HashMap<String, String> conditions, String ay, int fycj, String fymc, String dsr, String beginDate, String endDate) {
//        Session session=sessionFactory.openSession();
//        String hql="select count(*) from Wssxb where ";
//        int i=0;
//        boolean andsign=false;
//        for(String key:conditions.keySet()){
//            hql+=(key+" like '%"+conditions.get(key)+"%'");
//            if(i<conditions.size()-1){
//                hql+=" and ";
//                i++;
//            }
//            andsign=true;
//        }
//        if(fycj>0){
//            if(andsign){
//                hql+=" and ";
//            }
//            hql+=("fycj ="+fycj+" ");
//            andsign=true;
//        }
//        if(ay.length()>0){
//            if(andsign){
//                hql+=" and ";
//            }
//            hql+=("(yjaymc like '%"+ay+"%' or ejaymc like '%"+ay+"%' or sjaymc like '%"+ay+"%' or sijaymc like '%"+ay+"%') ");
//            andsign=true;
//        }
//        if(fymc.length()>0){
//            if(andsign){
//                hql+=" and ";
//            }
//            hql+=("(gymc like '%"+fymc+"%' or zymc like '%"+fymc+"%' or jcymc like '%"+fymc+"%')");
//            andsign=true;
//        }
//        if(dsr.length()>0){
//            if(andsign){
//                hql+=" and ";
//            }
//            hql+=("(yghzgsr like '%"+dsr+"%' or bg like '%"+dsr+"%')");
//            andsign=true;
//        }
//        if(beginDate.length()>0){
//            if(andsign){
//                hql+=" and ";
//            }
//            hql+="cprq >=:bdate";
//            andsign=true;
//        }
//        if(endDate.length()>0){
//            if(andsign){
//                hql+=" and ";
//            }
//            hql+="cprq <=:edate";
//            andsign=true;
//        }
//        System.out.println("getWssxbListNumhql:"+hql);
//        Query query=session.createQuery(hql);
//        if(beginDate.length()>0){
//            query.setDate("bdate",Date.valueOf(beginDate));
//        }
//        if(endDate.length()>0){
//            query.setDate("edate",Date.valueOf(endDate));
//        }
//        Long count=(Long)query.uniqueResult();
//        session.close();
//        return count.intValue();
//    }

    /*
    *beginIdex 开始序号，包括在内
    * listnum 数量
     */
    @Override
    public List<Wssxb> getWssxList(HashMap<String, String> preciseConditions, HashMap<String, String> ambiguousConditions, String ay, String fymc, String dsr, String beginDate, String endDate, HashMap<String,String> sorts, int beginIdex, int listNum) throws SQLException {
        Connection connection=null;
        try {
            connection=JDBCUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int max=beginIdex+listNum-1;
        String sql="select TOP "+max+" WS_ID, rownum=identity(3) " +
                "into #temp from WSXXB where ";
        int i=0;
//        boolean andsign=false;
        int preciseConditionsSize=preciseConditions.size();
        for(String key: preciseConditions.keySet()){
            if(key.equals("fycj")){
                sql+=(key.toUpperCase()+" = "+ preciseConditions.get(key));
            }else {
                sql+=(key.toUpperCase()+" = '"+ preciseConditions.get(key)+"'");
            }
            if(i<preciseConditionsSize-1){
                sql+=" and ";
                i++;
            }
        }

        i=0;
        int ambiguousConditionsSize=ambiguousConditions.size();
        if(preciseConditionsSize>0&&ambiguousConditionsSize>0){
            sql+=" and ";
        }
        for(String key: ambiguousConditions.keySet()){
            sql+=(key.toUpperCase()+" like '%"+ ambiguousConditions.get(key)+"%'");
            if(i<ambiguousConditionsSize-1){
                sql+=" and ";
                i++;
            }
        }

        if(preciseConditionsSize>0||ambiguousConditionsSize>0){
            sql+=" and ";
        }
        if(ay.length()>0){
            sql+=("(YJAYMC like '%"+ay+"%' or EJAYMC like '%"+ay+"%' or SJAYMC like '%"+ay+"%' or SiJAYMC like '%"+ay+"%') and ");
        }
        if(fymc.length()>0){
            sql+=("(GYMC like '%"+fymc+"%' or ZYMC like '%"+fymc+"%' or JCYMC like '%"+fymc+"%') and ");
        }
        if(dsr.length()>0){
            sql+=("(YGHZGSR like '%"+dsr+"%' or BG like '%"+dsr+"%') and ");
        }
        if(beginDate.length()>0){
            sql+=" CPRQ >='"+beginDate+"' and ";
        }
        if(endDate.length()>0){
            sql+=" CPRQ <='"+endDate+"' ";
        }
        sql=sql.trim();

//        System.out.println("sql before:"+sql);
//        System.out.println("--:"+sql.lastIndexOf("and"));
//        System.out.println(sql.length());
        if(sql.lastIndexOf("and")==(sql.length()-3)){
            sql=sql.substring(0,sql.length()-3);
        }
//        System.out.println("sql after:"+sql);

        i=0;
        int sortsSize=sorts.size();
        sql+=" order by ";
        for(String key: sorts.keySet()){
            sql+=key.toUpperCase()+" "+sorts.get(key)+" ";
            if(i<sortsSize-1){
                sql+=',';
            }
            i++;
        }

        System.out.println("sql execute:"+sql);

        Statement stmt=connection.createStatement();
        stmt.execute(sql);
        sql="select * from #temp t, WSXXB w where t.rownum>="+beginIdex+" and t.WS_ID=w.WS_ID";
        ResultSet rs = stmt.executeQuery(sql);
        List<Wssxb> res=new ArrayList<>();
        while(rs.next()){
            Wssxb wssxb=new Wssxb();
            wssxb.setWsid(rs.getInt(3));
            wssxb.setWsah(rs.getString(4));
            wssxb.setWsmc(rs.getString(5));
            wssxb.setWslx(rs.getString(6));
            wssxb.setXmlName(rs.getString(7));
            wssxb.setXmlPath(rs.getString(8));
            wssxb.setDocName(rs.getString(9));
            wssxb.setDocPath(rs.getString(10));
            wssxb.setAjlb(rs.getString(11));
            wssxb.setAycj(rs.getInt(12));
            wssxb.setYjaymc(rs.getString(13));
            wssxb.setYjaydm(rs.getString(14));
            wssxb.setEjaymc(rs.getString(15));
            wssxb.setEjaydm(rs.getString(16));
            wssxb.setSjaymc(rs.getString(17));
            wssxb.setSjaydm(rs.getString(18));
            wssxb.setSijaymc(rs.getString(19));
            wssxb.setSijaydm(rs.getString(20));
            wssxb.setFycj(rs.getInt(21));
            wssxb.setGymc(rs.getString(22));
            wssxb.setZymc(rs.getString(23));
            wssxb.setJcymc(rs.getString(24));
            wssxb.setCprq(rs.getDate(25));
            wssxb.setCpnf(rs.getString(26));
            wssxb.setSpcx(rs.getString(27));
            wssxb.setSpry(rs.getString(28));
            wssxb.setYghzgsr(rs.getString(29));
            wssxb.setBg(rs.getString(30));
            wssxb.setYgsfct(rs.getString(31));
            wssxb.setBgsfct(rs.getString(32));
            wssxb.setLsmc(rs.getString(33));
            wssxb.setLsxm(rs.getString(34));
            wssxb.setFlyj(rs.getString(35));
            res.add(wssxb);
            System.out.println(wssxb.toString());
        }
        rs.close();
        sql="drop table #temp";
        stmt.execute(sql);

        stmt.close();
        connection.close();
        return res;
    }

    @Override
    public int getWssxListNum(HashMap<String, String> preciseConditions, HashMap<String, String> ambiguousConditions, String ay, String fymc, String dsr, String beginDate, String endDate) throws SQLException {
        Connection connection=null;
        try {
            connection=JDBCUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql="select count(*) from WSXXB where ";
        int i=0;
        int preciseConditionsSize=preciseConditions.size();
        for(String key: preciseConditions.keySet()){
            if(key.equals("fycj")){
                sql+=(key.toUpperCase()+" = "+ preciseConditions.get(key));
            }else {
                sql+=(key.toUpperCase()+" = '"+ preciseConditions.get(key)+"'");
            }
            if(i<preciseConditionsSize-1){
                sql+=" and ";
                i++;
            }
        }

        i=0;
        int ambiguousConditionsSize=ambiguousConditions.size();
        if(preciseConditionsSize>0&&ambiguousConditionsSize>0){
            sql+=" and ";
        }
        for(String key: ambiguousConditions.keySet()){
            sql+=(key.toUpperCase()+" like '%"+ ambiguousConditions.get(key)+"%'");
            if(i<ambiguousConditionsSize-1){
                sql+=" and ";
                i++;
            }
        }
        if(preciseConditionsSize>0||ambiguousConditionsSize>0){
            sql+=" and ";
        }
        if(ay.length()>0){
            sql+=("(YJAYMC like '%"+ay+"%' or EJAYMC like '%"+ay+"%' or SJAYMC like '%"+ay+"%' or SiJAYMC like '%"+ay+"%') and ");
        }
        if(fymc.length()>0){
            sql+=("(GYMC like '%"+fymc+"%' or ZYMC like '%"+fymc+"%' or JCYMC like '%"+fymc+"%') and ");
        }
        if(dsr.length()>0){
            sql+=("(YGHZGSR like '%"+dsr+"%' or BG like '%"+dsr+"%') and ");
        }
        if(beginDate.length()>0){
            sql+=" CPRQ >='"+beginDate+"' and ";
        }
        if(endDate.length()>0){
            sql+=" CPRQ <='"+endDate+"' ";
        }
        sql=sql.trim();
        if(sql.lastIndexOf("and")==(sql.length()-3)){
            sql=sql.substring(0,sql.length()-3);
        }
        System.out.println("sql execute:"+sql);
        Statement stmt=connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        int count=rs.getInt(1);
        rs.close();
        stmt.close();
        connection.close();
        return count;
    }

    @Override
    public String createView(HashMap<String, String> preciseConditions, HashMap<String, String> ambiguousConditions, String ay, String fymc, String dsr, String beginDate, String endDate) throws SQLException {
        Connection connection=null;
        try {
            connection=JDBCUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String viewName="view"+System.currentTimeMillis();
        System.out.println("begin create view:"+viewName);
        String sql="CREATE VIEW " +viewName+ " AS SELECT * from WSXXB where ";
        int i=0;
        int preciseConditionsSize=preciseConditions.size();
        for(String key: preciseConditions.keySet()){
            if(key.equals("fycj")){
                sql+=(key.toUpperCase()+" = "+ preciseConditions.get(key));
            }else {
                sql+=(key.toUpperCase()+" = '"+ preciseConditions.get(key)+"'");
            }
            if(i<preciseConditionsSize-1){
                sql+=" and ";
                i++;
            }
        }

        i=0;
        int ambiguousConditionsSize=ambiguousConditions.size();
        if(preciseConditionsSize>0&&ambiguousConditionsSize>0){
            sql+=" and ";
        }
        for(String key: ambiguousConditions.keySet()){
            sql+=(key.toUpperCase()+" like '%"+ ambiguousConditions.get(key)+"%'");
            if(i<ambiguousConditionsSize-1){
                sql+=" and ";
                i++;
            }
        }
        if(preciseConditionsSize>0||ambiguousConditionsSize>0){
            sql+=" and ";
        }
        if(ay.length()>0){
            sql+=("(YJAYMC like '%"+ay+"%' or EJAYMC like '%"+ay+"%' or SJAYMC like '%"+ay+"%' or SiJAYMC like '%"+ay+"%') and ");
        }
        if(fymc.length()>0){
            sql+=("(GYMC like '%"+fymc+"%' or ZYMC like '%"+fymc+"%' or JCYMC like '%"+fymc+"%') and ");
        }
        if(dsr.length()>0){
            sql+=("(YGHZGSR like '%"+dsr+"%' or BG like '%"+dsr+"%') and ");
        }
        if(beginDate.length()>0){
            sql+=" CPRQ >='"+beginDate+"' and ";
        }
        if(endDate.length()>0){
            sql+=" CPRQ <='"+endDate+"' ";
        }
        sql=sql.trim();
        if(sql.lastIndexOf("and")==(sql.length()-3)){
            sql=sql.substring(0,sql.length()-3);
        }
        System.out.println("sql execute:"+sql);
        Statement stmt=connection.createStatement();
        stmt.execute(sql);
        stmt.close();
        connection.close();
        return viewName;
    }

    @Override
    public HashMap<String, Integer> getGroupStatistics(String groupName, String viewName, String whereName, String whereValue) throws SQLException {
        Connection connection=null;
        try {
            connection=JDBCUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql="";
        if(whereName!=null && whereName.length()>0){
            if(whereName.equals("FYCJ")){
                sql="select "+groupName+",count(*) " +
                        "from "+viewName +
                        " where "+whereName+"="+whereValue+
                        " group by "+groupName;
            }else{
                sql="select "+groupName+",count(*) " +
                        "from "+viewName +
                        " where "+whereName+"='"+whereValue+"'"+
                        " group by "+groupName;
            }
        }else{
            sql="select "+groupName+",count(*) " +
                    "from "+viewName +
                    " group by "+groupName;
        }
        Statement stmt=connection.createStatement();
        System.out.println(sql);
        ResultSet rs=stmt.executeQuery(sql);
        HashMap<String, Integer> hashMap=new HashMap<>();
        if(groupName.equals("FYCJ")||groupName.equals("AYCJ")){
            while(rs.next()){
                hashMap.put(String.valueOf(rs.getInt(1)),rs.getInt(2));
            }
        }else{
            while(rs.next()){
                hashMap.put(rs.getString(1)==null ? "未知":rs.getString(1) , rs.getInt(2));
            }
        }
        System.out.println("GRUOP BY "+groupName+" where "+whereName+"='"+whereValue+"'");
        for(String key: hashMap.keySet()){
            System.out.println(key+"||"+hashMap.get(key));
        }
        System.out.println();
        rs.close();
        stmt.close();
        connection.close();
        return hashMap;
    }

    @Override
    public String dropView(String viewName) throws SQLException {
        Connection connection=null;
        try {
            connection=JDBCUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql="drop view "+viewName;
        Statement stmt=connection.createStatement();
        stmt.execute(sql);
        return "done";
    }

    public List<Wssxb> getAll(){
//        Session session=sessionFactory.openSession();
//        String hql="select w from Wssxb w";
//        Query query=session.createQuery(hql);
//        List<Wssxb> list=query.list();
//        session.close();
//        System.out.println("size:"+list.size());
//        for(Wssxb wssxb:list){
//            System.out.println(wssxb.toString());
//        }
        Connection connection=null;
        try {
            connection=JDBCUtil.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql="select distinct WSLX from WSXXB";
        Statement stmt= null;
        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql="select distinct SPCX from WSXXB";
        stmt= null;
        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql="select distinct AJLB from WSXXB";
        stmt= null;
        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
