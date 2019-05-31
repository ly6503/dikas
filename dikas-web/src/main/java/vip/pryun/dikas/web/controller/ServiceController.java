package vip.pryun.dikas.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.domain.ServiceBean;
import vip.pryun.dikas.service.biz.IServiceService;
import vip.pryun.dikas.web.vo.ServiceVO;

import java.util.List;

/**
 * <p>
 * 服务支持 前端控制器
 * </p>
 *
 * @author LiuYin
 * @since 2019-05-30
 */
@RestController
@RequestMapping("/dikas/service")
@Api(tags = "服务支持")
public class ServiceController extends BaseController {

    @Autowired
    private IServiceService service;

    @GetMapping("/list")
    @ApiOperation(value = "服务支持列表")
    public Result<List<ServiceVO>> list() {
        return newResult(service.list(), ServiceVO.class);
    }
}
