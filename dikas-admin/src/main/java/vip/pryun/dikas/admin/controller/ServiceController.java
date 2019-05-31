package vip.pryun.dikas.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vip.pryun.dikas.admin.vo.ServiceSaveVO;
import vip.pryun.dikas.admin.vo.ServiceUpdateVO;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.common.util.bean.BeanMapper;
import vip.pryun.dikas.domain.ServiceBean;
import vip.pryun.dikas.service.biz.IServiceService;

import javax.validation.Valid;
import java.util.Date;


/**
 * @author 董大大
 * @date 2019/5/31 13:42
 * @Descript
 */
@RestController
@RequestMapping("/admin/service")
@Api(tags = "服务支持")
public class ServiceController {

    private IServiceService service;

    public ServiceController(IServiceService service){
        this.service = service;
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存服务")
    public Result<Boolean> save(@Validated @RequestBody ServiceSaveVO serviceSaveVO){
        ServiceBean serviceBean = BeanMapper.map(serviceSaveVO, ServiceBean.class);
        serviceBean.setEntryDt(new Date());
        serviceBean.setEntryId(1L);
        serviceBean.setEntryName("admin");
        boolean flag = service.save(serviceBean);
        return Result.success(flag);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改服务")
    public Result<Boolean> update(@Validated @RequestBody ServiceUpdateVO updateVO){
        ServiceBean serviceBean = BeanMapper.map(updateVO, ServiceBean.class);
        boolean flag = service.updateById(serviceBean);
        return Result.success(flag);
    }
}
