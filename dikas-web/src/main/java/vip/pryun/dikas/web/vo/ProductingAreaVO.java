package vip.pryun.dikas.web.vo;

import java.io.Serializable;

/**
 * @author CJ
 * @date 2019/5/30 20:04
 * @note
 */
public class ProductingAreaVO implements Serializable {
    private static final long serialVersionUID = 3336893753234858880L;
    /**
     * 生产基地地址
     */
    private String areaAdress;

    /**
     * 生产基地名称
     */
    private String areaName;

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

    @Override
    public String toString() {
        return "ProductingAreaVO{" +
                "areaAdress='" + areaAdress + '\'' +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}
