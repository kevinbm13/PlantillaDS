package entidad;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PdfReader {

		@SuppressWarnings("deprecation")
		public void escribiir(String text1,String path ) throws IOException{
			
			File file = new File(path); 
			PDDocument doc = PDDocument.load(file);
			PDPage page = doc.getPage(0);
		
			PDPageContentStream contentStream = new PDPageContentStream(doc, page, true,true);
			contentStream.beginText();
			contentStream.newLineAtOffset(25,700);
			contentStream.setFont( PDType1Font.TIMES_ROMAN, 16);
			contentStream.setLeading(14f);
			contentStream.newLine(); 
			contentStream.showText(text1);
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