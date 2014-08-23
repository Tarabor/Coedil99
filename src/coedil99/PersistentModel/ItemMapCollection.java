/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package coedil99.PersistentModel;

import org.orm.*;

public class ItemMapCollection extends org.orm.util.ORMMap {
	public ItemMapCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int targetKey, int collType) {
		super(owner, adapter, ownerKey, targetKey, true, collType);
	}
	
	public ItemMapCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int collType) {
		super(owner, adapter, ownerKey, -1, false, collType);
	}
	
	/**
	* Return an iterator over the persistent objects
	* @return The persisten objects iterator
	*/
	public java.util.Iterator getIterator() {
		return super.getIterator(_ownerAdapter);
	}
	
	/**
	 * Add the specified persistent object with the specified key to ORMMap.
	 * @param key The specified key
	 * @param value The specified persistent object
	 */
	public void add(Object key, Item value) {
		if (value != null) {
			super.add(key, value, value._ormAdapter);
		}
	}
	
	/**
	 * Remove the mapping for the key of persistent object from this map if it is present.
	 * @param key The key of persistent object
	 */
	public void remove(Object key) {
		Item value = get(key);
		if (value != null) {
			super.remove(key, value._ormAdapter);
		}
	}
	
	/**
	 *	Return boolean of this map contains a mapping for the specified persistent object or not. 
	 * @param key The specified persistent object
	 * @return True if the map contains a mapping for the specified persistent object
	 */
	public boolean contains(Object key) {
		return super.contains(key);
	}
	
	/**
	 * Get the specified persistent object by the key of ORMMap.
	 * @param key The specified persistent object key
	 * @return The specified persistent object
	 */
	public Item get(Object key) {
		return (Item) super.getImpl(key);
	}
	
	/**
	 * Return an iterator over the persistent objects in ORMMap.
	 * @return The Key Iterator
	 */
	public java.util.Iterator getKeyIterator() {
		return super.getKeyIterator();
	}
	
	/**
	 * Return an array containing all of the persistent objects in ORMMap.
	 * @return The array of persistent objects
	 */
	public Item[] toArray() {
		return (Item[]) super.toArray(new Item[size()]);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMMap
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>ID</li>
	 * <li>descrizione</li>
	 * <li>id_item</li>
	 * </ul>
	 * @return The persistent objects sorted array
	 */
	public Item[] toArray(String propertyName) {
		return toArray(propertyName, true);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMMap
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>ID</li>
	 * <li>descrizione</li>
	 * <li>id_item</li>
	 * </ul>
	 * @param ascending true for ascending, false for descending
	 * @return The persistent objects sorted array
	 */
	public Item[] toArray(String propertyName, boolean ascending) {
		return (Item[]) super.toArray(new Item[size()], propertyName, ascending);
	}
	
	protected PersistentManager getPersistentManager() throws PersistentException {
		return coedil99.PersistentModel.Coedil99PersistentManager.instance();
	}
	
}

