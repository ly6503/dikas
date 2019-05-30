package vip.pryun.dikas.domain;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 产品表
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
@TableName("products")
public class ProductsBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 标签名
     */
    private String name;

    /**
     * 系列
     */
    private String series;

    /**
     * 简述
     */
    private String sketch;

    /**
     * 描述
     */
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

    @Override
    public String toString() {
        return "ProductsBean{" +
        "name=" + name +
        ", series=" + series +
        ", sketch=" + sketch +
        ", description=" + description +
        "}";
    }
}
