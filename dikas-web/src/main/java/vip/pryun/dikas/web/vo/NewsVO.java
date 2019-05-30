package vip.pryun.dikas.web.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

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
    private Integer type;

    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;

    /**
     * 来源
     */
    @ApiModelProperty("来源")
    private byte[] source;

    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String content;

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

    public byte[] getSource() {
        return source;
    }

    public void setSource(byte[] source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
