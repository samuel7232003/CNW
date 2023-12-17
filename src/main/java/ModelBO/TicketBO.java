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
    public boolean insertTicket(String userID, String tourID, int numTicket, LocalDateTime dateTimeGo, String comment){
        LocalDateTime dateTimeOrder = LocalDateTime.now();
        System.out.println(dateTimeOrder);
        System.out.println(dateTimeGo);
        TicketBean newTicket = new TicketBean(userID, tourID, numTicket, dateTimeOrder, dateTimeGo,comment);
        TourBO tourBO = new TourBO();
        TourBean tour = tourBO.getTourByID(tourID);
        newTicket.setSumPrice(numTicket * tour.getTourPrice());
        if(ticketDAO.insertTicket(newTicket) == 1) return true;
        else return false;
    }
}
