package com.wssearch.dao;

import com.wssearch.model.Wssxb;
import com.wssearch.util.Sort;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cristph on 2017/4/7.
 */
public interface ComplexSearchDao {

//    public List<Wssxb> getWssxbList(HashMap<String,String> conditions,String ay,int fycj,String fymc,String dsr,String beginDate,String endDate,
//                                    List<Sort> sorts, int beginIdex, int listNum);
//
//
//    public int getWssxbListNum(HashMap<String,String> conditions,String ay,int fycj,String fymc,String dsr,String beginDate,String endDate);

    public List<Wssxb> getWssxList(HashMap<String,String> preciseConditions, HashMap<String,String> ambiguousConditions,
                                   String ay, String fymc, String dsr, String beginDate, String endDate,
                                   HashMap<String,String> sorts, int beginIdex, int listNum) throws SQLException;

    public int getWssxListNum(HashMap<String,String> preciseConditions, HashMap<String,String> ambiguousConditions,
                              String ay, String fymc, String dsr, String beginDate, String endDate) throws SQLException;


    public String createView(HashMap<String,String> preciseConditions, HashMap<String,String> ambiguousConditions,
                             String ay, String fymc, String dsr, String beginDate, String endDate) throws SQLException;

    public HashMap<String, Integer> getGroupStatistics(String groupName, String viewName, String whereName, String whereValue) throws SQLException;

    public String dropView(String viewName) throws SQLException;

    public String generateIndexFile(HashMap<String,String> preciseConditions, HashMap<String,String> ambiguousConditions,
                                    String ay, String fymc, String dsr, String beginDate, String endDate, String fileName) throws SQLException;

    public List<Wssxb> getAll();
}
