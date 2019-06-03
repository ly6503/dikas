package vip.pryun.dikas.service.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.domain.ProductQueryBean;
import vip.pryun.dikas.persistence.dao.ProductQueryDao;
import vip.pryun.dikas.service.biz.IProductQueryService;

/**
 * <p>
 * 产品查询 服务实现类
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
@Service
public class ProductQueryServiceImpl extends ServiceImpl<ProductQueryDao, ProductQueryBean> implements IProductQueryService {

}
