package Models;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLIBProxyHandler implements MethodInterceptor {

	private Object instance ;
	
	
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		Object o = arg3.invokeSuper(instance, arg2);
		return o;
	}

}
