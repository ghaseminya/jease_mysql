/*
    Copyright (C) 2016 maik.jablonski@jease.org

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jfix.relational;

import jfix.relational.engine.PersistenceEngine;

import java.util.List;

/**
 * Static wrapper around ObjectDatabase (with appropriate setup of the
 * PersistenceEngine) to ease the access to the database.
 * 
 * Per default PersistenceEngineDb4o is used. Other PersistenceEngines can be
 * configured via calling #setPersistenceEngine() before opening the database
 * via #open().
 */
public class Database {

	private static String persistenceEngineClassName;
	private static RelationalDatabase rdb;

	static {
		setPersistenceEngine("jfix.db4o.engine.PersistenceEngineMysql");
	}

	/**
	 * Sets the PersistenceEnginge by fully qualified classname.
	 */
	public static void setPersistenceEngine(String className) {
		persistenceEngineClassName = className;
	}

	/**
	 * Sets the PersistenceEngine by given class.
	 */
	public static void setPersistenceEngine(
			Class<? extends PersistenceEngine> clazz) {
		persistenceEngineClassName = clazz.getName();
	}

	/**
	 * Opens the given database. The parameter is usually a simple name for the
	 * database which is used by the PersistenceEngine to build the appropriate
	 * path to the database-file. If the given database-name contains a
	 * File.separator, the given database-name will be used as default directory
	 * for the database-file.
	 */
	public static void open(String database) {

	}

	/**
	 * Closes the current database.
	 */
	public static void close() {

	}

	/**
	 * Extended access to opened ObjectDatabase.
	 */
	public static RelationalDatabase ext() {
		return rdb;
	}

	/**
	 * Performs a Read-Command.
	 */
	public static void read(Runnable transaction) {

	}

	/**
	 * Performs a Write-Command.
	 */
	public static void write(Runnable transaction) {

	}

	/**
	 * Saves or upates given object in database.
	 */
	public static void save(Persistent persistent) {

	}

	/**
	 * Deletes given object from database. If references to given object still
	 * exists in database, a RuntimeException is thrown.
	 */
	public static void delete(Persistent persistent) {

	}

	/**
	 * Retrieves (cached) value from given supplier. The value of the supplier
	 * will be cached as long as no write-operation is performed against the
	 * database.
	 */
//	public static <E> E query(String TableN) {
//		return rdb.query(TableN);
//	}

	/**
	 * Queries all object from database which are instances of given class and
	 * match the given predicate.
	 */
	public static <E> List<E> query(String TableN, String Query) {
		return rdb.query(TableN, Query);
	}

	/**
	 * Queries all object from database which are instances of given class.
	 */
	//public static <E> List<E> query(String TableN) {
	//	return rdb.query(TableN);
	//}

	/**
	 * True if object is already stored in database.
	 */
	public static boolean isStored(String userid) {
		return rdb.isStored(userid);
	}

	/**
	 * Checks if given object is unique when compared by given predicate.
	 */
	public static <E> boolean isUnique(String TableN,String Query)
	{
		return rdb.isUnique(TableN,Query);
	}

	/**
	 * Retrieves unique object from database which is an instance of class and
	 * matches given predicate. If no or more than one object do match the
	 * predicate, null is returned.
	 */
	public static <E> E queryUnique(String TableN, String query) {
		return rdb.queryUnique(TableN, query);
	}
}
