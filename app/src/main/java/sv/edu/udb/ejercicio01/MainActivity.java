package sv.edu.udb.ejercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eta, etb, etc;
    Button calcular;
    TextView rx1, rx2;
    double a, b, c, d, x1, x2;
    Validaciones validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eta = (EditText) findViewById(R.id.editTextTextPersonName);
        etb = (EditText) findViewById(R.id.editTextTextPersonName2);
        etc = (EditText) findViewById(R.id.editTextTextPersonName3);

        calcular = (Button) findViewById(R.id.button);
        rx1 = (TextView) findViewById(R.id.textView2);
        rx2 = (TextView) findViewById(R.id.textView4);
        validar = new Validaciones();
    }

    public void calcularCuadratica(View v) {

        if (!validar.Vacio(eta) && !validar.Vacio(etb) && !validar.Vacio(etc)) {

            a = Double.parseDouble(eta.getText().toString());
            b = Double.parseDouble(etb.getText().toString());
            c = Double.parseDouble(etc.getText().toString());
            d = Math.pow(b, 2) - (4 * a * c);

            if (d == 0) {
                x1 = -b / (2 * a);
                rx1.setText("X=" + x1);
            }else if(d < 0){
                rx1.setText("Raices Imaginarias");
            }else if(d > 0){
                x1 = (-b + Math.sqrt(d))/(2*a);
                x2 = (-b - Math.sqrt(d))/(2*a);
                rx1.setText("X1=" + x1);
                rx2.setText("X2=" + x2);
            }
        } else {
            Toast.makeText(getApplicationContext(), "No se permiten campos vacios", Toast.LENGTH_SHORT).show();
        }
    }
}