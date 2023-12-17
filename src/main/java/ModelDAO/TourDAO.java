package ModelDAO;

import ModelBean.TourBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TourDAO {
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
}
