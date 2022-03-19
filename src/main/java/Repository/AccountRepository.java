package Repository;

import Entity.Account;
import org.hibernate.SessionFactory;

import java.util.List;

public class AccountRepository extends GenericRepositoryImpl<Account, Long>{
    private SessionFactory sessionFactory = SessionFactoryConnection.getInstance();

    public Account findById(Long id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            var a = session.find(Account.class, id);
            session.getTransaction().commit();
            return a;
        }
    }
    public Account findByUserName(String username) {
        try (var session = sessionFactory.openSession()) {
            String hql = " FROM Entity.Account a " +
                    " WHERE a.userName = :username ";
            var query = session.createQuery(hql, Account.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        }
    }

    public List<Account> findAll() {
        var session = sessionFactory.openSession();
        String hql = " FROM Entity.Account a ";
        var query = session.createQuery(hql, Account.class);
        return query.getResultList();
    }

    public Account login(String username, String password) {
        var session = sessionFactory.openSession();
        String hql = " FROM Entity.Account a " +
                " WHERE a.userName = :username " +
                " AND a.password = :password ";
        var query = session.createQuery(hql, Account.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.getSingleResult();
    }

}
