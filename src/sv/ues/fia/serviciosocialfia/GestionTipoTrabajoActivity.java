package sv.ues.fia.serviciosocialfia;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class GestionTipoTrabajoActivity extends Activity {
ImageButton btnnuevo;
ImageButton btnGestion;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gestion_tipo_trabajo);
		btnnuevo=(ImageButton)findViewById(R.id.CimageButtonNuevoTipoTrabajo);
		btnGestion=(ImageButton)findViewById(R.id.CimageButtonGestionTipoTrabajo);
		
		//LISTENER BOTON INSERTAR
		 btnnuevo.setOnClickListener (new OnClickListener () {  
            @ Override  
            public void onClick (View v) {  
           	 //Abrimos el Activity para insertar un nuevo precio
           	 Intent AbrirActInsertPrecio = new Intent(GestionTipoTrabajoActivity.this, InsertarTipoDeTrabajoActivity.class);
                startActivity(AbrirActInsertPrecio  );
                              
            }  
       });  
		 
		 //LISTENER BOTON MODIFICAR Y ELIMINAR
		 btnGestion.setOnClickListener (new OnClickListener () {  
            @ Override  
            public void onClick (View v) {  
           	 //Abrimos el Activity para insertar un nuevo precio
           	 Intent AbrirActModElim = new Intent(GestionTipoTrabajoActivity.this, ConsultarTipodeTrabajoActivity.class);
                startActivity(AbrirActModElim );
                              
            }  
       }); 
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gestion_tipo_trabajo, menu);
		return true;
	}

}
