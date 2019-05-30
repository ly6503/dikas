package vip.pryun.dikas.domain;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
@TableName("leave_message")
public class LeaveMessageBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 传真
     */
    private String fax;

    /**
     * 地址
     */
    private String adress;

    /**
     * 留言内容
     */
    private String content;

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "LeaveMessageBean{" +
        "contacts=" + contacts +
        ", email=" + email +
        ", phone=" + phone +
        ", fax=" + fax +
        ", adress=" + adress +
        ", content=" + content +
        "}";
    }
}
