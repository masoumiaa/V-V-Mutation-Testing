package m2ila.vv.Mutation_Testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javassist.NotFoundException;

public class TestRunner {

	public static void runTests() throws ClassNotFoundException, MalformedURLException, NotFoundException{
		
		URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[] {
	       new URL("file:///home/aminesoumiaa/workspace/VV-Mutation-Testing/inputs/target/test-classes/"),
	       new URL("file:///home/aminesoumiaa/workspace/VV-Mutation-Testing/inputs/target/classes/")
	    });
		Class<?> clazz = urlClassLoader.loadClass("m2ila.vv.inputs.BinOperationTest");

		JUnitCore core = new JUnitCore();
        Result result = core.run(clazz);
        System.out.println("FINISHED");
        System.out.println(String.format("| RUN: %d", result.getRunCount()));
        if(result.wasSuccessful())
        	System.out.println("| ALL SUCCEEDED !");
        else
        	System.out.println("| FAILURE ! ");
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
            System.out.println(failure.getTrace());
        }
        System.out.println(String.format("| TIME: %dms", result.getRunTime()));
	}
}
