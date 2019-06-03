package vip.pryun.dikas.file.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.file.vo.FileUploadResultVO;
import vip.pryun.dikas.persistence.dto.FileUploadDTO;
import vip.pryun.dikas.service.biz.IFileService;

import javax.validation.constraints.NotEmpty;
import java.io.IOException;
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
@RequestMapping("/file")
public class FileController extends BaseController {

    @Autowired
    private IFileService fileService;

    @PostMapping("/upload")
    @ApiOperation("上传文件")
    public Result<List<FileUploadResultVO>> upload(@RequestParam("loadfile") @ApiParam(name = "files", value = "<input>标签的name属性值") @NotEmpty List<MultipartFile> files) throws IOException {
        List<FileUploadDTO> fileUploadDTOS = fileService.upload(files);

        return newResult(fileUploadDTOS, FileUploadResultVO.class);
    }

}
