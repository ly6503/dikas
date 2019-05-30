package vip.pryun.dikas.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.pryun.dikas.common.mybatis.dto.QueryParam;
import vip.pryun.dikas.common.mybatis.utils.WrapperUtils;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.domain.NewsBean;
import vip.pryun.dikas.domain.ProductsBean;
import vip.pryun.dikas.service.biz.IProductsService;
import vip.pryun.dikas.web.vo.NewsVO;
import vip.pryun.dikas.web.vo.ProductsVO;

/**
 * <p>
 * 产品表 前端控制器
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
@RestController
@RequestMapping("/web/dikas/products")
@Api(tags = "产品")
public class ProductsController extends BaseController {

    @Autowired
    private IProductsService productsService;

    @PostMapping("/page")
    @ApiOperation(value = "产品分页/模糊查询")
    public Result<IPage<ProductsVO>> page(@RequestBody @Validated QueryParam<ProductsVO> queryParam){
        QueryWrapper<ProductsBean> wrapper = WrapperUtils.getWrapper(queryParam);
        IPage<ProductsBean> page = productsService.page(newPage(queryParam), wrapper);
        return newResult(page, ProductsVO.class);
    }
}
