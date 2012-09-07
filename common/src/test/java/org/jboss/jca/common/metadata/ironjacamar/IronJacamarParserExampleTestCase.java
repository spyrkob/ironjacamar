/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.jca.common.metadata.ironjacamar;

import org.jboss.jca.common.metadata.ParserTestBase;
import org.jboss.jca.common.metadata.ironjacamar.v11.IronJacamarParser;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * IronJacamarParserExampleTestCase
 *
 * @author <a href="mailto:vrastsel@redhat.com">Vladimir Rastseluev</a>
 *
 */
public class IronJacamarParserExampleTestCase extends ParserTestBase
{
   /**
   *
   * beforeClass method
   *
   * @throws Exception in casae of file not found
   */
   @BeforeClass
   public static void beforeClass() throws Exception
   {
      parser = new IronJacamarParser();
   }

   /**
    * 
    * test examples in ironjacamar resource subdirectory
    * 
    * @throws Exception in case of error
    */
   @Test
   public void testExamples() throws Exception
   {
      testSubSystem("ironjacamar");
   }
   
}
