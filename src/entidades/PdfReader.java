package entidad;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PdfReader {

		public void escribiir(String text1,String text2,String path,int x,int y ) throws IOException{
			File file = new File(path); 
			PDDocument doc = PDDocument.load(file);
			PDPage page = doc.getPage(0);
			@SuppressWarnings("deprecation")
			PDPageContentStream contentStream = new PDPageContentStream(doc, page, true,true);
			contentStream.beginText();
			contentStream.newLineAtOffset(25,700);
			
			contentStream.setFont( PDType1Font.TIMES_ROMAN, 16);
			contentStream.setLeading(10.4);
			contentStream.newLine();
			contentStream.drawString(text1);
			contentStream.newLine(); 
			contentStream. showText(text2);
			contentStream.newLine(); 
			contentStream.endText();
			contentStream.close();
			doc.save(path);
			doc.close();
		}
		
public void crearDocumentoPdf(String ruta) throws IOException{
	PDDocument document = new PDDocument();    
	PDPage my_page = new PDPage();
	document.addPage(my_page);

    //Saving the document
    document.save(ruta);
       
    System.out.println("PDF created");  
  
    //Closing the document  
    document.close();
}
	
		
}
