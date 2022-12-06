// Пали нейминги а то трахнут
import kotlin.random.Random

object Person {

    //Имя
    private var firstName = mutableListOf(
        "Иван", "Сергей", "Алексей", "Антон", "Петр",
        "Семен", "Михаил", "Павел", "Григорий", "Лев",
        "Андрей", "Роман", "Арсений", "Степан", "Владислав",
        "Давид", "Ярослав", "Евгений", "Матвей", "Фёдор",
        "Марк", "Никита", "Роман", "Николай", "Артемий",
        "Виктор", "Даниил", "Денис", "Глеб", "Евгений",
        "Тимофей", "Егор", "Игорь", "Леонид", "Руслан"
    )

    //Отчество
    private var middleName = mutableListOf(
        "Иванович", "Сергеевич", "Алексеевич", "Антонович", "Петрович",
        "Семёнович", "Михайлович", "Евгеньевич", "Григорьевич", "Львович",
        "Андреевич", "Романович", "Арсеньевич", "Степанович", "Владиславович",
        "Никитович", "Глебович", "Маркович", "Давидович", "Ярославович",
        "Матвеевич", "Фёдорович", "Николаевич", "Андреевич", "Тимофеевич",
        "Артемий", "Викторович", "Леонидович", "Даниилович", "Денисович",
        "Егорович", "Игоревич", "Павлович", "Романович", "Русланович"
    )

    //Фамилия
    private var lastName = mutableListOf(
        "Иванов", "Сергеев", "Алексеев", "Антонов", "Арсеньев",
        "Петров", "Семенов", "Михайлов", "Евгеньев", "Степанов",
        "Григорьев", "Львов", "Андреев", "Романов", "Владиславов",
        "Давидов", "Ярославов", "Евгеньев", "Матвеев", "Фёдоров",
        "Марков", "Никитов", "Николаев", "Артемьев", "Викторов",
        "Данилов", "Денисов", "Глебов", "Тимофеев", "Егоров",
        "Игорев", "Леонидов", "Павлов", "Романов", "Русланов"
    )

    //День рождения. С ним разберусь попозже, пока сделаю обычный список
    private var birthday = mutableListOf(
        "12.10.1997", "1.5.1975", "13.1.1990", "23.3.2000",
        "14.8.1989", "7.7.1999", "20.12.1980", "30.11.1992"
    )

    //Хобби
    private var hobby = mutableListOf(
        "Гольф", "Настольные игры", "Бег", "Коллекционирование",
        "Туризм", "Гимнастика", "Книги", "Футбол", "Баскетбол",
        "Рыбалка", "Бокс", "Фото", "Рисование", "Фильмы"
    )

    var person = PersonModel(
        lastName = String(),
        firstName = String(),
        middleName = String(),
        hobby = String(),
        birthday = String()
    )

    var personsList: MutableList<String> =
        mutableListOf("${person.lastName} ${person.firstName.take(1)} ${person.middleName.take(1)}")


    fun createList() {

        val amountPersons: Int = (5..5).random()

        for (id in 1..amountPersons) {

            val lastName = lastName[Random.nextInt(lastName.size)]
            val firstName = firstName[Random.nextInt(firstName.size)]
            val middleName = middleName[Random.nextInt(middleName.size)]
            val hobby = hobby[Random.nextInt(hobby.size)]
            val birthday = birthday[Random.nextInt(birthday.size)]

            val person = PersonModel(
                lastName = lastName,
                firstName = firstName,
                middleName = middleName,
                hobby = hobby,
                birthday = birthday
            )

            personsList.add(
                " ${person.lastName} ${person.firstName.take(1)} ${person.middleName.take(1)}"
            )
        }
        personsList.forEach { println(it) }

    }


    //Работает
    fun addPerson() {

        val id = personsList.size

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

        personsList.add("[$id] ${person.lastName} ${person.firstName.take(1)}. ${person.middleName.take(1)}.")
        println(Strings.PERSON_ADD.value)
        personsList.forEach { println(it) }


    }

    //Проблема с айдишниками
    fun deletePerson() {
        println(Strings.ENTER_NUMBER.value)
        val input = readLine()?.toInt() ?: 1
        personsList.removeAt(input)
        println(Strings.PERSON_DELETE.value)
        personsList.forEach { println(it) }
    }

