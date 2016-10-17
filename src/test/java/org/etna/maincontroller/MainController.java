package org.etna.maincontroller;
import java.io.File;
import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SendEmailGmail;
import org.etna.utils.TestUtility;
import org.etna.utils.Video;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import ru.yandex.qatools.allure.annotations.Attachment;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;


public class MainController implements IHookable{
	
	
 public static WebDriver driver ;
 
/*
 * @author Hemanth.Sridhar
 */
public static String outputVideo="";
public static String outputReport="";
private ScreenRecorder screenRecorder;
public static String applicationSetUp = "resources/PropertyFiles/ApplicationSetUp.properties";
public static String searchData = "resources/PropertyFiles/SearchData.properties";
DesiredCapabilities caps = new DesiredCapabilities();



	
@BeforeSuite(alwaysRun=true)
public void beforeSuite() throws Exception{
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
		outputVideo="./Videos";
		outputReport="./Report";
		FileUtils.forceMkdir(new File(outputVideo));
		FileUtils.forceMkdir(new File(outputReport));
		outputReport += "/Report_" + setUp.getBrowser().toUpperCase()+"_"+SendEmailGmail.getDate()+"_" + SendEmailGmail.getTime();
}

	@BeforeMethod(alwaysRun=true)
	public boolean setUp() throws Exception {
	
		ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
		PageFactoryInitializer pageFactoryInitializer = new PageFactoryInitializer();
		driver.get(setUp.getURL());
		driver.manage().deleteAllCookies();
		try
		{
		if(pageFactoryInitializer.homePage().userAccountDropdown.isDisplayed())
		{
			pageFactoryInitializer.homePage().logout();
		}
		}
		catch(Exception e)
		{
			return true;
		}
		return true;
	}

