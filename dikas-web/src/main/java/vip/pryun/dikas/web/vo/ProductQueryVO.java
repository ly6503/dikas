package vip.pryun.dikas.web.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: liuyin
 * @Date: 2019/5/31 10:33
 * @Description:
 */
public class ProductQueryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公司地址
     */
    @ApiModelProperty("公司地址")
    @NotBlank
    private String companyAddr;

    /**
     * 联系人
     */
    @ApiModelProperty("联系人")
    @NotBlank
    private String contacts;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量", example = "1")

    private Integer number;

    /**
     * 公司名称
     */
    @ApiModelProperty("公司名称")
    @NotBlank
    private String companyName;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    @NotBlank

    private String phone;

    /**
     * 联系邮箱
     */
    @ApiModelProperty("联系邮箱")
    private String email;

    /**
     * 交付时间
     */
    @ApiModelProperty("交付时间")
    private Date deliveryDt;

    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    private String productName;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
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

    public Date getDeliveryDt() {
        return deliveryDt;
    }

    public void setDeliveryDt(Date deliveryDt) {
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
}
