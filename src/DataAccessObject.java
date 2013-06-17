
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: servlok
 * Date: 17.06.13
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public class DataAccessObject {
    private static Connection conn;
    private static PreparedStatement stmt;
    private boolean isAdmin = false;
    private int id;
    
    public static void connect(String userName, String password) {  
	String connString = "jdbc:oracle:thin:@//ikar.elka.pw.edu.pl:1521/elka.elka.pw.edu.pl";
	try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://jatokor.net user=bd2.elka&password=admin1");
	}
	catch(SQLException e) {
	    System.out.println(e.getMessage() + "-> problem z połczeniem 2");
	} catch(ClassNotFoundException e) {
	    System.out.println(e.getMessage() + "-> problem z połczeniem 2");
	} catch (InstantiationException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DataAccessObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void disconnect() {
	try {
	    stmt.close();
	    conn.close();
	} catch(SQLException e) {
	    System.out.println(e.getMessage() + "-> problem z połczeniem 3");
	}
    }
    
    public int addNotification(int deviceId, int teamId, String status) {
	ResultSet rset;
        try {
            stmt = conn.prepareStatement("SELECT IdAdministratora FROM Administrator WHERE Administrator.AdresSieci=Siec.AdresSieci AND"+
                    "Siec.IdSprzetu=?");
            stmt.setInt(1, deviceId);
	    rset = stmt.executeQuery();
            rset.next();
            int adminId = Integer.parseInt(rset.getObject("IdAdministratora").toString());
            stmt = conn.prepareStatement("INSERT (IdZagloszenia, IdSprzetu, IdZespolu, IdAdministratora, Status) INTO "
                    +"\"Zgłoszenie naprawy\" VALUES (id_notif_seq.NEXTVAL, ?, ?, ?, ?)");
            stmt.setInt(1, deviceId);
            stmt.setInt(2, teamId);
            stmt.setInt(3, adminId);
            stmt.setString(4, status);
            stmt.executeQuery();
        }
        catch(SQLException e) {
            return -1;
        }
        return 0;
    }
    
    public LinkedList<Notification> getNotifications(int adminId) {
        LinkedList<Notification> notifs = new LinkedList<>();
        Notification n;
	ResultSet rset;
	try {
	    stmt = conn.prepareStatement("SELECT * FROM \"Zgłoszenia napraw\" WHERE IdAdministratora=?");
	    stmt.setInt(1, adminId);
	    rset = stmt.executeQuery();
	    while(rset.next()) {
                n = new Notification();
                n.admin = adminId;
                n.id = Integer.parseInt(rset.getObject("IdZgloszenia").toString());
		n.device = Integer.parseInt(rset.getObject("IdSprzetu").toString());
                n.team = Integer.parseInt(rset.getObject("IdZespolu").toString());
                notifs.add(n);
	    }
	    rset.close();
	}
	catch(SQLException e) {
	    System.out.println(e.getMessage() + "-> problem z połczeniem 4");
	}
	catch(NullPointerException e2) {
	    System.out.println("Nuull");
	}
        return notifs;
    }
    
    class Notification {
        public int id;
        public int device;
        public int team;
        public int admin;
    };
}
