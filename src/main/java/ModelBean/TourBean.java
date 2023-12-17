package ModelBean;

import ModelBO.UserBO;

public class TourBean {
    private String tourID;
    private String tourName;
    private String tourDetail;
    private int tourPrice;
    public TourBean(String tourID, String tourName, String tourDetail, int tourPrice) {
        this.tourID = tourID;
        this.tourName = tourName;
        this.tourDetail = tourDetail;
        this.tourPrice = tourPrice;
    }

    public TourBean(String tourName, String tourDetail, int tourPrice) {
        this.tourName = tourName;
        this.tourDetail = tourDetail;
        this.tourPrice = tourPrice;
    }

    public String getTourID() {
        return tourID;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourDetail() {
        return tourDetail;
    }

    public void setTourDetail(String tourDetail) {
        this.tourDetail = tourDetail;
    }

    public int getTourPrice() {
        return tourPrice;
    }

    public void setTourPrice(int tourPrice) {
        this.tourPrice = tourPrice;
    }
}
