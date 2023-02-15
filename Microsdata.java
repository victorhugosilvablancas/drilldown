package hugosql.drilldownnn;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HUGOSQL
 */
public class Microsdata {
    public Integer idindicador;
    public String indicador;
    public Double per2012;
    public Double per2013;
    public Double per2014;
    public Double per2015;
    public Double per2016;
    public Double per2017;
    public Double per2018;
    public Double per2019;
    public Double per2020;
    public Double per2021;
    public Boolean valido;
    
    public static List<Microsdata> listamicros=new ArrayList<>();
    
    public Microsdata() {
        idindicador=0;
        indicador="";
        per2012=0.0;
        per2013=0.0;
        per2014=0.0;
        per2015=0.0;
        per2016=0.0;
        per2017=0.0;
        per2018=0.0;
        per2019=0.0;
        per2020=0.0;
        per2021=0.0;
        valido=false;
    }
    private Double acotaFraccion(String cade) {
        Double rnumero=0.0;
        if (cade!=null) {
            String anumero="0.0";
            if (cade.length()>0) {
                int idx=cade.indexOf(".");
                if (idx>0) {
                    int fdx=cade.length();
                    if (fdx > (idx+2)) {
                        anumero=cade.substring(0, idx+2);
                    }
                } else {
                    if (cade.length()>10) anumero=cade.substring(0, cade.length()-3);
                }
                rnumero=Double.valueOf(anumero);
            }
        }
        return rnumero;
    }
    public Microsdata(String linea) {
        per2012=0.0;
        per2013=0.0;
        per2014=0.0;
        per2015=0.0;
        per2016=0.0;
        per2017=0.0;
        per2018=0.0;
        per2019=0.0;
        per2020=0.0;
        per2021=0.0;
        linea=linea.replace("\"", "");
        int r=0;
        try {
            String[] partes=linea.split(",");
            r=partes.length;
            idindicador=0;
            indicador=partes[0].trim();
            switch (r) {
                case 1:
                    break;
                case 2:
                    per2012=acotaFraccion(partes[1]);
                    break;
                case 3:
                    per2012=acotaFraccion(partes[1]);
                    per2013=acotaFraccion(partes[2]);
                    break;
                case 4:
                    per2012=acotaFraccion(partes[1]);
                    per2013=acotaFraccion(partes[2]);
                    per2014=acotaFraccion(partes[3]);
                    break;
                case 5:
                    per2012=acotaFraccion(partes[1]);
                    per2013=acotaFraccion(partes[2]);
                    per2014=acotaFraccion(partes[3]);
                    per2015=acotaFraccion(partes[4]);
                    break;
                case 6:
                    per2012=acotaFraccion(partes[1]);
                    per2013=acotaFraccion(partes[2]);
                    per2014=acotaFraccion(partes[3]);
                    per2015=acotaFraccion(partes[4]);
                    per2016=acotaFraccion(partes[5]);
                    break;
                case 7:
                    per2012=acotaFraccion(partes[1]);
                    per2013=acotaFraccion(partes[2]);
                    per2014=acotaFraccion(partes[3]);
                    per2015=acotaFraccion(partes[4]);
                    per2016=acotaFraccion(partes[5]);
                    per2017=acotaFraccion(partes[6]);
                    break;
                case 8:
                    per2012=acotaFraccion(partes[1]);
                    per2013=acotaFraccion(partes[2]);
                    per2014=acotaFraccion(partes[3]);
                    per2015=acotaFraccion(partes[4]);
                    per2016=acotaFraccion(partes[5]);
                    per2017=acotaFraccion(partes[6]);
                    per2018=acotaFraccion(partes[7]);
                    break;
                case 9:
                    per2012=acotaFraccion(partes[1]);
                    per2013=acotaFraccion(partes[2]);
                    per2014=acotaFraccion(partes[3]);
                    per2015=acotaFraccion(partes[4]);
                    per2016=acotaFraccion(partes[5]);
                    per2017=acotaFraccion(partes[6]);
                    per2018=acotaFraccion(partes[7]);
                    per2019=acotaFraccion(partes[8]);
                    break;
                case 10:
                    per2012=acotaFraccion(partes[1]);
                    per2013=acotaFraccion(partes[2]);
                    per2014=acotaFraccion(partes[3]);
                    per2015=acotaFraccion(partes[4]);
                    per2016=acotaFraccion(partes[5]);
                    per2017=acotaFraccion(partes[6]);
                    per2018=acotaFraccion(partes[7]);
                    per2019=acotaFraccion(partes[8]);
                    per2020=acotaFraccion(partes[9]);
                    break;
                case 11:
                    per2012=acotaFraccion(partes[1]);
                    per2013=acotaFraccion(partes[2]);
                    per2014=acotaFraccion(partes[3]);
                    per2015=acotaFraccion(partes[4]);
                    per2016=acotaFraccion(partes[5]);
                    per2017=acotaFraccion(partes[6]);
                    per2018=acotaFraccion(partes[7]);
                    per2019=acotaFraccion(partes[8]);
                    per2020=acotaFraccion(partes[9]);
                    per2021=acotaFraccion(partes[10]);
                    break;
            }
            valido=true;
        } catch (Exception e) {
            System.out.println(linea+"\n\t"+r+":"+e.getLocalizedMessage());
            valido=false;
        }
    }
    
    public String cadena() {
        return idindicador+"\t"
                + indicador+"\t"
                + per2012+"\t"
                + per2013+"\t"
                + per2014+"\t"
                + per2015+"\t"
                + per2016+"\t"
                + per2017+"\t"
                + per2018+"\t"
                + per2019+"\t"
                + per2020+"\t"
                + per2021
                ;
    }
    public String getIdpais() {
        return String.valueOf(idindicador);
    }
    public String getIndicador() {
        return String.valueOf(indicador);
    }

}
