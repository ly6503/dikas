package vip.pryun.dikas.web.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import vip.pryun.dikas.common.enums.Msg;
import vip.pryun.dikas.common.mybatis.dto.QueryParam;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.common.util.bean.BeanMapper;
import vip.pryun.dikas.domain.RecruitBean;
import vip.pryun.dikas.service.biz.IRecruitService;
import vip.pryun.dikas.web.vo.RecruitSaveVO;
import vip.pryun.dikas.web.vo.RecruitVO;

import java.util.List;

/**
 * <p>
 * 职务表 前端控制器
 * </p>
 *
 * @author cjzlx
 * @since 2019-05-29
 */
@RestController
@RequestMapping("/web/dikas/job")
@Api(tags = "招聘职务控制器")
public class RecruitController extends BaseController {

    private final IRecruitService recruitService;

    public RecruitController(IRecruitService recruitService) {
        this.recruitService = recruitService;
    }

    @PostMapping(value = "/page")
    @ApiOperation(value = "招聘职务分页列表", notes = "招聘职务分页列表")
    public Result page(@RequestBody QueryParam param) {
        IPage<RecruitBean> iPage = recruitService.pageList(param);
        return newResult(iPage, RecruitVO.class);
    }

    @GetMapping(value = "list")
    @ApiOperation(value = "招聘职务列表", notes = "招聘职务列表")
    public Result list() {
        List<RecruitBean> list = recruitService.list();
        return newResult(list, RecruitVO.class);
    }

    @PutMapping(value = "add")
    @ApiOperation(value = "添加招聘职务", notes = "添加招聘职务")
    public Result addRecruit(@RequestBody RecruitSaveVO saveVO) {
        RecruitBean recruitBean = BeanMapper.map(saveVO, RecruitBean.class);
        boolean save = recruitService.saveRecruit(recruitBean);
        return newResult(save, Msg.F00002);
    }
}
