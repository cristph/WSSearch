package com.wssearch.elasticsearch;

import com.wssearch.util.WSInfo;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cristph on 2017/4/27.
 */
public class Searcher {

    private static TransportClient transportClient;

    public void ini() throws UnknownHostException {
        if (transportClient == null) {
            Settings settings = Settings.builder()
                    .put("cluster.name", "WS").build();
            transportClient = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.68.80"), 9300));
            System.out.println("get transportClient");
        }
    }

    public void closeTransportClient(){
        if(transportClient!=null){
            transportClient.close();
            System.out.println("transportClient close");
        }
    }


    public List<WSInfo> getWSInfoList(HashMap<String,String> preciseConditions, HashMap<String,String> ambiguousConditions, String beginDate, String endDate,
                                      boolean isDefault, String order, int beginIndex, int listNum){
        try {
            ini();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        List<WSInfo> list=new ArrayList<WSInfo>();
        BoolQueryBuilder boolQueryBuilder= QueryBuilders.boolQuery();

        for(String pCond : preciseConditions.keySet()){
            boolQueryBuilder.must(QueryBuilders.termQuery(pCond.toUpperCase(),preciseConditions.get(pCond)));
        }

        for(String aCond : ambiguousConditions.keySet()){
            boolQueryBuilder.must(QueryBuilders.matchQuery(aCond.toUpperCase(),ambiguousConditions.get(aCond)).analyzer("jcseg_complex"));
        }

        if(beginDate!=null && beginDate.length()>0 && endDate!=null&& endDate.length()>0){
            boolQueryBuilder.must(QueryBuilders.rangeQuery("CPRQ").gte(beginDate).lte(endDate));
        }

//        System.out.println(boolQueryBuilder.toString());
        System.out.println("from "+beginIndex+" get"+listNum);


        HighlightBuilder highlightBuilder=new HighlightBuilder();
        highlightBuilder.preTags("<span style=\"color: red\">");
        highlightBuilder.postTags("</span>");
        highlightBuilder.field("QW");
        highlightBuilder.field("WS");
        highlightBuilder.field("AJJBQK");
        highlightBuilder.field("CPFXGC");
        highlightBuilder.field("PJJG");
        highlightBuilder.field("WW");
        highlightBuilder.field("AH");
        highlightBuilder.field("WSMC");
        highlightBuilder.field("FYMC");
        highlightBuilder.field("SPRY");
        highlightBuilder.field("DSR");
        highlightBuilder.field("FLYJ");

        SearchResponse scrollResp;
        if(!isDefault){
            if(order.startsWith("a")){
                SortBuilder sortBuilder= SortBuilders.fieldSort("CPRQ").order(SortOrder.ASC);
                scrollResp = transportClient.prepareSearch()
                        .setQuery(boolQueryBuilder)
                        .highlighter(highlightBuilder)
                        .addSort(sortBuilder)
                        .setFrom(beginIndex)
                        .setSize(listNum)
                        .execute()
                        .actionGet();
//                        .get();
            }else{
                SortBuilder sortBuilder= SortBuilders.fieldSort("CPRQ").order(SortOrder.DESC);
                scrollResp = transportClient.prepareSearch()
                        .setQuery(boolQueryBuilder)
                        .highlighter(highlightBuilder)
                        .addSort(sortBuilder)
                        .setFrom(beginIndex)
                        .setSize(listNum)
                        .execute()
                        .actionGet();
//                        .get();
            }
        }else{
            scrollResp = transportClient.prepareSearch()
                    .setQuery(boolQueryBuilder)
                    .highlighter(highlightBuilder)
                    .setFrom(beginIndex)
                    .setSize(listNum)
                    .execute()
                    .actionGet();
//                    .get();
        }


        //getHits()
        for (SearchHit hit : scrollResp.getHits().getHits()) {
            //Handle the hit...
            WSInfo wsInfo=new WSInfo();
            Map<String,Object> source=hit.getSource();
            wsInfo.setAh((String)source.get("AH"));
            wsInfo.setAjlx((String)source.get("AJLX"));
            wsInfo.setFymc((String)source.get("FYMC"));
            wsInfo.setSpcx((String)source.get("SPCX"));
            wsInfo.setWslx((String)source.get("WSLX"));
            wsInfo.setXmlPath((String)source.get("XMLPATH"));
            wsInfo.setCprq((String)source.get("CPRQ"));
            wsInfo.setWsmc((String)source.get("WSMC"));
            wsInfo.setScore(hit.getScore());
            wsInfo.set_id(hit.getId());

            Map<String, HighlightField> highlightFieldMap=hit.getHighlightFields();
            String matchText ="";
            HighlightField highlightField = highlightFieldMap.get("QW");
            if(highlightField!=null){
                Text[] fragments = highlightField.fragments();
                matchText += "<span style=\"color: black;font: larger bolder\">全文匹配情况：</span>";
                for (Text text : fragments) {
                    matchText+=text;
                    matchText+="……";
                }
                matchText+="<br/><br/>";
            }

            highlightField = highlightFieldMap.get("WS");
            if(highlightField!=null){
                Text[] fragments = highlightField.fragments();
                matchText += "<span style=\"color: black;font: larger bolder\">文首匹配情况：</span>";
                for (Text text : fragments) {
                    matchText+=text;
                    matchText+="……";
                }
                matchText+="<br/><br/>";
            }

            highlightField = highlightFieldMap.get("AJJBQK");
            if(highlightField!=null){
                Text[] fragments = highlightField.fragments();
                matchText += "<span style=\"color: black;font: larger bolder\">事实匹配情况：</span>";
                for (Text text : fragments) {
                    matchText+=text;
                    matchText+="……";
                }
                matchText+="<br/><br/>";
            }

            highlightField = highlightFieldMap.get("CPFXGC");
            if(highlightField!=null){
                Text[] fragments = highlightField.fragments();
                matchText += "<span style=\"color: black;font: larger bolder\">理由匹配情况：</span>";
                for (Text text : fragments) {
                    matchText+=text;
                    matchText+="……";
                }
                matchText+="<br/><br/>";
            }

            highlightField = highlightFieldMap.get("PJJG");
            if(highlightField!=null){
                Text[] fragments = highlightField.fragments();
                matchText += "<span style=\"color: black;font: larger bolder\">判决结果匹配情况：</span>";
                for (Text text : fragments) {
                    matchText+=text;
                    matchText+="……";
                }
                matchText+="<br/><br/>";
            }

            highlightField = highlightFieldMap.get("WW");
            if(highlightField!=null){
                Text[] fragments = highlightField.fragments();
                matchText += "<span style=\"color: black;font: larger bolder\">文尾匹配情况：</span>";
                for (Text text : fragments) {
                    matchText+=text;
                    matchText+="……";
                }
                matchText+="<br/><br/>";
            }

            highlightField = highlightFieldMap.get("AH");
            if(highlightField!=null){
                Text[] fragments = highlightField.fragments();
                matchText += "<span style=\"color: black;font: larger bolder\">案号匹配情况：</span>";
                for (Text text : fragments) {
                    matchText+=text;
                    matchText+="……";
                }
                matchText+="<br/><br/>";
            }

            highlightField = highlightFieldMap.get("WSMC");
            if(highlightField!=null){
                Text[] fragments = highlightField.fragments();
                matchText += "<span style=\"color: black;font: larger bolder\">案件名称匹配情况：</span>";
                for (Text text : fragments) {
                    matchText+=text;
                    matchText+="……";
                }
                matchText+="<br/><br/>";
            }

            highlightField = highlightFieldMap.get("FYMC");
            if(highlightField!=null){
                Text[] fragments = highlightField.fragments();
                matchText += "<span style=\"color: black;font: larger bolder\">法院名称匹配情况：</span>";
                for (Text text : fragments) {
                    matchText+=text;
                    matchText+="……";
                }
                matchText+="<br/><br/>";
            }

            highlightField = highlightFieldMap.get("SPRY");
            if(highlightField!=null){
                Text[] fragments = highlightField.fragments();
                matchText += "<span style=\"color: black;font: larger bolder\">裁判人员匹配情况：</span>";
                for (Text text : fragments) {
                    matchText+=text;
                    matchText+="……";
                }
                matchText+="<br/><br/>";
            }

            highlightField = highlightFieldMap.get("DSR");
            if(highlightField!=null){
                Text[] fragments = highlightField.fragments();
                matchText += "<span style=\"color: black;font: larger bolder\">当事人匹配情况：</span>";
                for (Text text : fragments) {
                    matchText+=text;
                    matchText+="……";
                }
                matchText+="<br/><br/>";
            }

            highlightField = highlightFieldMap.get("FLYJ");
            if(highlightField!=null){
                Text[] fragments = highlightField.fragments();
                matchText += "<span style=\"color: black;font: larger bolder\">法律依据匹配情况：</span>";
                for (Text text : fragments) {
                    matchText+=text;
                    matchText+="……";
                }
                matchText+="<br/><br/>";
            }
            wsInfo.setMatchText(matchText);
            list.add(wsInfo);
            System.out.println(wsInfo.toString());
        }
        return list;
    }

    public long getWSInfoListNum(HashMap<String,String> preciseConditions, HashMap<String,String> ambiguousConditions,
                                 String beginDate, String endDate){
        try {
            ini();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        BoolQueryBuilder boolQueryBuilder= QueryBuilders.boolQuery();
        for(String pCond : preciseConditions.keySet()){
            boolQueryBuilder.must(QueryBuilders.termQuery(pCond.toUpperCase(),preciseConditions.get(pCond)));
        }

        for(String aCond : ambiguousConditions.keySet()){
            boolQueryBuilder.must(QueryBuilders.matchQuery(aCond.toUpperCase(),ambiguousConditions.get(aCond)).analyzer("jcseg_complex"));
        }

        if(beginDate!=null && beginDate.length()>0 && endDate!=null&& endDate.length()>0){
            boolQueryBuilder.must(QueryBuilders.rangeQuery("CPRQ").gte(beginDate).lte(endDate));
        }

        System.out.println(boolQueryBuilder.toString());

        SearchResponse scrollResp = transportClient.prepareSearch()
                .setScroll(new TimeValue(60000))
                .setQuery(boolQueryBuilder)
                .get();

        long count=scrollResp.getHits().getTotalHits();
        return count;
    }


    public HashMap<String, Integer> getGroupStatistics(HashMap<String,String> preciseConditions, HashMap<String,String> ambiguousConditions,
                                                       String beginDate, String endDate,String groupName,String whereName, String whereValue){
        HashMap<String, Integer> hashMap=new HashMap<String, Integer>();

        try {
            ini();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        BoolQueryBuilder boolQueryBuilder= QueryBuilders.boolQuery();
        for(String pCond : preciseConditions.keySet()){
            boolQueryBuilder.must(QueryBuilders.termQuery(pCond.toUpperCase(),preciseConditions.get(pCond)));
        }
        for(String aCond : ambiguousConditions.keySet()){
            boolQueryBuilder.must(QueryBuilders.matchQuery(aCond.toUpperCase(),ambiguousConditions.get(aCond)).analyzer("jcseg_complex"));
        }

        if(beginDate!=null && beginDate.length()>0 && endDate!=null&& endDate.length()>0){
            boolQueryBuilder.must(QueryBuilders.rangeQuery("CPRQ").gte(beginDate).lte(endDate));
        }

        AggregationBuilder aggregationBuilder= AggregationBuilders.terms("groupBy").field(groupName.toUpperCase()).size(100);
//        System.out.println(groupName);
//        System.out.println(aggregationBuilder.toString());
//        System.out.println(boolQueryBuilder.toString());

        SearchResponse scrollResp = transportClient.prepareSearch()
                .setScroll(new TimeValue(60000))
                .setQuery(boolQueryBuilder)
                .addAggregation(aggregationBuilder)
                .execute().actionGet();

//        System.out.println();

        Terms agg = scrollResp.getAggregations().get("groupBy");
        System.out.println("BucketsSize: "+agg.getBuckets().size());
        if(groupName.equals("FYCJ")||groupName.equals("CPNF")){
            for (Terms.Bucket entry : agg.getBuckets()) {
                String key =String.valueOf ((long) entry.getKey()); // bucket key
                long docCount = entry.getDocCount(); // Doc count
                System.out.println("key " + key + " doc_count " + docCount);
                hashMap.put(key, (int)docCount);
            }
        }else{
            for (Terms.Bucket entry : agg.getBuckets()) {
                String key = (String) entry.getKey(); // bucket key
                long docCount = entry.getDocCount(); // Doc count
                System.out.println("key " + key + " doc_count " + docCount);
                hashMap.put(key, (int)docCount);
            }
        }


        return hashMap;
    }

    public String getSuggestWordList(String word, String field){
        CompletionSuggestionBuilder completionSuggestionBuilder=new CompletionSuggestionBuilder("suggest");
        return "";
    }

    private String xmlPathToDocPath(String path){
        String[] temp=path.split("\\\\");
        temp[temp.length-2]="doc";
        temp[temp.length-1]=temp[temp.length-1].replace("xml","doc");
        path="";
        for(int i=0;i< temp.length;i++){
            path+=(temp[i]+"\\");
        }
        path=path.substring(0,path.length()-1);
        return path;
    }

    public String generateIndexFile(HashMap<String,String> preciseConditions, HashMap<String,String> ambiguousConditions, String beginDate, String endDate, String fileName, String type){
        try {
            ini();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        List<WSInfo> list=new ArrayList<WSInfo>();
        BoolQueryBuilder boolQueryBuilder= QueryBuilders.boolQuery();

        for(String pCond : preciseConditions.keySet()){
            boolQueryBuilder.must(QueryBuilders.termQuery(pCond.toUpperCase(),preciseConditions.get(pCond)));
        }

        for(String aCond : ambiguousConditions.keySet()){
            boolQueryBuilder.must(QueryBuilders.matchQuery(aCond.toUpperCase(),ambiguousConditions.get(aCond)).analyzer("jcseg_complex"));
        }

        if(beginDate!=null && beginDate.length()>0 && endDate!=null&& endDate.length()>0){
            boolQueryBuilder.must(QueryBuilders.rangeQuery("CPRQ").gte(beginDate).lte(endDate));
        }

//        System.out.println(boolQueryBuilder.toString());

        SearchResponse scrollResp = transportClient.prepareSearch()
                .setScroll(new TimeValue(60000))
                .setQuery(boolQueryBuilder)
                .setSize(500)
                .get();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw=new BufferedWriter(osw);


        //Scroll until no hits are returned
        StringBuilder sb=new StringBuilder();
        if(type.toUpperCase().equals("XML")){
            do {
                for (SearchHit hit : scrollResp.getHits().getHits()) {
                    //Handle the hit...
                    sb.append(hit.getSource().get("XMLPATH"));
                    sb.append("\n");
                }
                try {
                    bw.write(sb.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sb.setLength(0);//清空字符串构造器
                scrollResp = transportClient.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
            } while(scrollResp.getHits().getHits().length != 0); // Zero hits mark the end of the scroll and the while loop.
        }else{
            do {
                for (SearchHit hit : scrollResp.getHits().getHits()) {
                    //Handle the hit...
                    sb.append(xmlPathToDocPath((String)hit.getSource().get("XMLPATH")));
                    sb.append("\n");
                }
                try {
                    bw.write(sb.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sb.setLength(0);//清空字符串构造器
                scrollResp = transportClient.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
            } while(scrollResp.getHits().getHits().length != 0); // Zero hits mark the end of the scroll and the while loop.
        }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
