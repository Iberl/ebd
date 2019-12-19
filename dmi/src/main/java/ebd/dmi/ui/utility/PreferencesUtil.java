package ebd.dmi.ui.utility;

import java.awt.*;
import java.io.File;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PreferencesUtil {

	private static final Pattern pattern = Pattern.compile("(\\d+) (\\d+) (\\d+) (\\d+)\\s*");
	private static final String FORMAT_PATTERN = "%d %d %d %d";


	private PreferencesUtil() {}


	public static void storeWindowBounds(Preferences preferences, String key, Window window) {
		if (preferences != null && key != null && window != null) {
			Rectangle bounds = window.getBounds();
			preferences.put(key + "WindowBounds", String.format(FORMAT_PATTERN, bounds.x, bounds.y, bounds.width, bounds.height));
		}
	}


	public static void restoreWindowBounds(Preferences preferences, String key, Window window, int altWidth, int altHeight) {
		if (preferences != null && key != null && window != null) {
			String bounds = preferences.get(key + "WindowBounds", null);
			Matcher matcher;
			if (bounds != null && (matcher = pattern.matcher(bounds)).matches()) {
				try {
					int x = Integer.parseInt(matcher.group(1));
					int y = Integer.parseInt(matcher.group(2));
					window.setLocation(x, y);

					int width = Integer.parseInt(matcher.group(3));
					int height = Integer.parseInt(matcher.group(4));
					window.setPreferredSize(new Dimension(width, height));
					return;
				} catch (NumberFormatException nfe) {}
			}
			window.setLocationByPlatform(true);
			window.setPreferredSize(new Dimension(altWidth, altHeight));
		}
	}


	public static void storeWindowVisibility(Preferences preferences, String key, Window window) {
		if (preferences != null && key != null && window != null) {
			preferences.putBoolean(key + ".isVisible", window.isVisible());
		}
	}


	public static void restoreWindowVisibility(Preferences preferences, String key, Window window, boolean alt) {
		if (preferences != null && key != null && window != null) {
			boolean visible = preferences.getBoolean(key + ".isVisible", alt);
			if (window.isVisible() != visible) {
				window.setVisible(visible);
			}
		}
	}


	public static void putFile(Preferences preferences, String key, File file) {
		preferences.put(key, file != null ? file.getAbsolutePath() : "");
	}


	public static File getFile(Preferences preferences, String key, File altFile) {
		String file = preferences.get(key, null);
		return file != null && !file.isEmpty() ? new File(file) : altFile;
	}
}
