package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.jdesktop.beansbinding.Converter;

public class ConverteData extends Converter<Object, Object> {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public Object convertForward(Object value) {
        Calendar c = (Calendar) value;
        return sdf.format(c.getTime());
    }

    @Override
    public Object convertReverse(Object value) {
        String str = (String) value;
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(str));
            return c;
        } catch(Exception e){
            return null;
        }
    }
    
}
