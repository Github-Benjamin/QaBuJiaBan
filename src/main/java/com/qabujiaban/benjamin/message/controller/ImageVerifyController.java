package com.qabujiaban.benjamin.message.controller;

import com.qabujiaban.benjamin.message.entity.TestVo;
import com.qabujiaban.benjamin.message.service.MessageService;
import com.qabujiaban.benjamin.message.util.GetIPCity;
import com.qabujiaban.benjamin.message.util.ImageVerify;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class ImageVerifyController {

    /**
     * Session Key
     */
    public final static String SESSION_KEY_IMAGE_CODE = "SESSION_KEY_IMAGE_CODE";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private MessageService messageService;


    /**
     * 生成图片验证码接口
     */
    @GetMapping("/imageVerify")
    public void imageVerify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final ImageVerify.ImageCode imageCode = new ImageVerify(
                68,/** 验证码图片宽度*/
                36,/** 验证码图片长度*/
                4,/** 验证码位数*/
                32,/** 验证码字体大小*/
                60,/** 验证码有效时间(秒)*/
                2,/** x轴距*/
                28/** y轴距*/
        ).create();

        sessionStrategy.setAttribute(
                new ServletWebRequest(request),
                SESSION_KEY_IMAGE_CODE,
                imageCode
        );

        ImageIO.write(imageCode.getImage(), "jpeg", response.getOutputStream());
        response.getOutputStream().flush();

    }


    /**
     * 验证接口
     */
    @PostMapping(value = "/verify", produces = {"application/json; charset=UTF-8"})
    public Map<String, String> verify(TestVo testVo, ServletWebRequest servletWebRequest, HttpServletRequest request) {

        // 获取用户请求的ip并解析ip所在的省份
        String message_ip = GetIPCity.GetRequestIP(request);
        testVo.setMessage_ip(message_ip);
        // 解析ip  可能存在获取失败的问题修复
        testVo.setMessage_city(GetIPCity.GetRequestCity(message_ip));

        final ImageVerify.ImageCode imageCode = (ImageVerify.ImageCode) sessionStrategy.getAttribute(servletWebRequest, SESSION_KEY_IMAGE_CODE);

        Map<String, String> m = new HashMap<>();

        if (StringUtils.isBlank(testVo.getCode())) {
            m.put("message", "验证码不能为空！");
            return m;
        }

        if (imageCode == null) {
            m.put("message", "验证码不存在！");
            return m;
        }

        if (imageCode.isExpire()) {
            sessionStrategy.removeAttribute(servletWebRequest, SESSION_KEY_IMAGE_CODE);
            m.put("message", "验证码已过期！");
            return m;
        }

        if (!StringUtils.equalsIgnoreCase(imageCode.getCode(), testVo.getCode())) {
            m.put("message", "验证码不正确！");
            return m;
        }

        sessionStrategy.removeAttribute(servletWebRequest, SESSION_KEY_IMAGE_CODE);



        // 评论数据，写入数据库;
        messageService.MessageInsert(testVo);

        m.put("message", "成功");
        return m;

    }




}
