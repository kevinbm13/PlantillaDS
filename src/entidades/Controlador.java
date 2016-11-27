package entidad;

import java.io.File;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;



public class Controlador {
	private Documento documento;
	private LectorXml lector;
	private Usuario usuario;
	
	public Controlador(){
		documento=new Seccion("0");
		lector=new LectorXml();
		
		
	}
//-----------------------------------------------------------------------------------------------------------
	public void crearSeccion(String idSeccion){
		Documento d=new Seccion(idSeccion);
		documento.add(d);	
	}
//-------------------------------------------------------------------------------------------------------
	public void crearElemento(String idElemento){
		Documento d=new Elemento(idElemento);
		documento.add(d);
		
	
	}
//----------------------------------------------------------------------------------------------------------
	public void eliminar(String idSeccion){
		documento.remove(idSeccion);
		
	}
	

	
	public void crearEstructura(){
		
		lector.leer(documento);
		
		
	}
	//-------------------------------------------------------------------------------------
	//Modificar Parte Aspectos Generales(Liista tiene lo que escribio el usuario,)
	public void modificarAspectosGenerales(List<String>texto){
		usuario=new Gestor();
		List<Documento>d=documento.getListaSeccion();
		Documento c= d.get(0);
		usuario.modificarPlantilla(c, texto);
	}
	//------------------------------------------------------------------------------------
	//CrearPlantillas a partir de una existente Datos para hacer la ruta del fichero
	//Datos para hacer el la direcciond del repositorio y la de las plantillas
	public void crearPlantillas(List<String>datos) throws CloneNotSupportedException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
		String direccion=null;
		Documento d=(Documento) documento.Clonar();
		crearDirectorio(direccion);
		crearArchivoXml(direccion,d);
		
	}
	//------------------------------------------------------------------------------------------------
	//hace repositorio
	
	public void crearDirectorio(String dato) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
		
		File directorio=new File("C:\\Users\\gollo\\Desktop\\Juan"); 
		directorio.mkdir(); 
		;
		
	}
	//--------------------------------------------------------------------------------------------------------
	//Para craer el archivo con la estructura y ponerla en el repositorio
	public void crearArchivoXml(String dato,Documento k) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
		LectorXml xml=new LectorXml();
		Document d=(Document) xml.crearArchivo();
		List<Documento> lista=k.getListaSeccion();
		Element raiz = d.createElement("Plantilla");
		d.appendChild(raiz);
		crearTags(d,raiz,lista,"C:\\Users\\gollo\\Desktop\\Juan"+".xml");
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------
	public void crearTags(Document d,Element raiz,List<Documento>lista,String direccion) throws TransformerFactoryConfigurationError, TransformerException{
		
		for(int x=0;x<lista.size();x++){
			
			
			if(lista.get(x).getListaSeccion()!=null){
				Element seccion= d.createElement("Seccion");
				seccion.setAttribute("id", lista.get(x).getId());
				raiz.appendChild(seccion);
				crearTags(d,seccion,lista.get(x).getListaSeccion(),direccion);
			}
			else{
				Element seccion= d.createElement("Elemento");
				seccion.setAttribute("id", lista.get(x).getId());
				 Text text = d.createTextNode("dta");
				 seccion.appendChild(text);

				raiz.appendChild(seccion);
			}
		}
		Source source = new DOMSource(d);
        //Indicamos donde lo queremos almacenar
        Result result = new StreamResult(new java.io.File(direccion)); //nombre del archivo
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
	}

		
		
		
	
		
	
	}
	
	

	

