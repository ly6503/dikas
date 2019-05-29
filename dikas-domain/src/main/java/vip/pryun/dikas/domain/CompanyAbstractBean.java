package vip.pryun.dikas.domain;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 公司简介
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-29
 */
@TableName("company_abstract")
public class CompanyAbstractBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CompanyAbstractBean{" +
                "content=" + content +
                "}";
    }
}
