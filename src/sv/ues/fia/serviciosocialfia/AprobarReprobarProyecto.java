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
import android.widget.ScrollView;
import android.widget.TextView;

public class AprobarReprobarProyecto extends Activity {
	
	TextView NombreProyecto;
	TextView DescripcionProyecto;
	TextView Modalidad;
	TextView Alumno;
	TextView Beneficiario;
	Button btnAprobar;
	Button btnReprobar;
public static String idproyecto;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aprobar_reprobar_proyecto);
	
		
		NombreProyecto=(TextView)findViewById(R.id.ClblContenidoNombreProyecto);
		DescripcionProyecto=(TextView)findViewById(R.id.CtextviewContenidoDescripcionProyecto);
		Modalidad=(TextView)findViewById(R.id.ClblcontenidoModalidad);
		Alumno=(TextView)findViewById(R.id.ClblContenidoAlumno);
		Beneficiario=(TextView)findViewById(R.id.ClblContenidoBeneficiario);
		//NombreProyecto.setText(idproyecto);
		CargarDatos(idproyecto);
		
		
		
		/*//LISTENER BOTON APROBAR
		
		 btnAprobar.setOnClickListener (new OnClickListener () {  
            @ Override  
            
            public void onClick (View v) {  
           	 //lo que hara el boton al presionarlo
           	 
            	
            	//Aprobar();
            	
            	
            	
            	
                              
            }  
       }); 
		 
		//LISTENER BOTON REROBAR
		 btnReprobar.setOnClickListener (new OnClickListener () {  
            @ Override  
            public void onClick (View v) {  
           	 //lo que hara el boton al presionarlo
           	 
            	
                              
            }  
       }); */ 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aprobar_reprobar_proyecto, menu);
		return true;
	}
	
	
	//PONER VALORES A LOS TEXTVIEW
	public void CargarDatos(String idproyecto){
		BDControl helper=new BDControl(this);
		Proyecto P=new Proyecto();
		AlumnoExpediente A=new AlumnoExpediente();
	//	TipoDeProyecto T=new TipoDeProyecto();
		Beneficiario B=new Beneficiario();
		P=helper.ConsultarProyecto(idproyecto);
		A=helper.ConsultarExpediente(P.getIdExpediente());
		B=helper.ConsultarBeneficiario(P.getIdBeneficiario());
		//T=helper.ConsultarTipoProyecto(P.getIdTipoProyecto());
		NombreProyecto.setText(P.getNombre());
	    DescripcionProyecto.setText(P.getDescripcion());
		Alumno.setText(A.getNombre()+"  "+A.getApellido());
		Beneficiario.setText(B.getNombreOrganizacion());
		//Modalidad.setText(T.getModalidadProyecto());
	}
	
	
	//APROBAR PROYECTO
	/*public void Aprobar()
	{
		 AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);  
         dialogo1.setTitle("Importante");  
         dialogo1.setMessage("¿ Esta Seguro que desea Aprobar ester Proyecto?");            
         dialogo1.setCancelable(false);  
         dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {  
             public void onClick(DialogInterface dialogo1, int id) {  
                 // SI ACEPTAMOS  
             }  
         });  
         dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
             public void onClick(DialogInterface dialogo1, int id) {  
                 //SI CANCELAMOS
             }  
         });            
         dialogo1.show(); 
		
		
	}*/

}
