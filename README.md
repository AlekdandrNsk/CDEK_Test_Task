[![Codacy Badge](https://api.codacy.com/project/badge/Grade/42d8de1b028b4a00bca36e27df5049d7)](https://www.codacy.com/app/AlekdandrNsk/CDEK_Test_Task?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=AlekdandrNsk/CDEK_Test_Task&amp;utm_campaign=Badge_Grade)

БД создается и заполняется при запуске программы

параметры доступа к БД описаны в 

\src\main\resources\db\mysql.properties:

database.url=jdbc:mysql://localhost:3306/test

database.username=root

database.password=root





Задание:
Написать программу, в которой будет две функции: добавить в БД строку и
вывести все строки на экран. БД - одна таблица с двумя колонками: id и
name. Соответственно будет два графических интерфейса:
- Интерфейс добавления строки: поле ввода имени и кнопка Добавить.
- Интерфейс вывода строк на экран - таблица с двумя колонкам: Ид и Имя. Над таблицей
должен присутствовать фильтр для поиска в таблице.
В качестве БД использовать MySQL.
В качестве фреймворков - желательно (но не обязательно) spring. Для доступа
к БД - jdbc (spring-jdbc).
По графическим интерфейсам: желательно, чтобы интерфейсы были сделаны с
испоьзованием паттерна MVC (spring-mvc приветствуется).