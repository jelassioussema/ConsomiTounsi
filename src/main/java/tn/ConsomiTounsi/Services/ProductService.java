package tn.ConsomiTounsi.Services;





import java.util.List;

/*import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ConsomiTounsi.Entities.Product;
import tn.ConsomiTounsi.Repositories.ProductRep;






@Service
@Transactional
public class ProductService implements IProductService {
	@Autowired 
	ProductRep prp;
	@Override
	public List<Product> getAllproduct() {
		// TODO Auto-generated method stub
		return prp.findAll();
	}

	@Override
	public Product getByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Product product) {
		// TODO Auto-generated method stub
		prp.save(product);
	}

	@Override
	public void deleteproduct(int id) {
		// TODO Auto-generated method stub
		prp.deleteById(id);
	}

	@Override
	public Product updateproduct(int id, Product product) {
		// TODO Auto-generated method stub
		Product pr1 = prp.findById(id).get();
		pr1.setNameproduct(product.getNameproduct());
		pr1.setBarcode(product.getBarcode());
		pr1.setPriceproduct(product.getPriceproduct());
		pr1.setQuantityproduct(product.getQuantityproduct());
		pr1.setWeightproduct(product.getWeightproduct());
		
		
		
		return prp.save(pr1);
	}
	
/*	private XSSFWorkbook workbook;
   private XSSFSheet sheet;
    private List<Product> list;
    
    public serviceproduct(List<Product> list) {
        this.list = list;
        workbook = new XSSFWorkbook();
    }
    
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Product List");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "ID Product", style);      
        createCell(row, 1, "Name", style);       
        createCell(row, 2, "PicProduct", style);    
       
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Product dm : list) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++,dm.getIdproduct() , style);
            createCell(row, columnCount++,dm.getNameproduct() , style);
            createCell(row, columnCount++,dm.getPicproduct() , style);
            
            
             
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }

	*/
}
