package vip.pryun.dikas.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.pryun.dikas.UserBean;
import vip.pryun.dikas.biz.IUserService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-27
 */
@RestController
@RequestMapping("/web/v1/")
@Api(tags = "用户")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @GetMapping("/test")
    @ApiOperation(value = "test")
    public void test() {
        userService.saveUser();
    }

    @GetMapping("/get")
    @ApiOperation(value = "get")
    public UserBean get() {
       return userService.getUser();
    }
    @GetMapping("/string")
    @ApiOperation(value = "get")
    public String getString() {
        return "fffff";
    }
}
