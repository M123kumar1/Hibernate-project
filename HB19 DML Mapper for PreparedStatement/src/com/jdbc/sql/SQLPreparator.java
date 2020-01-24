package com.jdbc.sql;

import com.jdbc.beans.EntityMetaData;

public interface SQLPreparator {
	public String sqlSelectObject(EntityMetaData entityMetaData);
	public String sqlSaveObject(EntityMetaData entityMetaData);
	public String sqlUpdateObject(EntityMetaData entityMetaData);
	public String sqlDeleteObject(EntityMetaData entityMetaData);
}
