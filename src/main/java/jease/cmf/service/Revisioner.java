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
package jease.cmf.service;

import jease.cmf.domain.Node;

import java.lang.reflect.Field;

public class Revisioner extends Serializer {

	/**
	 * Create a new Revisioner. The service needs to know about all nodes which
	 * exist to configure the serializer properly.
	 */
	public Revisioner(Node... nodes) {
		for (Node node : nodes) {
			for (Field field : getFields(node)) {

			}
		}
	}

	/**
	 * Serialize given Node into XML and return result as Blob.
	 */

}
