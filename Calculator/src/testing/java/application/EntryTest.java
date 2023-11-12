package application;

/**
 * @author DMarjanov
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.Entry;

public class EntryTest {
	// ENTRY FLOAT TESTS

	@Test
	// test 1.1 Does constructor accept float.
	public void testEntryFloatAcceptsFloat() {
		Entry entry = new Entry(5.3f);
		assertNotNull(entry);
	}

	@Test
	// test 1.2 Is entry type correct.
	// should be NUMBER type
	public void testEntryFloatTypeCorrect() {
		Entry entry = new Entry(5.6f);
		assertEquals(Type.NUMBER, entry.getType());
	}

	@Test
	// test 1.3 Checks if the correct value is returned.
	public void testEntryFloatReturnsCorrectFloat() {
		Entry entry = new Entry(9.9f);
		assertEquals(9.9f, entry.getValue());
	}

	@Test
	// test 1.4 Checks if the correct negative number is returned.
	public void testEntryFloatNegativeNumberCorrect() {
		Entry entry = new Entry(-6.3f);
		assertEquals(-6.3f, entry.getValue());
	}

	@Test
	// test 1.5 Checks if float number is 0 it is still returned.
	public void testEntryWhereFloatIs0() {
		Entry entry = new Entry(0.0f);
		assertEquals(0.0f, entry.getValue());
	}

	// ENTRYSYMBOL TESTS

	@Test
	// test 2.1 Checks if the constructor will take symbols +.
	public void testEntrySymbolAccepted() {
		Entry entry = new Entry(Symbol.PLUS);
		assertNotNull(entry);
	}

	@Test
	// test 2.2 Checks of entry is the correct type.
	public void testEntrySymbolCorrectType() {
		Entry entry = new Entry(Symbol.MINUS);
		assertEquals(Type.SYMBOL, entry.getType());

	}

	@Test
	// test 2.3 Checks if correct symbol is returned.
	public void testEntrySymbolCorrectReturned() throws BadType {
		Entry entry = new Entry(Symbol.DIVIDE);
		assertEquals(Symbol.DIVIDE, entry.getSymbol());
	}

	@Test
	// test 2.4 Checks if symbols such as RIGHT_BRACKET are accepted.
	public void testEntrySymbolRIGHT_BRACKETAccepted() {
		Entry entry = new Entry(Symbol.RIGHT_BRACKET);
		assertNotNull(entry);
	}

	// ENTRY STRING TESTS

	@Test
	// test 3.1 Check if constructor accepts strings.
	public void testEntryStringConstructor() {
		Entry entry = new Entry("Hello world");
		assertNotNull(entry);
	}

	@Test
	// test 3.2 Check if entry is correct type (string).
	public void testEntryStringIsCorrectType() {
		Entry entry = new Entry("HELLO WORLD");
		assertEquals(Type.STRING, entry.getType());
	}

	@Test
	// test 3.3 Check if correct string value is returned.
	public void testEntryStringReturnIsCorrect() throws BadType {
		Entry entry = new Entry("Hello World");
		assertEquals("Hello World", entry.getString());
	}

	@Test
	// test 3.4 Check if an empty string can be returned.
	public void testEntryStringEmptyReturn() throws BadType {
		Entry entry = new Entry("");
		assertEquals("", entry.getString());
	}

	@Test
	// test 3.5 Check is spaces are counted correctly in string.
	public void testEntryStringWithSpaces() throws BadType {
		Entry entry = new Entry("    Hello World    ");
		assertEquals("    Hello World    ", entry.getString());
	}

	@Test
	// test 3.6 check strings can be made with a variety of characters and numbers
	public void testEntryStringVarietyOfCharacters() {
		Entry entry = new Entry("5*3(7+3)/(x+5)(9+3)");
		assertNotNull(entry);
	}

	@Test
	// Test 4.1 Checks a Symbol entry correctly returns the Symbol value.
	public void testGetSymbolFromSymbolEntry() throws BadType {
		Entry entry = new Entry(Symbol.PLUS);
		assertEquals(Symbol.PLUS, entry.getSymbol());
	}

	@Test
	// Test 4.2 Checks that attempting to get a Symbol from a non-Symbol entry
	// throws BadType exception.
	public void testGetSymbolFromNonSymbolEntry() {
		Entry entry = new Entry(5.3f);
		assertThrows(BadType.class, entry::getSymbol);
	}

	@Test
	// Test 5.1 Checks that a String entry correctly returns the String value.
	public void testGetStringFromStringEntry() throws BadType {
		Entry entry = new Entry("Hello");
		assertEquals("Hello", entry.getString());
	}

	@Test
	// Test 5.2 Checks that attempting to get a String from a non-String entry
	// throws BadType.
	public void testGetStringFromNonStringEntry() {
		Entry entry = new Entry(13.6f);
		assertThrows(BadType.class, entry::getString);
	}

}
