package com.vti.backend.repository;

import com.vti.entity.Account;
import com.vti.entity.Role;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class AccountRepositoryV2 implements IAccountRepository{
    private Session session;

    @Override
    public List<Account> getAllAccount() throws SQLException {
        session = HibernateUtils.buildSessionFactory().openSession();
        // Tạo câu lệnh HQL. Cách 1
        Query<Account> query = session.createQuery("FROM Account");
        // Tạo câu lệnh SQL. Cách 2
//        NativeQuery<Account> nativeQuery = session.createSQLQuery("SELECT * FROM `Account`");
        return query.getResultList();
    }

    @Override
    public void createAccount(Account account) throws SQLException {
        account.setRole(Role.EMPLOYEE);

        session = HibernateUtils.buildSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(account); // Cách 3: Sử dụng method của Hibernate -> Thực hiện các chức năng
        session.getTransaction().commit();
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        session = HibernateUtils.buildSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(account); // Cách 3: Sử dụng method của Hibernate -> Thực hiện các chức năng
        session.getTransaction().commit();
        System.out.println("Update thành công!");

    }

    @Override
    public Account findById(int id) throws SQLException {
        session = HibernateUtils.buildSessionFactory().openSession();
        Account account = session.get(Account.class, id);
        return account;
    }

    @Override
    public void deleteById(int id) {
        session = HibernateUtils.buildSessionFactory().openSession();
        String hql = "DELETE FROM Account Where id = :accountID";
        Query<Account> query = session.createQuery(hql);
        query.setParameter("accountID", id);
        session.getTransaction().begin();

        int affectedRows = query.executeUpdate();
        session.getTransaction().commit();
        if (affectedRows < 1){
            System.err.println("Xoá khôgn thành công!");
        } else {
            System.out.println("Xoá thành công!");
        }
    }

    @Override
    public Account findByName(String name) throws SQLException {
        return null;
    }
}
