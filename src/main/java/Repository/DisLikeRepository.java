package Repository;

import Entity.Account;
import Entity.DisLike;
import org.hibernate.SessionFactory;

import java.util.List;

public class DisLikeRepository extends GenericRepositoryImpl<DisLike, Long> {
    private SessionFactory sessionFactory = SessionFactoryConnection.getInstance();

    public DisLike findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var a = session.find(DisLike.class, id);
            session.getTransaction().commit();
            return a;
        }
    }

    public List<DisLike> findAll() {
        var session = sessionFactory.openSession();
        String hql = " FROM Entity.DisLike a";
        var query = session.createQuery(hql, DisLike.class);
        return query.getResultList();
    }
}
