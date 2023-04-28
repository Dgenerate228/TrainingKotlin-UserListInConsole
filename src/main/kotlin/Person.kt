import kotlin.random.Random

object Person {

    //Имя
    private var firstName = mutableListOf(
        "Иван", "Сергей", "Алексей", "Антон", "Петр",
        "Семен", "Михаил", "Павел", "Григорий", "Лев",
        "Андрей", "Роман", "Арсений", "Степан", "Владислав",
        "Давид", "Ярослав", "Евгений", "Матвей", "Фёдор",
        "Марк", "Никита", "Роман", "Николай", "Артемий",
        "Виктор", "Даниил", "Денис", "Глеб", "Тимофей",
        "Егор", "Игорь", "Леонид", "Руслан"
    )

    //Отчество
    private var middleName = mutableListOf(
        "Иванович",
        "Сергеевич",
        "Алексеевич",
        "Антонович",
        "Петрович",
        "Семёнович",
        "Михайлович",
        "Евгеньевич",
        "Григорьевич",
        "Львович",
        "Андреевич",
        "Романович",
        "Арсеньевич",
        "Степанович",
        "Владиславович",
        "Никитович",
        "Глебович",
        "Маркович",
        "Давидович",
        "Ярославович",
        "Матвеевич",
        "Фёдорович",
        "Николаевич",
        "Андреевич",
        "Тимофеевич",
        "Артемий",
        "Викторович",
        "Леонидович",
        "Даниилович",
        "Денисович",
        "Егорович",
        "Игоревич",
        "Павлович",
        "Романович",
        "Русланович"
    )

    //Фамилия
    private var lastName = mutableListOf(
        "Иванов", "Сергеев", "Алексеев", "Антонов", "Арсеньев",
        "Петров", "Семенов", "Михайлов", "Евгеньев", "Степанов",
        "Григорьев", "Львов", "Андреев", "Романов", "Владиславов",
        "Давидов", "Ярославов", "Матвеев", "Фёдоров", "Марков",
        "Никитов", "Николаев", "Артемьев", "Викторов", "Данилов",
        "Денисов", "Глебов", "Тимофеев", "Егоров", "Игорев",
        "Леонидов", "Павлов", "Романов", "Русланов"
    )

    //День рождения. С ним разберусь попозже, пока сделаю обычный список
    private var birthday = mutableListOf(
        "12.10.1997", "1.5.1975", "13.1.1990", "23.3.2000", "14.8.1989", "7.7.1999", "20.12.1980", "30.11.1992"
    )

    //Хобби
    private var hobby = mutableListOf(
        "Гольф",
        "Настольные игры",
        "Бег",
        "Коллекционирование",
        "Туризм",
        "Гимнастика",
        "Книги",
        "Футбол",
        "Баскетбол",
        "Рыбалка",
        "Бокс",
        "Фото",
        "Рисование",
        "Фильмы"
    )


    private var persons = mutableListOf(PersonModel("", "", ""))



    fun createList() {

        val amountPersons: Int = (5..5).random()

        for (id in 1..amountPersons) {

            val lastName = lastName[Random.nextInt(lastName.size)]
            val firstName = firstName[Random.nextInt(firstName.size)]
            val middleName = middleName[Random.nextInt(middleName.size)]
            val hobby = hobby[Random.nextInt(hobby.size)]
            val birthday = birthday[Random.nextInt(birthday.size)]

            val person = PersonModel(
                lastName = lastName, firstName = firstName, middleName = middleName, hobby = hobby, birthday = birthday
            )

            persons.add(person)

        }

        printPersons()
    }

    private fun printPersons() {
        persons.forEach { println(it.lastName + " " + it.firstName.take(1) + ". " + it.middleName.take(1) + ".") }
    }

    fun addPerson() {

        val id = persons.size

        println(Strings.ENTER_LASTNAME.value)
        val inputLastName = readLine() ?: ""
        println(Strings.ENTER_FIRSTNAME.value)
        val inputFirstName = readLine() ?: ""
        println(Strings.ENTER_MIDDLE_NAME.value)
        val inputMiddleName = readLine() ?: ""
        println(Strings.ENTER_HOBBY.value)
        val hobby = readLine() ?: ""
        println(Strings.ENTER_BIRTHDAY.value)
        val birthday = readLine() ?: ""

        val person = PersonModel(
            lastName = inputLastName,
            firstName = inputFirstName,
            middleName = inputMiddleName,
            hobby = hobby,
            birthday = birthday
        )

        persons.add(person)
        println(Strings.PERSON_ADD.value)
        printPersons()

    }

    fun deletePerson() {
        println(Strings.ENTER_NUMBER.value)
        val input = readLine()?.toInt() ?: 1
        persons.removeAt(input)
        println(Strings.PERSON_DELETE.value)
        printPersons()
    }

