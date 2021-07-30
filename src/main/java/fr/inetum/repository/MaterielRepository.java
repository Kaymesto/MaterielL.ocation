package fr.inetum.repository;

import fr.inetum.Utils.HibernateUtils;
import fr.inetum.beans.Materiel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaterielRepository extends MysqlRepository<Materiel> {

    public List<Materiel> getMaterieuxDate(Date date){

        // Ouverture d'une session Hibernate
        Session session = HibernateUtils.getSession();


        // Début de la transaction
        Transaction tx = session.beginTransaction();

        Query q = session.createQuery("from Materiel m inner join Location l where m.id = l.id" +
                " and 1626732000000 between l.dateDebut and l.dateFin");


        ArrayList<Materiel>listeMateriel = (ArrayList<Materiel>)q.getResultList();

                tx.commit();

        return listeMateriel;
    }
}
