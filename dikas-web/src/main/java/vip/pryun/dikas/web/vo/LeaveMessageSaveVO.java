package vip.pryun.dikas.web.vo;

import vip.pryun.dikas.service.enums.ApprovalStatusEnum;

import java.io.Serializable;

/**
 * @author CJ
 * @date 2019/5/30 20:18
 * @note
 */
public class LeaveMessageSaveVO implements Serializable {
    private static final long serialVersionUID = 7688545656838676374L;
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

    /**
     * 审批状态（0：未审批，1：已通过，3：已拒绝）
     * @see vip.pryun.dikas.service.enums.ApprovalStatusEnum
     */
    private Integer approvalStatus;

    public LeaveMessageSaveVO(String approvalStatus) {
        this.approvalStatus = ApprovalStatusEnum.UNAPPROVED.value;
    }

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
        return "LeaveMessageSaveVO{" +
                "contacts='" + contacts + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", adress='" + adress + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
