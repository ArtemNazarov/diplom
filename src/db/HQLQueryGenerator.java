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
        deleteQuery(session, id);
        selectQuery(session, tableList);
        tx.commit();
        session.close();
    }

    public void deleteQuery(Session session, int id) {
        Query query = session.createQuery("delete from " + getMyType().getSimpleName() + " where id = :id");
        query.setParameter("id", id);
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

    public void generateUpdateQuery(List<T> tableList, Object[] fields, Object[] parameters) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        updateQuery(session, fields, parameters);
        selectQuery(session, tableList);
        tx.commit();
        session.close();
    }

    public void updateQuery(Session session, Object[] fields, Object[] parameters) {
        String q = "update " + getMyType().getSimpleName() + " SET ";
        for (int i = 0; i < fields.length - 1; i++) {
            q += fields[i + 1] + "= :param" + i;
            if (i != fields.length - 2)
                q += ',';
        }
        q += "WHERE " + fields[0] + " = :id";
        Query query = session.createQuery(q);
        for (int i = 0; i < fields.length; i++) {
            query.setParameter(fields[i].toString(), parameters[i]);
        }
    }

//    public void changeEmployee(ActionEvent actionEvent) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tx = session.beginTransaction();
//        EmployeesEntity.class.getDeclaredFields();
//        Query query = session.createQuery("update EmployeesEntity SET snp= :snpParam, city = :city, address = :address, phone = :phone, birthdate= :birthDate, seat = :seat, department = :dep, institution = :inst WHERE id = :id");
//        query.setParameter("id", Integer.parseInt(idEmployeeField.getText()));
//        query.setParameter("snpParam", snpEmployeeField.getText());
//        query.setParameter("birthDate", birthDateEmployeeField.getValue());
//        query.setParameter("city", cityEmployeeField.getText());
//        query.setParameter("address", addressEmplField.getText());
//        query.setParameter("phone", phoneEmployeeField.getText());
//        query.setParameter("inst", Integer.parseInt(institutionField.getText()));
//        query.setParameter("dep", Integer.parseInt(departmentEmployeeField.getText()));
//        query.setParameter("seat", Integer.parseInt(seatEmployeeField.getText()));
//        query.executeUpdate();
//        selectSeats(session);
//        tx.commit();
//        session.close();
//    }

}
