package vip.pryun.dikas.domain;

import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

/**
 * <p>
 * 产品查询
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
@TableName("product_query")
public class ProductQueryBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 公司地址
     */
    private String companyAddr;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 联系邮箱
     */
    private String email;

    /**
     * 交付时间
     */
    private LocalDateTime deliveryDt;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 备注
     */
    private String remarks;

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDeliveryDt() {
        return deliveryDt;
    }

    public void setDeliveryDt(LocalDateTime deliveryDt) {
        this.deliveryDt = deliveryDt;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "ProductQueryBean{" +
                "companyAddr=" + companyAddr +
                ", contacts=" + contacts +
                ", number=" + number +
                ", companyName=" + companyName +
                ", phone=" + phone +
                ", email=" + email +
                ", deliveryDt=" + deliveryDt +
                ", productName=" + productName +
                ", remarks=" + remarks +
                "}";
    }
}
