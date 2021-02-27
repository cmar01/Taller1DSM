package com.edu.sv.salario;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public EditText nombres;
    public EditText apellidos;
    public EditText horas;
    public Button calcular;
    private Spinner spinner;
    String selec = "";
    Validaciones validar;
    ArrayList<Empleados> empleado = new ArrayList<>();
    int count = 0;
    Empleados emp;
    boolean bandera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.locations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        nombres = (EditText) findViewById(R.id.txtNombres);
        apellidos = (EditText) findViewById(R.id.txtApellidos);
        horas = (EditText) findViewById(R.id.txtHoras);
        calcular = (Button) findViewById(R.id.btnCalcular);
        validar = new Validaciones();
        bandera = false;

    }

    public void registrar(View v) {
        try {
            int hora = Integer.parseInt(horas.getText().toString());
            double isss = 0.00;
            double afp = 0.00;
            double renta = 0.00;
            if (!validar.Vacio(nombres) && !validar.Vacio(apellidos) && !validar.Vacio(horas)) {
                if (validar.soloLetras(nombres.getText().toString()) && validar.soloLetras(apellidos.getText().toString())) {
                    if (hora != 0) {
                        count++;
                        if (count <= 3) {
                            if (selec.equals("Gerente")) {
                                String value = horas.getText().toString();
                                float finalValue = Float.parseFloat(value);
                                float bono, salarioLiquido, salario, descuentos;

                                if (finalValue <= 160) {
                                    emp = new Empleados();
                                    emp.setNombre(nombres.getText().toString());
                                    emp.setApellido(apellidos.getText().toString());
                                    emp.setCargo("Gerente");
                                    salario = (float) ((finalValue * 9.75));
                                    emp.setIsss(salario * 0.0525);
                                    emp.setAfp(salario * 0.0688);
                                    emp.setRenta(salario * 0.10);
                                    descuentos = (float) (isss + afp + renta);
                                    emp.setSalarioLiquido(salario - descuentos);
                                    emp.setBono(Float.toString(((float) ((emp.getSalarioLiquido() * 0.1) + emp.getSalarioLiquido()))));
                                    empleado.add(emp);

                                } else if (finalValue > 160) {
                                    emp = new Empleados();
                                    emp.setNombre(nombres.getText().toString());
                                    emp.setApellido(apellidos.getText().toString());
                                    emp.setCargo("Gerente");
                                    salario = (float) ((160 * 9.75) + ((finalValue - 160) * 11.50));
                                    emp.setIsss(salario * 0.0525);
                                    emp.setAfp(salario * 0.0688);
                                    emp.setRenta(salario * 0.10);
                                    descuentos = (float) (isss + afp + renta);
                                    emp.setSalarioLiquido(salario - descuentos);
                                    emp.setBono(Float.toString(((float) ((emp.getSalarioLiquido() * 0.1) + emp.getSalarioLiquido()))));
                                    empleado.add(emp);
                                }

                            } else if (selec.equals("Asistente")) {
                                String value = horas.getText().toString();
                                float finalValue = Float.parseFloat(value);
                                float bono, salarioLiquido, salario, descuentos;

                                if (finalValue <= 160) {
                                    emp = new Empleados();
                                    emp.setNombre(nombres.getText().toString());
                                    emp.setApellido(apellidos.getText().toString());
                                    emp.setCargo("Asistente");
                                    salario = (float) ((finalValue * 9.75));
                                    emp.setIsss(salario * 0.0525);
                                    emp.setAfp(salario * 0.0688);
                                    emp.setRenta(salario * 0.10);
                                    descuentos = (float) (isss + afp + renta);
                                    emp.setSalarioLiquido(salario - descuentos);
                                    emp.setBono(Float.toString(((float) ((emp.getSalarioLiquido() * 0.05) + emp.getSalarioLiquido()))));
                                    empleado.add(emp);

                                } else if (finalValue > 160) {
                                    emp = new Empleados();
                                    emp.setNombre(nombres.getText().toString());
                                    emp.setApellido(apellidos.getText().toString());
                                    emp.setCargo("Asistente");
                                    salario = (float) ((160 * 9.75) + ((finalValue - 160) * 11.50));
                                    emp.setIsss(salario * 0.0525);
                                    emp.setAfp(salario * 0.0688);
                                    emp.setRenta(salario * 0.10);
                                    descuentos = (float) (isss + afp + renta);
                                    emp.setSalarioLiquido(salario - descuentos);
                                    emp.setBono(Float.toString(((float) ((emp.getSalarioLiquido() * 0.05) + emp.getSalarioLiquido()))));
                                    empleado.add(emp);
                                }

                            } else if (selec.equals("Secretaria")) {
                                String value = horas.getText().toString();
                                float finalValue = Float.parseFloat(value);
                                float bono, salarioLiquido, salario, descuentos;

                                if (finalValue <= 160) {
                                    emp = new Empleados();
                                    emp.setNombre(nombres.getText().toString());
                                    emp.setApellido(apellidos.getText().toString());
                                    emp.setCargo("Secretaria");
                                    salario = (float) ((finalValue * 9.75));
                                    emp.setIsss(salario * 0.0525);
                                    emp.setAfp(salario * 0.0688);
                                    emp.setRenta(salario * 0.10);
                                    descuentos = (float) (isss + afp + renta);
                                    emp.setSalarioLiquido(salario - descuentos);
                                    emp.setBono(Float.toString(((float) ((emp.getSalarioLiquido() * 0.03) + emp.getSalarioLiquido()))));
                                    empleado.add(emp);

                                } else if (finalValue > 160) {
                                    emp = new Empleados();
                                    emp.setNombre(nombres.getText().toString());
                                    emp.setApellido(apellidos.getText().toString());
                                    emp.setCargo("Secretaria");
                                    salario = (float) ((160 * 9.75) + ((finalValue - 160) * 11.50));
                                    emp.setIsss(salario * 0.0525);
                                    emp.setAfp(salario * 0.0688);
                                    emp.setRenta(salario * 0.10);
                                    descuentos = (float) (isss + afp + renta);
                                    emp.setSalarioLiquido(salario - descuentos);
                                    emp.setBono(Float.toString(((float) ((emp.getSalarioLiquido() * 0.03) + emp.getSalarioLiquido()))));
                                    empleado.add(emp);
                                }

                            } else if (selec.equals("Empleado")) {
                                String value = horas.getText().toString();
                                float finalValue = Float.parseFloat(value);
                                float bono, salarioLiquido, salario, descuentos;

                                if (finalValue <= 160) {
                                    emp = new Empleados();
                                    emp.setNombre(nombres.getText().toString());
                                    emp.setApellido(apellidos.getText().toString());
                                    emp.setCargo("Empleado");
                                    salario = (float) ((finalValue * 9.75));
                                    emp.setIsss(salario * 0.0525);
                                    emp.setAfp(salario * 0.0688);
                                    emp.setRenta(salario * 0.10);
                                    descuentos = (float) (isss + afp + renta);
                                    emp.setSalarioLiquido(salario - descuentos);
                                    emp.setBono(Float.toString(((float) ((emp.getSalarioLiquido() * 0.02) + emp.getSalarioLiquido()))));
                                    empleado.add(emp);

                                } else if (finalValue > 160) {
                                    emp = new Empleados();
                                    emp.setNombre(nombres.getText().toString());
                                    emp.setApellido(apellidos.getText().toString());
                                    emp.setCargo("Empleado");
                                    salario = (float) ((160 * 9.75) + ((finalValue - 160) * 11.50));
                                    emp.setIsss(salario * 0.0525);
                                    emp.setAfp(salario * 0.0688);
                                    emp.setRenta(salario * 0.10);
                                    descuentos = (float) (isss + afp + renta);
                                    emp.setSalarioLiquido(salario - descuentos);
                                    emp.setBono(Float.toString(((float) ((emp.getSalarioLiquido() * 0.02) + emp.getSalarioLiquido()))));
                                    empleado.add(emp);
                                }
                            }
                            nombres.setText(null);
                            apellidos.setText(null);
                            horas.setText(null);
                            Toast.makeText(getApplicationContext(), "Empleado Ingresado Exitosamente", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Ya registro 3 empleados", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Las horas no pueden ser menores o iguales a 0", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Solo letras!", Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Ingrese las horas!", Toast.LENGTH_LONG).show();
        }
    }


    public int buscarCargo(String emp) {
        int index = -1;
        int bound = empleado.size();
        for (int cargoInd = 0; cargoInd < bound; cargoInd++) {
            if (empleado.get(cargoInd).getCargo().equals(emp)) {
                index = cargoInd;
                break;
            }
        }
        return index;
    }


    public void enviar(View v) {

        try {
            if(count < 3){
                Toast.makeText(getApplicationContext(), "Debe ingresar 3 Empleados", Toast.LENGTH_LONG).show();
            }else{
                if (buscarCargo("Gerente") == 0 && buscarCargo("Asistente") == 1 && buscarCargo("Secretaria") == 2) {
                    Intent i = new Intent(this, resultados.class);
                    Bundle args = new Bundle();
                    args.putSerializable("miList", (Serializable)empleado);
                    bandera = true;
                    empleado.get(0).setBono("No hay Bono");
                    empleado.get(1).setBono("No hay Bono");
                    empleado.get(2).setBono("No hay Bono");
                    i.putExtra("miLista", args);
                    i.putExtra("flag", bandera);
                    startActivity(i);
                } else {
                    Intent i = new Intent(this, resultados.class);
                    Bundle args = new Bundle();
                    args.putSerializable("miList", (Serializable)empleado);
                    bandera = false;
                    i.putExtra("miLista", args);
                    i.putExtra("flag", bandera);
                    startActivity(i);
                }
            }
        }catch (Exception exp){

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String choice = adapterView.getItemAtPosition(position).toString();
        selec = choice;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}