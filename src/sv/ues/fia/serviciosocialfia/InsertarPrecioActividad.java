package sv.ues.fia.serviciosocialfia;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class InsertarPrecioActividad extends Activity {
	//Lista con los tipos de actividades
ArrayList<String>NombreTipo=new ArrayList<String>();
ArrayList<String>idTipo=new ArrayList<String>();
Spinner Listanombres;
Button btnInsertarPrecio;
EditText EditFechaIni;
EditText Precio;
EditText observacion;
BDControl helper=new BDControl(this);
static public String valorseleccionado;
//TipoDeTrabajo tipodetrabajo=new TipoDeTrabajo();

//llenamos el listview



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insertar_precio_actividad);
		helper.consultarTipoTrabajo(NombreTipo, idTipo);
		Listanombres=(Spinner)findViewById(R.id.CspinnerTipoTrabajo);
		btnInsertarPrecio=(Button)findViewById(R.id.CbtnInsertarPrecio);
		EditFechaIni=(EditText)findViewById(R.id.CeditTextFechaIni);
		Precio=(EditText)findViewById(R.id.CEditTextPrecio);
		observacion=(EditText)findViewById(R.id.CeditTextObservacionPrecio);
	
		//llenamos el combobox
	
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, NombreTipo);
		   Listanombres.setAdapter(adaptador);
		   
		   Listanombres.setOnItemSelectedListener(new OnItemSelectedListener() {

			   
			   
			   /*public void onItemClick(AdapterView<?> parent, View view,
	                     int position, long id) {
				   
			   }*/
			   
			   
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				// Spinner  item selected index
                int itemPosition     = position;
                
                // sSpinner selected item value
                valorseleccionado   = (String) idTipo.get(itemPosition);
               
                   
                 // Show Alert 
                 Toast.makeText(getApplicationContext(),
                   "Position :"+itemPosition+"  ListItem : " +valorseleccionado , Toast.LENGTH_LONG)
                   .show();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			   
			  
		});
		   
		   //EVENTO DEL BOTON
		   btnInsertarPrecio.setOnClickListener (new OnClickListener () {  
	            @ Override  
	            
	            public void onClick (View v) {  
	           	 //lo que hara el boton al presionarlo
	            	actualizarfecha();
	            	InsertarPrecio();
	            	
	            	   
	            }  
	       }); 
	
   
          
		    
		  
	}
	
	
	public void InsertarPrecio()
	{
		  Precios precio=new Precios(); 	
 	    
      	precio=helper.consultarPrecio();
      	if(precio!=null)
      	{
      		
      		//INSERTAMOS EL NUEVO PRECIO
      		int nuevocorrelativo=0;
      		nuevocorrelativo=precio.getCorrelativo();
      		nuevocorrelativo=nuevocorrelativo+1;
      		
      		precio.setCorrelativo(nuevocorrelativo);
      		//precio.setCorrelativo(Integer.toString(nuevocorrelativo));
      		precio.setIdTipoDeTrabajo(valorseleccionado);
      		precio.setFechaInicialApliPre(EditFechaIni.getText().toString());
      		precio.setFechaFinalApliPre("VIGENTE");//LA FECHA INICIAL DEL SIGUIENTE ES LA FINAL DEL ANTERIOR
      		precio.setPrecio(Float.parseFloat(Precio.getText().toString()));
      		precio.setObservacion(observacion.getText().toString());
      		//INSERTAMOS A LA BASE DE DATOS
      		
     		
            String msj;
      		msj=helper.insertar(precio);
      		
      		AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
     		
    		 dialogo1.setMessage(msj);
    		 dialogo1.show();
      		
      		EditFechaIni.setText("");
      		Precio.setText("");
      		observacion.setText("");
      	
  
      	}
      	
      	else
      	{
      		int nuevocorrelativo=1;
      		
      		
      		precio.setCorrelativo(nuevocorrelativo);
      		precio.setIdTipoDeTrabajo(valorseleccionado);
      		precio.setFechaInicialApliPre(EditFechaIni.getText().toString());
      		precio.setFechaFinalApliPre(null);//LA FECHA INICIAL DEL SIGUIENTE ES LA FINAL DEL ANTERIOR
      		precio.setPrecio(Float.parseFloat(Precio.getText().toString()));
      		precio.setObservacion(observacion.getText().toString());
      		//INSERTAMOS A LA BASE DE DATOS
      		helper.insertar(precio);
      		
      	}
	}
	public void actualizarfecha(){
		
		  Precios p=new Precios();
		  
 	     String msj;
      	p=helper.consultarPrecioActualizarFecha(valorseleccionado,EditFechaIni.getText().toString());
      	
      	if(p!=null){
      		
      		msj="Fecha Final"+p.getFechaFinalApliPre()+"CORR: "+p.getCorrelativo();
          	AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
     		
    		 dialogo1.setMessage(msj);
    		 dialogo1.show();
      		
      	}
      	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insertar_precio_actividad, menu);
		return true;
	}

}
