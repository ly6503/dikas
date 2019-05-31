package vip.pryun.dikas.service.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import vip.pryun.dikas.domain.ProductsBean;

import java.util.List;

/**
 * <p>
 * 产品表 服务类
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
public interface IProductsService extends IService<ProductsBean> {

    List<ProductsBean> seriesList();
}
