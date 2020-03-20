package com.example.demo.boot.uitls;

import cn.hutool.core.img.Img;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description: ImageU <br>
 * @date: 2020/3/10 16:35 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 */
public class ImageU {

    public static BufferedImage getQrImage() {
        QrConfig qrConfig = new QrConfig();
        qrConfig.setHeight(113);
        qrConfig.setWidth(113);
        BufferedImage bufferedImage = QrCodeUtil.generate("https://hutool.cn/", qrConfig);
        return bufferedImage;
    }


    public static void doBuild() throws IOException {
       /* ClassPathResource classPathResource = new ClassPathResource("/static/images/a_1x_share_live.png");
        File file = classPathResource.getFile();*/
        BufferedImage baseBufferedImage;// = ImgUtil.read("D:/var/image/a_1x_share_live.png");
        baseBufferedImage = ImageIO.read(new File("D:/var/image/a_1x_share_live.png"));
        Console.log("he=" + baseBufferedImage.getHeight());
        Console.log("he=" + baseBufferedImage.getMinTileY());
        Console.log("he=" + baseBufferedImage.getMinY());
        Graphics2D baseGp = baseBufferedImage.createGraphics();

        /*classPathResource = new ClassPathResource("/static/images/a_1x_share_live.png");
        file = classPathResource.getFile();*/
        BufferedImage coverBufferedImage = ImgUtil.read("D:/var/image/b_1x_share_live.png");
        baseGp.drawImage(coverBufferedImage, 0, 760, null);
        baseGp.dispose();
        File imageFile = new File("D:/var/image/test.png");
        ImgUtil.write(baseBufferedImage, imageFile);
    }

    public static BufferedImage doBuildFirst() {
        Img img = Img.from(new File("D:/var/image/6.png"));
        img = img.scale(35, 36, Color.darkGray);
        img = img.round(0.8);
        Image image = img.getImg();
        ImgUtil.write(image, new File("D:/var/image/avart.png"));
        return ImgUtil.toBufferedImage(image);
    }



    public static BufferedImage doBuildSecond() {

        String pressText = "来自与皮卡丘的分享";
        BufferedImage baseBufferedImage = ImgUtil.read("D:/var/image/c_1x_share_live.png");

        System.out.println(baseBufferedImage.getHeight());
        Graphics2D baseGp = baseBufferedImage.createGraphics();
        Font font = new Font(null, Font.PLAIN, 24);
        baseGp.setFont(font);
        baseGp.drawImage(doBuildFirst(), 7, 4, null);
        //   GraphicsUtil.drawString(baseGp,"来自与皮卡丘的分享",null,null,241, 23);

        // 抗锯齿
        baseGp.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        baseGp.setFont(font);
        // 透明度
        //baseGp.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1));
        // 在指定坐标绘制水印文字
        final FontMetrics metrics = baseGp.getFontMetrics(font);
        final int textLength = metrics.stringWidth(pressText);
        final int textHeight = metrics.getAscent() - metrics.getLeading() - metrics.getDescent();
        baseGp.drawString(pressText, 51, Math.abs(baseBufferedImage.getHeight() + textHeight) / 2 - 1);
        baseGp.dispose();

        File imageFile = new File("D:/var/image/banner.png");
        ImgUtil.write(baseBufferedImage, imageFile);

        return baseBufferedImage;
    }


    /**
     * @param srcImg     原图片
     * @param destImg    目标位置
     * @param width      期望宽
     * @param height     期望高
     * @param equalScale 是否等比例缩放
     */
    public static void reSize(File srcImg, File destImg, int width,
                              int height, boolean equalScale) {
        String type = getImageType(srcImg);
        if (type == null) {
            return;
        }
        if (width < 0 || height < 0) {
            return;
        }

        BufferedImage srcImage = null;
        try {
            srcImage = ImageIO.read(srcImg);
            System.out.println("srcImg size=" + srcImage.getWidth() + "X" + srcImage.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        if (srcImage != null) {
            // targetW，targetH分别表示目标长和宽
            BufferedImage target = null;
            double sx = (double) width / srcImage.getWidth();
            double sy = (double) height / srcImage.getHeight();
            // 等比缩放
            if (equalScale) {
                if (sx > sy) {
                    sx = sy;
                    width = (int) (sx * srcImage.getWidth());
                } else {
                    sy = sx;
                    height = (int) (sy * srcImage.getHeight());
                }
            }
            System.out.println("destImg size=" + width + "X" + height);
            ColorModel cm = srcImage.getColorModel();
            WritableRaster raster = cm.createCompatibleWritableRaster(width, height);
            boolean alphaPremultiplied = cm.isAlphaPremultiplied();

            target = new BufferedImage(cm, raster, alphaPremultiplied, null);
            Graphics2D g = target.createGraphics();
            // smoother than exlax:
            //g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            // 抗锯齿
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.drawRenderedImage(srcImage, AffineTransform.getScaleInstance(sx, sy));
            g.rotate(0.);
            g.dispose();
            // 将转换后的图片保存
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(target, type, baos);
                FileOutputStream fos = new FileOutputStream(destImg);
                fos.write(baos.toByteArray());
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取文件后缀不带.
     *
     * @param file 文件后缀名
     * @return
     */
    private static String getImageType(File file) {
        if (file != null && file.exists() && file.isFile()) {
            String fileName = file.getName();
            int index = fileName.lastIndexOf(".");
            if (index != -1 && index < fileName.length() - 1) {
                return fileName.substring(index + 1);
            }
        }
        return null;
    }


    public static void main(String[] args) throws IOException {
        //doBuildSecond();
        //doBuild();
        doBuildFirst();
        reSize(new File("D:/var/image/6.png"),
                new File("D:/var/image/6avatar.png"),
                35, 36, true);
        reSize(new File("D:/var/image/6.png"),
                new File("D:/var/image/6avatar2.png"),
                35, 36, false);


    }

}
