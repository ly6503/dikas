package vip.pryun.dikas.admin.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 走进公司 前端控制器
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-29
 */
@RestController
@RequestMapping("/admin/dikas/company-detail-bean")
@Api
public class CompanyDetailController extends BaseController {

    @PostMapping("/test")
    @ApiOperation(value = "test")
    public String test() {
        return "abc";
    }
}
