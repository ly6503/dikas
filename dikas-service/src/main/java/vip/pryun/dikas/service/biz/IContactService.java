package vip.pryun.dikas.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import vip.pryun.dikas.domain.ContactBean;
import vip.pryun.dikas.persistence.dto.ContactDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cj
 * @since 2019-05-30
 */
public interface IContactService extends IService<ContactBean> {
    ContactDTO getContact();
}
