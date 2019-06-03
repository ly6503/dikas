package vip.pryun.dikas.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.pryun.dikas.common.enums.Msg;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.common.util.bean.BeanMapper;
import vip.pryun.dikas.domain.LeaveMessageBean;
import vip.pryun.dikas.service.biz.ILeaveMessageService;
import vip.pryun.dikas.web.vo.LeaveMessageSaveVO;

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

    @PutMapping(value = "addMessage")
    @ApiOperation(value = "添加留言信息", notes = "添加留言信息")
    public Result addLeaveMessage(@RequestBody LeaveMessageSaveVO saveVO) {
        LeaveMessageBean messageBean = BeanMapper.map(saveVO, LeaveMessageBean.class);
        return newResult(leaveMessageService.save(messageBean), Msg.F00004);
    }
}
