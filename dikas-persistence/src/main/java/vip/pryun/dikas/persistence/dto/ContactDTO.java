package vip.pryun.dikas.persistence.dto;

import vip.pryun.dikas.domain.ContactBean;
import vip.pryun.dikas.domain.ProductingAreaBean;

import java.util.List;

/**
 * @author CJ
 * @date 2019/5/30 17:40
 * @note
 */
public class ContactDTO extends ContactBean {
    private static final long serialVersionUID = -2814841094556029836L;
    private List<ProductingAreaBean> productingAreas;

    public List<ProductingAreaBean> getProductingAreas() {
        return productingAreas;
    }

    public void setProductingAreas(List<ProductingAreaBean> productingAreas) {
        this.productingAreas = productingAreas;
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "productingAreas=" + productingAreas +
                '}';
    }
}
