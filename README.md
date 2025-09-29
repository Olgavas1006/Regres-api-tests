
# Проект по автоматизации тестирования API для [Reqres](https://reqres.in/)
<p align="center">  
<a href="https://reqres.in/"><img title="Reqres" src="media/screens/reqres.png" width="950"/>  
</a></p>

> Reqres - сервис, предоставляющий публичный API для практики тестирования и разработки

## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">API-тесты</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure-testOps">Интеграция с Allure TestOps</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

____
<a id="tools"></a>
## **Технологии и инструменты:**

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="media/logo/intellij-idea.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="media/logo/java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="media/logo/github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="media/logo/junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="media/logo/gradle.svg" width="50" height="50"  alt="Gradle"/></a>   
<a href="https://rest-assured.io/"><img src="media/logo/rest-assured.png" width="50" height="50"  alt="REST-assured"/></a>  
<a href="https://github.com/allure-framework/allure2"><img src="media/logo/allure.svg" width="50" height="50"  alt="Allure"/></a>  
<a href="https://qameta.io/"><img src="media/logo/allure-testOps.svg" width="50" height="50"  alt="TestOps"/></a> 
<a href="https://www.jenkins.io/"><img src="media/logo/jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> 
<a href="https://telegram.org/"><img src="media/logo/telegram.svg" width="50" height="50"  alt="Telegram"/></a>
</p>

Автотесты разработаны на языке программирования `Java` с использованием библиотеки `REST-assured`. При проектировании тестов были применены модели с использованием библиотеки `lombok`.

В качестве фреймворка для запуска тестов используется `Junit5`, в качестве сборщика проекта - `Gradle`.

Произведена настройка CI системы `Jenkins`, по результатам каждого запуска автотестов создаётся `Allure` отчёт с использованием rest-assured listener с custom templates для лучшей читаемости.

Реализована интеграция с `Allure TestOps` – системой тест-менеджмента для управления процессом тестирования.

После выполнения автотестов `Telegram` бот присылает сообщение с информацией о результатах запуска.

----
## 🌐 API-тесты

### Основные проверки
- Создание пользователя
- Получение списка пользователей
- Удаления пользователя
- Получение данных пользователя
- Обновление данных пользователя
----

## Запуск тестов из терминала

### Удаленный запуск тестов

```bash
gradle clean test 
```

<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="media/logo/jenkins.svg" width="25"/> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/C34-Vicktalina-unit23-2/)
____
<p align="center">  
<img src="images/screenshot/jenkins_build.png" alt="Jenkins" width="950"/>
</p>
Для запуска сборки необходимо нажать кнопку <code><strong>*Собрать сейчас*</strong></code>.

<p align="center">
  <img src="src/test/resources/img/screenshots/Jenkins.png" alt="Jenkins" width="800">
</p>

После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки отобразятся
иконки *Allure Report* и *Allure TestOPS*, которые по клику открывают страницы соответствующих отчетов.

<p align="center">
  <img src="src/test/resources/img/screenshots/Jenkins2.png">
</p>

## <img width="4%" title="Allure Report" src="media/logo/allure.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/regresInAPI_tests/1/allure/#suites/2a99c9be34f1b0071cd237aacc339ae0/4c7db381de00c955/)

<p align="center">
  <img src="src/test/resources/img/screenshots/Allure.png" alt="allure-report1" width="900">
</p>


## <img width="4%" title="Allure TestOPS" src="media/logo/allure-testOps.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/19629)

### Основной дашборд

<p align="center">
  <img src="src/test/resources/img/screenshots/AllureTestOps.png" alt="dashboard" width="900">
</p>

### Список тестов с результатами прогона

<p align="center">
  <img src="src/test/resources/img/screenshots/AllureTest.png" alt="dashboard" width="900">
</p>

### Список тест-кейсов, сформированных в результате прогона

<p align="center">
  <img src="src/test/resources/img/screenshots/testCases.png" alt="dashboard" width="900">
</p>

## <img width="4%" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота
После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img title="Telegram Notifications" src="media/logo/telegram.png">


</p>