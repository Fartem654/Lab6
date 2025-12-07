 <p><strong>Автор</strong>: Фадеев Артём ИТ-12<br>
   <strong>Вариант</strong>: 1<br>
 </p>

<hr>

<h2>Оглавление</h2>
<ul>
 <li>
  <a href="#алгоритм">Описание и решение заданий</a>
  <ul>
   <li>
    <a href="#задание11">Задание 1.1</a>
   </li>
     <li>
    <a href="#задание12">Задание 1.2</a>
   </li>
   <li>
    <a href="#задание13">Задание 1.3</a>
   </li>
   <li>
    <a href="#задание14">Задание 1.3</a>
   </li>
   <li>
    <a href="#задание15">Задание 1.5</a>
   </li>
    <li>
    <a href="#задание16">Задание 1.6</a>
   </li>
    <li>
    <a href="#задание21">Задание 7.1</a>
   </li>
    <li>
    <a href="#задание27">Задание 7.2</a>
   </li>
  </ul>
 </li>
 <li><a href="#структура-проекта">Структура проекта</a></li>
 <li><a href="#как-запустить">Как запустить</a></li>
</ul>

<h2 id="алгоритм">Алгоритмы выполнения</h2>

<h3 id="задание11">Задание 1.1</h3>
<p><strong>Текст задачи:</strong><br></p>
<p><strong>@Invoke.</strong><br>
Разработайте аннотацию <code>@Invoke</code>, со следующими характеристиками:<br>
• Целью может быть только МЕТОД<br>
• Доступна во время исполнения программы<br>
• Не имеет свойств<br>
Создайте класс, содержащий несколько методов, и проаннотируйте хотя бы один из них аннотацией <code>@Invoke</code>.<br>
Реализуйте обработчик (через Reflection API), который находит методы, отмеченные аннотацией <code>@Invoke</code>, и вызывает их автоматически.</p>

<p><strong>Описание выполнения задания:</strong><br>
 <p><strong><code>@Invoke</code></strong></p>
    <ul>
      <li>
    Описывается аннотация <strong>@Invoke</strong> без свойств, только для методов - <code>@Target({ElementType.METHOD})</code>, доступная во время исполнения программы - <code>@Retention(RetentionPolicy.RUNTIME)</code>
    </li>
      <li>  
        В классе с обработчиками <code>Handler</code> реализуется статический метод <code>invokeHandler</code> с параметром  <code>Object obj</code>
      </li>
        <ul>
            <li>
                Метод проверяет, что параметр не нулевой
            </li>
            <li>
                Получает класс объекта и для каждого метода проверяет наличие аннотации
            </li>
            <li>
                Если аннотация есть - данный метод вызвается
            </li>
        </ul>
    </ul>
<h4>Тесты</h4>


<h3 id="задание12">Задание 1.2</h3>
<p><strong>Текст задачи:</strong><br></p>
<p><strong>@Default.</strong><br>
Разработайте аннотацию <code>@Default</code>, со следующими характеристиками:<br>
• Целью может быть ТИП или ПОЛЕ<br>
• Доступна во время исполнения программы<br>
• Имеет обязательное свойство <code>value</code> типа <code>Class</code><br>
Проаннотируйте какой-либо класс данной аннотацией, указав тип по умолчанию.<br>
Напишите обработчик, который выводит имя указанного класса по умолчанию.</p>

<p><strong>Описание выполнения задания:</strong><br>
 <p><strong><code>@Default</code></strong></p>
    <ul>
      <li>
    Описывается аннотация <strong>Default</strong> со свойством <code>Class<?> value()</code> для типа по умолчанию
    </li>
    <li>
     Данная аннотация только для типов или полей - <code>@Target({ElementType.TYPE, ElementType.FIELD})</code>, доступная во время исполнения программы - <code>@Retention(RetentionPolicy.RUNTIME)</code>
    </li>
      <li>  
        В классе с обработчиками <code>Handler</code> реализуется статический метод <code>defaultHandler</code> с параметром  <code>Object obj</code>
      </li>
        <ul>
            <li>
                Метод проверяет, что параметр не нулевой
            </li>
            <li>
                Получает класс объекта и выводит для него тип по умолчанию
            </li>
            <li>
                Далее метод аналогично действует с полями
            </li>
        </ul>
    </ul>

<h4>Тесты</h4>

