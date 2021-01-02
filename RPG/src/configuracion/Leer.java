package configuracion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leer {

//	Personajes:
//		- gunwoman
//		- king
//		- knight
//		- martial
//		- ninja
//		- robot
//		- skeletonArcher
//		- skeletonChief
//		- skeletonNormal
//		- wizard
//	Indices de localizaciones:
//	
//	Indices de Objetos:

	private final List<String> personajes = new ArrayList<String>();
	private final List<String> localizaciones = new ArrayList<String>();
	private final List<String> objetos = new ArrayList<String>();

	private final List<String> personajesLocIni = new ArrayList<String>();
	private final List<String> adyacenciasLocalizaciones = new ArrayList<String>();

	private final List<String> locObjetos = new ArrayList<String>();
	private final List<String> localizacionObjetivo = new ArrayList<String>();

	private final List<String> objetoObjetivo = new ArrayList<String>();

	public Leer() {
		int entrada = 0; // 0->Localizacion, 1->Personajes, 2->Objetos || 0->Localizacion,
		String linea;

		try {
			// Primero el fichero *Estado inicial*

			String filePath = System.getProperty("user.dir") + "\\recursos\\estado_inicial.txt";
			FileReader f = new FileReader(filePath);
			BufferedReader b = new BufferedReader(f);

			while ((linea = b.readLine()) != null) {
				if (linea.equals("<Localizacion>")) {
					entrada = 0;
					continue;
				} else if (linea.equals("<Personajes>")) {
					entrada = 1;
					continue;
				} else if (linea.equals("<Objetos>")) {
					entrada = 2;
					continue;
				}

				if (entrada == 0) {
					if (linea.indexOf("(") != -1) {
						adyacenciasLocalizaciones
								.add(linea.substring(linea.indexOf("(") + 1, linea.indexOf(")")).toLowerCase());
						localizaciones.add(linea.substring(0, linea.indexOf("(")).toLowerCase());
					}
				} else if (entrada == 1) {
					if (linea.indexOf("(") != -1) {
						if (comprobarPersonaje(linea.split("\\(")[0].toLowerCase())) {
							personajes.add(linea.split("\\(")[0].toLowerCase());
							personajesLocIni.add(linea.split("\\(")[1].substring(0, linea.split("\\(")[1].length() - 1)
									.toLowerCase());
						} else {
							System.out.println(linea.split("\\(")[0].toLowerCase() + " no es un nombre válido");
							System.exit(-1);
						}
					}
				} else if (entrada == 2) {
					if (linea.indexOf("(") != -1) {
						locObjetos.add(linea.substring(linea.indexOf("(") + 1, linea.indexOf(")")).toLowerCase());
						objetos.add(linea.substring(0, linea.indexOf("(")).toLowerCase());
					}
				}
			}

			System.out.println(personajes.toString() + " -> " + personajesLocIni.toString());
			System.out.println(localizaciones.toString() + " -> " + adyacenciasLocalizaciones.toString());
			System.out.println(objetos.toString() + " -> " + locObjetos.toString());

			b.close();

			// Segundo el archivo de *Objetivos*
			filePath = System.getProperty("user.dir") + "\\recursos\\objetivos.txt";
			f = new FileReader(filePath);
			b = new BufferedReader(f);

			while ((linea = b.readLine()) != null) {
				if (linea.equals("<Localización Personajes>")) {
					entrada = 0;
				} else if (linea.equals("<Posesión Objetos>")) {
					entrada = 1;
				}

				if (entrada == 0) {
					if (linea.indexOf("(") != -1) {
						localizacionObjetivo.add(linea.substring(0, linea.indexOf("(")) + ","
								+ linea.substring(linea.indexOf("(") + 1, linea.length() - 1));
					}
				} else if (entrada == 1) {
					if (linea.indexOf("(") != -1) {
						objetoObjetivo.add(linea.substring(linea.indexOf("(") + 1, linea.length() - 1) + ","
								+ linea.substring(0, linea.indexOf("(")));
					}
				}
			}

			System.out.println(localizacionObjetivo.toString());
			System.out.println(objetoObjetivo.toString());

			b.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getNumLoc() {
		return localizaciones.size();
	}

	public List<String> getLoc() {
		return localizaciones;
	}

	public List<String> getAdLoc() {
		return adyacenciasLocalizaciones;
	}

	public List<String> getObj() {
		return objetos;
	}

	public List<String> getLocObj() {
		return locObjetos;
	}

	public int getNumPersonajes() {
		return personajes.size();
	}

	public List<String> getPersonajes() {
		return personajes;
	}

	public List<String> getPersonajesLocIni() {
		return personajesLocIni;
	}

	public boolean comprobarPersonaje(String nombre) {
		if (nombre.split("\\(")[0].toLowerCase().equals("gunwoman")
				|| nombre.split("\\(")[0].toLowerCase().equals("king")
				|| nombre.split("\\(")[0].toLowerCase().equals("knight")
				|| nombre.split("\\(")[0].toLowerCase().equals("martial")
				|| nombre.split("\\(")[0].toLowerCase().equals("ninja")
				|| nombre.split("\\(")[0].toLowerCase().equals("robot")
				|| nombre.split("\\(")[0].toLowerCase().equals("skeletonArcher")
				|| nombre.split("\\(")[0].toLowerCase().equals("skeletonChief")
				|| nombre.split("\\(")[0].toLowerCase().equals("skeletonNormal")
				|| nombre.split("\\(")[0].toLowerCase().equals("wizard")) {

			return true;
		}
		return false;
	}

}
