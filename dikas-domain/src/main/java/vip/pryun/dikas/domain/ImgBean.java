package vip.pryun.dikas.domain;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 *
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-29
 */
@TableName("img")
public class ImgBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 图片类型
     */
    private Integer type;

    /**
     * 引用表id
     */
    private Integer refId;

    /**
     * 图片url
     */
    private String url;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImgBean{" +
                "type=" + type +
                ", refId=" + refId +
                ", url=" + url +
                "}";
    }
}