<h3 id="задание13">Задание 1.3</h3>
<p><strong>Текст задачи:</strong><br></p>
<p><strong>@ToString.</strong><br>
Разработайте аннотацию <code>@ToString</code>, со следующими характеристиками:<br>
• Целью может быть ТИП или ПОЛЕ<br>
• Доступна во время исполнения программы<br>
• Имеет необязательное свойство <code>value</code> c двумя вариантами значений: <code>YES</code> или <code>NO</code><br>
• Значение свойства по умолчанию: <code>YES</code><br>
Проаннотируйте класс аннотацией <code>@ToString</code>, а одно из полей – с <code>@ToString(Mode.NO)</code>.<br>
Создайте метод, который формирует строковое представление объекта, учитывая только те поля, где <code>@ToString</code> имеет значение <code>YES</code>.</p>

<p><strong>Описание выполнения задания:</strong><br>
 <p><strong><code>@ToString</code></strong></p>
    <ul>
      <li>
    Описывается аннотация <strong>ToString</strong> со свойством <code>Mode value() default Mode.YES</code> для обозначения вывода не вывода значений, <code>enum Mode</code> - перечисление, хранящее только "YES" и "NO"
    </li>
    <li>
     Данная аннотация только для типов или полей - <code>@Target({ElementType.TYPE, ElementType.FIELD})</code>, доступная во время исполнения программы - <code>@Retention(RetentionPolicy.RUNTIME)</code>
    </li>
      <li>  
        В классе с обработчиками <code>Handler</code> реализуется статический метод <code>toStringForm</code> с параметром  <code>Object obj</code>
      </li>
        <ul>
            <li>
                Метод проверяет, что параметр не нулевой
            </li>
            <li>
                Получает класс объекта, записывает его имя в результирующую строку
            </li>
            <li>
                Далее для каждого поля проверяется отсутствие аннотации или наличие аннотации со значением Mode.YES, в этом случае поле добавится в результирующую строку
            </li>
            <li>
                Возвращается строка
            </li>
        </ul>
    </ul>

<h4>Тесты</h4>

<h3 id="задание14">Задание 1.4</h3>
<p><strong>Текст задачи:</strong><br></p>
<p><strong>@Validate.</strong><br>
Разработайте аннотацию <code>@Validate</code>, со следующими характеристиками:<br>
• Целью может быть ТИП или АННОТАЦИЯ<br>
• Доступна во время исполнения программы<br>
• Имеет обязательное свойство <code>value</code>, типа <code>Class[]</code><br>
Проаннотируйте класс аннотацией <code>@Validate</code>, передав список типов для проверки.<br>
Реализуйте обработчик, который выводит, какие классы указаны в аннотации.</p>

<p><strong>Описание выполнения задания:</strong><br>
 <p><strong><code>@Validate</code></strong></p>
    <ul>
      <li>
    Описывается аннотация <strong>Validate</strong> со свойством <code>Class<?>[] value()</code> для списка классов
    </li>
    <li>
     Данная аннотация только для типов или аннотаций - <code>@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})</code>, доступная во время исполнения программы - <code>@Retention(RetentionPolicy.RUNTIME)</code>
    </li>
      <li>  
        В классе с обработчиками <code>Handler</code> реализуется статический метод <code>validateHandler</code> с параметром  <code>Class<?> clazz</code>
      </li>
        <ul>
            <li>
                Метод проверяет, что параметр не нулевой
            </li>
            <li>
                Проверяет, содержит ли параметр аннотацию Validate
            </li>
            <li>
                Далее получает массив из аннотации и выводит его, если он не пустой
            </li>
        </ul>
    </ul>

<h4>Тесты</h4>

<h3 id="задание15">Задание 1.5</h3>
<p><strong>Текст задачи:</strong><br></p>
<p><strong>@Two.</strong><br>
Разработайте аннотацию <code>@Two</code>, со следующими характеристиками:<br>
• Целью может быть ТИП<br>
• Доступна во время исполнения программы<br>
• Имеет два обязательных свойства: <code>first</code> типа <code>String</code> и <code>second</code> типа <code>int</code><br>
Проаннотируйте какой-либо класс аннотацией <code>@Two</code>, передав строковое и числовое значения.<br>
Реализуйте обработчик, который считывает и выводит значения этих свойств.</p>

<p><strong>Описание выполнения задания:</strong><br>
 <p><strong><code>@Two</code></strong></p>
    <ul>
      <li>
    Описывается аннотация <strong>Two</strong> со свойствами <code>String first()</code> для первого строкового значения и <code>int second()</code> для второго целочисленного значения
    </li>
    <li>
     Данная аннотация только для типов - <code>@Target({ElementType.TYPE})</code>, доступная во время исполнения программы - <code>@Retention(RetentionPolicy.RUNTIME)</code>
    </li>
      <li>  
        В классе с обработчиками <code>Handler</code> реализуется статический метод <code>twoHandler</code> с параметром  <code>Class<?> clazz</code>
      </li>
        <ul>
            <li>
                Метод проверяет, что параметр не нулевой
            </li>
            <li>
                Проверяет, содержит ли параметр аннотацию Two
            </li>
            <li>
                Получает из аннотации первое и второе значение и выводит их.
            </li>
        </ul>
    </ul>

