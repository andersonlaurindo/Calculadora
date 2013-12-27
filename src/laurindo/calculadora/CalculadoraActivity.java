package laurindo.calculadora;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculadoraActivity extends Activity {
	EditText num1;
	EditText num2;
	Button calcular;
	Button limpar;

	TextView resultadoSoma;
	TextView resultadoDiferenca;
	TextView resultadoProduto;
	TextView resultadoQuociente;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		num1 = (EditText) findViewById(R.id.edt_num1);
		num2 = (EditText) findViewById(R.id.edt_num2);
		calcular = (Button) findViewById(R.id.btn_calcular);
		limpar = (Button) findViewById(R.id.btn_limpar);

		resultadoSoma = (TextView) findViewById(R.id.resultado_soma);
		resultadoProduto = (TextView) findViewById(R.id.resultado_produto);
		resultadoQuociente = (TextView) findViewById(R.id.resultado_quociente);
		resultadoDiferenca = (TextView) findViewById(R.id.resultado_diferenca);

		calcular.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				String numeroUmString = num1.getText().toString();
				String numeroDoisString = num2.getText().toString();

				double numeroUmValor = Double.parseDouble(numeroUmString);
				double numeroDoisValor = Double.parseDouble(numeroDoisString);

				double soma = numeroUmValor + numeroDoisValor;
				double diferenca = numeroUmValor - numeroDoisValor;
				double produto = numeroUmValor * numeroDoisValor;
				double quociente;

				if (Double.compare(0, numeroDoisValor) == 0) {
					quociente = Double.POSITIVE_INFINITY;
				} else {
					quociente = numeroUmValor / numeroDoisValor;
				}

				resultadoSoma.setText(String.valueOf(soma));
				resultadoDiferenca.setText(diferenca + "");
				resultadoProduto.setText(produto + "");
				resultadoQuociente.setText(quociente + "");

			}
		});
		limpar.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				num1.setText("");
				num2.setText("");

				resultadoSoma.setText("0");
				resultadoDiferenca.setText("0");
				resultadoProduto.setText("0");
				resultadoQuociente.setText("0");

			}
		});

	}
}