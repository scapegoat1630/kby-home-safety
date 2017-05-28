package com.kby.home.safety.api.web;

import com.kby.home.safety.api.vo.ThresholdVo;

import java.util.List;

/**
 * Created by zhangpeng12 on 2017/5/28.
 */
public class SetRoomThresholdRequest extends Request {

    List<ThresholdVo>  thresholdVoList;


    public List<ThresholdVo> getThresholdVoList() {
        return thresholdVoList;
    }

    public void setThresholdVoList(List<ThresholdVo> thresholdVoList) {
        this.thresholdVoList = thresholdVoList;
    }
}
