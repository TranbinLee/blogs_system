package cn.reloadgoals.common.exception;

import cn.reloadgoals.common.vo.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author TranbinLee
 * @date 2019/10/4
 */
@Component
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 自定义异常处理
     * @param e
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler
    public ResponseBean<?> processException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        StackTraceElement[] ele = e.getStackTrace();
        String className = ele[0].getClassName();
        String methodName = ele[0].getMethodName();
        Integer line = ele[0].getLineNumber();
        logger.info("Exception:{} 发生位置为： {} {} [{}] ",e.getMessage(),className,methodName,line);

        if(e instanceof ParamException){
            return new ResponseBean<>(((ParamException) e).getRespCode(),((ParamException) e).getMsgKey());
        }

        if (e instanceof MissingServletRequestParameterException) {
            return new ResponseBean("400", e.getMessage());
        }

        if (e instanceof DuplicateKeyException) {
            logger.error("=======违反主键约束：主键重复插入=======");
            return new ResponseBean<>("400", "主键重复插入！");
        }

        /**
         * 未知异常
         */
        logger.error("【系统异常】{} {}",e.getMessage(),e);
        return new ResponseBean<>("500","SYSTEM_ERROR",e.getMessage(),null);
    }


}
