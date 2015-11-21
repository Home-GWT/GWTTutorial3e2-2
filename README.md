* `Введение в MVP GWT 2.1`: [habrahabr.ru/post/113121](http://habrahabr.ru/post/113121/) **(** [mvpinaction](http://code.google.com/p/mvpinaction/source/browse/) **)** >> [127.0.0.1:8888/index.html](http://127.0.0.1:8888/index.html)
* `Model-View-Presenter`: **[MVP](https://ru.wikipedia.org/wiki/Model-View-Presenter)** шаблон проектирования, производный от **[MVC](https://ru.wikipedia.org/wiki/Model-View-Controller)**, который используется в основном для построения пользовательского интерфейса


> "Виджет" обладает такими функциональными качествами как:
- отображение данных;
- обмен данными (получить/отправить);
- реагирование на действие пользователя (...);


> "Страница" обладает такими функциональными качествами как:
- привязка к URL-адрессу;
- передача/хождение по HTTP-протоколу...;
- хранение пользовательского состояния на странице...;


> "Контролер" обладает такими функциональными качествами как:
- (работает только с фронтальными клиентскими запросами...)
- получает информацию о клиентском запросе...;
- переключается между страницами ... организовывает навигацию по страницам - постраничный переход;
= его основная задача это централизированное управление компонентами (моделью и видом + привязка страниц к URL)...


> "Страница" связывается с "Виджетом" с помощью "Active"-объекта/класса (который передает данные...);