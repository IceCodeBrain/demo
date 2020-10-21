package com.example.demo.boot.uitls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.info.MultimediaInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.channels.FileChannel;

/**
 * @description: MediaUtils <br>
 * @date: 2020/10/21 10:43 <br>
 * @author: PWB <br>
 * @since: 1.0 <br>
 */
public class MediaUtils {

    private static Logger log = LoggerFactory.getLogger(MediaUtils.class);

    /**
     * 获取时长
     */
    public static long getDuration(File file) {
        long ls = 0;
        try {
            MultimediaObject instance = new MultimediaObject(file);
            instance.getFile();
            MultimediaInfo result = instance.getInfo();
            result.getVideo().getSize();
            ls = result.getDuration() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    /**
     * 获取时长
     */
    public static String getDuration(String fileUrl) {
        String length = "";
        try {
            URL source = new URL(fileUrl);
            MultimediaObject instance = new MultimediaObject(source);
            instance.getFile();
            MultimediaInfo result = instance.getInfo();
            result.getVideo().getSize();
            long ls = result.getDuration() / 1000;
            int hour = (int) (ls / 3600);
            int minute = (int) (ls % 3600) / 60;
            int second = (int) (ls - hour * 3600 - minute * 60);
            String hr = Integer.toString(hour);
            String mi = Integer.toString(minute);
            String se = Integer.toString(second);
            if (hr.length() < 2) {
                hr = "0" + hr;
            }
            if (mi.length() < 2) {
                mi = "0" + mi;
            }
            if (se.length() < 2) {
                se = "0" + se;
            }
            length = hr + ":" + mi + ":" + se;
        } catch (Exception e) {
            log.error("获取视频信息失败", e);
        }
        return length;
    }


    /**
     * 视频大小
     */
    public static String getSize(File source) {
        FileChannel fc = null;
        String size = "";
        try {
            FileInputStream fis = new FileInputStream(source);
            fc = fis.getChannel();
            BigDecimal fileSize = new BigDecimal(fc.size());
            size = fileSize.divide(new BigDecimal(1024 * 1024), 2, RoundingMode.HALF_UP) + "MB";
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fc) {
                try {
                    fc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return size;
    }
    /**
     * 获取https://image-store-all.oss-cn-beijing.aliyuncs.com/xymnTSJZwZ.mp4
     * 时长信息和大小信息
     */
    public static void main(String[] args) {
        try {
            String url = "https://image-store-all.oss-cn-beijing.aliyuncs.com/xymnTSJZwZ.mp4";
            File file = TempFileUtils.createTempFile(url);
            System.out.println("视频大小：" + file.length() / 1024 + "kb");
            System.out.println("视频大小：" + getSize(file) );
            System.out.println("视频时长：" + getDuration(url));
        } catch (Exception e) {
            log.error("获取视频信息失败", e);
        }
    }
}
