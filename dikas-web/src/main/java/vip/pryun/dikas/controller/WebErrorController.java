package vip.pryun.dikas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import vip.pryun.dikas.enums.Msg;
import vip.pryun.dikas.exception.BizException;
import vip.pryun.dikas.object.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class WebErrorController implements ErrorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebErrorController.class);
    private static final String ERROR_PATH = "/error";

    @Autowired
    ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(ERROR_PATH)
    public Result error(HttpServletRequest request, HttpServletResponse response) {
        WebRequest req = new ServletWebRequest(request);
        Map<String, Object> attrs = errorAttributes.getErrorAttributes(req, false);

        if (response.getStatus() == HttpServletResponse.SC_NOT_FOUND) {
            return Result.error(404, "Not found!");
        }
        return Result.error(response.getStatus(), "").setContent(attrs);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Result> bizException(ValidationException e) {
        return new ResponseEntity<>(Result.error(Msg.E40011.code(), e.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Result> bizException(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(Result.error(Msg.E40011.code(), Msg.E40011.message), HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Result> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();

        List<String> list = new ArrayList<>();
        for (ObjectError error : result.getAllErrors()) {
            FieldError fe = (FieldError) error;
            list.add(String.format("【%s.%s】%s", fe.getObjectName(), fe.getField(), fe.getDefaultMessage()));
        }
        return new ResponseEntity<>(Result.error(Msg.E40011).setMessages(list), HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Result> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        Result result = Result.error(Msg.E40012.code(), e.getMessage());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Result> bizException(MaxUploadSizeExceededException e) {
        Result result = Result.error(Msg.E40013.code(), e.getMessage());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Result> bizException(AccessDeniedException e) {
        Result result = Result.error(Msg.E40003.code(), Msg.E40003.message);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ExceptionHandler(BizException.class)
    public ResponseEntity<Result> bizException(BizException e) {
        return new ResponseEntity<>(e.toResult(), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result> exception(Exception e) {
        LOGGER.error(">>> 未知异常信息：" + e.getMessage(), e);
        Result<Object> result = Result.error(Msg.E40000).setContent(e.getClass().getName());
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
