package tn.ConsomiTounsi.Utils;




import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Hashtable;



import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;



public class QRCodeGenerator {

		public static void generateQRCodeImage(String text ,String filePath)
	            throws WriterException, IOException {
	        QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 350, 350);

	        Path path = FileSystems.getDefault().getPath(filePath);
	        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	       
	    }
		public static void GenerateBarcode(String text ,String filePath)
	            throws WriterException, IOException {
		    EAN13Writer barcodeWriter = new EAN13Writer();
		    BitMatrix bitMatrix = barcodeWriter.encode(text, BarcodeFormat.EAN_13, 300, 150);

	        Path path = FileSystems.getDefault().getPath(filePath);
	        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	       
	    }

		public static void getBarCodeImage(String text, String filePath) {
			try {
				Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
				hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
				Writer writer = new Code128Writer();
				BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.CODE_128, 300, 300);
				Path path = FileSystems.getDefault().getPath(filePath);
				MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
				
			} catch (Exception e) {
				
			}
		}
		
		public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
		    QRCodeWriter qrCodeWriter = new QRCodeWriter();
		    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		    
		    ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
		    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
		    byte[] pngData = pngOutputStream.toByteArray(); 
		    return pngData;
		}
		
		public static void generateEAN13BarcodeImage(String barcodeText , String filePath) throws Exception {
		    EAN13Writer barcodeWriter = new EAN13Writer();
		    BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.EAN_13, 300, 150);
		    
		    Path path = FileSystems.getDefault().getPath(filePath);
	        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

		   
		}
		
		

}