    fun detailPerson() {
        println(Strings.ENTER_NUMBER.value)
        val inputInt = readLine()!!.toInt()
        (lastName[inputInt])
        val person = PersonModel(
            lastName = personsList[inputInt],
            firstName = firstName[inputInt],
            middleName = middleName[inputInt],
            hobby = hobby[inputInt],
            birthday = birthday[inputInt]
        )

        println(person)
//        val nameDetail: PersonModel = Person.personsList(lastName) + " " + fNameList[inputInt] + " " + mNameList[inputInt]
//        val otherDetail = Strings.HOBBY.value + ": " + hNameList[inputInt] + ".\n" +
//                Strings.BIRTHDAY.value + bNameList[inputInt]

//        println(nameDetail)
//        println(otherDetail)
    }

    fun changeAPersonBirthday() {
        println(Strings.ENTER_NUMBER.value)
        val inputInt = readLine()!!.toInt()
        println(Strings.ENTER_BIRTHDAY.value)
        birthday = readLine()

        val person = PersonModel(
            lastName = Person.(lastName[inputInt]),
            firstName = firstName[inputInt],
            middleName = middleName[inputInt],
            hobby = hobby[inputInt],
            birthday = birthday[inputInt]
        )
        println(person)


    }

    fun changePerson() {
//
//        println(Strings.ENTER_NUMBER.value)
//        val inputInt = readLine()!!.toInt()
//        println(Strings.WHAT_CHANGE.value)
//
//        when (readLine()) {
//            Strings.LASTNAME.value -> {
//                println(Strings.ENTER_LASTNAME.value)
//                val input = readLine()!!.toString()
//                println(personsList[inputInt])
//                val id = inputInt
//                val lastName = input
//                val firstName = fNameList[inputInt]
//                val middleName = mNameList[inputInt]
//
//                personsList[inputInt] = "[$id] $lastName ${firstName.take(1)}. ${middleName.take(1)}."
//
//                println(Strings.PERSON_CHANGE.value)
//                println(personsList[inputInt])
//                personsList.forEach { println(it) }
//            }
//
//            Strings.FIRSTNAME.value -> {
//                println(Strings.ENTER_FIRSTNAME.value)
//                val input = readLine()!!.toString()
//                println(personsList[inputInt])
//                val id = inputInt
//                val lName = lNameList[inputInt]
//                val fName = input
//                fNameList[inputInt] = input
//                val mName = mNameList[inputInt]
//                personsList[inputInt] = "[$id] $lName ${fName.take(1)}. ${mName.take(1)}."
//
//                println(Strings.PERSON_CHANGE.value)
//                println(personsList[inputInt])
//                personsList.forEach { println(it) }
//            }
//
//            Strings.MIDDLE_NAME.value -> {
//                println(Strings.ENTER_MIDDLE_NAME.value)
//                val input = readLine()!!.toString()
//                println(personsList[inputInt])
//                val id = inputInt
//                val lName = lNameList[inputInt]
//                val fName = fNameList[inputInt]
//                val mName = input
//                mNameList[inputInt] = input
//
//                personsList[inputInt] = "[$id] $lName ${fName.take(1)}. ${mName.take(1)}."
//
//                println(Strings.PERSON_CHANGE.value)
//                println(personsList[inputInt])
//                personsList.forEach { println(it) }
//            }
//
//            Strings.BIRTHDAY_REDUCTION.value -> {
//                println(Strings.ENTER_BIRTHDAY.value)
//                val input = readLine()!!.toString()
//                println(personsList[inputInt])
//
//                bNameList[inputInt] = input
//
//                println(Strings.BIRTHDAY_CHANGE.value)
//                println(personsList[inputInt])
//                personsList.forEach { println(it) }
//            }
//
//            Strings.HOBBY.value -> {
//                println(Strings.ENTER_HOBBY.value)
//                val input = readLine()!!.toString()
//                println(personsList[inputInt])
//
//                hNameList[inputInt] = input
//
//                println(Strings.HOBBY_CHANGE.value)
//                println(personsList[inputInt])
//                personsList.forEach { println(it) }
//            }
//        }
    }


}




