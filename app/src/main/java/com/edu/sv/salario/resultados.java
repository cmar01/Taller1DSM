package com.edu.sv.salario;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class resultados extends AppCompatActivity {


    public TextView mayorSalario;
    public TextView menorSalario;
    public ListView info;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        info = (ListView) findViewById(R.id.listview1);
        mayorSalario = (TextView) findViewById(R.id.textView15);
        menorSalario = (TextView) findViewById(R.id.textView16);
        Empleados emp = new Empleados();

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("miLista");
        ArrayList<Empleados> empleado = (ArrayList<Empleados>) args.getSerializable("miList");
        Bundle bundle = getIntent().getExtras();
        boolean bandera = bundle.getBoolean("flag");


        ArrayAdapter <Empleados> adaptador = new ArrayAdapter<Empleados>(resultados.this, android.R.layout.simple_list_item_1, empleado);
        info.setAdapter(adaptador);

        Empleados maxS = Collections.max(empleado, Comparator.comparing(s -> s.getSalarioLiquido()));
        mayorSalario.setText("El mayor salario es de :" + maxS.getNombre());

        Empleados minS = Collections.min(empleado, Comparator.comparing(s -> s.getSalarioLiquido()));
        menorSalario.setText("El mayor salario es de :" + minS.getNombre());

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}