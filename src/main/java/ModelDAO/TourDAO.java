package ModelDAO;

import ModelBean.TourBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TourDAO {
    public ArrayList<TourBean> getAllTour(){
        ArrayList<TourBean> tourBeans = new ArrayList<>();
        try{
            Connection conn = DBUtil.connection();
            String sql = "SELECT * FROM tour";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String tourID = resultSet.getString("tourID");
                String tourName = resultSet.getString("tourName");
                int priceTour = resultSet.getInt("priceTour");
                String detailTour = resultSet.getString("detailTour");
                TourBean tour = new TourBean(tourID, tourName, detailTour, priceTour);
                tourBeans.add(tour);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return tourBeans;
    }
    public int insertTour(TourBean newTour){
        try{
            Connection conn = DBUtil.connection();
            String sql = "SELECT * FROM tour ORDER BY tourID DESC LIMIT 1";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            String tourLastID = null;
            while (resultSet.next()){
                tourLastID = resultSet.getString("tourID");
                break;
            }

            if(tourLastID == null) newTour.setTourID("To01");
            else{
                int numTour = Integer.parseInt(tourLastID.substring(2));
                String ID_newTour = "To";
                numTour++;
                if(numTour < 10) ID_newTour += "0" + numTour;
                else ID_newTour += numTour;
                newTour.setTourID(ID_newTour);
            }

            sql = "INSERT INTO tour(tourID, tourName, priceTour, detailTour) VALUES ('" + newTour.getTourID() + "'," +
                    "'" + newTour.getTourName() + "'," +
                    "'" + newTour.getTourPrice() + "'," +
                    "'" + newTour.getTourDetail() + "')";
            statement = conn.createStatement();
            return statement.executeUpdate(sql);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }
    public TourBean getTourByID(String tourID) {
        TourBean tour = null;
        try {
            tour = null;
            Connection conn = DBUtil.connection();
            String sql = "SELECT * FROM tour WHERE tourID='" + tourID + "';";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String tourName = resultSet.getString("tourName");
                int tourPrice = resultSet.getInt("priceTour");
                String tourDetail = resultSet.getString("detailTour");
                tour = new TourBean(tourID, tourName, tourDetail, tourPrice);
                break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tour;
    }
}