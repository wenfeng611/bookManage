package cn.edu.suda.bookmanagement.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class ExcelEasyPoiUtils {
    /**
     * @param sheetName 工作表名称
     * @param title  导出表名
     * @param filename  导出excel名
     * @param pojoClass entity.class
     * @param dataSet 导出的数据
     * @param response
     */
    public static void exportWithTitleAndSheetName(String sheetName, String title,String filename, Class<?> pojoClass, Collection<?> dataSet, HttpServletResponse response)throws IOException{
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(title,sheetName),pojoClass, dataSet);
        response.setHeader("content-disposition", "attachment;filename="+filename+".xls");
        workbook.write(response.getOutputStream());
    }

    public static void export(String filename,Class<?> pojoClass, Collection<?> dataSet, HttpServletResponse response)throws IOException{
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), pojoClass, dataSet);
        response.setHeader("content-disposition", "attachment;filename="+filename+".xls");
        workbook.write(response.getOutputStream());
    }
}
