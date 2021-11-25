package com.rion.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HttpServletResponse  res= (HttpServletResponse) response;
       res.setHeader("Access-Control-Allow-Origin","*");
       res.setHeader("Access-Control-Allow-Methods","POST,PUT,GET,OPTIONS,DELETE");
       res.setHeader("Access-Control-Max-Age","3600");
       res.setHeader("Access-Control-Allow-Headers","Origin");
       res.setHeader("Access-Control-Allow-Credentials", "true");
       res.setHeader("Pragma", "no-cache");
       chain.doFilter(request,response);
    }
}
