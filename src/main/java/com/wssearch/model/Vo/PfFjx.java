package com.wssearch.model.Vo;

import com.wssearch.model.WsXspjjgfjx;
import com.wssearch.model.WsXspjjgpf;

import java.util.List;

/**
 * Created by cristph on 2017/3/30.
 */
public class PfFjx {

    private WsXspjjgpf pf;
    private List<WsXspjjgfjx> fjxList;

    public PfFjx(WsXspjjgpf pf, List<WsXspjjgfjx> fjxList) {
        this.pf = pf;
        this.fjxList = fjxList;
    }

    public WsXspjjgpf getPf() {
        return pf;
    }

    public void setPf(WsXspjjgpf pf) {
        this.pf = pf;
    }

    public List<WsXspjjgfjx> getFjxList() {
        return fjxList;
    }

    public void setFjxList(List<WsXspjjgfjx> fjxList) {
        this.fjxList = fjxList;
    }
}
