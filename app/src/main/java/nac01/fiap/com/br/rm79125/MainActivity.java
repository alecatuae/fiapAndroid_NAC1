package nac01.fiap.com.br.rm79125;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rdgMaterial;
    EditText etxtM2;
    CheckBox chkFrete;
    TextView txtValor;
    double calculo = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgMaterial = findViewById(R.id.rdgMaterial);
        etxtM2 = findViewById(R.id.etxtM2);
        chkFrete = findViewById(R.id.chkFrete);
        txtValor = findViewById(R.id.txtValor);
    }

    public void calcular(View view) {

       double calculo = 0.0;

        int id = rdgMaterial.getCheckedRadioButtonId();
        switch (id) {
            case R.id.rdbPisoalbania45x45:
                calculo +=  11.90;
                break;
            case R.id.rdbPorcelanatoperlatobranco:
                calculo +=  39.90;
                break;
            case R.id.rdbPrisobrancobaixobrilho:
                calculo += 24.90;
                break;
            case R.id.rdbRevestimentomosaico:
                calculo += 16.90;
                break;
        }


        Editable texto = etxtM2.getText();

        calculo *= Double.parseDouble(String.valueOf(texto));

        if ( chkFrete.isChecked() ) {
            calculo = calculo * 1.3;
        }

        txtValor.setText( "R$ " + String.valueOf(calculo) );

    }
}
