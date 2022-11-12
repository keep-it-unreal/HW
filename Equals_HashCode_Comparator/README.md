# Equals, HashCode, Comparators

1. Класс CustomDigitComparator реализует интерфейс Comparator<Integer>.

Класс CustomDigitComparator определяет следующий порядок: 
 
* Сначала четные числа, затем нечетные 
* На вход подаются числа, отличные от null

2. Класс Person реализует интерфейс Comparable<Person>, который обеспечивает следующий порядок: 

* Сортировка сначала по полю city, а затем по полю name
* Поля name, city отличны от null

3. Класс DigitHandler(int value).
Данный класс представляет собой обертку над числом value

* Реализованы equals & hashCode

4. Класс Person{name, city, age}:

* Реализованы equals & hashCode
* Гарантируется, что значения name, city не null
* Условие равенства: все поля name, city, age должны совпадать. (name и city без учета регистра)

5. Публичные методы покрыты unit тестами, в том числе на альтернативные сценарии
