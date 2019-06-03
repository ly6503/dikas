package vip.pryun.dikas.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.domain.CompanyAbstractBean;
import vip.pryun.dikas.service.biz.ICompanyAbstractService;
import vip.pryun.dikas.web.vo.CompanyAbstractVO;

import java.util.List;

/**
 * <p>
 * 公司简介 前端控制器
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-29
 */
@RestController
@RequestMapping("/web/company-abstract")
@Api(tags = "公司简介")
public class CompanyAbstractController extends BaseController {

    @Autowired
    private ICompanyAbstractService companyAbstractService;

    @GetMapping("/list")
    @ApiOperation(value = "获取公司简介")
    public Result<List<CompanyAbstractVO>> list() {
        List<CompanyAbstractBean> companyAbstractBeans = companyAbstractService.list();
        return newResult(companyAbstractBeans, CompanyAbstractVO.class);
    }

}
