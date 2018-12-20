package ua.nure.sherbakov.practice7.server.client;

import java.net.MalformedURLException;
import java.net.URL;

import ua.nure.sherbakov.practice7.server.service.FlowerService;

public class ServiceProvider {
	private static FlowerService flowers;
	private static String url;

	private static FlowerService getDefaultFlowers() {
		ua.nure.sherbakov.practice7.server.service.Flowers port = new ua.nure.sherbakov.practice7.server.service.Flowers();
		return port.getFlowerPort();
	}

	private static FlowerService getFlowers(String url) throws MalformedURLException {
		ua.nure.sherbakov.practice7.server.service.Flowers port = new ua.nure.sherbakov.practice7.server.service.Flowers(
				new URL(url));
		return port.getFlowerPort();
	}

	public static FlowerService getInstance(String url) {
		if (flowers == null) {
			if (url == null) {
				flowers = getDefaultFlowers();
			} else {
				try {
					flowers = getFlowers(url);
				} catch (MalformedURLException e) {
					flowers = null;
				}
			}
		} else if (!url.equals(ServiceProvider.url)) {
			try {
				getFlowers(url);
				ServiceProvider.url = url;
			} catch (MalformedURLException e) {
				ServiceProvider.url = null;
				flowers = null;
			}
		}
		return flowers;
	}
}
