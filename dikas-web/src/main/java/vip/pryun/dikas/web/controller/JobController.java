package vip.pryun.dikas.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.pryun.dikas.service.biz.IJobService;

/**
 * <p>
 * 职务表 前端控制器
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
@RestController
@RequestMapping("/dikas/job-bean")
@Api(tags = "招聘职务控制器")
public class JobController extends BaseController {

    @Autowired
    IJobService jobService;

    @RequestMapping(value = "/list")
    @ApiOperation(value = "招聘职务分页列表", notes = "招聘职务分页列表")
    public String list() {
        return "4566";
    }

    @GetMapping(value = "test")
    @ApiOperation(value = "sdfsdfds")
    public String test1() {
        return "4566";
    }
}
