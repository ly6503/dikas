package vip.pryun.dikas.file.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vip.pryun.dikas.common.mybatis.dto.QueryParam;
import vip.pryun.dikas.common.mybatis.utils.WrapperUtils;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.domain.ImgBean;
import vip.pryun.dikas.file.vo.ImgQueryVO;
import vip.pryun.dikas.file.vo.ImgVO;
import vip.pryun.dikas.service.biz.IImgService;

import java.util.List;

/**
 * <p>
 * 图片 前端控制器
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-29
 */
@RestController
@RequestMapping("/file/img")
public class ImgController extends BaseController {

    @Autowired
    private IImgService imgService;

    @PostMapping("/query")
    @ApiOperation("获取图片")
    public Result<List<ImgVO>> query(@Validated @RequestBody QueryParam<ImgQueryVO> queryParam) {
        QueryWrapper<ImgBean> wrapper = WrapperUtils.getConditionWrapper(queryParam);
        List<ImgBean> imgBeans = imgService.list(wrapper);

        return newResult(imgBeans, ImgVO.class);
    }

    @PostMapping("/upload")
    @ApiOperation("上传图片")
    public Result upload(@RequestParam MultipartFile file) {
        imgService.upload(file);
        return Result.success();
    }
}
