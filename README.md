# Серверная часть приложения «Стоматологическая клиника Santé et Dents»

## Описание проекта
Проект представляет собой серверную часть приложения **"стоматологическая клиника"**. Приложение было разработано в рамках курсового проекта 4-ого семестра в РТУ МИРЭА по дисциплине «Шаблоны программных платформ на языке Java».

## Содержание
- [Технологии разработки](#технологии-разработки)
- [Функционал](#функционал)
- [Требования к системе](#требования-к-системе)
- [Использование](#использование)
- [Настройки по умолчанию](#настройки-по-умолчанию)

## Технологии разработки
- `Java`
- `Spring Boot`
- `Spring Security`
- `Spring Data JPA`
- `JWT Authentication`
- `PostgreSQL Database v14.1`
- `Docker`
- ...

## Функционал
Операции, доступные пользователю с ролью **администратору**:
1. Просмотреть список услуг, сотрудников клиники и всех пользователей системы.
2. Добавить новую услугу, нового сотрудника или зарегистрировать нового пользователя.
3. Заблокировать пользователя системы.

Операции, доступные пользователю с ролью **врач-стоматолог**:
1. Посмотреть записанных на прием пациентов.
2. Оставить заключение о пациенте после проведенного приема.

Операции, доступные пользователю с ролью **пациент**:
1. Просмотреть или отредактировать данные профиля.
2. Посмотреть доступные талоны на запись к стоматологу.
3. Записаться на прием к стоматологу или отменить запись.
4. Посмотреть записи в медицинской карте пациента (проведенные приемы).

Операции, доступные всем пользователям (авторизованным/неавторизованным):
1. Просмотреть список доступных услуг стоматологической клиники.

## Требования к системе
Необходимо иметь установленный Docker Desktop на локальной машине, независимо от ОС (Windows, Linux, macOS).

Также, освободите порты 8081 (Backend) и 5432 (PostgreSQL).

## Использование
Для начала необходимо склонировать данный репозиторий на локальную машину командой `git clone https://github.com/Mareanexx/backend-dentistry-coursework.git`.

Затем перейти в корневую директорию проекта и ввести команду `docker-compose up --build`.

Серверная часть запустится по адресу http://localhost:8081

## Настройки по умолчанию
По умолчанию зарегистрирована учетная запись администратора:
- login: `admin`, password: `admin`

Зарегистрирована учетная запись врача-стоматолога:
- login: `doctor`, password: `doctor`

Зарегистрирована учетная запись пациента:
- login: `patient`, password: `patient`
