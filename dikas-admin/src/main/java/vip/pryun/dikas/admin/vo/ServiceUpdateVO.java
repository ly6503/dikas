package vip.pryun.dikas.admin.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author 董大大
 * @date 2019/5/31 14:20
 * @Descript
 */
public class ServiceUpdateVO {

    /**
     * 服务标题 ：0服务综述 1服务政策 2服务体系
     */
    @ApiModelProperty("服务标题")
    @NotNull
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "ServiceUpdateVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
