package entidad;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
		documento=new Seccion("0","Plantilla");
		lector=new LectorXml();
		
		
	}
//---------------------------------------------------------------------------------------------------------------
	public void crearSeccion(String idSeccion,String idNombre){
		Documento d=new Seccion(idSeccion,idNombre);
		documento.add(d);	
	}
//-----------------------------------------------------------------------------------------------------------------
	public void crearElemento(String idElemento,String idNombre) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
		Documento d=new Elemento(idElemento,idNombre);
		documento.add(d);
		crearArchivoXml(lector.getNombre(), documento);
		
	
	}
//------------------------------------------------------------------------------------------------------------------
	public void eliminar(String idSeccion){
		documento.remove(idSeccion);
		
	}
	
//-----------------------------------------------------------------------------------------------------------------
	
	public void crearEstructura(String nombrePlantilla){
		
		lector.leer(documento,nombrePlantilla);
	}
	
	
//--------------------------------------------------------------------------------------------
//ModificaAspectosOperativos(Lista tiene lo que escribio el usuario)
	public void modificarAspectosOperativos(List<String>p){
		usuario=new Profesor();
		List<Documento>d=documento.getListaSeccion();
		for(int x=1;x<d.size();x++){
			
			usuario.modificarPlantilla(d.get(x),p );
		}
		
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
	
//-----------------------------------------------------------------------------------------------------------
	public List<Documento> obtenerElementos(){
		List<Documento>seccion=documento.getListaSeccion();
		List<Documento>seccionNueva=new ArrayList<Documento>();
		for(int x=0;x<seccion.size();x++){
			if(seccion.get(x).getListaSeccion()==null){
				System.out.println(seccion.get(x).getNombre());
				seccionNueva.add(seccion.get(x));
				obtenerHijoSeccion(seccion.get(x),seccionNueva);
			}
			seccionNueva.add(seccion.get(x));
		}
		return seccion;
		
	}
//-------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------
	public List<Documento> obtenerSecciones(){
		List<Documento>seccion=documento.getListaSeccion();
		List<Documento>seccionNueva=new ArrayList<Documento>();
		for(int x=0;x<seccion.size();x++){
			if(seccion.get(x).getListaSeccion()!=null){
				System.out.println(seccion.get(x).getNombre());
				seccionNueva.add(seccion.get(x));
				obtenerHijoSeccion(seccion.get(x),seccionNueva);
			}
			System.out.println(seccion.get(x).getNombre());
			seccionNueva.add(seccion.get(x));
		}
		return seccion;
		
	}
	
//---------------------------------------------------------------------------------------------
	public void obtenerHijoSeccion(Documento d,List<Documento>seccionNueva){
		List<Documento>seccion=d.getListaSeccion();
		for(int x=0;x<seccion.size();x++){
			if(seccion.get(x).getListaSeccion()!=null){
				System.out.println(seccion.get(x).getNombre());
				seccionNueva.add(seccion.get(x));
				obtenerHijoSeccion(seccion.get(x),seccionNueva);
			}
		}
		
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
//Crea los TAGS para formar el xml
//--------------------------------------------------------------------------------------------------------------------------------------------------
	public void crearTags(Document d,Element raiz,List<Documento>lista,String direccion) throws TransformerFactoryConfigurationError, TransformerException{
		
		for(int x=0;x<lista.size();x++){
			
			
			if(lista.get(x).getListaSeccion()!=null){
				Element seccion= d.createElement("Seccion");
				seccion.setAttribute("id", lista.get(x).getId());
				seccion.setAttribute("name", lista.get(x).getNombre());
				raiz.appendChild(seccion);
				crearTags(d,seccion,lista.get(x).getListaSeccion(),direccion);
			}
			else{
				Element seccion= d.createElement("Elemento");
				seccion.setAttribute("id", lista.get(x).getId());
				seccion.setAttribute("name", lista.get(x).getNombre());
				 Text text = d.createTextNode(lista.get(x).getContenido());
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
//-----------------------------------------------------------------------------------------------------------
//EscribirPDF
	public void escribirPdfPlantilla(String direccion) throws IOException{
		int linea1=10;
		int linea2=50;
		PdfReader escritor=new PdfReader();
		List<Documento>lista=documento.getListaSeccion();
		escritor.crearDocumentoPdf(direccion);
		crearLineas(escritor,lista,direccion,linea1,linea2);
	}
		
//---------------------------------

		public void crearLineas(PdfReader reader,List<Documento>lista,String direccion,int linea1,int linea2) throws IOException{
			linea1=linea1+50;
			linea2=linea2+200;
			
			for(int x=0;x<lista.size();x++){
				
				
				if(lista.get(x).getListaSeccion()!=null){
					System.out.println(lista.get(x).getNombre());
					reader.escribiir(lista.get(x).getId(), lista.get(x).getNombre(), direccion,linea1,linea2);
					crearLineas(reader,lista.get(x).getListaSeccion(),direccion,linea1,linea2);
				}
				else{
					reader.escribiir(lista.get(x).getId(), lista.get(x).getNombre(), direccion,linea1,linea2);
				}
			}
		}
	
	}
	
	

	

