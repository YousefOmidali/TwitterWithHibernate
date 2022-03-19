package Repository;

import Entity.Account;
import Entity.Twit;
import org.hibernate.SessionFactory;

import java.util.List;

public class TwitRepository extends GenericRepositoryImpl<Twit, Long> {
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
        String hql = " FROM Entity.Twit ";
        var query = session.createQuery(hql, Twit.class);
        return query.getResultList();
    }
    // String hql = "select id, twit FROM Entity.Twit t ";

}//select Twit.id , Twit.twit ,Twit.account.userName ,Twit.account.id
//TypedQuery<Media> query = em.createQuery("SELECT NEW package_name.Media(m.title, b.isbn, b.authors)"
//+ " FROM Book b, Media m", Media.class);