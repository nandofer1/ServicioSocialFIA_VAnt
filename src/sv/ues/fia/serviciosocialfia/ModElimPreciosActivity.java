package sv.ues.fia.serviciosocialfia;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ModElimPreciosActivity extends Activity {
public static String idprecio;
public static String nombreTipoTrabajo;
/*public static String FechaIni;
public static String Fechafin;
public static String FechaObser;*/
TextView contenidoTipoTrabajo;

TextView fechafin;
EditText ContenidoPrecio;
EditText ContenidoObservacion;
Button btnMod;
Button btnElim;
Button btnGMod;
Button btnCancelar;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mod_elim_precios);
		contenidoTipoTrabajo=(TextView)findViewById(R.id.ClblContenidoTipoTrabajoPrecio);
		
		fechafin=(TextView)findViewById(R.id.ClblContenidoFechaFinPrecios);
		ContenidoPrecio=(EditText)findViewById(R.id.ClblEditTextContendioPrecio);
		ContenidoObservacion=(EditText)findViewById(R.id.CEditTextContenidoObservacionPrecio);
		btnMod=(Button)findViewById(R.id.CbtnModPrecio);
		btnElim=(Button)findViewById(R.id.CbtnEliminarPrecio);
		btnGMod=(Button)findViewById(R.id.CbtnGModPrecio);
		 btnCancelar=(Button)findViewById(R.id.CbtnCancelarPrecio);
		 
		 
		 //agregar los datos a los controles
		SetDatos();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mod_elim_precios, menu);
		return true;
	}

	public void SetDatos()
	{
		ContenidoPrecio.setEnabled(false);
		ContenidoObservacion.setEnabled(false);
		contenidoTipoTrabajo.setText(nombreTipoTrabajo);
		btnGMod.setEnabled(false);
		
		BDControl helper = new BDControl(this);
		helper.consultarPrecio();
		Precios precio=new Precios();
		
		precio=helper.consultarPrecio(Integer.parseInt(idprecio));
		ContenidoPrecio.setText(Float.toString(precio.getPrecio()));
		ContenidoObservacion.setText(precio.getObservacion());
		fechafin.setText(precio.getFechaFinalApliPre());
	}

	
	
}
