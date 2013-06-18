/**
 * Created with IntelliJ IDEA.
 * User: Modzel
 * Date: 17.06.13
 * Time: 21:19
 * To change this template use File | Settings | File Templates.
 */
public class Zgloszenie {

    int idZgloszenia;
    int idSprzetu;
    int idLokalizacji;
    int idAdministarotra;
    int idZespolu;
    String nazwaGwaranta;
    String status;

    Zgloszenie(int idZgloszenia, int idSprzetu, int idLokalizacji, int idAdministarotra, String nazwaGwaranta){
        this.idAdministarotra = idAdministarotra;
        this.idSprzetu = idSprzetu;
        this.idLokalizacji = idLokalizacji;
        this.idZgloszenia = idZgloszenia;
        this.idZespolu = -1;
        this.status = null;
        this.nazwaGwaranta = nazwaGwaranta;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setIdZespolu(int id){
        idZespolu = id;
    }

    public void setIdZgloszenia(int id){
        idZgloszenia = id;
    }

    public void setIdAdmistratora(int id){
        idAdministarotra = id;
    }
}
