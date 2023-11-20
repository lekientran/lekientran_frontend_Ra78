package com.vti.frontEnd;

import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import com.vti.entity.Group;

public class TestHibernateProgram {

    public static void main(String[] args) {
        // get session
        Session session = null;
        try {
            session = HibernateUtils.buildSessionFactory().openSession();

            Group group = new Group();
            group.setName("SQL");

            session.save(group);

            System.out.println("Create success!");

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
