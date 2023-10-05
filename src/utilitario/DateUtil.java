package utilitario;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Cliente
 */
public class DateUtil {
    
   public static final String FULL_DATE = "dd/MM/yyyy HH:mm:ss";

    public static final String DATE_HOUR = "dd 'de' MMMM 'de' yyyy HH:mm";

    public static final String SIMPLE_DATE = "dd/MM/yyyy";

    public static final String DD_MM_YYYY = "dd/MM/yyyy";

    public static final String YYYY_MM_DD_T_HH_MM_SS_SSS_SS_SS = "yyyy-MM-dd'T'HH:mm:ss.SSS+SS:SS";

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYY_MM_DD_T_HH_MM_SS_SSSZ = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    public static final String DD_DE_MMMM_DE_YYYY = "dd 'de' MMMM 'de' yyyy";

    public static final String DD_MMMM_DE_YYYY_HH_MM_SS = "dd 'de' MMMM 'de' yyyy HH:mm:ss";

    public static Date parse(String pattern, String value) {

        Date data = null;

        try {
            data = new SimpleDateFormat(pattern).parse(value);
        } catch (ParseException ex) {
           // Logger.getLogger(DataConverter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;

    }

    public static String format(String pattern, Date data, Locale locale) {

        if (locale == null) {
            locale = new Locale("pt", "BR");
        }

        return new SimpleDateFormat(pattern, locale).format(data);

    }

    public static String format(String pattern, Date data) {
        return format(pattern, data, null);
    }

    public static String format(Date date) {
        return format(SIMPLE_DATE, date);
    }

    public static Date toDate(String date, String mask) throws ParseException {
        return new SimpleDateFormat(mask).parse(date);
    }
    public static Date StringToDate(String dataRecebida) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = formato.parse(dataRecebida);
        return dataFormatada;
    }
}
