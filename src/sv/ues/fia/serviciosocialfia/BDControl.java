package sv.ues.fia.serviciosocialfia;


import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class BDControl extends SQLiteOpenHelper {
//COSME
	private static final String[]camposProyecto = new String []
			{"IDPROYECTO","IDBENEFICIARIO","CARNETEMPLEADO","IDEXPEDIENTE","IDTIPOPROYECTO", "NOMBREDEPROYECTO","DESCRIPCIONPROYECTO","DURACIONPROYECTO","FECHAINICIOPROY","FECHAFINPROY","ESTADOPROYECTO","VALORPROYECTO"};
	
//COSME
	private static final String[]camposAlumnoExpediente = new String []
			{"IDEXPEDIENTE","IDBITACORA","CARNETEMPLEADO","CODCARRERA","CARNETALUMNO", "NOMBREALUMNO","APELLIDOALUMNO","SEXOALUMNO","FECHAINICIOSERVICIO","FECHAFINSERVICIO","ESTADOALUMNO","TELEFONO","EMAIL","OBSERVACIONES","VALORSERVICIO","HORASACUMULA","FECHAACUMULA"};
	
	//COSME
	private static final String[]camposBeneficiario = new String []
			{"IDBENEFICIARIO","CARNETEMPLEADO","NOMBREORGANIZACION","NOMBREREPRESENTANTE","APELLIDOREPRESENTANTE", "TELEFONOBENEF","DIRECCIONBENEF","EMAIL"};
	
	//COSME
		private static final String[]camposTipoProyecto = new String []
				{"IDTIPOPROYECTO","IDPROYECTO","MODALIDADPROYECTO"};
	
	// Nombre de nuestro archivo de base de datos
	private static final String NOMBRE_BD = "SSBD.s3db";

	// Versión de nuestra base de datos
	private static final int VERSION_BD = 1;

	// TABLAS DE LA BASE DE DATOS

	// Tabla AlumnoExpediente
	private static final String TABLA_ALUMNO_EXPEDIENTE = "create table ALUMNOEXPEDIENTE "
			+ "(IDEXPEDIENTE         CHAR(10)             not null,"
			+ "IDBITACORA           CHAR(10)             not null,"
			+ "CARNETEMPLEADO       CHAR(7),"
			+ "CODCARRERA           CHAR(4)              not null,"
			+ "CARNETALUMNO         CHAR(7)              not null,"
			+ "NOMBREALUMNO         CHAR(30)             not null,"
			+ "APELLIDOALUMNO       CHAR(30)             not null,"
			+ "SEXOALUMNO           CHAR(1)              not null,"
			+ "FECHAINICIOSERVICIO  CHAR(10)             not null,"
			+ "FECHAFINSERVICIO     CHAR(10),"
			+ "ESTADOALUMNO         CHAR(1)              not null,"
			+ "TELEFONO             CHAR(9),"
			+ "EMAIL                CHAR(15),"
			+ "OBSERVACIONES        CHAR(100),"
			+ "VALORSERVICIO        FLOAT,"
			+ "HORASACUMULA         INTEGER,"
			+ "FECHAACUMULA         CHAR(10),"
			+ "constraint PK_ALUMNOEXPEDIENTE primary key (IDEXPEDIENTE));";

	// Tabla Beneficiario
	private static final String TABLA_BENEFICIARIO = "create table BENEFICIARIO "
			+ "(IDBENEFICIARIO       CHAR(10)             not null,"
			+ "CARNETEMPLEADO       CHAR(7)              not null,"
			+ "NOMBREORGANIZACION   CHAR(50)             not null,"
			+ "NOMBREREPRESENTANTE  CHAR(30)             not null,"
			+ "APELLIDOREPRESENTANTE CHAR(30)             not null,"
			+ "TELEFONOBENEF        INTEGER,"
			+ "DIRECCIONBENEF       CHAR(50),"
			+ "EMAIL                CHAR(15),"
			+ "constraint PK_BENEFICIARIO primary key (IDBENEFICIARIO));";

	// Tabla Bitacora
	private static final String TABLA_BITACORA = "create table BITACORA "
			+ "(IDBITACORA           CHAR(10)             not null,"
			+ "IDEXPEDIENTE         CHAR(10),"
			+ "IDPROYECTO           CHAR(10)             not null,"
			+ "CODIGOTUTOR          CHAR(7)              not null,"
			+ "CANTIDADHORAS        INTEGER              not null,"
			+ "FECHAACTIVIDAD       CHAR(10)             not null,"
			+ "ESTADOACTIVIDAD      CHAR(1)              not null,"
			+ "FECHAAUTORIZADO      CHAR(10),"
			+ "HORAINICIO           CHAR(5)              not null,"
			+ "HORAFIN              CHAR(5)              not null,"
			+ "VALORACTIVIDAD       FLOAT," + "PRECIOTRABAJO        FLOAT,"
			+ "constraint PK_BITACORA primary key (IDBITACORA));";

	// Tabla Carreras
	private static final String TABLA_CARRERAS = "create table CARRERAS "
			+ "(CODCARRERA           CHAR(4)              not null,"
			+ "CODESCUELA           CHAR(30)             not null,"
			+ "NOMBRECARRERA        CHAR(25)             not null,"
			+ "constraint PK_CARRERAS primary key (CODCARRERA));";

	// Tabla Directorss
	private static final String TABLA_DIRECTORSS = "create table DIRECTORSS "
			+ "(CARNETEMPLEADO       CHAR(7)              not null,"
			+ "CODESCUELA           CHAR(30),"
			+ "NOMBREDIRECTOR       CHAR(30),"
			+ "APELLIDODIRECTOR     CHAR(30),"
			+ "SEXODIRECTOR         CHAR(1),"
			+ "FECHAINICIO          CHAR(10)              not null,"
			+ "FECHAFIN             CHAR(10),"
			+ "constraint PK_DIRECTORSS primary key (CARNETEMPLEADO));";

	// Tabla Escuela
	private static final String TABLA_ESCUELA = "create table ESCUELA "
			+ "(CODESCUELA           CHAR(30)             not null,"
			+ "CARNETEMPLEADO       CHAR(7),"
			+ "NOMBREESCUELA        CHAR(15)             not null,"
			+ "constraint PK_ESCUELA primary key (CODESCUELA));";

	// Tabla Informe
	private static final String TABLA_INFORME = "create table INFORME "
			+ "(CODIGOTUTOR          CHAR(7)              not null,"
			+ "IDEXPEDIENTE         CHAR(10)             not null,"
			+ "CORRINFORME          INTEGER              not null,"
			+ "FECHAENTREGA         CHAR(10)             not null,"
			+ "FECHAAUTORIZACION    CHAR(10),"
			+ "OBJETIVOALCANZADO    CHAR(50)             not null,"
			+ "COMENTARIOS          CHAR(50),"
			+ "TIPOINFORME          CHAR(1)              not null,"
			+ "ESTADO               CHAR(2)              not null,"
			+ "constraint PK_INFORME primary key (CODIGOTUTOR));";

	// Tabla Precios
	private static final String TABLA_PRECIOS = "create table PRECIOS "
			+ "(CORR                 CHAR(2)              not null,"
			+ "IDBITACORA           CHAR(10)             not null,"
			+ "IDTIPODETRABAJO      CHAR(10)             not null,"
			+ "PRECIO               FLOAT                not null,"
			+ "FECHAINICIALAPLIPRE  CHAR(10)             not null,"
			+ "FECHAFINALAPLIPRE    CHAR(10),"
			+ "OBSERVACION          CHAR(25),"
			+ "constraint PK_PRECIOS primary key (CORR));";

	// Tabla Proyecto
	private static final String TABLA_PROYECTO = "create table PROYECTO "
			+ "(IDPROYECTO           CHAR(10)             not null,"
			+ "IDBENEFICIARIO       CHAR(10)             not null,"
			+ "CARNETEMPLEADO       CHAR(7),"
			+ "IDEXPEDIENTE         CHAR(10),"
			+ "IDTIPOPROYECTO       CHAR(10),"
			+ "NOMBREDEPROYECTO     CHAR(100)            not null,"
			+ "DESCRIPCIONPROYECTO  CHAR(100)            not null,"
			+ "DURACIONPROYECTO     FLOAT,"
			+ "FECHAINICIOPROY      CHAR(10)             not null,"
			+ "FECHAFINPROY         CHAR(10),"
			+ "ESTADOPROYECTO       CHAR(1)              not null,"
			+ "VALORPROYECTO        FLOAT,"
			+ "constraint PK_PROYECTO primary key (IDPROYECTO));";

	// Tabla TipoDeProyecto
	private static final String TABLA_TIPO_DE_PROYECTO = "create table TIPO_DE_PROYECTO "
			+ "(IDTIPOPROYECTO       CHAR(10)             not null,"
			+ "IDPROYECTO           CHAR(10)             not null,"
			+ "MODALIDADPROYECTO    CHAR(100)            not null,"
			+ "constraint PK_TIPO_DE_PROYECTO primary key (IDTIPOPROYECTO));";

	// Tabla TipoDeTrabajo
	private static final String TABLA_TIPO_DE_TRABAJO = "create table TIPO_DE_TRABAJO "
			+ "(IDBITACORA           CHAR(10)             not null,"
			+ "IDTIPODETRABAJO      CHAR(10)             not null,"
			+ "CORR                 CHAR(2),"
			+ "NOMBRETIPO           CHAR(30)             not null,"
			+ "constraint PK_TIPO_DE_TRABAJO primary key (IDBITACORA, IDTIPODETRABAJO));";

	// Tabla Tutor
		private static final String TABLA_TUTOR = "create table TUTOR "
				+ "(CODIGOTUTOR          CHAR(7)              not null,"
				+ "IDBENEFICIARIO       CHAR(10)             not null,"
				+ "NOMBRETUTOR          CHAR(30)             not null,"
				+ "APELLIDOTUTOR        CHAR(30)             not null,"
				+ "SEXOTUTOR            CHAR(1)              not null,"
				+ "constraint PK_TUTOR primary key (CODIGOTUTOR));";
			
	// FIN DE TABLAS DE LA BASE DE DATOS

	// Constructor
	public BDControl(Context context) {
		super(context, NOMBRE_BD, null, VERSION_BD);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		// Creación de las tablas
		
		//COSME SE AGREGO UN CATCH
		try{
		db.execSQL(TABLA_ALUMNO_EXPEDIENTE);
		db.execSQL(TABLA_BENEFICIARIO);
		db.execSQL(TABLA_BITACORA);
		db.execSQL(TABLA_CARRERAS);
		db.execSQL(TABLA_DIRECTORSS);
		db.execSQL(TABLA_ESCUELA);
		db.execSQL(TABLA_INFORME);
		db.execSQL(TABLA_PRECIOS);
		db.execSQL(TABLA_PROYECTO);
		db.execSQL(TABLA_TIPO_DE_PROYECTO);
		db.execSQL(TABLA_TIPO_DE_TRABAJO);
		db.execSQL(TABLA_TUTOR);
		
		}catch(SQLException e){
			e.printStackTrace();
			}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_ALUMNO_EXPEDIENTE);
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_BENEFICIARIO);
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_BITACORA);
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_CARRERAS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_DIRECTORSS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_ESCUELA);
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_INFORME);
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_PRECIOS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_PROYECTO);
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_TIPO_DE_PROYECTO);
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_TIPO_DE_TRABAJO);
		db.execSQL("DROP TABLE IF EXISTS " + TABLA_TUTOR);
		onCreate(db);
	}

	// Funciones de inserción, actualización y eliminación de las tablas

	// FUNCIONES DE INSERCIÓN DE DATOS
	public String insertar(AlumnoExpediente alumExp) {

		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("IDEXPEDIENTE", alumExp.getIdExpediente());
			valores.put("IDBITACORA", alumExp.getIdBitacora());
			valores.put("CARNETEMPLEADO", alumExp.getCarnetEmpleado());
			valores.put("CODCARRERA", alumExp.getCodCarrera());
			valores.put("CARNETALUMNO", alumExp.getCarnet());
			valores.put("NOMBREALUMNO", alumExp.getNombre());
			valores.put("APELLIDOALUMNO", alumExp.getApellido());
			valores.put("SEXOALUMNO", alumExp.getSexo());
			valores.put("FECHAINICIOSERVICIO", alumExp.getFechaInicioServicio());
			valores.put("FECHAFINSERVICIO", alumExp.getFechaFinServicio());
			valores.put("ESTADOALUMNO", alumExp.getEstado());
			valores.put("TELEFONO", alumExp.getTelefono());
			valores.put("EMAIL", alumExp.getEmail());
			valores.put("OBSERVACIONES", alumExp.getObservaciones());
			valores.put("VALORSERVICIO", alumExp.getValorServicio());
			valores.put("HORASACUMULA", alumExp.getHorasAcumula());
			valores.put("FECHAACUMULA", alumExp.getFechaAcumula());
			contador = db.insert("ALUMNOEXPEDIENTE", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}
		return "La Base de Datos no existe";
	}

	public String insertar(Beneficiario beneficiario) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("IDBENEFICIARIO", beneficiario.getIdBeneficiario());
			valores.put("CARNETEMPLEADO", beneficiario.getCarnetEmpleado());
			valores.put("NOMBREORGANIZACION",
					beneficiario.getNombreOrganizacion());
			valores.put("NOMBREREPRESENTANTE",
					beneficiario.getNombreRepresentante());
			valores.put("APELLIDOREPRESENTANTE",
					beneficiario.getApellidoRepresentante());
			valores.put("TELEFONOBENEF", beneficiario.getTelefBeneficiario());
			valores.put("DIRECCIONBENEF",
					beneficiario.getDireccionBeneficiario());
			valores.put("EMAIL", beneficiario.getMail());
			contador = db.insert("BENEFICIARIO", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(Bitacora bitacora) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("IDBITACORA", bitacora.getIdBitacora());
			valores.put("IDEXPEDIENTE", bitacora.getIdExpediente());
			valores.put("IDPROYECTO", bitacora.getIdProyecto());
			valores.put("CODIGOTUTOR", bitacora.getCodigoTutor());
			valores.put("CANTIDADHORAS", bitacora.getCantidadHoras());
			valores.put("FECHAACTIVIDAD", bitacora.getFechaActividad());
			valores.put("ESTADOACTIVIDAD", bitacora.getEstadoActividad());
			valores.put("FECHAAUTORIZADO", bitacora.getFechaAutorizado());
			valores.put("HORAINICIO", bitacora.getHoraInicio());
			valores.put("HORAFIN", bitacora.getHoraFin());
			valores.put("VALORACTIVIDAD", bitacora.getValorActividad());
			valores.put("PRECIOTRABAJO", bitacora.getPrecioTrabajo());
			contador = db.insert("BITACORA", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(Carreras carreras) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("CODCARRERA", carreras.getCodCarrera());
			valores.put("CODESCUELA", carreras.getCodEscuela());
			valores.put("NOMBRECARRERA", carreras.getNombre());
			contador = db.insert("CARRERAS", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(DirectorSS directorss) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("CARNETEMPLEADO", directorss.getCarnet());
			valores.put("CODESCUELA", directorss.getCodEscuela());
			valores.put("NOMBREDIRECTOR", directorss.getNombre());
			valores.put("APELLIDODIRECTOR", directorss.getApellido());
			valores.put("SEXODIRECTOR", directorss.getSexo());
			valores.put("FECHAINICIO", directorss.getFechaInicio());
			valores.put("FECHAFIN", directorss.getFechaFin());
			contador = db.insert("DIRECTORSS", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(Escuela escuela) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("CODESCUELA", escuela.getCodEscuela());
			valores.put("CARNETEMPLEADO", escuela.getCarnetEmpleado());
			valores.put("NOMBREESCUELA", escuela.getNombre());
			contador = db.insert("ESCUELA", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(Informe informe) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("CODIGOTUTOR", informe.getCodigoTutor());
			valores.put("IDEXPEDIENTE", informe.getIdExpediente());
			valores.put("CORRINFORME", informe.getCorrInforme());
			valores.put("FECHAENTREGA", informe.getFechaEntrega());
			valores.put("FECHAAUTORIZACION", informe.getFechaAutorizacion());
			valores.put("OBJETIVOALCANZADO", informe.getObjetivoAlcanzado());
			valores.put("COMENTARIOS", informe.getComentarios());
			valores.put("TIPOINFORME", informe.getTipoInforme());
			valores.put("ESTADO", informe.getEstado());
			contador = db.insert("INFORME", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(Precios precios) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("CORR", precios.getCorrelativo());
			valores.put("IDBITACORA", precios.getIdBitacora());
			valores.put("IDTIPODETRABAJO", precios.getIdTipoDeTrabajo());
			valores.put("PRECIO", precios.getPrecio());
			valores.put("FECHAINICIALAPLIPRE", precios.getFechaInicialApliPre());
			valores.put("FECHAFINALAPLIPRE", precios.getFechaFinalApliPre());
			valores.put("OBSERVACION", precios.getObservacion());
			contador = db.insert("PRECIOS", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(Proyecto proyecto) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("IDPROYECTO", proyecto.getIdProyecto());
			valores.put("IDBENEFICIARIO", proyecto.getIdBeneficiario());
			valores.put("CARNETEMPLEADO", proyecto.getCarnetEmpleado());
			valores.put("IDEXPEDIENTE", proyecto.getIdExpediente());
			valores.put("IDTIPOPROYECTO", proyecto.getIdTipoProyecto());
			valores.put("NOMBREDEPROYECTO", proyecto.getNombre());
			valores.put("DESCRIPCIONPROYECTO", proyecto.getDescripcion());
			valores.put("DURACIONPROYECTO", proyecto.getDuracion());
			valores.put("FECHAINICIOPROY", proyecto.getFechaInicio());
			valores.put("FECHAFINPROY", proyecto.getFechaFin());
			valores.put("ESTADOPROYECTO", proyecto.getEstado());
			valores.put("VALORPROYECTO", proyecto.getValor());
			contador = db.insert("PROYECTO", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}
		return "La Base de Datos no existe";
	}

	public String insertar(TipoDeProyecto tipoDeProyecto) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("IDTIPOPROYECTO", tipoDeProyecto.getIdTipoProyecto());
			valores.put("IDPROYECTO", tipoDeProyecto.getIdProyecto());
			valores.put("MODALIDADPROYECTO",
					tipoDeProyecto.getModalidadProyecto());
			contador = db.insert("TIPO_DE_PROYECTO", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(TipoDeTrabajo tipoDeTrabajo) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("IDBITACORA", tipoDeTrabajo.getIdBitacora());
			valores.put("IDTIPOTRABAJO", tipoDeTrabajo.getIdTipoTrabajo());
			valores.put("CORR", tipoDeTrabajo.getCorrelativo());
			valores.put("NOMBRETIPO", tipoDeTrabajo.getNombreTipo());
			contador = db.insert("TIPO_DE_TRABAJO", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(Tutor tutor) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registros insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("CODIGOTUTOR", tutor.getCodigoTutor());
			valores.put("IDBENEFICIARIO", tutor.getIdBeneficiario());
			valores.put("NOMBRETUTOR", tutor.getNombre());
			valores.put("APELLIDOTUTOR", tutor.getApellido());
			valores.put("SEXOTUTOR", tutor.getSexo());
			contador = db.insert("TUTOR", null, valores);
			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}
		return "La Base de Datos no existe";
	}

	// FIN FUNCIONES DE INSERCIÓN DE DATOS

	// FUNCIONES DE ACTUALIZACIÓN DE DATOS
	public String actualizar(AlumnoExpediente alumExp) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { alumExp.getIdExpediente(), alumExp.getIdBitacora(),
					alumExp.getCarnetEmpleado(), alumExp.getCodCarrera() };
			valores.put("CARNETALUMNO", alumExp.getCarnet());
			valores.put("NOMBREALUMNO", alumExp.getNombre());
			valores.put("APELLIDOALUMNO", alumExp.getApellido());
			valores.put("SEXOALUMNO", alumExp.getSexo());
			valores.put("FECHAINICIOSERVICIO", alumExp.getFechaInicioServicio());
			valores.put("FECHAFINSERVICIO", alumExp.getFechaFinServicio());
			valores.put("ESTADOALUMNO", alumExp.getEstado());
			valores.put("TELEFONO", alumExp.getTelefono());
			valores.put("EMAIL", alumExp.getEmail());
			valores.put("OBSERVACIONES", alumExp.getObservaciones());
			valores.put("VALORSERVICIO", alumExp.getValorServicio());
			valores.put("HORASACUMULA", alumExp.getHorasAcumula());
			valores.put("FECHAACUMULA", alumExp.getFechaAcumula());
			contador = db.update("ALUMNOEXPEDIENTE", valores,
					"IDEXPEDIENTE = ? AND IDBITACORA = ?"
							+ " AND CARNETEMPLEADO = ? AND CODCARRERA = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Beneficiario beneficiario) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { beneficiario.getIdBeneficiario(),
					beneficiario.getCarnetEmpleado() };
			valores.put("NOMBREORGANIZACION",
					beneficiario.getNombreOrganizacion());
			valores.put("NOMBREREPRESENTANTE",
					beneficiario.getNombreRepresentante());
			valores.put("APELLIDOREPRESENTANTE",
					beneficiario.getApellidoRepresentante());
			valores.put("TELEFONOBENEF", beneficiario.getTelefBeneficiario());
			valores.put("DIRECCIONBENEF",
					beneficiario.getDireccionBeneficiario());
			valores.put("EMAIL", beneficiario.getMail());
			contador = db.update("BENEFICIARIO", valores,
					"IDBENEFICIARIO = ? AND CARNETEMPLEADO = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Bitacora bitacora) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { bitacora.getIdBitacora(),
					bitacora.getIdExpediente(), bitacora.getIdProyecto(),
					bitacora.getCodigoTutor() };
			valores.put("CANTIDADHORAS", bitacora.getCantidadHoras());
			valores.put("FECHAACTIVIDAD", bitacora.getFechaActividad());
			valores.put("ESTADOACTIVIDAD", bitacora.getEstadoActividad());
			valores.put("FECHAAUTORIZADO", bitacora.getFechaAutorizado());
			valores.put("HORAINICIO", bitacora.getHoraInicio());
			valores.put("HORAFIN", bitacora.getHoraFin());
			valores.put("VALORACTIVIDAD", bitacora.getValorActividad());
			valores.put("PRECIOTRABAJO", bitacora.getPrecioTrabajo());
			contador = db.update("BITACORA", valores,
					"IDBITACORA = ? AND IDEXPEDIENTE = ? AND IDPROYECTO = ?"
							+ " AND CODIGOTUTOR = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Carreras carreras) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { carreras.getCodCarrera(), carreras.getCodEscuela() };
			valores.put("NOMBRECARRERA", carreras.getNombre());
			contador = db.update("CARRERAS", valores,
					"CODCARRERA = ? AND CODESCUELA = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(DirectorSS directorss) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { directorss.getCarnet(), directorss.getCodEscuela() };
			valores.put("NOMBREDIRECTOR", directorss.getNombre());
			valores.put("APELLIDODIRECTOR", directorss.getApellido());
			valores.put("SEXODIRECTOR", directorss.getSexo());
			valores.put("FECHAINICIO", directorss.getFechaInicio());
			valores.put("FECHAFIN", directorss.getFechaFin());
			contador = db.update("DIRECTORSS", valores,
					"CARNETEMPLEADO = ? AND CODESCUELA = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Escuela escuela) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { escuela.getCodEscuela(),
					escuela.getCarnetEmpleado() };
			valores.put("NOMBREESCUELA", escuela.getNombre());
			contador = db.update("ESCUELA", valores,
					"CODESCUELA = ? AND CARNETEMPLEADO = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Informe informe) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { informe.getCodigoTutor(), informe.getIdExpediente() };
			valores.put("CORRINFORME", informe.getCorrInforme());
			valores.put("FECHAENTREGA", informe.getFechaEntrega());
			valores.put("FECHAAUTORIZACION", informe.getFechaAutorizacion());
			valores.put("OBJETIVOALCANZADO", informe.getObjetivoAlcanzado());
			valores.put("COMENTARIOS", informe.getComentarios());
			valores.put("TIPOINFORME", informe.getTipoInforme());
			valores.put("ESTADO", informe.getEstado());
			contador = db.update("INFORME", valores,
					"CODIGOTUTOR = ? AND IDEXPEDIENTE = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Precios precios) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { precios.getCorrelativo(), precios.getIdBitacora(),
					precios.getIdTipoDeTrabajo() };
			valores.put("PRECIO", precios.getPrecio());
			valores.put("FECHAINICIALAPLIPRE", precios.getFechaInicialApliPre());
			valores.put("FECHAFINALAPLIPRE", precios.getFechaFinalApliPre());
			valores.put("OBSERVACION", precios.getObservacion());
			contador = db.update("PRECIOS", valores,
					"CORR = ? AND IDBITACORA = ? AND IDTIPODETRABAJO = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Proyecto proyecto) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { proyecto.getIdProyecto(),
					proyecto.getIdBeneficiario(), proyecto.getCarnetEmpleado(),
					proyecto.getIdExpediente(), proyecto.getIdTipoProyecto() };
			valores.put("NOMBREPROYECTO", proyecto.getNombre());
			valores.put("DESCRIPCIONPROYECTO", proyecto.getDescripcion());
			valores.put("DURACIONPROYECTO", proyecto.getDuracion());
			valores.put("FECHAINICIOPROY", proyecto.getFechaInicio());
			valores.put("FECHAFINPROY", proyecto.getFechaFin());
			valores.put("ESTADOPROYECTO", proyecto.getEstado());
			valores.put("VALORPROYECTO", proyecto.getValor());
			contador = db
					.update("PROYECTO",
							valores,
							"IDPROYECTO = ? AND IDBENEFICIARIO = ? AND CARNETEMPLEADO = ? AND IDEXPEDIENTE = ? AND IDTIPOPROYECTO = ?",
							id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(TipoDeProyecto tipoDeProyecto) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { tipoDeProyecto.getIdTipoProyecto(),
					tipoDeProyecto.getIdProyecto() };
			valores.put("MODALIDADPROYECTO",
					tipoDeProyecto.getModalidadProyecto());
			contador = db.update("TIPODEPROYECTO", valores,
					"IDTIPODEPROYECTO = ? AND IDPROYECTO = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(TipoDeTrabajo tipoDeTrabajo) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { tipoDeTrabajo.getIdBitacora(),
					tipoDeTrabajo.getIdTipoTrabajo() };
			valores.put("CORR", tipoDeTrabajo.getCorrelativo());
			valores.put("NOMBRETIPO", tipoDeTrabajo.getNombreTipo());
			contador = db.update("TIPODETRABAJO", valores,
					"IDBITACORA = ? AND IDTIPODETRABAJO = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Tutor tutor) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { tutor.getCodigoTutor(), tutor.getIdBeneficiario() };
			valores.put("NOMBRETUTOR", tutor.getNombre());
			valores.put("APELLIDOTUTOR", tutor.getApellido());
			valores.put("SEXOTUTOR", tutor.getSexo());
			contador = db.update("TUTOR", valores,
					"CODIGOTUTOR = ? AND IDBENEFICIARIO = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	// FIN FUNCIONES DE ACTUALIZACIÓN DE DATOS

	
	//CONSULTAR PROYECTO NORMAL COSME
			public Proyecto ConsultarProyecto(String idproyecto){
				//ABRIENDO LA BASE
				SQLiteDatabase db = getWritableDatabase();
				String[] idp = {idproyecto};
				Cursor cursor = db.query("PROYECTO", camposProyecto, "IDPROYECTO = ?", idp,
						null, null, null);
				if(cursor.moveToFirst()){
					Proyecto proyecto=new Proyecto();
					proyecto.setIdProyecto(cursor.getString(0));
					proyecto.setIdBeneficiario(cursor.getString(1));
					proyecto.setCarnetEmpleado(cursor.getString(2));
					proyecto.setIdExpediente(cursor.getString(3));
					proyecto.setIdTipoProyecto(cursor.getString(4));
					proyecto.setNombre(cursor.getString(5));
					proyecto.setDescripcion(cursor.getString(6));
					proyecto.setDuracion(cursor.getInt(7));
					proyecto.setFechaInicio(cursor.getString(8));
					proyecto.setFechaFin(cursor.getString(9));
					proyecto.setEstado(cursor.getString(10));
					proyecto.setValor(cursor.getFloat(11));
					return proyecto;
				}
				else{
					return null;
				}
			}
			
			
			//COSME CONSULTAR TIPO DE PROYECTO
			
			public TipoDeProyecto ConsultarTipoProyecto(String idtipoproyecto){
				//ABRIENDO LA BASE
				SQLiteDatabase db = getWritableDatabase();
				String[] idp = {idtipoproyecto};
				Cursor cursor = db.query("TIPO_DE_PROYECTO", camposTipoProyecto, "IDTIPOPROYECTO = ?", idp,
						null, null, null);
				if(cursor.moveToFirst()){
				TipoDeProyecto tipoproyecto=new TipoDeProyecto();
				tipoproyecto.setIdTipoProyecto(cursor.getString(0));
				tipoproyecto.setIdProyecto(cursor.getString(1));
				tipoproyecto.setModalidadProyecto(cursor.getString(2));
				
					return tipoproyecto;
				}
				else{
					return null;
				}
			}
			
			
			
			
			
				//CONSULTAR BENFICIARIO NORMAL COSME
				public Beneficiario ConsultarBeneficiario(String idbeneficiario){
					//ABRIENDO LA BASE
					SQLiteDatabase db = getWritableDatabase();
					String[] idb = {idbeneficiario};
					Cursor cursor = db.query("BENEFICIARIO", camposBeneficiario, "IDBENEFICIARIO = ?", idb,
							null, null, null);
					if(cursor.moveToFirst()){
						Beneficiario beneficiario=new Beneficiario();
						beneficiario.setIdBeneficiario(cursor.getString(0));
						beneficiario.setCarnetEmpleado(cursor.getString(1));
						beneficiario.setNombreOrganizacion(cursor.getString(2));
						beneficiario.setNombreRepresentante(cursor.getString(3));
						beneficiario.setApellidoRepresentante(cursor.getString(4));
						beneficiario.setTelefBeneficiario(cursor.getInt(5));
						beneficiario.setDireccionBeneficiario(cursor.getString(6));
						beneficiario.setMail(cursor.getString(7));
						return beneficiario;
					}
					else{
						return null;
					}
			
				
				
			}
	
			//CONSULTAR EXPEDIENTE ALUMNO NORMAL COSME
			public AlumnoExpediente ConsultarExpediente(String idexpediente){
				//ABRIENDO LA BASE
				SQLiteDatabase db = getWritableDatabase();
				String[] ide = {idexpediente};
				Cursor cursor = db.query("ALUMNOEXPEDIENTE", camposAlumnoExpediente, "IDEXPEDIENTE = ?", ide,
						null, null, null);
				if(cursor.moveToFirst()){
					AlumnoExpediente alumno=new AlumnoExpediente();
					alumno.setIdExpediente(cursor.getString(0));
					alumno.setIdBitacora(cursor.getString(1));
					alumno.setCarnetEmpleado(cursor.getString(2));
					alumno.setCodCarrera(cursor.getString(3));
					alumno.setCarnet(cursor.getString(4));
					alumno.setNombre(cursor.getString(5));
					alumno.setApellido(cursor.getString(6));
					alumno.setSexo(cursor.getString(7));
					alumno.setFechaInicioServicio(cursor.getString(8));
					alumno.setFechaFinServicio(cursor.getString(9));
					alumno.setEstado(cursor.getString(10));
					alumno.setTelefono(cursor.getString(11));
					alumno.setEmail(cursor.getString(12));
					alumno.setObservaciones(cursor.getString(13));
					alumno.setValorServicio(cursor.getFloat(14));
					alumno.setHorasAcumula(cursor.getInt(15));
					alumno.setFechaAcumula(cursor.getString(16));
					
					return alumno;
				}
				else{
					return null;
				}
			
				
				
			}
	//COSME FUNCION CONSULTA DE PROYECTOS PENDIENTES DE APROBACION
	
	public Proyecto consultarProyecto(String estado, ArrayList<String> nombres, ArrayList<String> id){
		//ABRIENDO LA BASE
		SQLiteDatabase db = getWritableDatabase();
		String[] estad = {estado};
		Cursor cursor = db.query("PROYECTO", camposProyecto, "ESTADOPROYECTO = ?", estad,
		null, null, null);
		if(cursor.moveToFirst()){
			Proyecto proyecto = new Proyecto();
			//AGARRO EL PRIMERO VALOR 
			proyecto.setIdProyecto(cursor.getString(0));
			proyecto.setIdBeneficiario(cursor.getString(1));
			proyecto.setCarnetEmpleado(cursor.getString(2));
			proyecto.setIdExpediente(cursor.getString(3));
			proyecto.setIdTipoProyecto(cursor.getString(4));
			proyecto.setNombre(cursor.getString(5));
			proyecto.setDescripcion(cursor.getString(6));
			proyecto.setDuracion(cursor.getInt(7));
			proyecto.setFechaInicio(cursor.getString(8));
			proyecto.setFechaFin(cursor.getString(9));
			proyecto.setEstado(cursor.getString(10));
			proyecto.setValor(cursor.getFloat(11));
			id.add(proyecto.getIdProyecto().toString());
			nombres.add(proyecto.getNombre().toString());
			
			
			//TOMO LOS VALORES DESDE EL 2DO EN ADELANTE
			while(cursor.moveToNext()){

		proyecto.setIdProyecto(cursor.getString(0));
		proyecto.setIdBeneficiario(cursor.getString(1));
		proyecto.setCarnetEmpleado(cursor.getString(2));
		proyecto.setIdExpediente(cursor.getString(3));
		proyecto.setIdTipoProyecto(cursor.getString(4));
		proyecto.setNombre(cursor.getString(5));
		proyecto.setDescripcion(cursor.getString(6));
		proyecto.setDuracion(cursor.getInt(7));
		proyecto.setFechaInicio(cursor.getString(8));
		proyecto.setFechaFin(cursor.getString(9));
		proyecto.setEstado(cursor.getString(10));
		proyecto.setValor(cursor.getFloat(11));
		id.add(proyecto.getIdProyecto().toString());
		nombres.add(proyecto.getNombre().toString());
		
		
			}
			return proyecto;
			
			
			
		}else{
		return null;
		
		}
		
		
		
		
	}
	
	
	// FUNCIONES DE ELIMINACIÓN DE DATOS
	public String eliminar(AlumnoExpediente alumExp) {
		return null;
	}

	public String eliminar(Beneficiario beneficiario) {
		return null;
	}

	public String eliminar(Bitacora bitacora) {
		return null;
	}

	public String eliminar(Carreras carreras) {
		return null;
	}

	public String eliminar(DirectorSS directorss) {
		return null;
	}

	public String eliminar(Escuela escuela) {
		return null;
	}

	public String eliminar(Informe informe) {
		return null;
	}

	public String eliminar(Precios precios) {
		return null;
	}

	public String eliminar(Proyecto proyecto) {
		return null;
	}

	public String eliminar(TipoDeProyecto tipoDeProyecto) {
		return null;
	}

	public String eliminar(TipoDeTrabajo tipoDeTrabajo) {
		return null;
	}

	public String eliminar(Tutor tutor) {
		return null;
	}
	// FIN FUNCIONES DE ELIMINACIÓN DE DATOS
	
	
	

}
