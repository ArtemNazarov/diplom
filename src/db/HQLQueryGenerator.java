package db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sessionFactory.HibernateSessionFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class HQLQueryGenerator<T> {

    private final Class<T> classType;

    public HQLQueryGenerator(Class<T> type) {
        this.classType = type;
    }

    public Class<T> getMyType() {
        return this.classType;
    }


    public void generateSelectQuery(List<T> tableList) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        selectQuery(session, tableList);
        tx.commit();
        session.close();
    }

    public void selectQuery(Session session, List<T> tableList) {
        Query query = session.createQuery("from " + getMyType().getSimpleName());
        List<T> elements = query.list();
        tableList.clear();
        tableList.addAll(elements);
    }

    public void generateDeleteQuery(List<T> tableList, int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        deleteQuery(session, tableList, id);
        tx.commit();
        session.close();
    }

    public void deleteQuery(Session session, List<T> tableList, int id) {
        Query query = session.createQuery("delete from " + getMyType().getSimpleName() + " where id = :id");
        query.setParameter("id",id);
        List<T> elements = query.list();
        tableList.clear();
        tableList.addAll(elements);
    }

//    public void generateDeleteQuery(List<T> tableList, Object... fields) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        deleteQuery(session, tableList, fields);
//        tx.commit();
//        session.close();
//    }
//
//    public void deleteQuery(Session session, List<T> tableList, Object[] fields) {
//        Query query = session.createQuery("delete from " + getMyType().getSimpleName() + " where " + " fields[i] = :id");
//        query.setParameter("id",id);
//        List<T> elements = query.list();
//        tableList.clear();
//        tableList.addAll(elements);
//    }

    public void generateUpdateQuery(List<T> tableList) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        updateQuery(session, tableList);
        tx.commit();
        session.close();
    }

    public void updateQuery(Session session, List<T> tableList) {
        Query query = session.createQuery("delete from " + getMyType().getSimpleName());
        List<T> elements = query.list();
        tableList.clear();
        tableList.addAll(elements);
    }

}
