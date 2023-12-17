package ModelBean;

import java.time.LocalDateTime;

public class TicketBean {
    private String ticketID;
    private String userID;
    private String tourID;
    private int numTicket;
    private int sumPrice;
    private LocalDateTime dateTimeOrder;
    private LocalDateTime dateTimeGo;
    private String comment;

    public TicketBean(String ticketID, String userID, String tourID, int numTicket, int sumPrice, LocalDateTime dateTimeOrder, LocalDateTime dateTimeGo, String comment) {
        this.ticketID = ticketID;
        this.userID = userID;
        this.tourID = tourID;
        this.numTicket = numTicket;
        this.sumPrice = sumPrice;
        this.dateTimeOrder = dateTimeOrder;
        this.dateTimeGo = dateTimeGo;
        this.comment = comment;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTourID() {
        return tourID;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
    }

    public int getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(int numTicket) {
        this.numTicket = numTicket;
    }

    public int getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }

    public LocalDateTime getDateTimeOrder() {
        return dateTimeOrder;
    }

    public void setDateTimeOrder(LocalDateTime dateTimeOrder) {
        this.dateTimeOrder = dateTimeOrder;
    }

    public LocalDateTime getDateTimeGo() {
        return dateTimeGo;
    }

    public void setDateTimeGo(LocalDateTime dateTimeGo) {
        this.dateTimeGo = dateTimeGo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
