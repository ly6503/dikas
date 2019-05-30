package vip.pryun.dikas.service.biz.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.pryun.dikas.domain.ProductsBean;
import vip.pryun.dikas.persistence.dao.ProductsDao;
import vip.pryun.dikas.service.biz.IProductsService;

/**
 * <p>
 * 产品表 服务实现类
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsDao, ProductsBean> implements IProductsService {

}
