import java.sql.*;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: servlok
 * Date: 17.06.13
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public class DataAccessObject {
    private static Connection conn =null;
    private static PreparedStatement stmt =null;
    private boolean isAdmin = false;
    private int id;
    /*
    public static void main(String[] args) {
        //DataAccessObject dao = new DataAccessObject();
        //DataAccessObject.connect(null, null);
        //DataAccessObject.disconnect();
    }*/
    
    public static void connect(String userName, String password) {
	try {
            System.out.println("Trying to connect...");
            Class.forName("com.mysql.jdbc.Driver");//.newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://jatokor.net:3306/bd", "bd2.elka", "admin1");
            System.out.println("Connected to db.");
	}
	catch(SQLException e) {
	    System.out.println(e.getMessage() + "-> SQLException");
	} catch(ClassNotFoundException e) {
	    System.out.println(e.getMessage() + "-> class not found");
	}
    }
    
    public static void disconnect() {
	try {
	    if(stmt!=null)stmt.close();
	    if(conn!=null)conn.close();
	} catch(SQLException e) {
	    System.out.println(e.getMessage() + "-> problem z połczeniem 3");
	}
    }
    
    public LinkedList<DataAccessObject.Device> getDevices() {
        LinkedList<DataAccessObject.Device> devices = new LinkedList<DataAccessObject.Device>();
        DataAccessObject.Device n;
	ResultSet rset;
	try {
	    stmt = conn.prepareStatement("SELECT * FROM Urzadzenie");
	    rset = stmt.executeQuery();
	    while(rset.next()) {
                n = new DataAccessObject.Device();
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
    
    public DataAccessObject.Warranty getWarranty(int deviceId) {
        DataAccessObject.Warranty n = new DataAccessObject.Warranty();
	ResultSet rset;
	try {
	    stmt = conn.prepareStatement("SELECT A.IdGwarancji, A.NazwaGwaranta, A.PoczatekGwarancji, A.KoniecGwarancji,"+
                    "A.NumerUmowy, B.Ulica, B.Miasto, B.NrTelefonu FROM Gwarancja A, Gwarant B, `Wlasciwosci uzytkowe` C "+
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
    
    public LinkedList<DataAccessObject.Notification> getNotifications(int adminId) {
        LinkedList<DataAccessObject.Notification> notifs = new LinkedList<DataAccessObject.Notification>();
        DataAccessObject.Notification n;
	ResultSet rset;
	try {
	    stmt = conn.prepareStatement("SELECT * FROM `Zgloszenie` WHERE IdAdministratora=?");
	    stmt.setInt(1, adminId);
	    rset = stmt.executeQuery();
	    while(rset.next()) {
                n = new DataAccessObject.Notification();
                n.admin = adminId;
                n.id = Integer.parseInt(rset.getObject("IdZgloszenia").toString());
		n.device = Integer.parseInt(rset.getObject("IdSprzetu").toString());
                n.team = Integer.parseInt(rset.getObject("IdZespolu").toString());
                n.opis = rset.getObject("Opis").toString();
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
    
    public LinkedList<DataAccessObject.Worker> getWorkers() {
        LinkedList<DataAccessObject.Worker> workers = new LinkedList<DataAccessObject.Worker>();
        DataAccessObject.Worker n;
	ResultSet rset;
	try {
	    stmt = conn.prepareStatement("SELECT * FROM Pracownik");
	    rset = stmt.executeQuery();
	    while(rset.next()) {
                n = new DataAccessObject.Worker();
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
    
    public LinkedList<DataAccessObject.Team> getTeams() {
        LinkedList<DataAccessObject.Team> teams = new LinkedList<DataAccessObject.Team>();
        DataAccessObject.Team n;
	ResultSet rset;
	try {
	    stmt = conn.prepareStatement("SELECT * FROM `Zespol`");
	    rset = stmt.executeQuery();
	    while(rset.next()) {
                n = new DataAccessObject.Team();
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
    
    public int addNotification(int deviceId, int teamId, String status, String opis) {
	ResultSet rset;
        try {
            stmt = conn.prepareStatement("SELECT IdAdministratora FROM Administrator WHERE Administrator.AdresSieci=Siec.AdresSieci AND"+
                    "Siec.IdSprzetu=?");
            stmt.setInt(1, deviceId);
	    rset = stmt.executeQuery();
            rset.next();
            int adminId = Integer.parseInt(rset.getObject("IdAdministratora").toString());
            stmt = conn.prepareStatement("INSERT (IdZagloszenia, IdSprzetu, IdZespolu, IdAdministratora, Status, Opis) INTO "
                    +"\"Zgłoszenie naprawy\" VALUES (id_notif_seq.NEXTVAL, ?, ?, ?, ?, ?)");
            stmt.setInt(1, deviceId);
            stmt.setInt(2, teamId);
            stmt.setInt(3, adminId);
            stmt.setString(4, status);
            stmt.setString(5, opis);
            stmt.executeQuery();
        }
        catch(SQLException e) {
            return -1;
        }
        return 0;
    }
    
    public int deleteNotifications(int id) {
	try {
	    stmt = conn.prepareStatement("DELETE FROM `Zgloszenia napraw` WHERE IdZgloszenia=?");
	    stmt.setInt(1, id);
	    stmt.executeQuery();
	}
	catch(SQLException e) {
	    System.out.println(e.getMessage() + "-> problem z połczeniem 4");
            return -1;
	}
        return 0;
    }
    
    public int changeTeamNotification(int notificationId, int teamId) {
	try {
	    stmt = conn.prepareStatement("UPDATE `Zgloszenia napraw` SET IdZespolu=? WHERE IdZgloszenia=?");
	    stmt.setInt(1, teamId);
	    stmt.setInt(2, notificationId);
	    stmt.executeQuery();
	}
	catch(SQLException e) {
	    System.out.println(e.getMessage() + "-> problem z połczeniem 4");
            return -1;
	}
        return 0;
    }
    
    class Notification {
        public int id;
        public int device;
        public int team;
        public int admin;
        public String opis;
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
