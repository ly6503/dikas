package vip.pryun.dikas.file.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author 59941
 * @date 2019/5/30 15:17
 */
public class ImgVO implements Serializable {
    private static final long serialVersionUID = 539234808092460034L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("图片类型")
    private Short type;

    @ApiModelProperty("参照表id")
    private Integer refId;

    @ApiModelProperty("图片url")
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
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
}
