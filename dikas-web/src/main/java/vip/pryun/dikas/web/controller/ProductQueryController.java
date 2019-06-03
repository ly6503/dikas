package vip.pryun.dikas.web.controller;


import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.pryun.dikas.common.enums.Msg;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.common.util.bean.BeanMapper;
import vip.pryun.dikas.domain.ProductQueryBean;
import vip.pryun.dikas.service.biz.IProductQueryService;
import vip.pryun.dikas.web.vo.ProductQueryVO;

/**
 * <p>
 * 产品查询 前端控制器
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
@RestController
@RequestMapping("/web/product_query")
@Api(tags = "产品查询")
public class ProductQueryController extends BaseController {

    @Autowired
    private IProductQueryService service;

    @PostMapping("/query")
    @ApiOperation(value = "查询产品")
    @ApiImplicitParam(name = "queryVO", required = true, dataType = "ProductQueryVO")
    public Result<Boolean> query(@RequestBody @Validated ProductQueryVO queryVO) {
        ProductQueryBean bean = BeanMapper.map(queryVO, ProductQueryBean.class);
        return newResult(service.save(bean), Msg.A40001);
    }
}
