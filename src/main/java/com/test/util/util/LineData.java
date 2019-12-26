package com.test.util.util;

/**
 * @author zhangnan
 * @date 2019/11/05 14:49
 */
public class LineData {

    public LineData(Integer skuId, Integer thirdId, String thirdName) {
        this.skuId = skuId;
        this.thirdId = thirdId;
        this.thirdName = thirdName;
    }

    private Integer skuId;

    private Integer thirdId;

    private String thirdName;

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getThirdId() {
        return thirdId;
    }

    public void setThirdId(Integer thirdId) {
        this.thirdId = thirdId;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }
}
