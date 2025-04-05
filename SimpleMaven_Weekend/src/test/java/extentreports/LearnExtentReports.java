package extentreports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LearnExtentReports {
	@Test
	public void createReport() {
		String time = LocalDateTime.now().toString().replace(":", "-");
		// step 1: create ExtentSparkReporter object
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/ExtentReport_"+time+".html");
		
		// step 2: create ExtentReports object
		ExtentReports extReport=new ExtentReports();
		
		// step 3: attach ExtentSparkReporter to ExtentReports
		extReport.attachReporter(spark);
		
		// step 4: create ExtentTest object
		ExtentTest test = extReport.createTest("createReport");
		
		// step 5: call log() to provide status and message
		test.log(Status.PASS, "Home page is displayed");
		
		// step 6: call flush()
		extReport.flush();
	}
}