<h4>Тесты</h4>

<h3 id="задание16">Задание 1.6</h3>
<p><strong>Текст задачи:</strong><br></p>
<p><strong>@Cache.</strong><br>
Разработайте аннотацию <code>@Cache</code>, со следующими характеристиками:<br>
• Целью может быть ТИП<br>
• Доступна во время исполнения программы<br>
• Имеет необязательное свойство <code>value</code>, типа <code>String[]</code><br>
• Значение свойства по умолчанию: пустой массив<br>
Проаннотируйте класс аннотацией <code>@Cache</code>, указав несколько кешируемых областей.<br>
Создайте обработчик, который выводит список всех кешируемых областей или сообщение, что список пуст.</p>

<p><strong>Описание выполнения задания:</strong><br>
 <p><strong><code>@Cache</code></strong></p>
    <ul>
      <li>
    Описывается аннотация <strong>Cache</strong> со свойством <code>String[] value() default {}</code> - для указания кешируемых областей, мо умолчанию пустой массив
    </li>
    <li>
     Данная аннотация только для типов - <code>@Target({ElementType.TYPE})</code>, доступная во время исполнения программы - <code>@Retention(RetentionPolicy.RUNTIME)</code>
    </li>
      <li>  
        В классе с обработчиками <code>Handler</code> реализуется статический метод <code>cacheHandler</code> с параметром  <code>Class<?> clazz</code>
      </li>
        <ul>
            <li>
                Метод проверяет, что параметр не нулевой
            </li>
            <li>
                Проверяет, содержит ли параметр аннотацию Сache
            </li>
            <li>
                Получает из аннотации массив кешируемых областей и если он не пустой выводит эти области
            </li>
        </ul>
    </ul>

<h4>Тесты</h4>

<h3 id="задание21">Задание 2.1</h3>
<p><strong>Текст задачи:</strong><br></p>
<p>Напишите тест, используя фреймворк JUnit, к методу <code>toString()</code> (или методу, формирующему строковое представление объекта, основанное на аннотации <code>@ToString</code>).<br>
• Проверить, что в результирующей строке отображаются только те поля, которые имеют аннотацию <code>@ToString(Mode.YES)</code> или не аннотированы вовсе.<br>
• Убедиться, что поля с <code>@ToString(Mode.NO)</code> не попадают в вывод.</p>

<p><strong>Описание выполнения задания:</strong><br>
 <p><strong><code>TestToString</code></strong></p>
    <ul>
      <li>
    Из задания 1.3 берется класс <code>toStringClass</code> c полями <code>private String field1</code> - без аннотации; <code>public int field2</code> - просто с аннотацией ToString;  <code>public boolean field3</code> - с аннотацией @ToString(Mode.NO)
    </li>
    <li>
        Также реализуется коснтруктор
    </li>
    <li>
      Создается класс <code>Tests</code>, в нем метод <code>testToString</code> помеченный аннотацией <code>testToString</code> из фреймворка <code>JUnit</code>
    </li>
    <ul>
        <li>
            Метод создает объект класса <code>toStringClass</code> с параметрами: "Первый", "3", "true"
        </li>
        <li>
            В строковое поле <code>result</code> сохранят вывод методо обработчика <code>toStringForm(toStr)</code>
        </li>
        <li>
            С помощью метода <code>assertTrue</code> из фреймворка <code>JUnit</code> проверяем с помощью <code>result.contains()</code> содержит ли результирующая строка ожидаемые значения "field1 = Первый", "field2 = 3", "field3 = true"
        </li>
    </ul>
    </ul>

<h4>Тесты</h4>

<h3 id="задание27">Задание 2.7</h3>
<p><strong>Текст задачи:</strong><br></p>
<p>Создайте тест, используя фреймворк JUnit, проверяющий совместную работу аннотаций <code>@Cache</code> и <code>@Invoke</code> на одном классе.<br>
• Разработайте класс, содержащий аннотацию <code>@Cache({"users", "orders"})</code> и метод, помеченный <code>@Invoke</code>.<br>
• В тесте c помощью Reflection получите экземпляр аннотированного класса, убедитесь, что аннотация <code>@Cache</code> корректно возвращает массив строк <code>["users","orders"]</code>, автоматически вызовите метод с <code>@Invoke</code> и проверьте, что он действительно выполняется.<br>
• Добавьте проверку, что при пустом массиве <code>@Cache</code> кеширование не активируется (например, метод не добавляет данные в фиктивный кеш).<br>
• Для моделирования кеша можно использовать Mockito или простую коллекцию <code>Map&lt;String, Object&gt;</code>.</p>

