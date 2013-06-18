
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
	try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://jatokor.net:3306", "bd2.elka", "admin1");
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
    
    public LinkedList<Device> getDevices() {
        LinkedList<Device> devices = new LinkedList<>();
        Device n;
	ResultSet rset;
	try {
	    stmt = conn.prepareStatement("SELECT * FROM \"Urządzenie\"");
	    rset = stmt.executeQuery();
	    while(rset.next()) {
                n = new Device();
                n.id = Integer.parseInt(rset.getObject("IdSprzetu").toString());
		n.type = rset.getObject("NazwaRodzaju").toString();
                devices.add(n);
	    }
	    rset.close();
	}
	catch(SQLException e) {
	    System.out.println(e.getMessage() + "-> problem z połczeniem 4");
	}
	catch(NullPointerException e2) {
	    System.out.println("Nuull");
	}
        return devices;
    }
    
    public Warranty getWarranty(int deviceId) {
        Warranty n = new Warranty();
	ResultSet rset;
	try {
	    stmt = conn.prepareStatement("SELECT A.IdGwarancji, A.NazwaGwaranta, A.PoczatekGwarancji, A.KoniecGwarancji,"+
                    "A.NumerUmowy, B.Ulica, B.Miasto, B.NrTelefonu FROM Gwarancja A, Gwarant B, \"Właściwości uzytkowe\" C "+
                    "WHERE A.NazwaGwaranta=B.NazwaGwaranta AND C.IdGwarancji=A.IdGwarancji AND C.IdSprzetu=?");
	    stmt.setInt(1, deviceId);
	    rset = stmt.executeQuery();
	    rset.next();
            n.id = Integer.parseInt(rset.getObject("A.IdGwarancji").toString());
            n.warrantyName = rset.getObject("A.NazwaGwaranta").toString();
            n.begin = rset.getObject("A.PoczatekGwarancji").toString();
            n.end = rset.getObject("A.KoniecGwarancji").toString();
            n.street = rset.getObject("B.Ulica").toString();
            n.city = rset.getObject("B.Miasto").toString();
            n.nr = Integer.parseInt(rset.getObject("A.NumerUmowy").toString());
            n.phone = Integer.parseInt(rset.getObject("B.NrTelefonu").toString());
	    rset.close();
	}
	catch(SQLException e) {
	    System.out.println(e.getMessage() + "-> problem z połczeniem 4");
	}
	catch(NullPointerException e2) {
	    System.out.println("Nuull");
	}
        return n;
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
    
    public LinkedList<Worker> getWorkers() {
        LinkedList<Worker> workers = new LinkedList<>();
        Worker n;
	ResultSet rset;
	try {
	    stmt = conn.prepareStatement("SELECT * FROM \"Pracownik\"");
	    rset = stmt.executeQuery();
	    while(rset.next()) {
                n = new Worker();
                n.id = Integer.parseInt(rset.getObject("IdPracownika").toString());
		n.name = rset.getObject("Imie").toString();
		n.surname = rset.getObject("Nazwisko").toString();
		n.status = rset.getObject("Status").toString();
                n.teamId = Integer.parseInt(rset.getObject("IdZespolu").toString());
                workers.add(n);
	    }
	    rset.close();
	}
	catch(SQLException e) {
	    System.out.println(e.getMessage() + "-> problem z połczeniem 4");
	}
	catch(NullPointerException e2) {
	    System.out.println("Nuull");
	}
        return workers;
    }
    
    public LinkedList<Team> getTeams() {
        LinkedList<Team> teams = new LinkedList<>();
        Team n;
	ResultSet rset;
	try {
	    stmt = conn.prepareStatement("SELECT * FROM \"Zespół serwisowy\"");
	    rset = stmt.executeQuery();
	    while(rset.next()) {
                n = new Team();
                n.id = Integer.parseInt(rset.getObject("IdZespolu").toString());
		n.name = rset.getObject("NazwaZespolu").toString();
		n.opis = rset.getObject("Opis").toString();
                teams.add(n);
	    }
	    rset.close();
	}
	catch(SQLException e) {
	    System.out.println(e.getMessage() + "-> problem z połczeniem 4");
	}
	catch(NullPointerException e2) {
	    System.out.println("Nuull");
	}
        return teams;
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
    
    public void deleteNotifications(int id) {
	try {
	    stmt = conn.prepareStatement("DELETE FROM \"Zgłoszenia napraw\" WHERE IdZgloszenia=?");
	    stmt.setInt(1, id);
	    stmt.executeQuery();
	}
	catch(SQLException e) {
	    System.out.println(e.getMessage() + "-> problem z połczeniem 4");
	}
    }
    
    public int changeTeamNotification(int notificationId, int teamId) {
	try {
	    stmt = conn.prepareStatement("UPDATE \"Zgłoszenia napraw\" SET IdZespolu=? WHERE IdZgloszenia=?");
	    stmt.setInt(1, teamId);
	    stmt.setInt(2, notificationId);
	    stmt.executeQuery();
	}
	catch(SQLException e) {
	    System.out.println(e.getMessage() + "-> problem z połczeniem 4");
            return 1;
	}
        return 0;
    }
    
    class Notification {
        public int id;
        public int device;
        public int team;
        public int admin;
    }
    
    class Device {
        public int id;
        public String type;
    }
    
    class Warranty {
        public int id;
        public String warrantyName;
        public String street;
        public String city;
        public int phone;
        public String begin;
        public String end;
        public int nr;
    }
    
    class Worker {
        public int id;
        public String name;
        public String surname;
        public int teamId;
        public String status;
    }
    
    class Team {
        public int id;
        public String name;
        public String opis;
    }
}
