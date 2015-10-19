package Assignment3;

import java.lang.reflect.Method;

public class MainAnnotation {
	public static void main(String args[]) {
		AnnotationRunner annotationRunner = new AnnotationRunner();
		Method[] methods = annotationRunner.getClass().getMethods(); 
		for(Method method:methods) {
			CanRun canRun = method.getAnnotation(CanRun.class);
			if(canRun != null) {
				try {
					method.invoke(annotationRunner);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
