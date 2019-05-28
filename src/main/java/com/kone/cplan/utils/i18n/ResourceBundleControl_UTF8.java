package com.kone.cplan.utils.i18n;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

/**
 * This is a custom implementation of the java.util.ResourceBundle.Control that supports loading of
 * resource files using UTF-8 encoding. It looks like this class is not needed in Java 9 and higher,
 * but is needed in Java 8.
 * 
 * @author Gennadiy Pervukhin
 * @created 28-05-2019
 */
public class ResourceBundleControl_UTF8 extends Control {
	
	
	public ResourceBundle newBundle(String baseName, Locale locale, String format,
		ClassLoader loader, boolean reload)
			throws IllegalAccessException, InstantiationException, IOException
	{
		//this method is almost a full copy of the default implementation of this method in the
		//java.util.ResourceBundle.Control
		String bundleName = toBundleName(baseName, locale);
		String resourceName = toResourceName(bundleName, "properties");
		ResourceBundle bundle = null;
		InputStream stream = null;
		if (reload) {
			URL url = loader.getResource(resourceName);
			if (url != null) {
				URLConnection connection = url.openConnection();
				if (connection != null) {
					connection.setUseCaches(false);
					stream = connection.getInputStream();
				}
			}
		} else {
			stream = loader.getResourceAsStream(resourceName);
		}
		
		if (stream != null) {
			try {
				//this is the only line, that was changed, to read properties files as UTF-8
				bundle = new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));
			} finally {
				stream.close();
			}
		}
		return bundle;
	}
}