	@BeforeMethod(alwaysRun=true)
	public void startRecording(Method methodName) throws Exception{
		ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
 		if(setUp.getVideoPermission().equalsIgnoreCase("yes"))
 		{
 		 File file = new File(outputVideo+"/");
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         int width = screenSize.width;
         int height = screenSize.height;    
         String testcaseName = methodName.getName();
         Rectangle captureSize = new Rectangle(0,0, width, height);
                        
       GraphicsConfiguration gc = GraphicsEnvironment
          .getLocalGraphicsEnvironment()
          .getDefaultScreenDevice()
          .getDefaultConfiguration();
 
	this.screenRecorder = new Video(gc, captureSize,
          new Format(MediaTypeKey, MediaType.VIDEO, MimeTypeKey, MIME_AVI),
          new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
               CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
               DepthKey, 24, FrameRateKey, Rational.valueOf(15),
               QualityKey, 1.0f,
               KeyFrameIntervalKey, 15 * 60),
          new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
               FrameRateKey, Rational.valueOf(30)),
          null, file, testcaseName);
     this.screenRecorder.start();
 		}
 }
	
	@BeforeTest(alwaysRun=true)
	public void beforeTest() throws Exception
	{
		ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
		
	if(System.getProperty("os.name").toUpperCase().contains("MAC"))
		
	{
		
		if(setUp.getBrowser().trim().equalsIgnoreCase("chrome"))
		{
			  
			System.setProperty("webdriver.chrome.driver", "resources/drivers/Mac/chromedriver");
			driver = new ChromeDriver();
			TestUtility.maximizeScreen(driver);
			
			  
		}
		else if(setUp.getBrowser().trim().equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","resources/drivers/Mac/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  
		}

		
		else if(setUp.getBrowser().trim().equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "resources/drivers/MAC/geckodriver");
			driver = new FirefoxDriver();

		}
		
		else if(setUp.getBrowser().trim().equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
			TestUtility.maximizeScreen(driver);
		}
			
		else
		{
			System.out.println("cannot load driver");
		}

	}

	else if(System.getProperty("os.name").toUpperCase().contains("WIN"))
	{
		if(setUp.getBrowser().trim().equalsIgnoreCase("chrome"))
		{
			  
			System.setProperty("webdriver.chrome.driver", "resources/drivers/Windows/chromedriver.exe");
			driver = new ChromeDriver();
			
			  
		}
		else if(setUp.getBrowser().trim().equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","resources/drivers/Windows/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		}
		
		else if(setUp.getBrowser().trim().equalsIgnoreCase("firefox"))
		{

			System.setProperty("webdriver.gecko.driver", "resources/drivers/Windows/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("cannot load driver");
		}
	}
		driver.manage().window().maximize();
		
	}


	@Override
	public void run(IHookCallBack callBack, ITestResult testResult){
		ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
		callBack.runTestMethod(testResult);
	    if (testResult.getThrowable()!= null) {
	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	try
	    	{
	    	saveScreenshot(testResult.getName(),driver);
	    	if(setUp.getVideoPermission().equalsIgnoreCase("yes"))
			{
	    	this.screenRecorder.stop();
	    	Thread.sleep(1500);
	    	convert(testResult.getName());
	    	saveVideo(testResult.getName(),driver);
			}
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	    } 
	
	public void convert(String testCaseName) throws Exception
	{
		if(System.getProperty("os.name").toUpperCase().contains("MAC"))
		{
		File ffmpegFile = new File("resources/ffmpeg/Mac/ffmpeg");
		File ffProbeFile = new File("resources/ffmpeg/Mac/ffprobe");
		
		FFmpeg ffmpeg = new FFmpeg(ffmpegFile.getAbsolutePath());
		FFprobe ffprobe = new FFprobe(ffProbeFile.getAbsolutePath());
		
		FFmpegProbeResult probeResult = ffprobe.probe("Videos/"+testCaseName+".avi");
		
		FFmpegBuilder builder = new FFmpegBuilder()
				.setInput(probeResult)
				  .overrideOutputFiles(true) 
				  
				  .addOutput("Videos/"+testCaseName+".mp4")
				    .setFormat("mp4")   
				    .setVideoCodec("libx264")
				    .addExtraArgs("-pix_fmt", "yuv420p")
				    .setVideoFrameRate(30,1)
				    .addExtraArgs("-q","50")
				    .setVideoResolution(1680, 1050) 
				    .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
				    .done();
				FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
				executor.createJob(builder).run();
			}
		else if(System.getProperty("os.name").toUpperCase().contains("WIN"))
		{
			File ffmpegFile = new File("resources/ffmpeg/Windows/ffmpeg.exe");
			File ffProbeFile = new File("resources/ffmpeg/Windows/ffprobe.exe");
			
			FFmpeg ffmpeg = new FFmpeg(ffmpegFile.getAbsolutePath());
			FFprobe ffprobe = new FFprobe(ffProbeFile.getAbsolutePath());
			FFmpegProbeResult probeResult = ffprobe.probe("Videos/"+testCaseName+".avi");
			
			FFmpegBuilder builder = new FFmpegBuilder()
					.setInput(probeResult)
					  .overrideOutputFiles(true) 
					  
					  .addOutput("Videos/"+testCaseName+".mp4")
					    .setFormat("mp4")   
					    .setVideoCodec("libx264")
					    .addExtraArgs("-pix_fmt", "yuv420p")
					    .setVideoFrameRate(30,1)
					    .addExtraArgs("-q","50")
					    .setVideoResolution(1680, 1050) 
					    .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL)
					    .done();
					FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
					executor.createJob(builder).run();
		}
	}

	
	private byte[] getFile(String fileName) throws Exception {
		File file = new File(fileName);
		return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
	   
	}
	
	@Attachment(value = "Video of {0}",type="video/mp4")
	private byte[] saveVideo(String name, WebDriver driver) throws Exception {
		return getFile("Videos/"+name+".mp4");
		
	}


@Attachment(value = "Screenshot of {0}", type = "image/png")
  public byte[] saveScreenshot(String name,WebDriver driver) {
	return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

@AfterMethod(alwaysRun=true)
public void stopRecording(ITestResult result) throws Exception
{
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	if(setUp.getVideoPermission().equalsIgnoreCase("yes"))
		{
		if(this.screenRecorder.getStateMessage() != null)
		{
		this.screenRecorder.stop();
		}
		}
	deleteFile(result.getName(),"avi");
	deleteFile(result.getName(),"mp4");
}

private void deleteFile(String name,String extension) {
	File file = new File("Videos/"+name+"."+extension);
	file.delete();	
}


@AfterSuite(alwaysRun=true)
public void tearDown(){
	driver.quit();
}
}
