package Assignment3;

public class AnnotationRunner {
	@CanRun
	public void method1(){
		System.out.println("Method1");
	}
	public void method2(){
		System.out.println("Method2");
	}
	@CanRun
	public void method3(){
		System.out.println("Method3");
	}
	public void method4(){
		System.out.println("Method4");
	}
	@CanRun
	public void method5(){
		System.out.println("Method5");
	}
}
