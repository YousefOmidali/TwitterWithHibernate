package Repository;

import Entity.Account;
import Entity.Replay;
import org.hibernate.SessionFactory;

import java.util.List;

public class ReplayRepository extends GenericRepositoryImpl<Replay, Long>{
    private SessionFactory sessionFactory = SessionFactoryConnection.getInstance();

    public Replay findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var a = session.find(Replay.class, id);
            session.getTransaction().commit();
            return a;
        }
    }

    public List<Replay> findAll() {
        var session = sessionFactory.openSession();
        String hql = " FROM Entity.Replay r";
        var query = session.createQuery(hql, Replay.class);
        return query.getResultList();
    }
}
