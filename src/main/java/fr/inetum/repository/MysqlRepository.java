package fr.inetum.repository;

import fr.inetum.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class MysqlRepository<T> {

    public void save(T object){

        // Ouverture d'une session Hibernate
        Session session = HibernateUtils.getSession();


        // Début de la transaction
        Transaction tx = session.beginTransaction();

        //Enregistrements de l'objet
        session.save(object);

        tx.commit();
        session.close();
    }

    public T get(int id, Class<T> type){
        Session session = HibernateUtils.getSession();
        Transaction tx = session.beginTransaction();
        T object = session.get(type, id);
        tx.commit();
        session.close();

        return object;
    }

    public List<T> getAll(Class<T> type){
        Session session = HibernateUtils.getSession();
        Transaction tx = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery query = criteriaBuilder.createQuery(type);
        Root<T> root = query.from(type);

        CriteriaQuery<T> all = query.select(root);
        TypedQuery<T> allQuery = session.createQuery(all);
        tx.commit();
        return allQuery.getResultList();
    }


    /**
     * Delete the object parameter in the database
     * @param object
     */
    public void delete(T object) {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Update the object parameter in the database
     * @param object
     */
    public void update(T object) {
        Session session = HibernateUtils.getSession();
        Transaction tx = session.beginTransaction();
        session.update(object);
        tx.commit();
        session.close();
    }

}
