package m2ila.vv.Mutation_Testing;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;
import javassist.expr.NewExpr;

public class ClassLoader {

	public ClassPool loadClasses() throws NotFoundException{
		// Creating container
		ClassPool pool = ClassPool.getDefault();
		pool.appendClassPath("/home/aminesoumiaa/workspace/VV-Mutation-Testing/inputs/target/classes");
		return pool;
	}
	
	public CtClass getCtClass(ClassPool pool,String className) throws NotFoundException{
		//creating compile-time class
		CtClass ctClass = pool.get("m2ila.vv.inputs."+className);		
		return ctClass;
	}
	
	public CtMethod getMethodByName(CtClass ctClass, String name) throws NotFoundException {
		CtMethod ctm = ctClass.getDeclaredMethod(name);
		//printing method name 
		// TODO replace prints with reporting
		System.out.println("Method found : "+ctm.getName());
		return ctm;
	}

}
