package com.edward.utils;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Date;

public class FileDownloader {

	public FileDownloader() {
	}

	public static void download(String path, String dest) {
		URL website;
		try {
			System.out.println("[INFO] " + new Date()
					+ ": Downloading file from: " + path);
			System.out
					.println("[INFO] "
							+ new Date()
							+ ": Please wait, this may take quite a while depending on your internet connection.");
			website = new URL(path);

			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(dest);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			fos.close();
			System.out.println("[INFO] " + new Date()
					+ ": Done downloading files.");
			website = null;
			rbc = null;
			fos = null;
		} catch (Exception e) {
			EyeThrowableDealer etd = new EyeThrowableDealer();
			etd.load(e);
			etd.print();
		}
	}
}