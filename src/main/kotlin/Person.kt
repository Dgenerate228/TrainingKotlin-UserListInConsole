import kotlin.random.Random

//создать класс, использовать его в объекте +
//класс в отдельный файл +
//object перенести в другой файл +

//в fun main только отображение данных +
//Создать функцию createUsers внутри object Person и там сделать создание списка через что-то -
//можно создать класс внутри объекта ?

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
        "Игорь", "Леонидов", "Павлов", "Романов", "Русланов"
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

    private var usersList = mutableListOf("")
    private var lNameList = mutableListOf("")
    private var fNameList = mutableListOf("")
    private var mNameList = mutableListOf("")
    private var hNameList = mutableListOf("")
    private var bNameList = mutableListOf("")

    fun createList() {


        val amountUsers: Int = (1..100).random()

        for (id in 1..amountUsers) {

            val lRand = Random.nextInt(lastName.size)
            val lName = lastName[lRand]

            val fRand = Random.nextInt(firstName.size)
            val fName = firstName[fRand]

            val mRand = Random.nextInt(middleName.size)
            val mName = middleName[mRand]

            val hRand = Random.nextInt(hobby.size)
            val hName = hobby[hRand]

            val bRand = Random.nextInt(birthday.size)
            val bName = birthday[bRand]

            usersList.add("[$id] $lName ${fName.take(1)}. ${mName.take(1)}. ")
            lNameList.add(lName)
            fNameList.add(fName)
            mNameList.add(mName)
            hNameList.add(hName)
            bNameList.add(bName)

        }
        usersList.forEach { println(it) }
    }


    //Работает
    fun addUser() {

        val id = usersList.size + 1

        println("Введите Фамилию")
        var input = readLine() ?: ""
        val lName = input
        lNameList.add(input)
        println("Введите Имя")
        input = readLine()!!
        val fName = input
        fNameList.add(input)
        println("Введите Отчество")
        input = readLine()!!
        val mName = input
        mNameList.add(input)
        println("Введите Хобби")
        input = readLine() ?: ""
        hNameList.add(input)
        println("Введите Дату рождения")
        println("В формате DD.MM.YEAR - без нулей")
        input = readLine() ?: ""
        bNameList.add(input)
        usersList.add("[$id] $lName ${fName.take(1)}. ${mName.take(1)}.")
        println("Добавляем сотрудника")
        usersList.forEach { println(it) }

    }

    //Проблема с айдишниками
    fun deleteUser() {
        println(usersList)
        println("Введите номер сотрудника")
        val input = readLine()?.toInt() ?: 1
        usersList.removeAt(input)
        println("Сотрудник удален")
        usersList.forEach { println(it) }
    }


    //Работает. Переделать
    fun changeUser() {

        println("Введите номер сотрудника")
        val inputInt = readLine()!!.toInt()
        println("Что конкретно собираетесь изменить ?")
        println("Фамилия/Имя/Отчество/Хобби/ДатаР/Всё")

        when (readLine()) {
            "Фамилия" -> {
                println("Введите требуемую фамилию")
                val input = readLine()!!.toString()
                println(usersList[inputInt])
                val id = inputInt
                val lName = input
                val fName = fNameList[inputInt]
                val mName = mNameList[inputInt]

                usersList[inputInt] = "[$id] $lName ${fName.take(1)}. ${mName.take(1)}."

                println("Сотрудник изменен. Стал:")
                println(usersList[inputInt])
                usersList.forEach { println(it) }
            }

            "Имя" -> {
                println("Введите требуемую фамилию")
                val input = readLine()!!.toString()
                println(usersList[inputInt])
                val id = inputInt
                val lName = lNameList[inputInt]
                val fName = input
                fNameList[inputInt] = input
                val mName = mNameList[inputInt]
                usersList[inputInt] = "[$id] $lName ${fName.take(1)}. ${mName.take(1)}."

                println("Сотрудник изменен. Стал:")
                println(usersList[inputInt])
                usersList.forEach { println(it) }
            }

            "Отчество" -> {
                println("Введите требуемую фамилию")
                val input = readLine()!!.toString()
                println(usersList[inputInt])
                val id = inputInt
                val lName = lNameList[inputInt]
                val fName = fNameList[inputInt]
                val mName = input
                mNameList[inputInt] = input

                usersList[inputInt] = "[$id] $lName ${fName.take(1)}. ${mName.take(1)}."

                println("Сотрудник изменен. Стал:")
                println(usersList[inputInt])
                usersList.forEach { println(it) }
            }

            "ДатаР" -> {
                println("Введите требуемую фамилию")
                val input = readLine()!!.toString()
                println(usersList[inputInt])

                bNameList[inputInt] = input

                println("Дата рождения у сотрудника изменена")
                println(usersList[inputInt])
                usersList.forEach { println(it) }
            }

            "Хобби" -> {
                println("Введите требуемую фамилию")
                val input = readLine()!!.toString()
                println(usersList[inputInt])

                hNameList[inputInt] = input

                println("Изменено хобби у сотрудника:")
                println(usersList[inputInt])
                usersList.forEach { println(it) }
            }
        }
    }

    //Работает
    fun detailUser() {
        println("Введите номер сотрудника")
        val inputInt = readLine()!!.toInt()

        val nameDetail = lNameList[inputInt] + " " + fNameList[inputInt] + " " + mNameList[inputInt]
        val otherDetail = "Хобби: " + hNameList[inputInt] + "." + " Дата рождения: " + bNameList[inputInt]

        println(nameDetail)
        println(otherDetail)
    }

}




