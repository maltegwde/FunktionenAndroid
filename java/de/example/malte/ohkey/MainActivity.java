package de.example.malte.ohkey;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Double para, pot, yA;
    int i = 0, x = 101;
    public boolean quadF = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        para = 1.0;
        pot = 2.0;
        yA = 0.0;

        Switch qswitch = (Switch) findViewById(R.id.quadSwitch);
        qswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView tv1 = (TextView) findViewById(R.id.tv1);
                EditText etPot = (EditText) findViewById(R.id.etPot);
                if (isChecked) {
                    quadF = true;
                    pot = 2.0;
                    Toast toast = Toast.makeText(getApplicationContext(), "Quadratische Funktion aktiviert", Toast.LENGTH_SHORT);
                    toast.show();
                    tv1.setText("f(x)=" + para + "x" + "**" + pot + " + " + yA);
                    etPot.setVisibility(View.VISIBLE);
                } else {
                    quadF = false;
                    pot = 1.0;
                    Toast toast = Toast.makeText(getApplicationContext(), "Quadratische Funktion deaktiviert", Toast.LENGTH_SHORT);
                    toast.show();
                    tv1.setText("f(x)=" + para + "x" + " + " + yA);
                    etPot.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    protected void showInputDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View promptView = layoutInflater.inflate(R.layout.dialog_werte, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText etmax = (EditText) promptView.findViewById(R.id.et_max_dl);
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        x = Integer.parseInt(etmax.getText().toString());
                        x++;
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public void bt1Click(View v) {
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        EditText etPara = (EditText) findViewById(R.id.etPara);
        EditText etPot = (EditText) findViewById(R.id.etPot);
        EditText etyA = (EditText) findViewById(R.id.etyA);

        if (etPara.getText().toString().isEmpty() || etPara.getText().toString().equals(0) ) {
            para = 1.0;
        } else {
            para = Double.parseDouble(etPara.getText().toString());
            if (quadF) {
                tv1.setText("f(x)=" + para + "x" + "**" + pot + " + " + yA);
            } else {
                tv1.setText("f(x)=" + para + "x" + " + " + yA);
            }
        }

        if (etPot.getText().toString().isEmpty() || etPot.getText().toString().equals(0)) {
            if (quadF)  {
                pot = 2.0;
            }   else {
                pot = 1.0;
            }
        } else {
            pot = Double.parseDouble(etPot.getText().toString());
            tv1.setText("f(x)=" + para + "x" + "**" + pot + " + " + yA);
        }

        if (etyA.getText().toString().isEmpty() || etyA.getText().toString().equals(0)) {
            yA = 0.0;
        } else {
            yA = Double.parseDouble(etyA.getText().toString());
            if (quadF) {
                tv1.setText("f(x)=" + para + "x" + "**" + pot + " + " + yA);
            } else {
                tv1.setText("f(x)=" + para + "x" + " + " + yA);
            }
        }

        Toast toast = Toast.makeText(getApplicationContext(), "Werte übernommen!", Toast.LENGTH_SHORT);
        toast.show();

    }

    public void bt1weiterClick(View v) {
        setContentView(R.layout.werte);

        TextView tvFct = (TextView) findViewById(R.id.tvFct);

        Integer xWerte[] = new Integer[x];
        Double yWerte[] = new Double[x];
        String werte[] = new String[x];

        for(i = 0; i < x; i++) {
            xWerte[i] = i;
            if (i == 0) {
                yWerte[i] = yA;
            }   else {
                yWerte[i] = (para * Math.pow(i, pot) + yA);
            }
            werte[i] = "             " + xWerte[i].toString() + "              " + yWerte[i].toString();
        }

        ListAdapter myAda = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, werte);
        ListView mylv = (ListView)findViewById(R.id.listView1);
        mylv.setAdapter(myAda);

        tvFct.setText("f(x)=" + para + "x" + "**" + pot + " + " + yA);
    }

    public void back_Click(View v) {
        setContentView(R.layout.activity_main);
        TextView tv1 = (TextView) findViewById(R.id.tv1);

        tv1.setText("f(x)=" + para + "x" + "**" + pot + " + " + yA);

        Switch qswitch = (Switch) findViewById(R.id.quadSwitch);
        qswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TextView tv1 = (TextView) findViewById(R.id.tv1);
                EditText etPot = (EditText) findViewById(R.id.etPot);
                if (isChecked) {
                    quadF = true;
                    pot = 2.0;
                    Toast toast = Toast.makeText(getApplicationContext(), "Quadratische Funktion aktiviert", Toast.LENGTH_SHORT);
                    toast.show();
                    tv1.setText("f(x)=" + para + "x" + "**" + pot + " + " + yA);
                    etPot.setVisibility(View.VISIBLE);
                } else {
                    quadF = false;
                    pot = 1.0;
                    Toast toast = Toast.makeText(getApplicationContext(), "Quadratische Funktion deaktiviert", Toast.LENGTH_SHORT);
                    toast.show();
                    tv1.setText("f(x)=" + para + "x" + " + " + yA);
                    etPot.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settingsMenu:
                return true;
            case R.id.wertebereichMenu:
                showInputDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}