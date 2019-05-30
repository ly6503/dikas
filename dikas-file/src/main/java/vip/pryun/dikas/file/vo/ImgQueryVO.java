package vip.pryun.dikas.file.vo;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;
import vip.pryun.dikas.common.mybatis.annotation.property.Equal;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 59941
 * @date 2019/5/30 15:10
 */
public class ImgQueryVO implements Serializable {
    private static final long serialVersionUID = 4908578318890646426L;

    @NotNull
    @Range(min = 0)
    @Equal
    @ApiModelProperty("图片类型")
    private Short type;

    @NotNull
    @Equal
    @Range(min = 0)
    @ApiModelProperty("引用表id")
    private Integer refId;

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
}
