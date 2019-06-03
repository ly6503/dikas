package vip.pryun.dikas.admin.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.pryun.dikas.admin.vo.ApplicantUpdateVO;
import vip.pryun.dikas.admin.vo.ApplicantVO;
import vip.pryun.dikas.common.enums.Msg;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.common.util.bean.BeanMapper;
import vip.pryun.dikas.domain.ApplicantBean;
import vip.pryun.dikas.service.biz.IApplicantService;
import vip.pryun.dikas.service.biz.impl.SendMailImpl;

import java.util.List;

/**
 * <p>
 * 求职者表 前端控制器
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
@RestController
@RequestMapping("/web/dikas/applicant")
@Api(tags = "求职者控制器")
public class ApplicantController extends BaseController {
    private final IApplicantService applicantService;
    @Autowired
    private SendMailImpl sendMail;

    public ApplicantController(IApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PutMapping(value = "getApplicant")
    @ApiOperation(value = "查询求职者信息", notes = "查询求职者信息")
    public Result getApplicant() {
        List<ApplicantBean> list = applicantService.list();
        return newResult(list, ApplicantVO.class);
    }
    @PutMapping(value = "apprival")
    @ApiOperation(value = "审批求职者信息", notes = "审批求职者信息")
    public Result approval(@RequestBody List<ApplicantUpdateVO> updateVOS) {
        List<ApplicantBean> applicantBeans = BeanMapper.mapList(updateVOS, ApplicantUpdateVO.class, ApplicantBean.class);
        Boolean aBoolean = applicantService.updateOrDelete(applicantBeans);
        return newResult(aBoolean, Msg.F00004);
    }


    @PostMapping(value = "send")
    @ApiOperation(value = "发送审批结果", notes = "发送审批结果")
    public Result sendMessage(@RequestParam String url) {
        Boolean aBoolean = sendMail.sendMailMessage(url);
        return newResult(aBoolean, Msg.F00004);
    }
}
