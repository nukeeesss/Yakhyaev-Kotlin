# Практическая работа 2 — Kotlin и Jetpack Compose

**Студент:** Яхяев Фирамил Фируддин Оглы  
**Группа:** ИКБО-61-24

Код заданий 1–10 приведён в соответствие с отчётом `Yakhyaev_Firamil_Report_Final (1)(1).pdf`.
Контактные телефоны и адреса в примерах условные, как на рисунках отчёта.

| № | Задание | Страницы отчёта | Файлы |
| --- | --- | --- | --- |
| 1 | «Привет, Фирамил!» и обработка null | 3 | [С именем](task-01/MainActivity.kt), [без имени](task-01/without-name/MainActivity.kt) |
| 2 | Портретный, альбомный и круглый Preview | 4 | [MainActivity.kt](task-02/MainActivity.kt) |
| 3 | Три варианта оформления текста | 5 | [MainActivity.kt](task-03/MainActivity.kt), [strings.xml](task-03/res/values/strings.xml) |
| 4 | Кнопка с границей и скруглением | 6 | [MainActivity.kt](task-04/MainActivity.kt) |
| 5 | Синий круг с инициалами ЯФФ | 6 | [MainActivity.kt](task-05/MainActivity.kt) |
| 6 | Круг и растянутый фиолетовый эллипс | 7 | [MainActivity.kt](task-06/MainActivity.kt), [circle.xml](task-06/res/drawable/circle.xml) |
| 7 | Контакты в Column, список, Row с треугольником | 8–9 | [Column](task-07/column/MainActivity.kt), [список](task-07/list/MainActivity.kt), [Row](task-07/row/MainActivity.kt), [triangle.xml](task-07/row/res/drawable/triangle.xml) |
| 8 | Трекер воды | 10–11 | [MainActivity.kt](task-08/MainActivity.kt) |
| 9 | Четыре UI-теста трекера | 12 | [MainActivity.kt](task-09/MainActivity.kt), [тесты](task-09/androidTest/ExampleInstrumentedTest.kt), [пример Gradle](task-09/app/build.gradle.kts) |
| 10 | Корзина: добавление, удаление, сумма и доставка | 13–15 | [MainActivity.kt](task-10/MainActivity.kt) |

## Как запускать в Android Studio

Это набор отдельных файлов для существующего проекта **KotlinPractice**, а не самостоятельный Gradle-проект. Все варианты используют пакет `com.example.kotlinpractice` и тему `KotlinPracticeTheme`.

1. Открой проект KotlinPractice с Jetpack Compose.
2. Скопируй **один** выбранный `MainActivity.kt` в `app/src/main/java/com/example/kotlinpractice/`, заменив текущий файл. Варианты нельзя складывать вместе: в них повторяются классы и функции.
3. Для задания 3 добавь строку `compose_description` из приложенного `strings.xml` в `app/src/main/res/values/strings.xml`.
4. Для задания 6 скопируй `circle.xml` в `app/src/main/res/drawable/`.
5. Для задания 7 с Row скопируй `triangle.xml` в `app/src/main/res/drawable/`.
6. Для задания 9 используй его `MainActivity.kt`, а `ExampleInstrumentedTest.kt` положи в `app/src/androidTest/java/com/example/kotlinpractice/`. Приложенный `app/build.gradle.kts` — пример из исходного проекта с каталогом `libs`; он требует соответствующих алиасов в `gradle/libs.versions.toml`. Перенеси тестовые зависимости в свой проект с учётом его настроек. Запускай тесты на устройстве или эмуляторе.

## Поведение по отчёту

- Трекер начинает со 100 мл. Шесть нажатий «+250 мл» дают 1600 мл. При завершении дня норма 1500 мл увеличивает серию; при меньшем объёме серия сбрасывается. Объём после завершения дня равен нулю.
- Корзина начинает с цен 100, 150 и 56 рублей, всего 306 рублей. Сумма вычисляется через `sumOf`, последний товар удаляется через `dropLast(1)`. После добавления при сумме больше 500 рублей появляется «Доставка бесплатная!».
- Добавляемые цены случайные. Суммы 548 и 492 рубля на скриншотах относятся к одному запуску; в другом запуске они могут отличаться.

## Проверка этой версии

Проверены соответствие данных отчёту, XML-ресурсы и ссылки на ресурсы. Android SDK и эмулятора в среде подготовки нет, поэтому сборка приложения и четыре UI-теста здесь не запускались. Скриншот «4 passed» в отчёте относится к ранее выполненному запуску.

[ВСЕ_КОДЫ.txt](ВСЕ_КОДЫ.txt) содержит те же файлы для копирования.
