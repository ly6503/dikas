package vip.pryun.dikas.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.pryun.dikas.admin.vo.CompanyAbstractUpdateVO;
import vip.pryun.dikas.admin.vo.CompanyAbstractVO;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.common.util.bean.BeanMapper;
import vip.pryun.dikas.domain.CompanyAbstractBean;
import vip.pryun.dikas.service.biz.ICompanyAbstractService;

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
@RequestMapping("/admin/dikas/company-abstract-bean")
public class CompanyAbstractController extends BaseController {

    @Autowired
    private ICompanyAbstractService companyAbstractService;

    public Result<List<CompanyAbstractVO>> list() {
        List<CompanyAbstractBean> companyAbstractBeans = companyAbstractService.list();
        return newResult(companyAbstractBeans, CompanyAbstractVO.class);
    }

    public Result<Boolean> update(@Validated CompanyAbstractUpdateVO companyAbstractUpdateVO) {
        CompanyAbstractBean companyAbstractBean = BeanMapper.map(
                companyAbstractUpdateVO, CompanyAbstractBean.class);

        companyAbstractService.updateById(companyAbstractBean);
        return Result.success();
    }
}
