package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private EntityManagerFactory emf;

   @PersistenceUnit
   public void setEntityManagerFactory(EntityManagerFactory emf) {
      this.emf = emf;
   }

   @Override
   public void saveUser(User user) {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      em.persist(user);
      em.getTransaction().commit();
      em.close();
   }
   @Override
   public void updateUser(User user) {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      em.merge(user);
      em.getTransaction().commit();
      em.close();
   }
   @Override
   public User getUserById(long id) {
      EntityManager em = emf.createEntityManager();
      User user = em.find(User.class, id);
      em.close();
      return user;
   }
   @Override
   public void removeUserById(long id) {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      User user = em.find(User.class, id);
      em.remove(user);
      em.getTransaction().commit();
      em.close();
   }
   @Override
   @SuppressWarnings("unchecked")
   public List<User> getAllUsers() {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      List<User> users = em.createQuery("from User").getResultList();
      em.getTransaction().commit();
      em.close();
      return users;
   }
   @Override
   public void cleanUsersTable() {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      em.createQuery("delete from User").executeUpdate();
      em.getTransaction().commit();
      em.close();
   }
}
