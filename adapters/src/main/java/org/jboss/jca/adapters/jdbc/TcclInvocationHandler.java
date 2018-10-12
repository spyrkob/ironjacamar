package org.jboss.jca.adapters.jdbc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedAction;

import org.jboss.jca.adapters.jdbc.spi.ClassLoaderPlugin;

public class TcclInvocationHandler implements InvocationHandler {
   private final Object delegate;
   private final ClassLoaderPlugin classLoaderPlugin;

   public TcclInvocationHandler(Object delegate, ClassLoaderPlugin classLoaderPlugin) {
      if (delegate == null) {
         throw new IllegalArgumentException("delegate can't be null");
      }
      this.delegate = delegate;
      this.classLoaderPlugin = classLoaderPlugin;
   }

   @Override
   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      Object res = null;
      ClassLoader tccl = getThreadContextClassLoader();
      try {
         setThreadContextClassLoader(classLoaderPlugin.getClassLoader());
         res = method.invoke(delegate, args);
      } finally {
         setThreadContextClassLoader(tccl);
      }

      if (res != null && method.getReturnType().isInterface()) {
         res = Proxy.newProxyInstance(getThreadContextClassLoader(), new Class[] {method.getReturnType()}, new TcclInvocationHandler(res, classLoaderPlugin));
      }

      return res;
   }
   
   static ClassLoader getThreadContextClassLoader()
   {
      if (System.getSecurityManager() == null)
         return Thread.currentThread().getContextClassLoader();

      return AccessController.doPrivileged(new PrivilegedAction<ClassLoader>()
      {
         public ClassLoader run()
         {
            return Thread.currentThread().getContextClassLoader();
         }
      });
   }

   /**
    * Set the context classloader.
    * @param cl classloader
    */
   static void setThreadContextClassLoader(final ClassLoader cl)
   {
      if (System.getSecurityManager() == null)
      {
         Thread.currentThread().setContextClassLoader(cl);
      }
      else
      {
         AccessController.doPrivileged(new PrivilegedAction<Object>()
         {
            public Object run()
            {
               Thread.currentThread().setContextClassLoader(cl);

               return null;
            }
         });
      }
   }

}