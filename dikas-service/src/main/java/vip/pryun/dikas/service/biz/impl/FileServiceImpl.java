package vip.pryun.dikas.service.biz.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vip.pryun.dikas.common.enums.ModuleEnum;
import vip.pryun.dikas.common.util.StringUtils;
import vip.pryun.dikas.common.util.file.FileUtils;
import vip.pryun.dikas.common.util.file.web.path.PathUtils;
import vip.pryun.dikas.persistence.dto.FileUploadDTO;
import vip.pryun.dikas.service.consts.UploadConstant;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 文件 服务实现类
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-29
 */
@Service
public class FileServiceImpl implements IFileService {

    @Override
    public List<FileUploadDTO> upload(List<MultipartFile> files) throws IOException {
        String imgDirPrefix = PathUtils.getResourcesPath(ModuleEnum.FILE.getName()) +
                FileUtils.SEPARATOR +
                UploadConstant.UPLOAD_PREFIX +
                FileUtils.SEPARATOR;

        List<FileUploadDTO> fileUploadDTOS = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String fileExtensionName = StringUtils.getExtensionName(file.getOriginalFilename());
                String key = UUID.randomUUID().toString() + "." + fileExtensionName;
                File dstFile = new File(imgDirPrefix + key);
                file.transferTo(dstFile);

                FileUploadDTO fileUploadDTO = new FileUploadDTO(file.getOriginalFilename(), key);
                fileUploadDTOS.add(fileUploadDTO);
            }
        }

        return fileUploadDTOS;
    }
}
