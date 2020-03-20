package com.example.demo.controller;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @description: ImageController <br>
 * @date: 2020/3/10 16:45 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 */
@RestController
@RequestMapping("/image")
public class ImageController {


    @ApiOperation(value = "获取二维码", notes = "获取用户信息二维吗")
    @GetMapping(value = "/qrcode/{id}")
    public void getQRCode( HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store");
        // 不设置缓存
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/png");

        QrConfig config = new QrConfig(300, 300);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 设置前景色，既二维码颜色（青色）
        // config.setForeColor(Color.CYAN.getRGB());
        // 设置背景色（灰色）
        //config.setBackColor(Color.GRAY.getRGB());
        // config.setRatio();
        //config.setImg(new File(yyUser.getThumbImg()));
        QrCodeUtil.generate(//
                "https://hutool.cn/", //二维码内容
                config, //附带logo
                "png",
                response.getOutputStream()//写出到的文件
        );



    }
}
