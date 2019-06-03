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
@TableName("producting_area")
public class ProductingAreaBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 生产基地地址
     */
    private String areaAdress;

    /**
     * 生产基地名称
     */
    private String areaName;

    /**
     * 联系表关联id
     */
    private Long contactId;

    public String getAreaAdress() {
        return areaAdress;
    }

    public void setAreaAdress(String areaAdress) {
        this.areaAdress = areaAdress;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    @Override
    public String toString() {
        return "ProductingAreaBean{" +
                "areaAdress=" + areaAdress +
                ", areaName=" + areaName +
                ", contactId=" + contactId +
                "}";
    }
}
