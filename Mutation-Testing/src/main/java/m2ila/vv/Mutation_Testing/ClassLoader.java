package m2ila.vv.Mutation_Testing;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class ClassLoader {
	
	private String classesUrl;
	
	public ClassLoader(String classesUrl) {
		this.classesUrl = classesUrl;
	}

	public ClassPool loadClasses() throws NotFoundException{
		// Creating container
		ClassPool pool = new ClassPool(true);
		pool = ClassPool.getDefault();
		pool.appendClassPath(this.classesUrl+"target/classes");
		return pool;
	}
	
	public CtClass getCtClass(ClassPool pool,String className) throws NotFoundException{
		//creating compile-time class
		CtClass ctClass = pool.get("m2ila.vv.inputs."+className);		
		return ctClass;
	}
	
	public CtMethod getMethodByName(CtClass ctClass, String name) throws NotFoundException {
		return ctClass.getDeclaredMethod(name);
	}

}
