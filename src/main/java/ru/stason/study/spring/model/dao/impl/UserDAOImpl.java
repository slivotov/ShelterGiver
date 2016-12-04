package ru.stason.study.spring.model.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.stason.study.spring.model.dao.UserDAO;
import ru.stason.study.spring.persist.entities.User;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
//@Transactional //todo discuss transactions
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public UserDAOImpl() {
    }

    public UserDAOImpl(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //todo investigate session issue, maybe stateless session is needed
    //or open-close session in each method??
    private Session getSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (final HibernateException e) {
            return sessionFactory.openSession();
        }
    }

    @Override
    public List<User> list() {
        final CriteriaQuery<User> criteriaQuery = getSession()
                .getCriteriaBuilder()
                .createQuery(User.class);

        final Root<User> from = criteriaQuery.from(User.class);

        criteriaQuery.select(from);

        return getSession().createQuery(criteriaQuery).getResultList();
    }

    @Override
    public User getById(final int id) {
        return null;
    }

    @Override
    public User getByName(final String name) {
        final CriteriaBuilder builder = getSession()
                .getCriteriaBuilder();
        final CriteriaQuery<User> criteriaQuery = builder
                .createQuery(User.class);

        final Root<User> from = criteriaQuery.from(User.class);

        criteriaQuery.select(from);
        criteriaQuery.where(builder.equal(from.get("user_name"), name));

        try {
            return getSession().createQuery(criteriaQuery).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void saveOrUpdate(final User user) {
        getSession().save(user);
    }

    @Override
    public void delete(final int id) {

    }
}
