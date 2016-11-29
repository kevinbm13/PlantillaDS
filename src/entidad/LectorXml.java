package entidad;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librer�as
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder;

public class LectorXml {
	String nombre=null;
	public String getNombre() {
		return nombre;
	}
//----------------------------------------------------------------------------------
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//---------------------------------------------------------------------------------

	public List<String> obtenerUsuarios(String nombre){
		List<String> datos = new ArrayList<String>();
		SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File( "C:\\Users\\Flo\\Documents\\PlantillaDS\\usuario.xml" );
	    //C:\\Users\\gollo\\Desktop\\eclipse\\usuario.xml
	    //
	    try
	    {
	        //Se crea el documento a traves del archivo
	        Document document = (Document) builder.build( xmlFile );
	 
	        //Se obtiene la raiz 'tables'
	        Element rootNode = document.getRootElement();
	      
	        List<Element> list = rootNode.getChildren();
	       
	        for(int x=0;x<list.size();x++){
	        	
	        	if(list.get(x).getAttributeValue("name").equals(nombre)){
	        		System.out.println(list.get(x).getAttributeValue("password"));
	        		datos.add(list.get(x).getAttributeValue("password"));
	        		datos.add(list.get(x).getAttributeValue("rol"));
	        	}
	        }
	 
		        
		    }catch ( IOException io ) {
		        System.out.println( io.getMessage() );
		    }catch ( JDOMException jdomex ) {
		        System.out.println( jdomex.getMessage() );
		    }
		    return datos;
	
	}
	 
	
	
//--------------------------------------------------------------------
	public Documento leer(Documento documento,String nombrePlantilla){
		 SAXBuilder builder = new SAXBuilder();
		 File fichero = new File(nombrePlantilla);
		    File xmlFile = new File( fichero.getAbsolutePath() );//
		    nombre=fichero.getAbsolutePath();
		    try
		    {
		        //Se crea el documento a traves del archivo
		        Document document = (Document) builder.build( xmlFile );
		 
		        Element rootNode = document.getRootElement();//Plantilla
		     
		        crearEstructura(rootNode,documento,document);        
		        
		    }catch ( IOException io ) {
		        System.out.println( io.getMessage() );
		    }catch ( JDOMException jdomex ) {
		        System.out.println( jdomex.getMessage() );
		    }
		    return documento; 
	}
//--------------------------------------------------------------------------------------------------------
	
	public void crearEstructura(Element nodo,Documento documento,Document c){
		Element nodoRaiz=c.getRootElement();
		List<Element> nodosHijos= nodo.getChildren();
	    for ( int i = 0; i<nodosHijos.size(); i++ )
        {
           
            Element nodoHijo = (Element) nodosHijos.get(i);//Se obtiene el elemento
            List<Element> nodosHijosSecundarios=nodoHijo.getChildren();
            if(nodosHijosSecundarios.size()!=0 || nodoHijo.getParent()==nodoRaiz ){
            	Documento seccion=new Seccion(nodoHijo.getAttributeValue("id"),nodoHijo.getAttributeValue("name"));
            	documento.add(seccion);
            	crearEstructura(nodoHijo,seccion,c);
            }
            else{
            	Documento d = new Elemento(nodoHijo.getAttributeValue("id"),nodoHijo.getAttributeValue("name"));
            	d.setContenido(nodoHijo.getText());
            	documento.add(d);
            	
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