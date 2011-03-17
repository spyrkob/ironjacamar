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
package org.jboss.jca.common.api.metadata.common;

import org.jboss.jca.common.api.metadata.JCAMetadata;
import org.jboss.jca.common.api.metadata.ValidatableMetadata;
import org.jboss.jca.common.api.validator.ValidateException;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * A Recovery.
 *
 * @author <a href="stefano.maestri@jboss.com">Stefano Maestri</a>
 *
 */
public class Recovery implements JCAMetadata, ValidatableMetadata
{
   /** The serialVersionUID */
   private static final long serialVersionUID = -7425365995463321893L;

   private final Credential credential;

   private final Extension recoverPlugin;

   private final Boolean noRecovery;

   /**
    * Create a new Recovery.
    *
    * @param credential credential
    * @param recoverPlugin plugin
    * @param noRecovery niRecovery
    * @throws ValidateException in case of not valid metadata creation
    */
   public Recovery(Credential credential, Extension recoverPlugin, Boolean noRecovery) throws ValidateException
   {
      super();
      this.credential = credential;
      this.recoverPlugin = recoverPlugin;
      this.noRecovery = noRecovery;
      this.validate();
   }

   /**
    * Get the security.
    *
    * @return the security.
    */
   public final Credential getCredential()
   {
      return credential;
   }

   /**
    * Get the plugin.
    *
    * @return the plugin.
    */
   public final Extension getRecoverPlugin()
   {
      return recoverPlugin;
   }

   /**
    * Get the noRecovery.
    *
    * @return the noRecovery.
    */
   public final Boolean getNoRecovery()
   {
      return noRecovery;
   }

   @Override
   public void validate() throws ValidateException
   {
      // the only field not yet validated is a Boolean and all value are fine
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((noRecovery == null) ? 0 : noRecovery.hashCode());
      result = prime * result + ((recoverPlugin == null) ? 0 : recoverPlugin.hashCode());
      result = prime * result + ((credential == null) ? 0 : credential.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (!(obj instanceof Recovery))
         return false;
      Recovery other = (Recovery) obj;
      if (noRecovery == null)
      {
         if (other.noRecovery != null)
            return false;
      }
      else if (!noRecovery.equals(other.noRecovery))
         return false;
      if (recoverPlugin == null)
      {
         if (other.recoverPlugin != null)
            return false;
      }
      else if (!recoverPlugin.equals(other.recoverPlugin))
         return false;
      if (credential == null)
      {
         if (other.credential != null)
            return false;
      }
      else if (!credential.equals(other.credential))
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return "Recovery [credential=" + credential + ", plugin=" + recoverPlugin + ", noRecovery=" + noRecovery + "]";
   }

   /**
   *
   * A Tag.
   *
   * @author <a href="stefano.maestri@jboss.com">Stefano Maestri</a>
   *
   */
   public enum Tag
   {
      /** always first
       *
       */
      UNKNOWN(null),

      /**
       * pool tag

      /**
      * config-property tag
      */
      RECOVER_CREDENTIAL("recover-credential"),
      /** plugin tag */

      RECOVER_PLUGIN("recover-plugin");

      private final String name;

      /**
       *
       * Create a new Tag.
       *
       * @param name a name
       */
      Tag(final String name)
      {
         this.name = name;
      }

      /**
       * Get the local name of this element.
       *
       * @return the local name
       */
      public String getLocalName()
      {
         return name;
      }

      private static final Map<String, Tag> MAP;

      static
      {
         final Map<String, Tag> map = new HashMap<String, Tag>();
         for (Tag element : values())
         {
            final String name = element.getLocalName();
            if (name != null)
               map.put(name, element);
         }
         MAP = map;
      }

      /**
      *
      * Static method to get enum instance given localName XsdString
      *
      * @param localName a XsdString used as localname (typically tag name as defined in xsd)
      * @return the enum instance
      */
      public static Tag forName(String localName)
      {
         final Tag element = MAP.get(localName);
         return element == null ? UNKNOWN : element;
      }

   }

   /**
    *
    * A Attribute.
    *
    * @author <a href="stefano.maestri@jboss.com">Stefano Maestri</a>
    *
    */
   public enum Attribute
   {

      /** class-name attribute
      *
      */
      NO_RECOVERY("no-recovery");

      private final String name;

      /**
       *
       * Create a new Tag.
       *
       * @param name a name
       */
      Attribute(final String name)
      {
         this.name = name;
      }

      /**
       * Get the local name of this element.
       *
       * @return the local name
       */
      public String getLocalName()
      {
         return name;
      }

   }

}
