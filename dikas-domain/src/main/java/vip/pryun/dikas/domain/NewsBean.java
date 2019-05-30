package vip.pryun.dikas.domain;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 新闻和动态
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
@TableName("news")
public class NewsBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 类型:1新闻  2行业动态
     */
    private Integer type;

    /**
     * 标题
     */
    private String title;

    /**
     * 来源
     */
    private byte[] source;

    /**
     * 内容
     */
    private String content;

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

    @Override
    public String toString() {
        return "NewsBean{" +
        "type=" + type +
        ", title=" + title +
        ", source=" + source +
        ", content=" + content +
        "}";
    }
}
