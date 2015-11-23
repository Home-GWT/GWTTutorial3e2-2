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



Хорошим тоном программирования является использование класса-фабрики который в последствии возвращает будет возвращать актуальную версию реализации классов...
> 'ClientFactoryImpl'

...для автоматической генерации реализации интерфейса при вызове метода 'GWT.create(Class)'


===================================================================================================================================================
** (Введение в MVP GWT 2.1) http://habrahabr.ru/post/113121/
** (Блог татарина-программиста ** [GWT] Activities And Places (Вольный перевод)) http://gshmalik.blogspot.com/2014/11/gwt-activities-and-places.html
** (Блог татарина-программиста ** [GWT] Building MVP apps: MVP Part I (Вольный перевод)) http://gshmalik.blogspot.com/2015/06/building-mvp-apps-mvp-part-i.html
** (Блог татарина-программиста ** [GWT] Building MVP apps: MVP Part II (Вольный перевод)) http://gshmalik.blogspot.com/2015/08/gwt-building-mvp-apps-mvp-part-ii.html

*  (GWT + mvp4g: лэйауты, порталы, портлеты) http://shamansir.github.io/gwt-mvp4g-layouting-demo/index-ru.html
   (Тестирование GWT приложений архитектуры MVP) http://habrahabr.ru/post/246285/
   http://kgiu.kz/wp-content/plugins/spoilers/import/?http%3A%2F%2Fkgiu.kz%2Fwp-content%2Fplugins%2Ffeedgrubber%2Fimport%2Ffrozen%3Fhttp%3A%2F%2Fhabrahabr.ru%2Frss%2Fblogs%2Fgwt%2F
*  (GWT Development with Activities and Places) http://webcentersuite.blogspot.com/2011/08/gwt-development-with-activities-and.html
*  (Managing GWT History and Hyperlinks Tutorial) http://developerlife.com/tutorials/?p=232

(Java Web Application Developer) https://moikrug.ru/vacancies/933440495

---------------------------------------------------------------------------------------------------------------------------------------------------
* `[GWT] Activities And Places (Вольный перевод)`: [gshmalik.blogspot.com/2014/11/gwt-activities-and-places](http://gshmalik.blogspot.com/2014/11/gwt-activities-and-places.html)
>1) GWT 2.1 представила встроенный framework для управления историей в браузере.
>   Activities and Places framework позволяет вам создавать URL с метками в вашем приложении, тем самым позволяя кнопке «назад» и закладкам в браузере работать так, как от них ожидают пользователи. 
>
>2) GWT 2.1 ввел интерфейс IsWidget, который реализуют большинство Widget’ов так же, как Composite.
>
>3) Для того чтобы быть доступным через URL, Activity нужен соответствующий Place.
>   Place должен иметь связанный PlaceTokenizer, который знает как сериализовать состояние Place в маркер URL...
>

* `Введение в MVP GWT 2.1`: [habrahabr.ru/post/113121](http://habrahabr.ru/post/113121/)
>0) В MVP принято “обмениваться” между презентером и видом только интерфейсами.
>   Поэтому для каждого вида в приложении есть соответствующий интерфейс.
>
>1) Логика страниц (видов) или Activity.
>   При кликах на этих ссылка выполняется переключение между видами...
>
>2.1) Как это работает:
>     ActivityManager следит за всеми Activities, которые функционируют в контексте одного контейнер-виджета. Он отлавливает событие PlaceChangeRequestEvent и сообщает текущему Activity о смене Place.
>     ActivityManager при получении события изменения URL от PlaceHistoryManager создает с помощью ActivityMapper-а нужный инстанс Activity и запускает ее на выполнение с помощью метода start().
>     Помимо ActivityManager, есть два других GWT класса так же работающих с Place:
>     1. PlaceController отвечает за смену Place, а так же уведомление пользователя, прежде чем это (сменить Place) сделать.
>     2. PlaceHistoryHandler позволяет определять Place по URL и наоборот.
>   .. Всякий раз, когда приложение переходит в новый Place, обновляется URL с новыми токенами хранящимися в этом Place, так появляется возможность делать закладки, а так же пользоваться механизмом истории в браузере. (Таким же образом, когда пользователь нажмет кнопку «назад» или же перейдет на закладку, PlaceHistoryHandler позволит загрузиться вашему приложению c соответствующим Place.)
>
>2.2) Как перемещаться:
>     Для перехода на новый Place можно использовать метод goTo() экземпляра PlaceController...
>     PlaceController оповещает текущее Activity о том, что оно может быть остановлено (через событие PlaceChangeRequestEvent).
>     Если остановка Activity разрешается, то выстреливается событие PlaceChangeEvent/ValueChangeEvent с информацией о новой Place.
>     PlaceHistoryHandler ловит событие PlaceChangeEvents и обновляет историю токенов URL.
>     ActivityManager так же слушает события PlaceChangeEvent. При помощи ActivityMapper он определяет Activity советующий Place’у. (Затем ActivityManager запускает это Activity)
>     Когда пользователь переходит в новый URL (через гиперссылку, кнопку «назад» или закладку), PlaceHistoryHandler ловит событие ValueChangeEvent с объекта History и вызывает PlaceHistoryMapper для преобразования токена истории в соответствующий Place. Затем вызывается PlaceController.goTo() с новым Place.
>
>3) Place или хеш-URL’ы и их обработка:
>   объект Place отвечает за текущее состояние UI.
>   Состояние передается с помощью URL посредством history-токенов. По сути в этом объекте можно хранить параметры, которые передаются с хэш-URL’ой. Состояние URL кодируется/декодируется с помощью объекта Tokenizer’а.
>
>4) Определение нужной Activity и регистрация обработчиков:
>   При поступлении новой URL и успешной инстанциации объекта Place менеджер ActivityManager с помощью ActivityMapper’а принимает решение о том, какой объект презентера нужно запустить.
>
>5) Регистрация обработчиков хэш-URL’ов, т.е. токенайзеров выполняется в интерфейсе PlaceHistoryMapper.
>   Все что нужно на данном этапе это просто перечислить в аннотации @WithTokenizers классы токенайзеров приложения.
>


