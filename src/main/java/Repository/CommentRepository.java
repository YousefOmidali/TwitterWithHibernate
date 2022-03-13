package Repository;

import Entity.Account;
import Entity.Comment;
import org.hibernate.SessionFactory;

import java.util.List;

public class CommentRepository extends GenericRepositoryImpl<Comment, Long>{
    private SessionFactory sessionFactory = SessionFactoryConnection.getInstance();

    public Comment findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var a = session.find(Comment.class, id);
            session.getTransaction().commit();
            return a;
        }
    }

    public List<Comment> findAll() {
        var session = sessionFactory.openSession();
        String hql = " FROM Entity.Comment c";
        var query = session.createQuery(hql, Comment.class);
        return query.getResultList();
    }
}
