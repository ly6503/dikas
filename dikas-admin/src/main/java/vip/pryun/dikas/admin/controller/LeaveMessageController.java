package vip.pryun.dikas.admin.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.pryun.dikas.admin.vo.LeaveMessageVO;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.domain.LeaveMessageBean;
import vip.pryun.dikas.service.biz.ILeaveMessageService;

import java.util.List;

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
@Api(tags = "在线留言控制器")
public class LeaveMessageController extends BaseController {

    private final ILeaveMessageService leaveMessageService;

    public LeaveMessageController(ILeaveMessageService leaveMessageService) {
        this.leaveMessageService = leaveMessageService;
    }
    @PutMapping(value = "getMessages")
    @ApiOperation(value = "查询留言信息", notes = "查询留言信息")
    public Result addLeaveMessage() {
        List<LeaveMessageBean> leaveMessageBeans = leaveMessageService.list();
        return newResult(leaveMessageBeans, LeaveMessageVO.class);
    }
}
