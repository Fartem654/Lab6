package ru.fadeev;

import static ru.fadeev.Classes.Handler.*;

import ru.fadeev.Classes.CacheClass;
import ru.fadeev.Classes.TwoClass;
import ru.fadeev.Classes.toStringClass;

public class Main {

	public static void main(String[] args) {

//		InvokeClass asd = new InvokeClass();
//		invokeHandler(asd);

//		DefaultClass def = new DefaultClass();
//		defaultHandler(def);

		toStringClass tstr = new toStringClass("Строка", 1, false);
		System.out.println(toStringForm(tstr));

//		validateHandler(ValidateClass.class);
//		validateHandler(Invoke.class);
//		validateHandler(Default.class);

//		twoHandler(TwoClass.class);

//		cacheHandler(CacheClass.class);


	}
}