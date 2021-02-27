package sv.edu.udb.ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    SeekBar seekBar1, seekBar2, seekBar3, seekBar4;
    TextView nayib, gerson, maduro, norman;
    TextView porcentaje1, porcentaje2, porcentaje3, porcentaje4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        seekBar1 = findViewById(R.id.seek_bar1);
        seekBar2 = findViewById(R.id.seek_bar2);
        seekBar3 = findViewById(R.id.seek_bar3);
        seekBar4 = findViewById(R.id.seek_bar4);
        nayib = findViewById(R.id.nayib);
        gerson = findViewById(R.id.gerson);
        maduro = findViewById(R.id.maduro);
        norman = findViewById(R.id.norman);
        porcentaje1 = findViewById(R.id.percent1);
        porcentaje2 = findViewById(R.id.percent2);
        porcentaje3 = findViewById(R.id.percent3);
        porcentaje4 = findViewById(R.id.percent4);

        double percent1 = Double.parseDouble(getIntent().getStringExtra("porcentaje1"));
        double percent2 = Double.parseDouble(getIntent().getStringExtra("porcentaje2"));
        double percent3 = Double.parseDouble(getIntent().getStringExtra("porcentaje3"));
        double percent4 = Double.parseDouble(getIntent().getStringExtra("porcentaje4"));
        String voto1 = getIntent().getStringExtra("voto1");
        String voto2 = getIntent().getStringExtra("voto2");
        String voto3 = getIntent().getStringExtra("voto3");
        String voto4 = getIntent().getStringExtra("voto4");

        porcentaje1.setText(String.format("%.0f%%", percent1));
        seekBar1.setProgress((int) percent1);
        porcentaje2.setText(String.format("%.0f%%", percent2));
        seekBar2.setProgress((int) percent2);
        porcentaje3.setText(String.format("%.0f%%", percent3));
        seekBar3.setProgress((int) percent3);
        porcentaje4.setText(String.format("%.0f%%", percent4));
        seekBar4.setProgress((int) percent4);

        nayib.setText("Nayib Bukele " + "("+ (voto1) +")");
        gerson.setText("Gerson Martinez " + "("+ (voto2) +")");
        maduro.setText("Nicolas Maduro " + "("+ (voto3) +")");
        norman.setText("Norman Quijano " + "("+ (voto4) +")");

    }
}