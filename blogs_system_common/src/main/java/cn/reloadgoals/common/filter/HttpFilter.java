package cn.reloadgoals.common.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决ajax跨域请求
 * 使用@WebFilter注解配置过滤
 * @author TranbinLee
 * @date 2019/10/5
 */
@Component
@WebFilter(urlPatterns = "/", filterName = "HttPFilter")
public class HttpFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            HttpServletRequest request = (HttpServletRequest)servletRequest;

            String origin = request.getHeader("Origin");
            response.setHeader("Access-Control-Allow-Origin", origin);
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            String method = request.getMethod();
            if(method.equalsIgnoreCase("OPTIONS")){
                servletResponse.getOutputStream().write("Success".getBytes("utf-8"));
            }else{
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }

}
