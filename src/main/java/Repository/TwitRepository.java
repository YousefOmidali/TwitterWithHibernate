package Repository;

import Entity.Account;
import Entity.Twit;
import org.hibernate.SessionFactory;

import java.util.List;

public class TwitRepository extends GenericRepositoryImpl<Twit, Long>{
    private SessionFactory sessionFactory = SessionFactoryConnection.getInstance();

    public Twit findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var a = session.find(Twit.class, id);
            session.getTransaction().commit();
            return a;
        }
    }

    public List<Twit> findAll() {
        var session = sessionFactory.openSession();
        String hql = " FROM Entity.Twit t";
        var query = session.createQuery(hql, Twit.class);
        return query.getResultList();
    }
}
