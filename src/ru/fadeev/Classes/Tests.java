package ru.fadeev.Classes;

import static ru.fadeev.Classes.Handler.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.fadeev.Annotations.Cache;

import static org.junit.jupiter.api.Assertions.*;

/// Класс с тестами
public class Tests {

	///  Проверка на вывод полей без аннотаций или с аннотацией toString с полем Mode.YES
	@Test
	public void testToString() {
		toStringClass toStr = new toStringClass("Первый", 3, true);

		String result = toStringForm(toStr);

		assertTrue(result.contains("field1 = Первый"));
		assertTrue(result.contains("field2 = 3"));
		assertFalse(result.contains("field3 = true"));
	}


	/// Проверка совместно работы @Cache и @Invoke в одном классе
	/// Проверяется корректный вывод кешируемых областей, выполнение метода с аннотацией Invoke
	/// При пустом Cache метод с аннотацией Invoke не кеширует данные
	@Test
	public void testCahceInvoke(){
		Map<String, Object> cache = Mockito.mock(Map.class);
		CacheInvokeClass cachInv = new CacheInvokeClass(cache);

		String[] regions = CacheInvokeClass.class.getAnnotation(Cache.class).value();
		if(regions.length != 0) {
			assertArrayEquals(new String[]{"users", "orders"}, regions);

			invokeHandler(cachInv);

			Mockito.verify(cache).put("users", "user-data");
			Mockito.verify(cache).put("orders", "order-data");
		}else{
			assertArrayEquals(new String[]{}, regions);
			invokeHandler(cachInv);
			Mockito.verifyNoInteractions(cache);
		}

	}
}
