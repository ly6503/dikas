package vip.pryun.dikas.admin.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author: liuyin
 * @Date: 2019/5/30 15:17
 * @Description:
 */
public class NewsSaveVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    @ApiModelProperty("标题")
    @NotBlank
    private String title;

    /**
     * 来源
     */
    @ApiModelProperty("来源")
    @NotBlank
    private String source;

    /**
     * 内容
     */
    @ApiModelProperty("内容")
    @NotBlank
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
