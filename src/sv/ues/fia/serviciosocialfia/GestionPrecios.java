package sv.ues.fia.serviciosocialfia;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class GestionPrecios extends Activity {
ImageButton btnInsertar;
ImageButton btnModElim;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gestion_precios);
		
		btnInsertar=(ImageButton)findViewById(R.id.CImgButtonInsertPrecio);
		btnModElim=(ImageButton)findViewById(R.id.CimgBtnModElimPrecio);
		
		//LISTENER BOTON INSERTAR
		 btnInsertar.setOnClickListener (new OnClickListener () {  
             @ Override  
             public void onClick (View v) {  
            	 //Abrimos el Activity para insertar un nuevo precio
            	 Intent AbrirActInsertPrecio = new Intent(GestionPrecios.this, InsertarPrecioActividad.class);
                 startActivity(AbrirActInsertPrecio  );
                               
             }  
        });  
		 
		 //LISTENER BOTON MODIFICAR Y ELIMINAR
		 btnModElim.setOnClickListener (new OnClickListener () {  
             @ Override  
             public void onClick (View v) {  
            	 //Abrimos el Activity para insertar un nuevo precio
            	 Intent AbrirActModElim = new Intent(GestionPrecios.this, ConsultarPreciosActivity.class);
                 startActivity(AbrirActModElim );
                               
             }  
        });  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gestion_precios, menu);
		return true;
	}
	
	
	 

}
