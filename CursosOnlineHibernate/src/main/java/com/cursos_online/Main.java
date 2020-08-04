package com.cursos_online;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.cursos_online.entidades.Curso;
import com.cursos_online.entidades.Estudiante;

public class Main {

	 static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
	 static SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	 
	public static void main(String[] args) {
		Curso cur1 = new Curso(0,"fundamnetos de java");
		Curso cur2 = new Curso(0,"fundamnetos para principiantes");
		
		ingresarCurso(cur1);
		ingresarCurso(cur2);
		
		Estudiante es1 = new Estudiante(0,"joel", "olivos");
		Estudiante es2 = new Estudiante(0,"yadira" ,"suqui");
		
		ingresarEstudiante(es1);
		ingresarEstudiante(es2);
		
		List<Curso>curso=getCurso();
		
		for(Curso temp:curso) {
			System.out.print(temp);
			
		}
			
			List<Estudiante>estudiante=getEstudiante();
			
			for(Estudiante tem:estudiante) {
				System.out.print(tem);
		}
			
		//List<Estudiante> estudiantes = getEstudiantesPorNombre("olivos");
		//for(Estudiante e:estudiantes) {
			//System.out.println(e);
			//}
		
		
	
	
	Curso curso1= new Curso(1,"matematicas");
	modificarCursos(curso1);
	
	Estudiante estudiante1= new Estudiante(3,"choez","perroso");
	modificarEstudiante(estudiante1);
}
	static void modificarCursos(Curso curso)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(curso);
		session.getTransaction().commit();
		session.close();
		
	}
	static void eliminarCurso(int id ) 
	{
		
	}
	
	
	
    static void modificarEstudiante(Estudiante estudiante) 
    {
    	Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(estudiante);
		session.getTransaction().commit();
		session.close();	
	}
	static void eliminarEstudiante(int id ) 
	{}
		


	
	//static List<Estudiante>getEstudiantesPorNombre(String nombre){
	//Session session = sessionFactory.openSession();
	//Query query= session
			//.createQuery("form Estudiante where nombre=:nombre");
	//query.setParameter("nombre", nombre);
	//List<Estudiante> estudiantes =(List<Estudiante>)query.getResultList();
	//return estudiantes;
	//}
	
	
	static List<Estudiante>getEstudiante(){
		Session session = sessionFactory.openSession();
		List<Estudiante>estudiante = session.createQuery("from Estudiante",Estudiante.class).list();
		return estudiante;
		
	}
	static List<Curso> getCurso(){
		Session session = sessionFactory.openSession();
		List<Curso>curso = session.createQuery("from Curso",Curso.class).list();
		return curso;
	}
	static void ingresarEstudiante(Estudiante estudiante) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(estudiante);
		
		session.getTransaction().commit();
		session.close();

	}
	static void ingresarCurso(Curso curso) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(curso);
		
		session.getTransaction().commit();
		session.close();

	}

}
