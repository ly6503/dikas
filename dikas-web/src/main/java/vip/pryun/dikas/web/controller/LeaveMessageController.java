package vip.pryun.dikas.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
@RestController
@RequestMapping("/dikas/leave-message-bean")
@Api
public class LeaveMessageController extends BaseController {

    @GetMapping(value = "test")
    @ApiOperation(value = "sdfsdfds")
    public String test1() {
        return "4566";
    }
}
