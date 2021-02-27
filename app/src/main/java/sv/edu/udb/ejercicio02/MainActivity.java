package sv.edu.udb.ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnEnviar;
    ImageView nayib;
    ImageView gerson;
    ImageView maduro;
    ImageView norman;

    int voto1 = 0;
    int voto2 = 0;
    int voto3 = 0;
    int voto4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView nayib = findViewById(R.id.imageView3);
        ImageView gerson = findViewById(R.id.imageView4);
        ImageView maduro = findViewById(R.id.imageView5);
        ImageView norman = findViewById(R.id.imageView6);
        Button btnEnviar = findViewById(R.id.button);
    }

    public void votoNayib(View v) {
        voto1++;
        Toast.makeText(getApplicationContext(), "Usted voto por Nayib Bukele", Toast.LENGTH_SHORT).show();
        //Log.d("PRUEBA", Double.toString(voto1));
    }

    public void votoGerson(View v) {
        voto2++;
        Toast.makeText(getApplicationContext(), "Usted voto por Gerson Martinez", Toast.LENGTH_SHORT).show();
        //Log.d("PRUEBA", Double.toString(voto2));
    }

    public void votoMaduro(View v) {
        voto3++;
        Toast.makeText(getApplicationContext(), "Usted voto por Nicolas Maduro", Toast.LENGTH_SHORT).show();
    }

    public void votoNorman(View v) {
        Toast.makeText(getApplicationContext(), "Usted voto por Norman Quijano", Toast.LENGTH_SHORT).show();
        voto4++;
    }

    public void enviar(View v) {

        Intent i = new Intent(this, Resultados.class);
        //Calculo del total
        double total = (voto1) + (voto2) + (voto3) + (voto4);
        //Calculo del porcentaje
        double porcentaje1 = ((voto1)/total)*100;
        double porcentaje2 = ((voto2)/total)*100;
        double porcentaje3 = ((voto3)/total)*100;
        double porcentaje4 = ((voto4)/total)*100;
        i.putExtra("porcentaje1", Double.toString(porcentaje1));
        i.putExtra("porcentaje2", Double.toString(porcentaje2));
        i.putExtra("porcentaje3", Double.toString(porcentaje3));
        i.putExtra("porcentaje4", Double.toString(porcentaje4));
        i.putExtra("voto1", Double.toString(voto1));
        i.putExtra("voto2", Double.toString(voto2));
        i.putExtra("voto3", Double.toString(voto3));
        i.putExtra("voto4", Double.toString(voto4));
        startActivity(i);

    }
}