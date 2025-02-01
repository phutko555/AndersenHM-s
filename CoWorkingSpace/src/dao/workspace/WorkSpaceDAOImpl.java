package dao.workspace;
import model.WorkSpacesE;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;
import java.sql.*;
import java.util.List;

public class WorkSpaceDAOImpl implements WorkSpaceDAO {

    @Override
    public void addWorkSpace(WorkSpacesE workSpace) throws SQLException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(workSpace);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null) transaction.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void removeWorkSpace(int id) throws SQLException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            WorkSpacesE workSpacesE = session.get(WorkSpacesE.class, id);

            if (workSpacesE != null) {
                session.remove(workSpacesE);
                transaction.commit();
                System.out.println("Workspace with ID " + id + " removed successfully.");
            } else {
                throw new SQLException("Workspace with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            if (transaction != null) transaction.rollback();
           throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void viewAllReservations() throws SQLException {
        Session session = HibernateUtil.getSession();
        try {
            Query query = session.createQuery("from WorkSpacesE where availabilityStatus = false");
            List<WorkSpacesE> workSpacesE = query.list();
            if(workSpacesE.isEmpty()){
                throw new SQLException("There are no reservations.");
            }
            for (WorkSpacesE workSpacesE1 : workSpacesE) {
                System.out.println(workSpacesE1);
            }
        }finally {
            session.close();
        }
    }
}