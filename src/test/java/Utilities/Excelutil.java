package Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutil {
 
		Workbook workbook = null;

		public Sheet readExcel(String filePath, String fileName, String sheetName)
				throws IOException, InvalidFormatException {

			File filepath = new File(filePath + "\\" + fileName);

			FileInputStream file = new FileInputStream(filepath);

			String fileExtensionName = fileName.substring(fileName.indexOf("."));

			if (fileExtensionName.equals(".xlsx"))
			{
				workbook = new XSSFWorkbook(file);
			}
			else if (fileExtensionName.equals(".xls"))

			{
				workbook = new HSSFWorkbook(file);

			}

			Sheet sheet = workbook.getSheet(sheetName);

			return sheet;

		}

}

