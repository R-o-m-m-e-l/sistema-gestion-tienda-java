package model;

public class validante {
	public boolean validarName(String v) {
		return v.matches("^\\p{Lu}[\\p{L}ñÑüÜáÁéÉíÍóÓúÚ']+(?:[-']?[\\p{L}ñÑüÜáÁéÉíÍóÓúÚ']+)?\\s\\p{Lu}[\\p{L}ñÑüÜáÁéÉíÍóÓúÚ']+(?:[-']?[\\p{L}ñÑüÜáÁéÉíÍóÓúÚ']+)?$");
	}
	public boolean validarID(String v) {
		return v.matches("^\\d{10}$");
	}public boolean validarMail(String v) {
		return v.matches("^[A-Za-z0-9._%+-]+@(?:gmail\\.com|hotmail\\.com)$");
	}
	public boolean validarTelf(String v) {
		return v.matches("^\\d{7,9}$");
	}
	public boolean validarCel(String v) {
		return v.matches("^09\\d{8}$");
	}
	public boolean validarAdrress(String v) {
		return v.matches("^[\\p{L}\\d\\s\\#\\-\\.,ºª/\\\\]+$");
	}
	public boolean validarDate(String v) {
		return v.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$");
	}
	public boolean validarPassword(String v) {
		return v.matches("^(?=.{8,}$)(?=.*\\p{Lu})(?=.*[@/\\-]).+$");
	}
	public boolean validarUnidad(String v) {
		return v.matches("^[1-9]\\d*$");
	}
	public boolean validarPrecio(String v) {
		return v.matches("^(?:[1-9]\\d*(?:\\.\\d+)?|0\\.\\d*[1-9]\\d*)$");
	}
	public boolean validarRS(String v) {
		return v.matches("^[\\p{L}\\d\\s&\\.,\\-()ºª'\"]{2,100}$");
	}
}
