package Repository;

import Entity.Account;
import Entity.Comment;
import org.hibernate.SessionFactory;

import java.util.List;

public class CommentRepository extends GenericRepositoryImpl<Comment, Long> {
    private SessionFactory sessionFactory = SessionFactoryConnection.getInstance();

    public Comment findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var a = session.find(Comment.class, id);
            session.getTransaction().commit();
            return a;
        }
    }

    public List<Comment> findAll(Long twitId) {
        try (var session = sessionFactory.openSession();) {
            String hql = " FROM Entity.Comment c where twit.id = :twit_id  ";
            var query = session.createQuery(hql, Comment.class);
            query.setParameter("twit_id", twitId);  //c Where Comment.twit.id = :twit_id
            return query.getResultList();
        }
    }
}
//FROM Employee e INNER JOIN Team t ON e.Id_team=t.Id_team
//Inner join Entity.Account a on c.account_id=a.id
