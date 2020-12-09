/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watch.admin.model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import watch.entity.Categories;
import watch.entity.Producers;
import watch.util.NewHibernateUtil;

/**
 *
 * @author ThinkPad T440s
 */
public class CategoriesModel {
      public List<Categories> getAll(){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from Categories");
        List<Categories> listCat = query.list();
        session.getTransaction().commit();
        session.close();
        return  listCat;
   }
      
    public  boolean InsertCat(Categories cat){
        Session session = null;
        boolean check = false;
        try {
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.save(cat);
            session.getTransaction().commit();
            check = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return check;
    }
    public  boolean  UpdateCat(Categories cat){
        Session session = null;
        boolean check= false;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.merge(cat);
            session.getTransaction().commit();
            check= true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return check;
    }
    
    public Categories getById(String catId){

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        Query query= session.createQuery("from Categories  where catId=:catId");
        query.setString("catId", catId);
        Categories cat = (Categories) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return cat;
    }
    public  boolean  DeleteCat(String catId){
        Session session = null;
        boolean check= false;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Categories CatRemove = getById(catId);
            session.getTransaction().begin();
            session.delete(CatRemove);
            session.getTransaction().commit();
            check= true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        return check;
    }
   
}
