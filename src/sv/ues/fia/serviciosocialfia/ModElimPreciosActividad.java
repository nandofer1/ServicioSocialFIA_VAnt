package sv.ues.fia.serviciosocialfia;

import java.util.ArrayList;

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

public class ModElimPreciosActividad extends Activity {
	
	BDControl helper=new BDControl(this);
	public static String idtipotrabajo;
	TextView Contenidoid;
	EditText EditNombre;
	Button btnMod;
	Button btnElim;
	Button btnGuarMod;
	Button btnCancelar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mod_elim_precios_actividad);
		Contenidoid=(TextView)findViewById(R.id.ClblContenidoIdTipoTrabajo);
		EditNombre=(EditText)findViewById(R.id.CEditContenedorTipoTrabajo);
		btnMod=(Button)findViewById(R.id.CbtnModTipoTrabajo);
		btnElim=(Button)findViewById(R.id.CbtnElimTipoTrabajo);
		btnGuarMod=(Button)findViewById(R.id.CbtnGModTipoTrabajo);
		btnCancelar=(Button)findViewById(R.id.CbrnCancelarTipoTrabajo);
		
		//mostrar los datos en los objetos
		Mostrardatos();
		
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
            	 Intent RegresarVerTipoPoryecto = new Intent(ModElimPreciosActividad.this, ConsultarTipodeTrabajoActivity.class);
                 startActivity( RegresarVerTipoPoryecto );
            	finish();
                              
            }  
       }); 
		
		//BOTON GUARDAR MODIFICACION
		btnGuarMod.setOnClickListener (new OnClickListener () {  
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
		getMenuInflater().inflate(R.menu.mod_elim_precios_actividad, menu);
		return true;
	}
	
	public void Mostrardatos()
	{
		TipoDeTrabajo tipoTrabajo=new TipoDeTrabajo();
		tipoTrabajo=helper.ConsultarTipoTrabajo(idtipotrabajo);
		Contenidoid.setText(tipoTrabajo.getIdTipoTrabajo());
		EditNombre.setText(tipoTrabajo.getNombreTipo());
		
		EditNombre.setEnabled(false);
		btnGuarMod.setEnabled(false);
		
		
	}
	
	//si seleccionamos Modificar datos
	public void ClickModificar()
	{
		 btnGuarMod.setEnabled(true);
		 EditNombre.setEnabled(true);
		 btnMod.setEnabled(false);		
	}
	
	
	//si seleccionamos Guardar la Modificacion datos
		public void ClickGuardarModificar()
		{
			TipoDeTrabajo tipoTrabajomod=new TipoDeTrabajo();
			tipoTrabajomod.setIdTipoTrabajo(Contenidoid.getText().toString());
			tipoTrabajomod.setNombreTipo(EditNombre.getText().toString());
			String msj;
			msj=helper.actualizar(tipoTrabajomod);
			AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this); 
			dialogo1.setMessage(msj);
			dialogo1.show();
			 Intent RegresarVerTipoPoryecto = new Intent(ModElimPreciosActividad.this, ConsultarTipodeTrabajoActivity.class);
             startActivity( RegresarVerTipoPoryecto );
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
	            	
	            	
	            	 TipoDeTrabajo tipoTrabajoElim=new TipoDeTrabajo();
	     			tipoTrabajoElim.setIdTipoTrabajo(Contenidoid.getText().toString());
	     			tipoTrabajoElim.setNombreTipo(EditNombre.getText().toString());
	     		
	     			helper.eliminar(tipoTrabajoElim);
	     			Intent RegresarVerTipoPoryecto = new Intent(ModElimPreciosActividad.this, ConsultarTipodeTrabajoActivity.class);
	                startActivity( RegresarVerTipoPoryecto );
	                 
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
