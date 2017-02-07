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

import jease.cmf.annotation.NotSerialized;
import jease.cmf.domain.Node;
import jfix.relational.Persistent;
import jfix.util.Reflections;

import java.lang.reflect.Field;
import java.util.Set;


public class Serializer {


	public Serializer() {

	}

	public Set<Field> getFields(Node node) {
		return Reflections.getFields(node.getClass());
	}

	public boolean isPersistentEntity(Field field) {
		return Reflections.isAssignable(Persistent.class, field)
				&& !(Reflections.isAssignable(Persistent.Value.class, field));
	}

	public boolean isPersistentValue(Field field) {
		return Reflections.isAssignable(Persistent.class, field)
				&& Reflections.isAssignable(Persistent.Value.class, field);
	}

	public boolean isNodeDeclaringClass(Field field) {
		return field.getDeclaringClass() == Node.class;
	}

	public boolean isNotSerialized(Field field) {
		return field.getAnnotation(NotSerialized.class) != null;
	}
	


}
