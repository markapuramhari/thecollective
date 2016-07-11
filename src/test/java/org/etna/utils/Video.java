package org.etna.utils;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.screenrecorder.ScreenRecorder;


	public class Video extends ScreenRecorder
	{
			private String name;
			public String fileName;

			public Video(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat,
			Format mouseFormat, Format audioFormat, File movieFolder, String name) throws IOException, AWTException {
			super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
			this.name = name;
			}

			
			@Override
			public File createMovieFile(Format fileFormat) throws IOException {
			if (!movieFolder.exists()) {
			movieFolder.mkdirs();
			} else if (!movieFolder.isDirectory()) {
			throw new IOException("\"" + movieFolder + "\" is not a directory.");
			}
			File f = new File(movieFolder, name +"_"+SendEmailGmail.getTime()+"." + Registry.getInstance().getExtension(fileFormat));
			fileName = f.getAbsolutePath();
			
		return f;
		}
}
