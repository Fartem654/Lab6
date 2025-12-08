package ru.fadeev.Classes;

import java.util.Map;
import ru.fadeev.Annotations.Cache;
import ru.fadeev.Annotations.Invoke;


/// Класс для демонстрации работы аннотации Cache с областями {"users", "orders"} или {} и аннотации Invoke
@Cache//({"users", "orders"})
public class CacheInvokeClass {

	private final Map<String, Object> cache;

	/// Конструктор
	public CacheInvokeClass(Map<String, Object> cache) {
		this.cache = cache;
	}

	/// Метод для кеширования указанных в аннотации областей
	@Invoke
	public void cacheData() {
		Cache cachAnn = this.getClass().getAnnotation(Cache.class);
		if (cachAnn == null || cachAnn.value().length == 0) {
			return;
		}
		cache.put("users", "user-data");
		cache.put("orders", "order-data");

	}
}