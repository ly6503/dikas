package vip.pryun.dikas.file.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class FileUploadResultVO implements Serializable {

    private static final long serialVersionUID = 655032589028622876L;

    @ApiModelProperty("上传文件文件名")
    private String fileName;

    @ApiModelProperty("保存文件的key")
    private String key;

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
