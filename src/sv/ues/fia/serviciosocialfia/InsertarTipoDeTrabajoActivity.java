package sv.ues.fia.serviciosocialfia;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InsertarTipoDeTrabajoActivity extends Activity {
Button btnInsertarTipo ;
EditText Codigo;
EditText Tipo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insertar_tipo_de_trabajo);
		
		btnInsertarTipo=(Button)findViewById(R.id.CbtnInsertarTTrabajo1);
		Codigo=(EditText)findViewById(R.id.CedittextCodigoTTrabajo);
		Tipo=(EditText)findViewById(R.id.CedittextTipoDeTrabajo);
		
		btnInsertarTipo.setOnClickListener (new OnClickListener () {  
            @ Override  
            
            public void onClick (View v) {  
           	 //lo que hara el boton al presionarlo
           	 
            	InsertarTipo();
            	
                              
            }  
       }); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insertar_tipo_de_trabajo, menu);
		return true;
	}
	
	public void InsertarTipo()
	{
	String msj;
		 BDControl helper=new BDControl(this);
		 TipoDeTrabajo TipoTrabajo=new TipoDeTrabajo();
		 TipoTrabajo.setIdTipoTrabajo(Codigo.getText().toString());
		 TipoTrabajo.setNombreTipo(Tipo.getText().toString());
		 msj=helper.insertar(TipoTrabajo);
		AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
		
		 dialogo1.setMessage(msj);
		 dialogo1.show();
		 Codigo.setText("");
		 Tipo.setText("");
		
	}

}
