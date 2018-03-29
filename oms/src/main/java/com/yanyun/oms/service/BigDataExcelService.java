package com.yanyun.oms.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * zhaoziyu excel生成
 */
public interface BigDataExcelService {
    void writeToExcel(List<Map<String, String>> values, List<String> colsName, File file, List<String> fieldNames) throws IOException;

    void writeToExcel(List objs, File file)throws IOException;
}
