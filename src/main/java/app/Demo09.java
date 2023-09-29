package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

public class Demo09 {

	// Listado de TODOS los usuarios, segun un criterio (filtro)

	public static void main(String[] args) {
		String usuario = JOptionPane.showInputDialog("Ingrese Usuario: ");
		String clave = JOptionPane.showInputDialog("Ingrese clave: ");

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();

		// select * from tb_usuarios where usr_usua = ? and cla_usua =? -->lista
		String jpql = "select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla";
		try {
			Usuario u = em.createQuery(jpql, Usuario.class).setParameter("xusr", usuario).setParameter("xcla", clave)
					.getSingleResult();

			//mostrar el contenido del usuario
			JOptionPane.showMessageDialog(null, "Bienvenido " +  u.getNom_usua());
			//abrir ventana principal
			FrmManteProd v = new FrmManteProd();
			v.setVisible(true);
			// dispose();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: Usuario o clave incorrecto");
		}

		em.close();
	}

}
