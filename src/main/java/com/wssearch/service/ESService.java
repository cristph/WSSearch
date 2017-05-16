package com.wssearch.service;

import com.wssearch.util.WSInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cristph on 2017/4/27.
 */


public interface ESService {

    public List<WSInfo> getWSInfoList(HashMap<String,String> preciseConditions, HashMap<String,String> ambiguousConditions, String beginDate, String endDate,
                                      boolean isDefault, String order, int beginIndex, int listNum);


    public long getWSInfoListNum(HashMap<String,String> preciseConditions, HashMap<String,String> ambiguousConditions,
                                 String beginDate, String endDate);


    public HashMap<String, Integer> getGroupStatistics(HashMap<String,String> preciseConditions, HashMap<String,String> ambiguousConditions,
                                                       String beginDate, String endDate,String groupName,String whereName, String whereValue);


    public String generateIndexFile(HashMap<String,String> preciseConditions, HashMap<String,String> ambiguousConditions, String beginDate, String endDate, String fileName);




}
