package vip.pryun.dikas.web.vo;

import io.swagger.annotations.ApiModelProperty;
import vip.pryun.dikas.common.mybatis.annotation.property.Equal;
import vip.pryun.dikas.common.mybatis.annotation.property.Like;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: liuyin
 * @Date: 2019/5/30 15:17
 * @Description:
 */
public class NewsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 类型:1新闻  2行业动态
     */
    @ApiModelProperty(value = "类型:1新闻  2行业动态", example = "1")
    @Equal
    private Integer type;

    /**
     * 标题
     */
    @ApiModelProperty("标题")
    @Like
    private String title;

    /**
     * 来源
     */
    @ApiModelProperty("来源")
    @Like
    private String source;

    /**
     * 内容
     */
    @ApiModelProperty("内容")
    @Like
    private String content;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date entryDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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

    public Date getEntryDt() {
        return entryDt;
    }

    public void setEntryDt(Date entryDt) {
        this.entryDt = entryDt;
    }
}
