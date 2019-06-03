package vip.pryun.dikas.service.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.common.util.bean.BeanMapper;
import vip.pryun.dikas.domain.ContactBean;
import vip.pryun.dikas.domain.ProductingAreaBean;
import vip.pryun.dikas.persistence.dao.ContactDao;
import vip.pryun.dikas.persistence.dto.ContactDTO;
import vip.pryun.dikas.service.biz.IContactService;
import vip.pryun.dikas.service.biz.IProductingAreaService;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cj
 * @since 2019-05-30
 */
@Service
public class ContactServiceImpl extends ServiceImpl<ContactDao, ContactBean> implements IContactService {

    @Autowired
    private IProductingAreaService productingAreaService;

    @Override
    public ContactDTO getContact() {
        ContactDTO contactDTO = new ContactDTO();
        List<ContactBean> list = list();
        if (list.size() == 1) {
            ContactBean contactBean = list.get(0);
            Wrapper<ProductingAreaBean> qw = new LambdaQueryWrapper<ProductingAreaBean>()
                    .eq(ProductingAreaBean::getContactId, contactBean.getId());
            List<ProductingAreaBean> areaBeans = productingAreaService.list(qw);
            contactDTO = BeanMapper.map(contactBean, ContactDTO.class);
            contactDTO.setProductingAreas(areaBeans);
        }
        return contactDTO;
    }
}
