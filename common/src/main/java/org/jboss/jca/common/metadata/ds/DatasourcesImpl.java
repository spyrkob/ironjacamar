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
package org.jboss.jca.common.metadata.ds;

import org.jboss.jca.common.api.metadata.ds.DataSource;
import org.jboss.jca.common.api.metadata.ds.DataSources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.XADataSource;

/**
 *
 * A DatasourcesImpl.
 *
 * @author <a href="stefano.maestri@jboss.com">Stefano Maestri</a>
 *
 */
public class DatasourcesImpl implements DataSources
{
   /** The serialVersionUID */
   private static final long serialVersionUID = 6933310057105771370L;

   private final ArrayList<DataSource> datasource;

   private final ArrayList<XADataSource> xaDataSource;

   /**
    * Create a new DatasourcesImpl.
    *
    * @param datasource datasource
    * @param xaDataSource xaDataSource
    */
   public DatasourcesImpl(List<DataSource> datasource, List<XADataSource> xaDataSource)
   {
      super();
      if (datasource != null)
      {
         this.datasource = new ArrayList<DataSource>(datasource.size());
         this.datasource.addAll(datasource);
      }
      else
      {
         this.datasource = new ArrayList<DataSource>(0);
      }
      if (xaDataSource != null)
      {
         this.xaDataSource = new ArrayList<XADataSource>(xaDataSource.size());
         this.xaDataSource.addAll(xaDataSource);
      }
      else
      {
         this.xaDataSource = new ArrayList<XADataSource>(0);
      }
   }

   /**
    * Get the datasource.
    *
    * @return the datasource.
    */
   @Override
   public final List<DataSource> getDatasource()
   {
      return Collections.unmodifiableList(datasource);
   }

   /**
    * Get the xaDataSource.
    *
    * @return the xaDataSource.
    */
   @Override
   public final List<XADataSource> getXaDataSource()
   {
      return Collections.unmodifiableList(xaDataSource);
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((datasource == null) ? 0 : datasource.hashCode());
      result = prime * result + ((xaDataSource == null) ? 0 : xaDataSource.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (!(obj instanceof DatasourcesImpl))
         return false;
      DatasourcesImpl other = (DatasourcesImpl) obj;
      if (datasource == null)
      {
         if (other.datasource != null)
            return false;
      }
      else if (!datasource.equals(other.datasource))
         return false;
      if (xaDataSource == null)
      {
         if (other.xaDataSource != null)
            return false;
      }
      else if (!xaDataSource.equals(other.xaDataSource))
         return false;
      return true;
   }

   @Override
   public String toString()
   {
      return "DatasourcesImpl [datasource=" + datasource + ", xaDataSource=" + xaDataSource + "]";
   }

}