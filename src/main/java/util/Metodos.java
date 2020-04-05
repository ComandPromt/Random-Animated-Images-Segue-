package util;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;

import renders.BarnDoorCloseEffect;
import renders.BarnDoorOpenEffect;
import renders.BlindsEffect;
import renders.CheckerboardEffect;
import renders.IrisCloseEffect;
import renders.IrisOpenEffect;
import renders.PixelDissolveEffect;
import renders.ScrollDownEffect;
import renders.ScrollLeftEffect;
import renders.ScrollRightEffect;
import renders.ScrollUpEffect;
import renders.ShrinkToBottomEffect;
import renders.ShrinkToCenterEffect;
import renders.ShrinkToTopEffect;
import renders.StretchFromBottomEffect;
import renders.StretchFromCenterEffect;
import renders.StretchFromTopEffect;
import renders.WipeDownEffect;
import renders.WipeLeftEffect;
import renders.WipeRightEffect;
import renders.WipeUpEffect;
import renders.ZoomInEffect;
import renders.ZoomOutEffect;

public abstract class Metodos {
	private static int salto = 0;
	static File fpdfOrigen = new File("160KB Prueba - Test Standard.pdf");

	static File fpdfDestino = new File("160KB Prueba - Test Standard-f.pdf");

	public static String eliminarPuntos(String cadena) {

		String cadena2 = cadena.substring(0, cadena.length() - 4);

		cadena = cadena2.replace(".", "_") + "." + extraerExtension(cadena);

		return cadena;
	}

	public static void renombrar(String ruta1, String ruta2) {

		File f1 = new File(ruta1);
		File f2 = new File(ruta2);

		f1.renameTo(f2);

	}

	public static LinkedList<String> directorio(String ruta, String extension) {

		LinkedList<String> lista = new LinkedList<>();

		File f = new File(ruta);

		if (f.exists()) {

			lista.clear();

			File[] ficheros = f.listFiles();

			String fichero = "";

			String extensionArchivo;

			File folder;

			boolean comprobacion;

			for (int x = 0; x < ficheros.length; x++) {

				fichero = ficheros[x].getName();

				folder = new File(ruta + "/" + fichero);

				extensionArchivo = extraerExtension(fichero);

				comprobacion = !folder.isDirectory();

				if (comprobacion && fichero.length() > 5 && fichero.substring(0, fichero.length() - 5).contains(".")) {

					renombrar(ruta + "/" + fichero, ruta + "/" + eliminarPuntos(fichero));

				}

				if (comprobacion && extension.equals("webp") && extensionArchivo.equals("webp")
						|| comprobacion && extension.equals("jpeg") && extensionArchivo.equals("jpeg")
						|| comprobacion && extension.equals(".")
						|| comprobacion && extension.equals(extensionArchivo)) {

					lista.add(fichero);
				}

			}
		}

		return lista;

	}

	public static String extraerExtension(String nombreArchivo) {

		String extension = "";

		if (nombreArchivo.length() >= 3) {

			extension = nombreArchivo.substring(nombreArchivo.length() - 3, nombreArchivo.length());

			extension = extension.toLowerCase();

			if (extension.equals("peg")) {
				extension = "jpeg";
			}

			if (extension.equals("fif")) {
				extension = "jfif";
			}

			if (extension.equals("ebp")) {
				extension = "webp";
			}

		}

		return extension;
	}

	private static String readAll(Reader rd) throws IOException {

		StringBuilder sb = new StringBuilder();

		int cp;

		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}

		return sb.toString();
	}

	public static String eliminarEspacios(String cadena) {
		cadena = cadena.trim();
		cadena = cadena.replace("  ", " ");
		return cadena;
	}

	public static Object calcularAnimacion(int animacion) {

		Object claseanimacion = new Object();

		switch (animacion) {

		case 1:
			claseanimacion = PixelDissolveEffect.class;
			break;

		case 2:

			claseanimacion = CheckerboardEffect.class;
			break;

		case 3:

			claseanimacion = BlindsEffect.class;
			break;

		case 4:

			claseanimacion = ScrollLeftEffect.class;
			break;

		case 5:

			claseanimacion = ScrollRightEffect.class;
			break;

		case 6:

			claseanimacion = ScrollUpEffect.class;
			break;

		case 7:

			claseanimacion = ScrollDownEffect.class;
			break;

		case 8:

			claseanimacion = WipeLeftEffect.class;
			break;

		case 9:

			claseanimacion = WipeRightEffect.class;
			break;

		case 10:

			claseanimacion = WipeUpEffect.class;
			break;

		case 11:

			claseanimacion = WipeDownEffect.class;
			break;

		case 12:

			claseanimacion = ZoomOutEffect.class;
			break;

		case 13:

			claseanimacion = ZoomInEffect.class;
			break;

		case 14:

			claseanimacion = IrisOpenEffect.class;
			break;

		case 15:

			claseanimacion = IrisCloseEffect.class;
			break;

		case 16:

			claseanimacion = BarnDoorOpenEffect.class;
			break;

		case 17:

			claseanimacion = BarnDoorCloseEffect.class;
			break;

		case 18:

			claseanimacion = ShrinkToBottomEffect.class;
			break;

		case 19:

			claseanimacion = ShrinkToTopEffect.class;
			break;

		case 20:

			claseanimacion = ShrinkToCenterEffect.class;
			break;

		case 21:

			claseanimacion = StretchFromBottomEffect.class;
			break;

		case 22:

			claseanimacion = StretchFromTopEffect.class;
			break;

		case 23:

			claseanimacion = StretchFromCenterEffect.class;
			break;

		default:
			claseanimacion = ScrollLeftEffect.class;
			break;
		}

		return claseanimacion;

	}

}
