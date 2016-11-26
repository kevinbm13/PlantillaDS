package entidad;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librer�as
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
            	Documento d = new Elemento(nodoHijo.getAttributeValue("name"));
            	documento.add(d);
            
            }
            else{
            	Documento seccion=new Seccion(nodoHijo.getAttributeValue("name"));
            	documento.add(seccion);
            	crearEstructura(nodoHijo,seccion);
            }
            
           
            
           
        }
		
	}

}