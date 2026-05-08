package com.uc.ppt;

import cn.hutool.core.io.FileUtil;
import com.uc.util.PptxUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * PPTX 模板引擎 - 自动替换文字与图片
 */
public class PptxUtilTest {

    @Test
    public void createPptx() {
        // 1. 配置路径
        String filePathPrefix = "/Users/administrator/Desktop/pptx";
        String templatePath = filePathPrefix + "/template.pptx";
        String outputPath = filePathPrefix + "/output.pptx";
        String imagePath = filePathPrefix + "/1.png";
        FileUtil.del(outputPath);
        // 2. 准备替换数据 (Key 为模板中的占位符)
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("${title}", "2026年度业务报告");
        dataMap.put("${author}", "Gemini AI");
        dataMap.put("${date}", "2026-05-07");
        // 约定：以 {image 开头的键将被识别为图片路径，替换掉对应的文本框
        dataMap.put("${image1}", imagePath);
        dataMap.put("${titleImage1}", "这是Image Title");
        dataMap.put("${image2}", imagePath);
        dataMap.put("${image3}", imagePath);
        dataMap.put("${image4}", imagePath);
        // 3. 执行处理
        PptxUtil.processPptx(templatePath, outputPath, dataMap, "${image");
    }


}