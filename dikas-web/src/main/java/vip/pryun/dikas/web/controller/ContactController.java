package vip.pryun.dikas.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.pryun.dikas.common.object.Result;
import vip.pryun.dikas.persistence.dto.ContactDTO;
import vip.pryun.dikas.service.biz.IContactService;
import vip.pryun.dikas.web.vo.ContactVO;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cj
 * @since 2019-05-30
 */
@RestController
@RequestMapping("/web/dikas/contact")
@Api(tags = "联系我们控制器")
public class ContactController extends BaseController {

    private final IContactService contactService;

    public ContactController(IContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(value = "getContact")
    @ApiOperation(value = "查询联系我们的信息", notes = "查询联系我们的信息")
    public Result getContact() {
        ContactDTO dto = contactService.getContact();
        return newResult(dto, ContactVO.class);
    }
}
