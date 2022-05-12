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
public class TestePersistirPermissao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Permissao pusuario = new Permissao();
        pusuario.setNome("USUARIO");
        pusuario.setDescricao("Usuário Simples");
        Permissao padmin = new Permissao();
        padmin.setNome("ADMINISTRADOR");
        padmin.setDescricao("Usuario Admin");
        em.getTransaction().begin();
        em.persist(pusuario);
        em.persist(padmin);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
