package hugosql.drilldownnn;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HUGOSQL
 */
public class Ciudadesdata {
    public Integer idciudad;
    public String codigo;
    public String pais;
    public String ciudad;
    public Integer poblacion;
    public Boolean valido;
    
    public static List<Ciudadesdata> listaciudades=new ArrayList<>();
    
    public Ciudadesdata() {
        idciudad=0;
        codigo="";
        pais="";
        ciudad="";
        poblacion=0;
        valido=false;
    }
    /**
     * "city","city_ascii","lat","lng","country","iso2","iso3","admin_name","capital","population","id"
     * @param linea 
     */
    public Ciudadesdata(String linea) {
        try {
            String[] partes=linea.split(",");
            idciudad=0;
            codigo=partes[6];
            pais=partes[4];
            ciudad=partes[0];
            poblacion=Integer.valueOf(partes[9]);
            valido=true;
        } catch (Exception e) {
            valido=false;
        }
    }
    
    public String cadena() {
        return idciudad+"\t"
                + codigo+"\t"
                + pais+"\t"
                + ciudad+"\t"
                + poblacion
                ;
    }
    public String getIdpais() {
        return String.valueOf(idciudad);
    }
    public String getPoblacion() {
        return String.valueOf(poblacion);
    }

    public static String getMaximaCiudad(String acode) {
        String aciudad="";
        Integer imax=0;
        Ciudadesdata cdata=new Ciudadesdata();
        for (int j=0;j<Ciudadesdata.listaciudades.size();j++) {
            cdata=Ciudadesdata.listaciudades.get(j);
            if (acode.equals(cdata.codigo)) {
                if (imax<cdata.poblacion) {
                    imax=cdata.poblacion;
                    aciudad=cdata.ciudad+", "+cdata.pais
                            +"\nPoblación: "+cdata.poblacion+" hab.";
                }
            }
        }
        return aciudad;
    }

}
