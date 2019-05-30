package vip.pryun.dikas.domain;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author cj
 * @since 2019-05-30
 */
@TableName("contact")
public class ContactBean extends BaseBean {

    private static final long serialVersionUID = 1L;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "ContactBean{" +
                "companyEnglistName='" + companyEnglistName + '\'' +
                ", companyChinesName='" + companyChinesName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", tel='" + tel + '\'' +
                ", contactName='" + contactName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
