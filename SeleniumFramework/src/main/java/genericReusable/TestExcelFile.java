package genericReusable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcelFile {

	private static String path = System.getProperty("user.dir") + "\\src\\test\\resources\\";
	private static XSSFSheet sheet = null;
	private static FileInputStream fis = null;
	private static XSSFWorkbook workbook = null;

	public static void main(String[] args) {
		

		for (int i = 0; i < cell("Create_Account", "GarmentOrder_NoGrp", "Customer").size(); i++) {
			System.out.println(cell("Create_Account", "GarmentOrder_NoGrp", "Customer").get(i));

		}
		// System.out.println(Arrays.toString(cell(
		// "Create_Account","GarmentOrder_NoGroup","Customer").toArray()));
	}

	public static List<String> cell(String WrokBookName, String sheetName, String Column_Name) {
		String envFilePath = path + WrokBookName + ".xlsx";
		List<String> cells = new ArrayList<String>();

		try {
			fis = new FileInputStream(envFilePath);
			workbook = new XSSFWorkbook(fis);

			// Get the first sheet.
			int index = workbook.getSheetIndex(sheetName);
			Sheet sheet = workbook.getSheetAt(index);

			// we will search for column index containing string "Your Column
			// Name" in the row 0 (which is first row of a worksheet
			String columnWanted = Column_Name;
			Integer columnNo = null;

			// Get the first cell.
			Row row = sheet.getRow(0);
			// Cell cell = row.getCell(0);
			for (Cell cell : row) {
				// Column header names.
				// System.out.println(cell.toString());
				if (cell.getStringCellValue().equals(columnWanted)) {
					columnNo = cell.getColumnIndex();
				}
			}

			if (columnNo != null) {
				for (Row row1 : sheet) {
					Cell c = row1.getCell(columnNo);
					// if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK)
					if (c == null) {
						// Nothing in the cell in this row, skip it
						break;
					} else {
						String b = c.toString();
						cells.add(b);

						// System.out.println(c);
					}
				}

			} else {
				System.out.println("could not find column " + columnWanted + " in first row of " + sheetName);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		// }
		// }

		return cells.stream().distinct().collect(Collectors.toList());
	}

}