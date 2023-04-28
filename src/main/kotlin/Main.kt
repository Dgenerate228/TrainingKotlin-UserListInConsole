import Person

fun main(args: Array<String>) {

    Person.createList()
    while (true) {
        println(Strings.WHAT_DO.value)
        when (readLine()) {
            Strings.ADD.value -> {
                Person.addPerson()
            }

            Strings.REMOVE.value -> {
                Person.deletePerson()
            }

            Strings.CHANGE.value -> {
                Person.changePerson()
            }

            Strings.DETAILS.value -> {
                Person.detailPerson()
            }

            Strings.CLOSE.value -> {
                return
            }

            else -> {
                println(Strings.ERROR.value)

            }
        }
    }


}









