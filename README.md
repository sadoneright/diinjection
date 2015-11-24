# diinjection
This is an example for how dependency injection can be implemented. 
Also this example presents how custom Annotations in Java can be used and implemented.

The core class for the injection is <b>DependencyInjecter</b> which introduce only one method.
The method injectDependencies(Object app); is responsible for the instantiation of the injected beans.

For now there is only one Annotation, which can be parameterized with a Type of the Bean that should be injected. 

Example use:

```java

public static void main(String[] args){
	DependencyInjecter diContainer = new DependencyInjecter();
	ApplicationWithInjection app = new ApplicationWithInjection();
	
	diContainer.injectDependencies(app);
	
	app.getInjectedBean().getAnotherInjectedBean().doSth();
}
```

This dependency injecter only works if there are setters implemented for the declared fields. 
