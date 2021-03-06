package pe.com.ricindigus.generadorinei.componentes.componente_visitas;

import android.content.Context;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.componentes.componente_visitas.pojos.Visita;
import pe.com.ricindigus.generadorinei.pojos.OpcionSpinner;

import static android.os.Environment.getExternalStorageDirectory;

/**
 * Created by dmorales on 07/02/2018.
 */

public class VisitaPullParser {
    public static final String VISITA_ID = "ID";
    public static final String VISITA_MODULO = "MODULO";
    public static final String VISITA_NUMERO = "NUMERO";
    public static final String VISITA_VARNUM = "VARNUM";
    public static final String VISITA_VARDIA = "VARDIA";
    public static final String VISITA_VARMES = "VARMES";
    public static final String VISITA_VARANIO = "VARANIO";
    public static final String VISITA_VARHORI = "VARHORI";
    public static final String VISITA_VARMINI = "VARMINI";
    public static final String VISITA_VARHORF = "VARHORF";
    public static final String VISITA_VARMINF = "VARMINF";
    public static final String VISITA_VARRES = "VARRES";
    public static final String VISITA_VARDIAP = "VARDIAP";
    public static final String VISITA_VARMESP = "VARMESP";
    public static final String VISITA_VARANIOP = "VARANIOP";
    public static final String VISITA_VARHORP = "VARHORP";
    public static final String VISITA_VARMINP = "VARMINP";
    public static final String VISITA_VARRESFINAL = "VARRESFINAL";
    public static final String VISITA_VARRESDIA = "VARRESDIA";
    public static final String VISITA_VARRESMES = "VARRESMES";
    public static final String VISITA_VARRESANIO = "VARRESANIO";
    public static final String VISITA_VARRESHORA = "VARRESHORA";
    public static final String VISITA_VARRESMIN = "VARRESMIN";

    private Visita currentVisita = null;
    private String currentTag = null;
    ArrayList<Visita> visitas = new ArrayList<Visita>();

    public ArrayList<Visita> parseXML(Context context){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            try {
                InputStream stream = context.getAssets().open("visitas.xml");
                xpp.setInput(stream,null);

                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTag(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleText(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return visitas;
    }

    public ArrayList<Visita> parseXML(Context context, String archivo){
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            FileInputStream fis = null;
            try {
                File nuevaCarpeta = new File(getExternalStorageDirectory(), "GENERADOR");
                File file = new File(nuevaCarpeta, archivo);
                FileInputStream fileInputStream = new FileInputStream(file);
                fis = new FileInputStream(file);
                xpp.setInput(fis, null);
                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        handleStarTag(xpp.getName());
                    }else if(eventType == XmlPullParser.END_TAG){
                        currentTag = null;
                    }else if(eventType == XmlPullParser.TEXT){
                        handleText(xpp.getText());
                    }
                    eventType = xpp.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return visitas;
    }

    private void handleText(String text) {
        String xmlText = text;
        if(currentVisita!= null && currentTag != null){
            switch (currentTag){
                case VISITA_ID:currentVisita.setID(xmlText);break;
                case VISITA_MODULO:currentVisita.setMODULO(xmlText);break;
                case VISITA_NUMERO:currentVisita.setNUMERO(xmlText);break;
                case VISITA_VARNUM:currentVisita.setVARNUM(xmlText);break;
                case VISITA_VARDIA:currentVisita.setVARDIA(xmlText);break;
                case VISITA_VARMES:currentVisita.setVARMES(xmlText);break;
                case VISITA_VARANIO:currentVisita.setVARANIO(xmlText);break;
                case VISITA_VARHORI:currentVisita.setVARHORI(xmlText);break;
                case VISITA_VARMINI:currentVisita.setVARMINI(xmlText);break;
                case VISITA_VARHORF:currentVisita.setVARHORF(xmlText);break;
                case VISITA_VARMINF:currentVisita.setVARMINF(xmlText);break;
                case VISITA_VARRES:currentVisita.setVARRES(xmlText);break;
                case VISITA_VARDIAP:currentVisita.setVARDIAP(xmlText);break;
                case VISITA_VARMESP:currentVisita.setVARMESP(xmlText);break;
                case VISITA_VARANIOP:currentVisita.setVARANIOP(xmlText);break;
                case VISITA_VARHORP:currentVisita.setVARHORP(xmlText);break;
                case VISITA_VARMINP:currentVisita.setVARMINP(xmlText);break;
                case VISITA_VARRESFINAL:currentVisita.setVARRESFINAL(xmlText);break;
                case VISITA_VARRESDIA:currentVisita.setVARRESDIA(xmlText);break;
                case VISITA_VARRESMES:currentVisita.setVARRESMES(xmlText);break;
                case VISITA_VARRESANIO:currentVisita.setVARRESANIO(xmlText);break;
                case VISITA_VARRESHORA:currentVisita.setVARRESHORA(xmlText);break;
                case VISITA_VARRESMIN:currentVisita.setVARRESMIN(xmlText);break;
            }
        }
    }

    private void handleStarTag(String name) {
        if(name.equals("VISITA")){
            currentVisita= new Visita();
            visitas.add(currentVisita);
        }else{
            currentTag = name;
        }
    }
}
