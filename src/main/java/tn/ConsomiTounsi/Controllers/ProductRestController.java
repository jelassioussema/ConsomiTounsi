package tn.ConsomiTounsi.Controllers;




import java.util.List;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import tn.ConsomiTounsi.Entities.Product;
import tn.ConsomiTounsi.Repositories.ProductRep;
import tn.ConsomiTounsi.Services.ProductService;
import tn.ConsomiTounsi.Utils.GeneratePdfReport;
import tn.ConsomiTounsi.Utils.QRCodeGenerator;




@RestController
@Transactional
@EnableAutoConfiguration
@RequestMapping(value ="/product")
public class ProductRestController {
	@Autowired
	ProductService ser;
	@Autowired
	ProductRep pr;

	  


	private static final String QR_CODE_IMAGE_PATH = "src/main/resources/QRCode" ;
	private static final String BAR_CODE_IMAGE_PATH = "src/main/resources/" ;

	
	
	@PostMapping("/save")
	@ResponseBody
	public void save(@RequestBody Product product) throws Exception  {
		/* String path = "src/main/resources/123456789101.png" ;
		
		BufferedImage bf = ImageIO.read(new FileInputStream(path));
		
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
				new BufferedImageLuminanceSource(bf)));
		
		Result result = new MultiFormatReader().decode(bitmap);
		if( result.getText().substring(0, 3)=="123"){
			product.setBarcode(result.getText());
		}
		else {
		*/
		

		  Calendar currentDate = Calendar.getInstance();
		  Date d =currentDate.getTime();
		  
		  product.setDateProduct(d);
		// for (int i = 0; i <ServiceProduct.getAllProducts().size(); i++){
		// String name= pr.getClass().getName();
		// long id=product.getUser().getIdUser();
		 String bar = product.getBarcode();
		if (bar.length()==12 || bar.length()==13 && bar.substring(0,2)=="619")
		{
			if (bar.substring(0,3).equals("619"))
			{
				System.out.println(bar);
				System.out.println(bar.substring(0,3));

		ser.saveOrUpdate(product);

		QRCodeGenerator.generateQRCodeImage(bar, QR_CODE_IMAGE_PATH + product.getBarcode() + ".png");
		QRCodeGenerator.GenerateBarcode(bar, BAR_CODE_IMAGE_PATH + product.getBarcode() + ".png");
			}}
		else {
			System.out.println("Invalid Bar Code");
		}
		}

	
	
	
	@GetMapping("/list")
	public List<Product> listproduct(){
			
		
			
			return ser.getAllproduct();
		}
	
	@DeleteMapping("/delete/{id}")
	public  String deleteproduct(@PathVariable(value = "id")int id){
		
		ser.deleteproduct(id);
		return "Deleted succesfully id= "+id;
	}
	
	@PutMapping("/update/{id}")
	public Product updateproduct(@PathVariable (value = "id")int id,@RequestBody Product product)
	{
		
		return ser.updateproduct(id, product);
	}
	
	@GetMapping("/recherche/{name}")
	public List<Product> recherche(@PathVariable String name)
	{	
			return (List<Product>)pr.recherche(name);
		}
	
	
	@PostMapping("/file")

	public Product uploddImage(@RequestParam("file") @Nullable MultipartFile file,@RequestParam("id") int id) {
		Product product = pr.findById(id).get();
		if (file == null) {
			product.setImageProduct("defaultPic.jpg");
			pr.save(product);
		} else {
			try {
				File f = new File("C:\\wamp64\\www\\ImageProducts\\" + file.getOriginalFilename());
				file.transferTo(f);
				product.setImageProduct(file.getOriginalFilename());
				pr.save(product);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
			return product;
		}
		

	

/*
	  @GetMapping("/excel")
	  public ResponseEntity<Resource> getFile() {
	    String filename = "products.xlsx";
	    InputStreamResource file = new InputStreamResource(fileService.load());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	        .body(file);
	  }
	  */
    
    @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {

    	List<Product> pr =ser.getAllproduct();

        ByteArrayInputStream bis = GeneratePdfReport.ProductReport(pr);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=productreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
   
  
	@GetMapping("/search/{name}")
	public List<Product> findProducts(@PathVariable String name)
	{	
			return pr.findProducts(name);
		}
	/*


	 @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        //String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
	        String headerValue = "attachment; filename=DisabledDM_.xlsx";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Product> list = pr.findAll();
	   
	        serviceproduct excelExporter = new serviceproduct(list);
	         
	        excelExporter.export(response);    
	    }  
  */
}

