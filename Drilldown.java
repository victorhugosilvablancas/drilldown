package hugosql.drilldownnn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author HUGOSQL
 */
public class Drilldown {
    
    private static final int MILLON=1000000;

    public Drilldown() {
        CargaCiudades(false);
    }
    
    public void CargaCiudades(boolean muestra) {
        Ciudadesdata.listaciudades=new ArrayList<>();
        Ciudadesdata midato=new Ciudadesdata();
        try {
            BufferedReader br = new BufferedReader(new FileReader("worldcities.csv"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            boolean primera=true;
            Integer iciudad=0;
            while (line != null) {
                if (primera) primera=false;
                else {
                    String cade=line.replace("\"", "");
                    midato=new Ciudadesdata(cade);
                    if (midato.valido) {
                        iciudad++;
                        midato.idciudad=iciudad;
                        Ciudadesdata.listaciudades.add(midato);
                    }
                }
                line = br.readLine();
                
            }
            if (muestra) {
                for (int i=0;i<Ciudadesdata.listaciudades.size();i++) {
                    System.out.println(Ciudadesdata.listaciudades.get(i).cadena());
                }
            }
        } catch (Exception e) {
            System.out.println("CargaCiudades: "+e.getLocalizedMessage());
        }
    }
    public void AgrupaPaises(boolean muestra) {
        Ciudadesdata.listaciudades.sort(new Comparator<Ciudadesdata>() {
            @Override
            public int compare(Ciudadesdata o1, Ciudadesdata o2) {
                return o1.codigo.compareTo(o2.codigo);
            }
        });
        Paisesdata.listapaises=new ArrayList<>();
        Paisesdata pdata=new Paisesdata();
        Ciudadesdata cdata=new Ciudadesdata();
        String acodigo="XXX";
        Integer spoblacion=0;
        Boolean primera=true;
        int k=1;
        for (int i=0;i<Ciudadesdata.listaciudades.size();i++) {
            cdata=Ciudadesdata.listaciudades.get(i);
            if (!acodigo.equals(cdata.codigo)) {
                if (primera) primera=false;
                else {
                    pdata.poblacion=spoblacion/MILLON;
                    if (pdata.poblacion>1)
                        Paisesdata.listapaises.add(pdata);
                }
                acodigo=cdata.codigo;
                pdata=new Paisesdata();
                pdata.idpais=k;
                pdata.codigo=cdata.codigo;
                pdata.pais=cdata.pais;
                k++;
                spoblacion=0;
            }
            spoblacion+=cdata.poblacion;
        }
        if (spoblacion>0) {
            pdata.poblacion=spoblacion/MILLON;
            if (pdata.poblacion>1)
                Paisesdata.listapaises.add(pdata);
        }
        if (muestra) {
            for (int j=0;j<Paisesdata.listapaises.size();j++) {
                pdata=Paisesdata.listapaises.get(j);
                System.out.println(pdata.cadena());
            }
        }
    }
    
    public String[] Cabeza=new String[0];
    public String[][] TablaPaises() {
        Cabeza=new String[Paisesdata.listapaises.size()];
        Paisesdata pdata=new Paisesdata();
        for (int j=0;j<Paisesdata.listapaises.size();j++) {
            pdata=Paisesdata.listapaises.get(j);
            Cabeza[j]=pdata.codigo;
        }
        //máxima población
        Integer maximaPoblacion=Paisesdata.getMaxima();
        Integer renglones=maximaPoblacion/10;
        
        int maxren=2+renglones;
        String[][] mitabla=new String[maxren][Cabeza.length];
        for (int j=0;j<Paisesdata.listapaises.size();j++) {
            pdata=Paisesdata.listapaises.get(j);
            mitabla[0][j]=pdata.getPoblacion();
            mitabla[1][j]=pdata.pais;
            
            int iultimo=maxren-1;
            if (pdata.renglones()<2) {
                mitabla[iultimo][j]="X";
            } else {
                int irens=pdata.renglones();
                while (irens>0) {
                    mitabla[iultimo][j]="X";
                    iultimo--;
                    irens--;
                }
            }
        }
        return mitabla;
    }
    
    //MICROECONÓMICOS
    public void CargaMicros(boolean muestra) {
        Microsdata.listamicros=new ArrayList<>();
        Microsdata midato=new Microsdata();
        try {
            BufferedReader br = new BufferedReader(new FileReader("bancomundialmexico.csv"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            boolean primera=true;
            Integer iindicador=0;
            while (line != null) {
                if (primera) primera=false;
                else {
                    String cade=line.replace("\"", "");
                    midato=new Microsdata(cade);
                    if (midato.valido) {
                        iindicador++;
                        midato.idindicador=iindicador;
                        Microsdata.listamicros.add(midato);
                    }
                }
                line = br.readLine();
                
            }
            if (muestra) {
                for (int i=0;i<Microsdata.listamicros.size();i++) {
                    System.out.println(Microsdata.listamicros.get(i).cadena());
                }
            }
        } catch (Exception e) {
            System.out.println("CargaMicros: "+e.getLocalizedMessage());
        }
    }
    
    public String[] CabezaMicros=new String[0];
    public String[][] TablaMicros(String afiltro) {
        CabezaMicros=new String[] {
            "Id",
            "Indicador",
            "2012",
            "2013",
            "2014",
            "2015",
            "2016",
            "2017",
            "2018",
            "2019",
            "2020",
            "2021",
        };
        String[][] mitabla=new String[0][CabezaMicros.length];
        if (afiltro.length()>0) {
            int r=Microsdata.listamicros.size();
            List<Microsdata> milista=new ArrayList<>();
            Microsdata mdata=new Microsdata();
            for (int i=0;i<r;i++) {
                mdata=Microsdata.listamicros.get(i);
                if (mdata.getIndicador().contains(afiltro)) {
                    milista.add(mdata);
                }
            }
            if (milista.size()>0) {
                int maxren=milista.size();
                mitabla=new String[maxren][CabezaMicros.length];
                for (int i=0;i<maxren;i++) {
                    mdata=milista.get(i);
                    mitabla[i]=mdata.cadena().split("\t");
                }
            }
        } else {
            int maxren=Microsdata.listamicros.size();
            mitabla=new String[maxren][CabezaMicros.length];
            Microsdata mdata=new Microsdata();
            for (int i=0;i<maxren;i++) {
                mdata=Microsdata.listamicros.get(i);
                mitabla[i]=mdata.cadena().split("\t");
            }
        }
        return mitabla;
    }

}
