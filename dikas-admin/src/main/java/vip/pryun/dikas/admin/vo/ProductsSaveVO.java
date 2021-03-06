package vip.pryun.dikas.admin.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: liuyin
 * @Date: 2019/5/30 16:37
 * @Description:
 */
public class ProductsSaveVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    private String name;

    /**
     * 系列
     */
    @ApiModelProperty("系列")
    private String series;

    /**
     * 简述
     */
    @ApiModelProperty("简述")
    private String sketch;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSketch() {
        return sketch;
    }

    public void setSketch(String sketch) {
        this.sketch = sketch;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
