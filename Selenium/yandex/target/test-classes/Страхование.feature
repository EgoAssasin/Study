#language: ru

  Функционал: Товар в маркете

    Сценарий: Выбор товара 1
      Когда выбран пункт меню "Маркет"
      Когда выбран раздел - "Электроника"
      Тогда выбран подраздел - "Телевизоры"
      Когда заполняются поля:
        |Цена от:|20000|
        |Производитель 1|LG|
        |Производитель 2|Samsung|
      Когда нажата кнопка - Применить
      Тогда количество элементов на странице равно - "12"
      Когда заполнена строка поиска
      Когда нажата кнопка - Найти
      Тогда наименование товара соответствует запомненному значению


    Сценарий: Выбор товара 2
      Когда выбран пункт меню "Маркет"
      Когда выбран раздел - "Электроника"
      Тогда выбран подраздел - "Наушники"
      Когда заполняются поля:
        |Цена от:|5000|
        |Производитель 1|Beats|
      Когда нажата кнопка - Применить
      Тогда количество элементов на странице равно - "12"
      Когда заполнена строка поиска
      Когда нажата кнопка - Найти
      Тогда наименование товара соответствует запомненному значению


      




