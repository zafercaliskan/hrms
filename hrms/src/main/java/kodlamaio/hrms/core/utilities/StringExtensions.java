package kodlamaio.hrms.core.utilities;

public class StringExtensions {
	public static boolean isNullOrEmpty(String... values) {
		for (String item : values) {
			if (item.isBlank() || item == null) {
				return true;
			}			
		}
		
		return false;
	}
}