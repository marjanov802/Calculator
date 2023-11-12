package application;

/**
 * The Type enum represents different data types that the calculator could have.
 * 
 * @author DMarjanov
 */
public enum Type {
	STRING("string"), NUMBER("number"), SYMBOL("symbol"), INVALID("invalid");

	String name;

	private Type(String name) {
		this.name = name;
	}

	/**
	 * Returns the name of the type represented by this enum value as a string.
	 *
	 * @return The type name as a string.
	 */
	public String toString() {
		return this.name;
	}
}
