package sv.edu.udb.ejercicio01;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;

import java.util.regex.Pattern;

public class Validaciones {

    //metodo para validar si es un valor numerico
    public  boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }

    //metodo para validar si es un email
    public  boolean soloLetras(String cadena) {
        boolean resultado;
        if (Pattern.compile("[a-zA-Z]{1,254}").matcher(cadena).matches()) {
            resultado = true;
        } else {
            resultado = false;
        }

        return resultado;
    }

    //metodo para validar si es un email
    public  boolean isEmail(String cadena) {
        boolean resultado;
        if (Patterns.EMAIL_ADDRESS.matcher(cadena).matches()) {
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }

    //metodo para validar si editext esta vacio
    public  boolean Vacio(EditText campo) {
        String dato = campo.getText().toString().trim();
        if (TextUtils.isEmpty(dato)) {
            campo.setError("Campo Requerido");
            campo.requestFocus();
            return true;
        } else {
            return false;
        }
    }

}
