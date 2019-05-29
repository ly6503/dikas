package vip.pryun.dikas.domain;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 走进公司
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-29
 */
@TableName("company_detail")
public class CompanyDetailBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CompanyDetailBean{" +
                "title=" + title +
                "}";
    }
}
