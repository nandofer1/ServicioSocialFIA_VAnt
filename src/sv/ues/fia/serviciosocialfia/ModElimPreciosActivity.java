package sv.ues.fia.serviciosocialfia;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ModElimPreciosActivity extends Activity {
	BDControl helper=new BDControl(this);
public static String idprecio;
public static String nombreTipoTrabajo;
public static String idtipotrabajo;
public static String FechaIn;

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
		
		//BOTON MODIFICAR
				btnMod.setOnClickListener (new OnClickListener () {  
		            @ Override  
		            public void onClick (View v) {  
		           	 //lo que hara el boton al presionarlo
		           	 
		            	ClickModificar();
		                              
		            }  
		       }); 
				
				//BOTON ELIMINAR
				btnElim.setOnClickListener (new OnClickListener () {  
		            @ Override  
		            public void onClick (View v) {  
		           	 //lo que hara el boton al presionarlo
		           	 
		            	ClickEliminar();
		                              
		            }  
		       }); 
				
				//BOTON CANCELAR
				btnCancelar.setOnClickListener (new OnClickListener () {  
		            @ Override  
		            public void onClick (View v) {  
		           	 //lo que hara el boton al presionarlo
		            	 Intent RegresarVerPrecios = new Intent(ModElimPreciosActivity.this, ConsultarPreciosActivity.class);
		                 startActivity( RegresarVerPrecios );
		            	finish();
		                              
		            }  
		       }); 
				
				//BOTON GUARDAR MODIFICACION
				btnGMod.setOnClickListener (new OnClickListener () {  
		            @ Override  
		            public void onClick (View v) {  
		           	 //lo que hara el boton al presionarlo
		           	 
		            	 ClickGuardarModificar();
		                              
		            }  
		       }); 
		
		
		
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

	
	
	
	//si seleccionamos Modificar datos
	public void ClickModificar()
	{
		 btnGMod.setEnabled(true);
		 ContenidoObservacion.setEnabled(true);
		 btnMod.setEnabled(false);		
		 btnElim.setEnabled(false);
		 ContenidoPrecio.setEnabled(true);
	}
	
	
	//si seleccionamos Guardar la Modificacion datos
		public void ClickGuardarModificar()
		{
			Precios precio=new Precios();
			precio.setCorrelativo(Integer.parseInt(idprecio));
			precio.setIdTipoDeTrabajo(idtipotrabajo);
			precio.setPrecio(Float.parseFloat(ContenidoPrecio.getText().toString()));
			precio.setFechaInicialApliPre(FechaIn);
			precio.setFechaFinalApliPre(fechafin.getText().toString());
			precio.setObservacion(ContenidoObservacion.getText().toString());
			String msj;
			msj=helper.actualizar(precio);
			AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this); 
			dialogo1.setMessage(msj);
			dialogo1.show();
			 Intent RegresarPrecios = new Intent(ModElimPreciosActivity.this, ConsultarPreciosActivity.class);
             startActivity( RegresarPrecios );
        	finish();
			
		}
		
	
		//si seleccionamos Eliminar el registro
		public void ClickEliminar()
		{
			
			
			 AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);  
	         dialogo1.setTitle("Importante");  
	         dialogo1.setMessage("¿ Esta Seguro que desea Eliminar este Registro?");            
	         dialogo1.setCancelable(false);  
	         dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {  
	             public void onClick(DialogInterface dialogo1, int id) {  
	                 // SI ACEPTAMOS  
	            	
	            	
	            	Precios precio=new Precios();
	     			
			
	            	
	            	
	            	
	        precio.setCorrelativo(Integer.parseInt(idprecio));
			precio.setIdTipoDeTrabajo(idtipotrabajo);
			precio.setFechaInicialApliPre(FechaIn);
			precio.setFechaFinalApliPre(fechafin.getText().toString());
			precio.setObservacion(ContenidoObservacion.getText().toString());
	     		String msj;
	     			msj=helper.eliminar(precio);
	     			 Toast.makeText(getApplicationContext(),
		                      msj , Toast.LENGTH_LONG)
		                      .show();
	     			
	     			 //cambios fecha al precio anterior de este tipo de trabajo
	     			 precio=helper.consultarPrecio(idtipotrabajo);
	     			 if(precio!=null)
	     			 {
	     			 precio=helper.consultarPrecioActualizarFecha(idtipotrabajo, "Vigente");
	     			 }
	     			Intent RegresarPrecios = new Intent(ModElimPreciosActivity.this, ConsultarPreciosActivity.class);
             startActivity( RegresarPrecios );
        	finish();
	            	 
	             }  
	         });  
	         dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
	             public void onClick(DialogInterface dialogo1, int id) {  
	                 //SI CANCELAMOS
	             }  
	         });            
	         dialogo1.show(); 
			
		}
		
	
	
}
