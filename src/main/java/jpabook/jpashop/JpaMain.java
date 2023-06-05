package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            tx.commit();
//에러없이 완료시 커밋
        } catch (Exception e) {
            //에러발생시 롤백
            tx.rollback();

        } finally {
            //에러나든 완료되든 일단닫아
            em.close();
        }


        //code
        emf.close();
    }
}
