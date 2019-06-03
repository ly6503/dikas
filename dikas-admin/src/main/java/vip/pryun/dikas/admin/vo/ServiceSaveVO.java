package vip.pryun.dikas.admin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @author 董大大
 * @date 2019/5/31 13:45
 * @Descript
 */
@ApiModel("服务")
public class ServiceSaveVO {
    /**
     * 服务标题 ：0服务综述 1服务政策 2服务体系
     */
    @ApiModelProperty("服务标题")
    @NotBlank(message = "标题为空")
    private String title;

    /**
     * 服务内容
     */
    @NotBlank(message = "服务内容为空")
    @ApiModelProperty("服务内容")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ServiceSaveVO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
