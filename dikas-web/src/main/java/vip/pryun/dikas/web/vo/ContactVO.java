package vip.pryun.dikas.web.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author CJ
 * @date 2019/5/30 19:40
 * @note
 */
public class ContactVO implements Serializable {
    private static final long serialVersionUID = 3615033313283010987L;
    /**
     * 公司英文名称
     */
    private String companyEnglistName;

    /**
     * 公司中文名称
     */
    private String companyChinesName;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 电话号码
     */
    private String tel;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 邮箱
     */
    private String email;

    private List<ProductingAreaVO> productingAreaVOS;

    public String getCompanyEnglistName() {
        return companyEnglistName;
    }

    public void setCompanyEnglistName(String companyEnglistName) {
        this.companyEnglistName = companyEnglistName;
    }

    public String getCompanyChinesName() {
        return companyChinesName;
    }

    public void setCompanyChinesName(String companyChinesName) {
        this.companyChinesName = companyChinesName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ProductingAreaVO> getProductingAreaVOS() {
        return productingAreaVOS;
    }

    public void setProductingAreaVOS(List<ProductingAreaVO> productingAreaVOS) {
        this.productingAreaVOS = productingAreaVOS;
    }

    @Override
    public String toString() {
        return "ContactVO{" +
                "companyEnglistName='" + companyEnglistName + '\'' +
                ", companyChinesName='" + companyChinesName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", tel='" + tel + '\'' +
                ", contactName='" + contactName + '\'' +
                ", email='" + email + '\'' +
                ", productingAreaVOS=" + productingAreaVOS +
                '}';
    }
}
