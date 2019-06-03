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
import vip.pryun.dikas.domain.ApplicantBean;
import vip.pryun.dikas.service.biz.IApplicantService;
import vip.pryun.dikas.web.vo.ApplicantSaveVO;

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

    public ApplicantController(IApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PutMapping(value = "addApplicant")
    @ApiOperation(value = "添加求职者信息", notes = "添加求职者信息")
    public Result addApplicant(@RequestBody ApplicantSaveVO saveVO) {
        ApplicantBean applicantBean = BeanMapper.map(saveVO, ApplicantBean.class);
        boolean save = applicantService.saveApplicant(applicantBean);
        return newResult(save, Msg.F00001);
    }
}