Чтобы встроенный MVP-фреймворк заработал нужно подключить соответствующие GWT-модули в файле описания GWT-модуля (gwt.xml-файл)
открыть ту или иную подсистему можно просто набрав в адресной строке браузера корректную URL. Автоматически будет запущен процесс преобразования состояния из URL в соответствующий place с запуском соответствующей activity, которая и отобразит нужный нам вид.


Весь код по инициализации и запуску механизма MVP-фреймворка собран в onModuleLoad()-методе EntryPoint’а

---------------------------------------------------------------------------------------------------------------------------------------------------
* `[GWT] Activities And Places (Вольный перевод)`: [gshmalik.blogspot.com/2014/11/gwt-activities-and-places](http://gshmalik.blogspot.com/2014/11/gwt-activities-and-places.html)
* `Введение в MVP GWT 2.1`: [habrahabr.ru/post/113121](http://habrahabr.ru/post/113121/)
>
>     GWT 2.1 ввел интерфейс IsWidget, который реализуют большинство Widget’ов так же, как Composite.
>
>     Place должен иметь связанный PlaceTokenizer, который знает как сериализовать состояние Place в маркер URL...
>     Когда пользователь переходит в новый URL (через гиперссылку, кнопку «назад» или закладку), PlaceHistoryHandler ловит событие ValueChangeEvent с объекта History и вызывает PlaceHistoryMapper для преобразования токена истории в соответствующий Place.
>>    2. PlaceHistoryHandler позволяет определять Place по URL и наоборот.
>     Затем вызывается PlaceController.goTo() с новым Place.
>>    1. PlaceController отвечает за смену Place, а так же уведомление пользователя, прежде чем это (сменить Place) сделать.
>
>     ActivityManager при получении события изменения URL от PlaceHistoryMapper создает с помощью ActivityMapper-а нужный инстанс Activity и запускает ее на выполнение с помощью метода start().
>   .. Всякий раз, когда приложение переходит в новый Place, обновляется URL с новыми токенами хранящимися в этом Place, так появляется возможность делать закладки, а так же пользоваться механизмом истории в браузере. (Таким же образом, когда пользователь нажмет кнопку «назад» или же перейдет на закладку, PlaceHistoryHandler позволит загрузиться вашему приложению c соответствующим Place.)
>
>     ActivityManager так же слушает события PlaceChangeEvent. При помощи ActivityMapper он определяет Activity советующий Place’у. (Затем ActivityManager запускает это Activity)
>     Логика страниц (видов) или Activity. При кликах на этих ссылка выполняется переключение между видами...
>
>     объект Place отвечает за текущее состояние UI.
>     Состояние передается с помощью URL посредством history-токенов. По сути в этом объекте можно хранить параметры, которые передаются с хэш-URL’ой. Состояние URL кодируется/декодируется с помощью объекта Tokenizer’а.
>
>     Для перехода на новый Place можно использовать метод goTo() экземпляра PlaceController...
>     PlaceController оповещает текущее Activity о том, что оно может быть остановлено (через событие PlaceChangeRequestEvent).
>     Если остановка Activity разрешается, то выстреливается событие PlaceChangeEvent/ValueChangeEvent с информацией о новой Place.
>     PlaceHistoryHandler ловит событие PlaceChangeEvents и обновляет историю токенов URL.
>     ActivityManager так же слушает события PlaceChangeEvent. При помощи ActivityMapper он определяет Activity советующий Place’у. (Затем ActivityManager запускает это Activity)














