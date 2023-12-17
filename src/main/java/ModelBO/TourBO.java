package ModelBO;

import ModelBean.TourBean;
import ModelDAO.TourDAO;

import java.util.ArrayList;

public class TourBO {
    TourDAO tourDAO;
    private static TourBO instance;
    public static synchronized TourBO getInstance() {
        if (instance == null) {
            instance = new TourBO();
        }
        return instance;
    }
    public TourBO(){
        tourDAO = new TourDAO();
    }
    public boolean insertTour(String tourName, String turDetail, int tourPrice){
        TourBean newTour = new TourBean(tourName, turDetail, tourPrice);
        if(tourDAO.insertTour(newTour) == 1) return true;
        else return false;
    }
    public TourBean getTourByID(String idTour){
        TourBean tour = tourDAO.getTourByID(idTour);
        if(tour == null) System.out.println("Tour không tồn tại");
        else System.out.println("Có tour");
        return tour;
    }

    public ArrayList<TourBean> getAllTour(){
        return tourDAO.getAllTour();
    }
}
