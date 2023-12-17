package ModelDAO;

import ModelBean.TicketBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class TicketDAO {
    public int insertTicket(TicketBean ticket){
        try{
            Connection conn = DBUtil.connection();
            String sql = "SELECT * FROM ticket ORDER BY ticketID DESC LIMIT 1";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            String ticketID = null;
            while (resultSet.next()){
                ticketID = resultSet.getString("ticketID");
                break;
            }
            if(ticketID == null) ticket.setTicketID("Tk01");
            else{
                int numTicket = Integer.parseInt(ticketID.substring(2));
                String ID_newTicket = "Tk";
                numTicket++;
                if(numTicket < 10) ID_newTicket += "0" + numTicket;
                else ID_newTicket += numTicket;
                ticket.setTicketID(ID_newTicket);
            }

            sql = "INSERT INTO ticket(ticketID, userID, tourID, numTicket, priceSum, datetimeOrder, datetimeGo, comment) VALUES ('" + ticket.getTicketID()                    + "'," +
                                                                                                                                "'" + ticket.getUserID()                      + "'," +
                                                                                                                                "'" + ticket.getTourID()                      + "'," +
                                                                                                                                "'" + ticket.getNumTicket()                   + "'," +
                                                                                                                                "'" + ticket.getSumPrice()                    + "'," +
                                                                                                                                "'" + timeToString(ticket.getDateTimeOrder()) + "'," +
                                                                                                                                "'" + timeToString(ticket.getDateTimeGo())    + "'," +
                                                                                                                                "'" + ticket.getComment()                     + "')";
            statement = conn.createStatement();
            return statement.executeUpdate(sql);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }

    public String timeToString(LocalDateTime timenow){
        String datetime = timenow.toString();
        String timeSet = datetime.replace('T' , ' ').substring(0,19);
        return timeSet;
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
