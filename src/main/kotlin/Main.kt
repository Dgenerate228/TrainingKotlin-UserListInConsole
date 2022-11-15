import kotlin.random.Random

object Person {

    var id = 1

    //Имя
    var firstName = mutableListOf(
        "Иван", "Сергей", "Алексей", "Антон", "Петр",
        "Семен", "Михаил", "Павел", "Григорий", "Лев",
        "Андрей", "Роман", "Арсений", "Степан", "Владислав",
        "Давид", "Ярослав", "Евгений", "Матвей", "Фёдор",
        "Марк", "Никита", "Роман", "Николай", "Артемий",
        "Виктор", "Даниил", "Денис", "Глеб", "Евгений",
        "Тимофей", "Егор", "Игорь", "Леонид", "Руслан"
    )

    //Отчество
    var middleName = mutableListOf(
        "Иванович", "Сергеевич", "Алексеевич", "Антонович", "Петрович",
        "Семёнович", "Михайлович", "Евгеньевич", "Григорьевич", "Львович",
        "Андреевич", "Романович", "Арсеньевич", "Степанович", "Владиславович",
        "Никитович", "Глебович", "Маркович", "Давидович", "Ярославович",
        "Матвеевич", "Фёдорович", "Николаевич", "Андреевич", "Тимофеевич",
        "Артемий", "Викторович", "Леонидович", "Даниилович", "Денисович",
        "Егорович", "Игоревич", "Павлович", "Романович", "Русланович"
    )

    //Фамилия
    var lastName = mutableListOf(
        "Иванов", "Сергеев", "Алексеев", "Антонов", "Арсеньев",
        "Петров", "Семенов", "Михайлов", "Евгеньев", "Степанов",
        "Григорьев", "Львов", "Андреев", "Романов", "Владиславов",
        "Давидов", "Ярославов", "Евгеньев", "Матвеев", "Фёдоров",
        "Марков", "Никитов", "Николаев", "Артемьев", "Викторов",
        "Данилов", "Денисов", "Глебов", "Тимофеев", "Егоров",
        "Игорь", "Леонидов", "Павлов", "Романов", "Русланов"
    )

    //День рождения. С ним разберусь попозже, пока сделаю обычный список
    var birthday = mutableListOf(
        "12.10.1997", "1.5.1975", "13.1.1990", "23.3.2000",
        "14.8.1989", "7.7.1999", "20.12.1980", "30.11.1992"
    )

    //Хобби
    var hobby = mutableListOf(
        "Гольф", "Настольные игры", "Бег", "Коллекционирование",
        "Туризм", "Гимнастика", "Книги", "Футбол", "Баскетбол",
        "Рыбалка", "Бокс", "Фото", "Рисование", "Фильмы"
    )

    private var lSize = lastName.size
    private var lRand = Random.nextInt(lSize)
    private var fSize = firstName.size
    private var fRand = Random.nextInt(fSize)
    private var mSize = middleName.size
    private var mRand = Random.nextInt(mSize)
    private var hSize = hobby.size
    private var hRand = Random.nextInt(hSize)
    private var bSize = birthday.size
    private var bRand = Random.nextInt(bSize)
    var users =
        mutableListOf(
            "[${id}] ",
            lastName[lRand], "${firstName[fRand]}.", "${middleName[mRand]}.", "${hobby[hRand]}.",
            "${birthday[bRand]}."
        )

}

// Случайная генерация пользователей с выводом на экран
fun main(args: Array<String>) {
//    Person.users.forEach { println(it) }
//    println("прогнали список")
    var mainListFun = Person.users
    mainListFun.clear()
    val amountUsers: Int = (1..100).random()

    for (id in 1..amountUsers) {

        val lSizeFun = Person.lastName.size
        val lRandFun = Random.nextInt(lSizeFun)
        val lNameFun = Person.lastName[lRandFun]

        val fSizeFun = Person.firstName.size
        val fRandFun = Random.nextInt(fSizeFun)
        val fNameFun = Person.firstName[fRandFun].take(1)

        val mSizeFun = Person.middleName.size
        val mRandFun = Random.nextInt(mSizeFun)
        val mNameFun = Person.middleName[mRandFun].take(1)

        val hSizeFun = Person.hobby.size
        val hRandFun = Random.nextInt(hSizeFun)
        val hNameFun = Person.hobby[hRandFun]

        val bSizeFun = Person.birthday.size
        val bRandFun = Random.nextInt(bSizeFun)
        val bNameFun = Person.birthday[bRandFun]

        Person.users.add("[$id] $lNameFun $fNameFun.$mNameFun. $hNameFun. $bNameFun. ")
        Person.id + 1

    }

    Person.users.forEach { println(it) }
    changingList()

}

//Внесение изменений в список
fun changingList() {
    var mainList = Person.users

    //println("Для просмотра подробностей о сотруднике введите его номер")
    println("Для изменения списка сотрудников введите: Изменить/Добавить/Удалить")
    var inputChange = readLine()

    when (inputChange) {
        "Добавить" -> {

            var id = Person.id + 1
            println("Введите Фамилию")
            inputChange = readLine()
            var lNameFun = inputChange
            println("Введите Имя")
            inputChange = readLine()!!.take(1)
            var fNameFun = inputChange
            println("Введите Отчество")
            inputChange = readLine()!!.take(1)
            var mNameFun = inputChange
            println("Введите Хобби")
            inputChange = readLine()
            var hNameFun = inputChange
            println("Введите Дату рождения")
            println("В формате DD/MM/YEAR - без нулей")
            inputChange = readLine()
            var bNameFun = inputChange
            mainList.add("[${id}] $lNameFun $fNameFun.$mNameFun. $hNameFun. $bNameFun ")
            println("Добавляем сотрудника")
            mainList.forEach { println(it) }

        }

        "Удалить" -> {
            println("Введите номер сотрудника")
            var inputInt = readLine()!!.toInt()
            println(mainList[inputInt - 1])
            mainList.removeAt(inputInt - 1)
            println("Сотрудник удален")
            mainList.forEach { println(it) }
        }

        "Изменить" -> {
            println("Введите номер сотрудника")
            var inputInt = readLine()!!.toInt() - 1
            println("Что конкретно собираетесь изменить ?")
            println("Фамилия/Имя/Отчество/Хобби/ДатаР/Всё")
            inputChange = readLine()
            if (inputChange == "Фамилия") {
                println("Введите требуемую фамилию")
                inputChange = readLine()
                Person.lastName[inputInt] = inputChange!!

            }
            println("Сотрудник изменен")
            println(mainList[inputInt])
            mainList.forEach { println(it) }
        }
    }

}











