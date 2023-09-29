package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	
	public static void main(String[] args) {
		//Obtener la conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		//Crear manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//Proceso
		Usuario u = new Usuario();
		u.setCod_usua(123);
		u.setNom_usua("Juan");
		u.setApe_usua("Perez");
		u.setUsr_usua("jperez");
		u.setCla_usua("7854");
		u.setFna_usua("2000/01/15");
		u.setIdtipo(1);
		u.setEst_usua(1);
		
		//Usuario u = new Usuario(321, "Maria", "Lopez", "mlopez", "maryl", "2005/05/14", 1, 1);
		
		//Insertar into tb_xxx values
		//Si el proceso es: regis, actu, elim -> necesitan : transacciones
		
		em.getTransaction().begin();
		em.persist(u);
		
		// update tb_xxx set campo=? ..... where....
		em.merge(u);
		//delete from tb_xxx where
		em.remove(u);
		
		//Select * from tb_xxx where id=?
		Usuario x = em.find(Usuario.class, 1);
		
		em.getTransaction().commit();
		System.out.println("Registro OK");
		
		em.close();
	}

}
