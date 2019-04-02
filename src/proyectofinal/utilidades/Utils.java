package proyectofinal.utilidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static String obtenerFechaActual(){
        Date fecha = Calendar.getInstance().getTime();  
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        return formatoFecha.format(fecha);  
    }

}
