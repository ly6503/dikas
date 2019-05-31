package vip.pryun.dikas.web.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: liuyin
 * @Date: 2019/5/31 9:33
 * @Description:
 */
public class ProductSeriesVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系列
     */
    @ApiModelProperty("系列")
    private String series;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
