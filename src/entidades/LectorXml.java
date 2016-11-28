package entidad;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librerías
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder;

public class LectorXml {
	
	public Documento leer(Documento documento){
		 SAXBuilder builder = new SAXBuilder();
		    File xmlFile = new File( "C:\\Users\\gollo\\Desktop\\plantilla.xml" );
		    try
		    {
		        //Se crea el documento a traves del archivo
		        Document document = (Document) builder.build( xmlFile );
		        Element rootNode = document.getRootElement();//Plantilla
		      
		        crearEstructura(rootNode,documento);        
		        
		    }catch ( IOException io ) {
		        System.out.println( io.getMessage() );
		    }catch ( JDOMException jdomex ) {
		        System.out.println( jdomex.getMessage() );
		    }
		    return documento; 
	}
//--------------------------------------------------------------------------------------------------------
	
	public void crearEstructura(Element nodo,Documento documento){
		List<Element> nodosHijos= nodo.getChildren();
	    for ( int i = 0; i<nodosHijos.size(); i++ )
        {
           
            Element nodoHijo = (Element) nodosHijos.get(i);//Se obtiene el elemento
            List<Element> nodosHijosSecundarios=nodoHijo.getChildren();
            if(nodosHijosSecundarios.size()==0){
            	
            	Documento d = new Elemento(nodoHijo.getAttributeValue("id"),nodoHijo.getAttributeValue("name"));
            	d.setContenido(nodoHijo.getText());
            	documento.add(d);
            
            }
            else{
            	Documento seccion=new Seccion(nodoHijo.getAttributeValue("id"),nodoHijo.getAttributeValue("name"));
            	documento.add(seccion);
            	crearEstructura(nodoHijo,seccion);
            }
            
           
            
           
        }
		
	}
	
//------------------------------------------------------------------------------------------------------------
public org.w3c.dom.Document crearArchivo() throws ParserConfigurationException {
	  
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// elemento raiz
			org.w3c.dom.Document doc = docBuilder.newDocument();
			return doc;


}

//-------------------------------------------------------------------------------------------------------

}

