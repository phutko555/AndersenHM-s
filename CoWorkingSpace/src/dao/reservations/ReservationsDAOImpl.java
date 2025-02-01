package dao.reservations;
import model.ReservationsE;
import model.WorkSpacesE;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;
import java.sql.SQLException;
import java.util.List;

public class ReservationsDAOImpl implements ReservationsDAO{
    @Override
    public void getAvailableSpaces() throws SQLException {
        Session session = HibernateUtil.getSession();
        try {
            Query query = session.createQuery("from WorkSpacesE where availabilityStatus = true");
            List<WorkSpacesE> workSpacesE = query.list();
            if(workSpacesE.isEmpty()){
                throw new SQLException("There are no available workspaces.");
            }
            for (WorkSpacesE workSpacesE1 : workSpacesE) {
                System.out.println(workSpacesE1);
            }
        }finally {
            session.close();
        }
    }

    @Override
    public void makeReservation(int id) throws SQLException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            WorkSpacesE workSpacesE = session.get(WorkSpacesE.class, id);
            if (workSpacesE != null) {
                if(!workSpacesE.isAvailabilityStatus()){
                    throw new SQLException("Workspace with ID " + id + "is not available");
                }
                ReservationsE reservationsE = new ReservationsE();
                workSpacesE.setAvailabilityStatus(false);
                reservationsE.setWorkSpacesE(workSpacesE);
                session.save(reservationsE);
                System.out.println("Workspace with ID " + id + " reserved successfully.");
            } else {
                throw new SQLException("Workspace with ID " + id + " not found.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new SQLException("Error reserving workspace: " + e.getMessage(), e);
        } finally {
            session.close();
        }
    }

    @Override
    public void ownReservations() throws SQLException {
        Session session = HibernateUtil.getSession();
        try{
            Query query = session.createQuery("from ReservationsE");
            List<ReservationsE> reservationsES = query.list();
            if(reservationsES.isEmpty()){
                throw new SQLException("There are no available workspaces.");
            }
            for(ReservationsE reservationsE : reservationsES){
                System.out.println("ID: " +reservationsE.getId() + ")  " + reservationsE.getWorkSpacesE());
            }
        }finally {
            session.close();
        }
    }

    @Override
    public void cancelReservation(int id) throws SQLException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            ReservationsE reservationsE = session.get(ReservationsE.class,id);
            if(reservationsE != null){
                reservationsE.getWorkSpacesE().setAvailabilityStatus(true);
                session.remove(reservationsE);
                transaction.commit();
                System.out.println("Reservation with ID " + id + " removed successfully.");
            }else{
                throw new SQLException("Reservation with ID " + id + " not found.");
            }
        }catch (SQLException e){
            if (transaction != null) transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
    }
}