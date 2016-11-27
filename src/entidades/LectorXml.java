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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
		      
		        documento.incluir();
		       
		        
		        
		           
		        
		    }catch ( IOException io ) {
		        System.out.println( io.getMessage() );
		    }catch ( JDOMException jdomex ) {
		        System.out.println( jdomex.getMessage() );
		    }
		    return documento; 
	}
	
	public void crearEstructura(Element nodo,Documento documento){
		List<Element> nodosHijos= nodo.getChildren();
	    for ( int i = 0; i<nodosHijos.size(); i++ )
        {
           
            Element nodoHijo = (Element) nodosHijos.get(i);//Se obtiene el elemento
            List<Element> nodosHijosSecundarios=nodoHijo.getChildren();
            if(nodosHijosSecundarios.size()==0){
            	Documento d = new Elemento(nodoHijo.getAttributeValue("id"));
            	documento.add(d);
            
            }
            else{
            	Documento seccion=new Seccion(nodoHijo.getAttributeValue("id"));
            	documento.add(seccion);
            	crearEstructura(nodoHijo,seccion);
            }
            
           
            
           
        }
		
	}
	
public void obtenerNodos(String id) throws SAXException, IOException, ParserConfigurationException{
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	Document doc = (Document) builder.parse(new File("ruta//al//archivo.xml"));

	// 2. buscar y eliminar el elemento <enfermera id="3"> de entre 
//	    muchos elementos <enfermera> ubicados en cualquier posicion del documento
	NodeList items = ((org.w3c.dom.Document) doc).getElementsByTagName("enfermera");

	}

}