<p><strong><code>testCahceInvoke</code></strong></p>
    <ul>
    <li>
    Создается класс <code>tCacheInvokeClass</code> c полем <code>private final Map(String, Object) cache</code> - являющийся кешем
    </li>
    <li>
        Реализуется коснтруктор и метод <code>cacheData</code> моделирующий кеширование с использованием метаданных своего класса, если у класса есть аннотация областями для кеширования, метод выполнит кеширование
    </li>
    <li>
      В классе <code>Tests</code> создается метод <code>testCahceInvoke</code> помеченный аннотацией <code>testToString</code> из фреймворка <code>JUnit</code>
    </li>
    <ul>
        <li>
            Метод создает имитацию словаря с помощью <code>Mockito.mock(Map.class)</code> -  <code>Map(String, Object) cache = Mockito.mock(Map.class)</code>
        </li>
        <li>
            Создается объект класса <code>tCacheInvokeClass</code> с параметром cache - моком, отслеживающий все взаимодействия с ним
        </li>
        <li>
            Если класс имеет аннотацию <code>Cache</code>, то если его список кешируемых областей не пустой, с помощью <code>assertArrayEquals</code> сравниваются массивы: new String[]{"users", "orders"} - ожидаемое, regions - резелтирующее
        </li>
        <li>
            Далее с помощью <code>invokeHandler(cachInv)</code> вызывается метод <code>cacheData()</code>, так как он помечен аннотацией <code>Invoke</code>
        </li>
        <li>
            С помощью метода <code>verify(cache)</code> проверяем применялись ли к <code>cache</code> методы <code>put</code> имитирующие кеширование в классе <code>tCacheInvokeClass</code>
        </li>
        <li>
            Если же класс аннотация класса имеет пустой список кеширующих областей, проверяется что этот список действительно пуст, а после вызова кеширования с моком не выполнялось никаких взаимодействий
        </li>
    </ul>
    </ul>

<h4>Тесты</h4>

<h2 id="структура-проекта">Структура проекта</h2>
<pre>
src
├── ru.fadeev
│   ├── Animal
│   │   ├── Interface
│   │   │   └── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Animal/Interface/Meowable.java">Meowable.java</a>
│   │   ├── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Animal/Cat.java">Cat.java</a>
│   │   ├── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Animal/ExtrMeow.java">ExtrMeow.java</a>
│   │   └── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Animal/MeowCount.java">MeowCount.java</a>
│   ├── Competition
│   │   ├── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Competition/AnalyzeFile.java">AnalyzeFile.java</a>
│   │   ├── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Competition/Participant.java">Participant.java</a>
│   │   └── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Competition/Score.txt">Score.txt</a>
│   ├── Lists
│   │   └── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Lists/MergeList.java">MergeList.java</a>
│   ├── Mathem
│   │   ├── Interfaces
│   │   │   └── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Mathem/Interfaces/FractionOnInterface.java">FractionOnInterface.java</a>
│   │   ├── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Mathem/CacheFraction.java">CacheFraction.java</a>
│   │   └── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Mathem/Fraction.java">Fraction.java</a>
│   ├── Queue
│   │   └── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Queue/QueueElem.java">QueueElem.java</a>
│   ├── Stream
│   │   ├── geometry
│   │   │   ├── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Stream/geometry/InputPoint.java">InputPoint.java</a>
│   │   │   ├── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Stream/geometry/Line.java">Line.java</a>
│   │   │   ├── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Stream/geometry/Point.java">Point.java</a>
│   │   │   └── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Stream/geometry/Polyline.java">Polyline.java</a>
│   │   ├── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Stream/people.txt">people.txt</a>
│   │   └── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Stream/Stream.java">Stream.java</a>
│   ├── Text
│   │   ├── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Text/CountLetter.java">CountLetter.java</a>
│   │   └── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Text/text.txt">text.txt</a>
│   └── UserPanel
│       ├── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/UserPanel/CheckInput.java">CheckInput.java</a>
│       └── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/UserPanel/UserPanel.java">UserPanel.java</a>
└── <a href="https://github.com/Fartem654/Lab5/blob/master/src/ru/fadeev/Main.java">Main.java</a>
</pre>

<h2 id="как-запустить">Как запустить</h2>
<ol>
 <li>Убедитесь, что установлен JDK.</li>
 <li>
   Скачайте архив с проектом.
 </li>
 <li>
   Откройте в консоли каталог "src".
 </li>
 <li>
   Введите в консоль:
   <pre>java master.java</pre>
 </li>
</ol>
