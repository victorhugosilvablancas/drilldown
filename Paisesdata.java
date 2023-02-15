package hugosql.drilldownnn;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HUGOSQL
 */
public class Paisesdata {
    public Integer idpais;
    public String codigo;
    public String pais;
    public Integer poblacion;
    
    public static List<Paisesdata> listapaises=new ArrayList<>();
    
    public Paisesdata() {
        idpais=0;
        codigo="";
        pais="";
        poblacion=0;
    }
    
    public String cadena() {
        return idpais+"\t"
                + codigo+"\t"
                + pais+"\t"
                + poblacion
                ;
    }
    public String getIdpais() {
        return String.valueOf(idpais);
    }
    public String getPoblacion() {
        return String.valueOf(poblacion);
    }
    public Integer renglones() {
        return poblacion/10;
    }

    public static Integer getMaxima() {
        Integer imax=0;
        for (int j=0;j<Paisesdata.listapaises.size();j++) {
            if (imax<Paisesdata.listapaises.get(j).poblacion) {
                imax=Paisesdata.listapaises.get(j).poblacion;
            }
        }
        return imax;
    }

}
