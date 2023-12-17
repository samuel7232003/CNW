package ModelBO;

import ModelBean.TicketBean;
import ModelBean.TourBean;
import ModelDAO.TicketDAO;

import java.time.LocalDateTime;

public class TicketBO {
    TicketDAO ticketDAO;
    public TicketBO(){
        ticketDAO = new TicketDAO();
    }
    public boolean insertTicket(String userID, String tourID, int numTicket, String dateTimeStrGo, String comment){
        LocalDateTime dateTimeOrder = LocalDateTime.now();
        //truyền cho cái dateTimeStrGo theo cú pháp là "2023-12-25 11:20:20" thì mới chạy nghe
        LocalDateTime dateTimeGo = timeToLocalDateTime(dateTimeStrGo);
        TicketBean newTicket = new TicketBean(userID, tourID, numTicket, dateTimeOrder, dateTimeGo,comment);
        TourBO tourBO = new TourBO();
        TourBean tour = tourBO.getTourByID(tourID);
        newTicket.setSumPrice(numTicket * tour.getTourPrice());
        if(ticketDAO.insertTicket(newTicket) == 1) return true;
        else return false;
    }
    public static LocalDateTime timeToLocalDateTime(String timeSend){
        LocalDateTime timenow;
        // timeSend = "2023-11-25 11:36:09";
        int year = Integer.parseInt(timeSend.substring(0,4));
        int month = Integer.parseInt(timeSend.substring(5,7));
        int day = Integer.parseInt(timeSend.substring(8,10));
        int hour = Integer.parseInt(timeSend.substring(11,13));
        int minute = Integer.parseInt(timeSend.substring(14,16));
        int second = Integer.parseInt(timeSend.substring(17,19));
        timenow = LocalDateTime.of(year,month,day,hour,minute,second);
        return timenow;
    }
}
