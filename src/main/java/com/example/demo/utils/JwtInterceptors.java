package com.example.demo.utils;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class JwtInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        // 获取请求中的token令牌
        String token = request.getHeader("token");

        if(token == null){
            map.put("status", 500);
            map.put("msg", "token为空!");

            response.getWriter().println(map);
            return false;
        }

        try {
            // 验证令牌
            JwtUtil.verifyToken(token);
            // 放行请求
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg", "无效签名!");
        } catch (TokenExpiredException e){
            e.printStackTrace();
            map.put("msg", "token过期!");
        }catch (ArithmeticException e){
            e.printStackTrace();
            map.put("msg", "token算法不一致!");
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg", "token验证失败!");
        }

        // 失败状态
        map.put("status", 500);

        response.getWriter().println(map);

        return false;
    }
}
