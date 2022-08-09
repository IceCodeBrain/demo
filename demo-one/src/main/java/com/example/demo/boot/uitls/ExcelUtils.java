package com.example.demo.boot.uitls;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.io.OutputStream;
import java.util.List;


public class ExcelUtils {

    public static void exportExcelStream(List list, Class clazz, String title, OutputStream outputStream) {
        ExcelWriter excelWriter = EasyExcelFactory.write(outputStream).build();
        //将要输出的内容填充到Sheet里
        WriteSheet sheet = new WriteSheet();
        //设置sheet表名
        sheet.setSheetName(title);
        sheet.setSheetNo(1);
        sheet.setClazz(clazz);
        sheet.setNeedHead(true);
        excelWriter.write(list, sheet);
        excelWriter.finish();
    }


}



