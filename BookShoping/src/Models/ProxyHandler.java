package Models;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

	private Object instance;

	public static Object getInstance(Object o) {
		ProxyHandler p = new ProxyHandler();
		p.instance = o;

		Object ob = Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), p);
		return ob;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Object o = method.invoke(instance, args);
		return o;
	}
}
