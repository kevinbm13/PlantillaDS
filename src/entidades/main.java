package entidades;

public class main {
	public static void main(String[] args){
		Documento d=new Seccion("Plantilla");
		Documento d1=new Seccion("1 Aspectos Relativos");
		Documento e= new Elemento("1.1 Datos Generales del Curso");
		Documento e1=new Elemento("1.2 Descripción General");
		Documento e2=new Elemento("1.3 Objetivos Generales y Específicos");
		Documento e3=new Elemento("1.4 Contenido Temático");
		
		Documento d2 =new Seccion("2. Aspectos Operativos");
		Documento f= new Elemento("2.1 Evaluación");
		Documento f1=new Elemento("2.2 Bibliografía");
		Documento f2=new Elemento("2.3 Datos del Profesor");
	
		d.add(d1);
		d.add(d2);
		
		d1.add(e);
		d1.add(e1);
		d1.add(e2);
		d1.add(e3);
		
		
		d2.add(f);
		d2.add(f1);
		d2.add(f2);
		
		d.incluir();
		
		
	}
}
