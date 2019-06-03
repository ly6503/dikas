package vip.pryun.dikas.file.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.pryun.dikas.service.biz.IFileService;

/**
 * <p>
 * 图片 前端控制器
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-29
 */
@RestController
@RequestMapping("/file")
public class FileController extends BaseController {

    @Autowired
    private IFileService imgService;

    /*@PostMapping("/query")
    @ApiOperation("获取图片")
    public Result<List<ImgVO>> query(@Validated @RequestBody QueryParam<ImgQueryVO> queryParam) {
        QueryWrapper<ImgBean> wrapper = WrapperUtils.getConditionWrapper(queryParam);
        List<ImgBean> imgBeans = imgService.list(wrapper);

        return newResult(imgBeans, ImgVO.class);
    }*/

    /*@PostMapping("/upload")
    @ApiOperation("上传图片")
    public Result<FileUploadResultVO> upload(@RequestParam("loadfile") List<MultipartFile> files) throws IOException {
        imgService.upload(imgBean, files, new UnifyUser(1L, "hx"));


        return Result.success();
    }*/

   

}
