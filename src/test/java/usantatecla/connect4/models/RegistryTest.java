package usantatecla.connect4.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegistryTest {
	/*
	 * Equivalence class undo, redo register: 0[1,..3]4  
	 */
	private Registry registry;
	
	@BeforeEach
	void beforeEach() {
		Game game = mock(Game.class);
		this.registry = new Registry(game);
	}
	
	@Test
	void testGivenRegistryOneRegister_whenUndo_thenIsUndoableFalse() {
		this.registry.register();
		this.registry.undo();
		assertFalse(this.registry.isUndoable());
	}
	
	@Test
	void testGivenRegistryThreRegister_whenFourRedo_thenIsUndoableFalse() {
		this.registry.register();
		this.registry.register();
		this.registry.register();
		this.registry.undo();
		this.registry.undo();
		this.registry.undo();
		this.registry.redo();
		this.registry.redo();
		this.registry.redo();
		assertFalse(this.registry.isRedoable());
	}
	
	@Test
	void testGivenNewRegistry_whenIsUndoable_thenReturnFalse() {
		assertFalse(this.registry.isUndoable());
	}
	
	@Test
	void testGivenNewRegistry_whenIsRedoable_thenReturnFalse() {
		assertFalse(this.registry.isRedoable());
	}
	
	@Test
	void testGivenNewRegistry_whenIsUndo_thenReturnFalse() {
		assertThrows(AssertionError.class, () -> {
			registry.undo();
		});
	}
	
	@Test
	void testGivenNewRegistry_whenIsRedo_thenReturnFalse() {
		assertThrows(AssertionError.class, () -> {
			registry.redo();
		});
	}

}