    fun detailPerson() {
        println(Strings.ENTER_NUMBER.value)
        val inputInt = readLine()!!.toInt()

        persons.forEach {
            if (persons[inputInt] == it)
                println(
                    it.lastName + " " + it.firstName + " " + it.middleName
                            + ". Хобби: " + it.hobby + ". ДР: " + it.birthday
                )
        }
    }

    private fun changeALastName() {

        println(Strings.ENTER_NUMBER.value)
        val inputInt = readLine()!!.toInt()

        println(Strings.ENTER_LASTNAME.value)
        val input = readLine()!!

        val personsOld = persons[inputInt]
        val personsNew = personsOld.copy(lastName = input)

        persons[inputInt] = personsNew

        println(
            "Был: " + personsOld.lastName + " " + personsOld.firstName + " " + personsOld.middleName
                    + ". Хобби: " + personsOld.hobby + ". ДР: " + personsOld.birthday
        )

        println(
            "Стал: " + personsNew.lastName + " " + personsNew.firstName + " " + personsNew.middleName
                    + ". Хобби: " + personsNew.hobby + ". ДР: " + personsNew.birthday
        )

        println()
        printPersons()
    }

    private fun changeAFirstName() {
        println(Strings.ENTER_NUMBER.value)
        val inputInt = readLine()!!.toInt()

        println(Strings.ENTER_FIRSTNAME.value)
        val input = readLine()!!

        val personsOld = persons[inputInt]
        val personsNew = personsOld.copy(firstName = input)

        persons[inputInt] = personsNew

        println(
            "Был: " + personsOld.lastName + " " + personsOld.firstName + " " + personsOld.middleName
                    + ". Хобби: " + personsOld.hobby + ". ДР: " + personsOld.birthday
        )

        println(
            "Стал: " + personsNew.lastName + " " + personsNew.firstName + " " + personsNew.middleName
                    + ". Хобби: " + personsNew.hobby + ". ДР: " + personsNew.birthday
        )

        println()
        printPersons()
    }

    private fun changeAMiddleName() {
        println(Strings.ENTER_NUMBER.value)
        val inputInt = readLine()!!.toInt()

        println(Strings.ENTER_MIDDLE_NAME.value)
        val input = readLine()!!

        val personsOld = persons[inputInt]
        val personsNew = personsOld.copy(middleName = input)

        persons[inputInt] = personsNew

        println(
            "Был: " + personsOld.lastName + " " + personsOld.firstName + " " + personsOld.middleName
                    + ". Хобби: " + personsOld.hobby + ". ДР: " + personsOld.birthday
        )

        println(
            "Стал: " + personsNew.lastName + " " + personsNew.firstName + " " + personsNew.middleName
                    + ". Хобби: " + personsNew.hobby + ". ДР: " + personsNew.birthday
        )

        println()
        printPersons()
    }

    private fun changeAHobby() {
        println(Strings.ENTER_NUMBER.value)
        val inputInt = readLine()!!.toInt()

        println(Strings.ENTER_HOBBY.value)
        val input = readLine()!!

        val personsOld = persons[inputInt]
        val personsNew = personsOld.copy(hobby = input)

        persons[inputInt] = personsNew

        println(
            "Был: " + personsOld.lastName + " " + personsOld.firstName + " " + personsOld.middleName
                    + ". Хобби: " + personsOld.hobby + ". ДР: " + personsOld.birthday
        )

        println(
            "Стал: " + personsNew.lastName + " " + personsNew.firstName + " " + personsNew.middleName
                    + ". Хобби: " + personsNew.hobby + ". ДР: " + personsNew.birthday
        )

        println()
        printPersons()
    }

    private fun changeABirthday() {
        println(Strings.ENTER_NUMBER.value)
        val inputInt = readLine()!!.toInt()

        println(Strings.ENTER_BIRTHDAY.value)
        val input = readLine()!!

        val personsOld = persons[inputInt]
        val personsNew = personsOld.copy(birthday = input)

        persons[inputInt] = personsNew

        println(
            "Был: " + personsOld.lastName + " " + personsOld.firstName + " " + personsOld.middleName
                    + ". Хобби: " + personsOld.hobby + ". ДР: " + personsOld.birthday
        )

        println(
            "Стал: " + personsNew.lastName + " " + personsNew.firstName + " " + personsNew.middleName
                    + ". Хобби: " + personsNew.hobby + ". ДР: " + personsNew.birthday
        )

        println()

        printPersons()
    }

    fun changePerson() {

        println(Strings.WHAT_CHANGE.value)

        when (readLine()) {
            Strings.LASTNAME.value -> {
                changeALastName()
            }

            Strings.FIRSTNAME.value -> {
                changeAFirstName()
            }

            Strings.MIDDLENAME.value -> {
                changeAMiddleName()
            }

            Strings.HOBBY.value -> {
                changeAHobby()
            }

            Strings.BIRTHDAY.value -> {
                changeABirthday()
            }
        }

    }
}




