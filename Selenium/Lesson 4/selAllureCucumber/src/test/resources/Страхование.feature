#language: ru

  Функционал: Страхование

    Сценарий: Заявка на страховку путешественников

      Когда выбран пункт меню "Раздел Застраховать себя  и имущество"
      Тогда выбран вид страхования "Страхование путешественников"
      Когда заголовок открывшейся страницы равен - "Страхование путешественников"
      Тогда нажата кнопка - Оформить онлайн
      Когда переключились в новое окно
      Тогда выбрана сумма страхования "Минимальная"
      Когда заполняются поля:
        |ФамилияСтрахуемого|Romanov|
        |ИмяСтрахуемого|Petr|
        |ДатаРожденияСтрахуемого|09.05.1965|
        |Фамилия|Романов|
        |Имя|Игорь|
        |Отчество|Петрович|
        |ДатаРождения|01.08.1985|
        |ПаспортСерия|9300|
        |ПаспортНомер|635987|
        |ПаспортДатаВыдачи|10.11.2005|
        |ПаспортГдеВыдан|Город N|
      Тогда проверяются поля, что заполненны следующими значениями:
        |ФамилияСтрахуемого|Romanov|
        |ИмяСтрахуемого|Petr|
        |ДатаРожденияСтрахуемого|09.05.1965|
        |Фамилия|Романов|
        |Имя|Игорь|
        |Отчество|Петрович|
        |ДатаРождения|01.08.1985|
        |ПаспортСерия|9300|
        |ПаспортНомер|635987|
        |ПаспортДатаВыдачи|10.11.2005|
        |ПаспортГдеВыдан|Город N|
      Когда нажата кнопка - Продолжить
      Тогда ошибка сообщения равна - "Заполнены не все обязательные поля"



      




