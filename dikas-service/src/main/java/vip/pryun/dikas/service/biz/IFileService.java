package vip.pryun.dikas.service.biz;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 文件 服务类
 * </p>
 *
 * @author 7yan1h
 * @since 2019-05-29
 */
public interface IFileService {

    void upload(List<MultipartFile> files) throws IOException;
}
