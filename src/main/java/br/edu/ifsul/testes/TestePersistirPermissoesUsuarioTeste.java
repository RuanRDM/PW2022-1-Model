package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorgebavaresco@ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirPermissoesUsuarioTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Usuario u = em.find(Usuario.class, "jorgebavaresco");
        Permissao padmin = em.find(Permissao.class, "ADMINISTRADOR");
        padmin.getUsuarios().add(u);
        em.getTransaction().begin();
        em.persist(padmin);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
