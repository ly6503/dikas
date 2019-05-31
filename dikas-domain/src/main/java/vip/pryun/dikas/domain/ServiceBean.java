package vip.pryun.dikas.domain;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 服务支持
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
@TableName("service")
public class ServiceBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
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
        return "ServiceBean{" +
        "title=" + title +
        ", content=" + content +
        "}";
    }
}
