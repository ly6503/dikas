package vip.pryun.dikas.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vip.pryun.dikas.admin.vo.ProductSeriesVO;
import vip.pryun.dikas.admin.vo.ProductsSaveVO;
import vip.pryun.dikas.admin.vo.ProductsVO;
import vip.pryun.dikas.common.enums.Msg;
import vip.pryun.dikas.common.mybatis.dto.QueryParam;
import vip.pryun.dikas.common.mybatis.utils.WrapperUtils;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.common.object.UnifyUser;
import vip.pryun.dikas.common.util.bean.BeanMapper;
import vip.pryun.dikas.common.util.bean.BeanUtils;
import vip.pryun.dikas.domain.ProductsBean;
import vip.pryun.dikas.service.biz.IProductsService;

import java.util.List;

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
    @ApiImplicitParam(name = "queryParam", required = true, dataType = "QueryParam")
    public Result<IPage<ProductsVO>> page(@RequestBody @Validated QueryParam<ProductsVO> queryParam) {
        QueryWrapper<ProductsBean> wrapper = WrapperUtils.getWrapper(queryParam);
        IPage<ProductsBean> page = productsService.page(newPage(queryParam), wrapper);
        return newResult(page, ProductsVO.class);
    }

    @GetMapping("/list")
    @ApiOperation(value = "产品列表")
    public Result<List<ProductsVO>> list() {
        return newResult(productsService.list(), ProductsVO.class);
    }

    @GetMapping("/seriesList")
    @ApiOperation(value = "产品系列名称列表")
    public Result<List<ProductSeriesVO>> seriesList() {
        List<ProductsBean> productsBeans = productsService.seriesList();
        return newResult(productsBeans, ProductSeriesVO.class);
    }

    @PostMapping("/save")
    @ApiOperation(value = "添加产品")
    @ApiImplicitParam(name = "vo", required = true, dataType = "ProductsSaveVO")
    public Result<Boolean> save(@RequestBody @Validated ProductsSaveVO vo) {
        ProductsBean bean = BeanMapper.map(vo, ProductsBean.class);
        BeanUtils.addEntryInfo(bean, new UnifyUser(1L, "admin"));
        return newResult(productsService.save(bean), Msg.A40002);
    }
}
