package Repository;

import Entity.Liking;
import org.hibernate.SessionFactory;

import java.util.List;

public class LikeRepository extends GenericRepositoryImpl<Liking, Long>{
    private SessionFactory sessionFactory = SessionFactoryConnection.getInstance();

    public Liking findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var a = session.find(Liking.class, id);
            session.getTransaction().commit();
            return a;
        }
    }

    public List<Liking> findAll() {
        var session = sessionFactory.openSession();
        String hql = " FROM Entity.Liking a ";
        var query = session.createQuery(hql, Liking.class);
        return query.getResultList();
    }
}
