package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		/*
		Pessoa p1 = new Pessoa(null, "Diego", "diego@gmail.com"); //banco de dados que vai atribuir o id pra elas
		Pessoa p2 = new Pessoa(null, "Fiego", "fiego@gmail.com");
		Pessoa p3 = new Pessoa(null, "Giego", "giego@gmail.com");
		*/
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-spring-hibernate");
		EntityManager em = emf.createEntityManager();
		
		/*
	    em.getTransaction().begin();
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		em.getTransaction().commit();
		*/
		
		
		Pessoa p = em.find(Pessoa.class, 2); //buscar pessoa por id
		em.getTransaction().begin();
		em.remove(p); //pra remover tem que estar monitorado e nao destacado, ou seja, tem que ser algo que criou ou que buscou, no banco de dados
		System.out.println(p);
		em.getTransaction().commit();
		
		
		System.out.println("Pronto");
		em.close();
		emf.close();
	}

}
