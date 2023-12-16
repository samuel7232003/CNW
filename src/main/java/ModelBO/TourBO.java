package ModelBO;

import ModelBean.TourBean;
import ModelDAO.TourDAO;

public class TourBO {
    TourDAO tourDAO;
    public TourBO(){
        tourDAO = new TourDAO();
    }
    public boolean insertTour(String tourName, String turDetail, int tourPrice){
        TourBean newTour = new TourBean(tourName, turDetail, tourPrice);
        if(tourDAO.insertTour(newTour) == 1) return true;
        else return false;
    }
}
