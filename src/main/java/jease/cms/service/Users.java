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
package jease.cms.service;

import jease.cms.domain.Content;
import jease.cms.domain.User;
import jfix.relational.Database;

import java.util.List;

public class Users {

	/**
	 * Returns all users with administration rights.
	 */
	public static List<User> queryAdministrators() {
		return Database.query("user", "isAdministrator=1");
	}

	/**
	 * Returns all users who are modifiable by given user. At the current state
	 * administrators will retrieve all existing users, all other users will
	 * retrieve themselfes.
	 */
	public static List<User> queryModifiableByUser(final User user) {
		return Database.query("user","isAdministrator=1");//must add a certificate!
	}

	/**
	 * Returns a unique user for given combination of login / password. If the
	 * login is also compared to the email address of the user.
	 */
	public static User queryByLogin(final String login, final String password) {
		return Database.queryUnique("user","username="+login+" password="+password);
	}

	/**
	 * Returns a unique user for given login
	 */
	public static User queryByLogin(final String login) {
		return Database.queryUnique("user","username="+login);
	}

	/**
	 * Returns a unique user for given email address.
	 */
	public static User queryByEmail(final String email) {
		return Database.queryUnique("user","email="+email);
	}

	/**
	 * Returns true if given login and given email is unique within database for
	 * given user.
	 */
	public static boolean isIdentityUnique(final User user, final String login,
			final String email) {
		return Database.isUnique(
				"user","username="+login+" or email="+email);
	}

	/**
	 * Replaces all occurences of old user with new user as editor of content.
	 */
	public static void replace(User oldUser, User newUser) {
		//for (Content content : queryContentsEditedByUser(oldUser)) {
		//	content.setEditor(newUser);
		//	Nodes.save(content);
		//}
	}

	private static List<Content> queryContentsEditedByUser(String userid) {
		return Database.query("content","userid="+userid);
	}

	/**
	 * Returns true if the given user is stored in database.
	 */
	public static boolean isStored(String userid) {
		return Database.isStored(userid);
	}
}
