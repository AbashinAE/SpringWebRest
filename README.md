Урок 3. Использование Spring для разработки серверного приложения

Задание: Используя Spring, создайте серверное REST приложение. Добавить функционал в приложение разработанное на семинаре:

=============================== Проверка работы ====================================

Для теcтирования проекта использовать программу PostMan:
a) Добавление пользователя - запрос :
метод - POST
адрес - http://localhost:8080/users/body
тело -
{
"name":"Artur",
"age":23,
"email":"exam1@yandex.ru"
}
b) Получение списка пользователей на сервере - запрос:
метод - GET
адрес - http://localhost:8080/users
c) Проверка сортировки - запрос:
метод - GET
адрес - http://localhost:8080/tasks/sort
d) Проверка фильтрации - запрос:
метод - GET
адрес - http://localhost:8080/tasks/filter/23
e) Проверка среднего арифметического - запрос:
метод - GET
адрес - http://localhost:8080/tasks/calc
================================_________=====================================

Базовое задание
1) В класс RegistrationService добавить поля UserService, NotificationService(добавить в IOC контейнер аннотацией @Autowired или через конструктор класса)
2) Разработать метод processRegistration в котором:
- создается пользователь из параметров метода
- созданный пользователь добавляется в репозиторий
- через notificationService выводится сообщение в консоль
3) В TaskController добавить обработчики filterUsersByAge()(Подсказка @GetMapping("/filter/{age}")) и calculateAverageAge (Подсказка @GetMapping("/calc"))
4) В методе filterUsersByAge параметр age получать через аннотацию @PathVariable

Задание со звездочкой
1) В классе UserController добавить обработчик userAddFromParam извлекающий данные для создания пользователя из параметров HTTP запроса
2) Перенести репозиторий проекта с List<User> на базу данных H2
