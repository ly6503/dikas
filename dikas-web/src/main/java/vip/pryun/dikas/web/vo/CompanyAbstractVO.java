package vip.pryun.dikas.web.vo;

import java.io.Serializable;

/**
 * @author 59941
 * @date 2019/5/30 11:29
 */
public class CompanyAbstractVO implements Serializable {
    private static final long serialVersionUID = 6750189616175542933L;

    private Integer id;

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
