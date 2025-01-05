/*
 * jgeom: Geometry Library for Java
 * 
 * Copyright (C) 2005  Samuel Gerber
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package net.jgeom.nurbs.geomContainers;

import java.util.Iterator;
import java.util.Vector;

public class AutoGrowingVector<E> implements Iterable {
	int size = 0;
	Vector<E> tab = new Vector<E>();
	private static final long serialVersionUID = 1L;
	public void add(int index, E obj) {
		E coo = (E) obj;
		if (tab.size() <= index)
			tab.setSize(index +1);
		tab.set(index, (E)coo);
		size++;
	}
	int size() {
		return size;
	}

	void set(int index,E p) {
		tab.set(index, p);
	}

	E get(int index) {
		// return tab[index];
		return (E)tab.get(index);
	}

	Vector<E> getAll()
	{
		return tab;
	}
	
	public Iterator iterator() {
		// attention a ne pas utilser l'iterateur pour choper autre chose
		// ques les coordonnées
		return tab.iterator();
	}
}