package com.baobaotao.annotationshibernate;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.annotations.*;


import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

public class Test {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    // 增加
    public int add(String fname, String lname, int salary){
        Session session = ourSessionFactory.openSession();
        TEmployeeEntity employeeEntity = new TEmployeeEntity(fname, lname, salary);
        Transaction tx = null;
        int e_id = 0;
        try{
            tx = session.beginTransaction();
            e_id = (Integer) session.save(employeeEntity);
            tx.commit();
        }catch (HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return e_id;
    }
    // 选择
    public void select(){
        Session session = ourSessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List employees = session.createQuery(" FROM TEmployeeEntity").list();
            Iterator iterator = employees.iterator();
            while (iterator.hasNext()){
                TEmployeeEntity tEmployeeEntity = (TEmployeeEntity) iterator.next();
                System.out.println("ID: " + tEmployeeEntity.getId());
                System.out.println("Fname: " + tEmployeeEntity.getFname());
                System.out.println("Lname: " + tEmployeeEntity.getLname());
                System.out.println("salary: " + tEmployeeEntity.getSalary());
            }
            tx.commit();
        }catch (HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    //更新
    public void update(int id, int salary){
        Session session = ourSessionFactory.openSession();
        Transaction tx = null;
        try{
             tx = session.beginTransaction();
             TEmployeeEntity employeeEntity = session.get(TEmployeeEntity.class, id);
             employeeEntity.setSalary(salary);
             session.update(employeeEntity);
             tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void delete(int id){
        Session session = ourSessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            TEmployeeEntity tEmployeeEntity = session.get(TEmployeeEntity.class, id);
            session.delete(tEmployeeEntity);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    public static void main(final String[] args) throws Exception {
        Test test = new Test();
//        int e_id1 = test.add("b", "c", 9000);
//        int e_id2 = test.add("d", "e", 8000);
//        int e_id3 = test.add("f", "g", 7000);
//        System.out.println(e_id1+e_id2+e_id3);
        test.select();


    }

}