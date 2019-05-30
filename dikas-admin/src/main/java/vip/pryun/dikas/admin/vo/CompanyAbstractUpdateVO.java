package vip.pryun.dikas.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 59941
 * @date 2019/5/30 11:48
 */
public class CompanyAbstractUpdateVO implements Serializable {
    private static final long serialVersionUID = -5026601289353756826L;

    /**
     * id
     */
    @NotNull
    @Range(min = 1)
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 公司简介内容
     */
    @NotBlank
    @Length(max = 1000)
    @ApiModelProperty("公司简介内容")
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
