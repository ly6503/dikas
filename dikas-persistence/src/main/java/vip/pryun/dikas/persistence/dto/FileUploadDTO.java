package vip.pryun.dikas.persistence.dto;

import java.io.Serializable;

/**
 * @author 59941
 * @date 2019/6/3 12:14
 */
public class FileUploadDTO implements Serializable {

    private static final long serialVersionUID = 5061789862723987680L;
    /**
     * 上传文件文件名
     */
    private String fileName;
    /**
     * 保存文件的key
     */
    private String key;

    public FileUploadDTO(String fileName, String key) {
        this.fileName = fileName;
        this.key = key;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
