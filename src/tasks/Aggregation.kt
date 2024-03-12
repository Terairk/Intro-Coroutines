package tasks

import contributors.User

/*
TODO: Write aggregation code.

 In the initial list each user is present several times, once for each
 repository he or she contributed to.
 Merge duplications: each user should be present only once in the resulting list
 with the total value of contributions for all the repositories.
 Users should be sorted in a descending order by their contributions.

 The corresponding test can be found in test/tasks/AggregationKtTest.kt.
 You can use 'Navigate | Test' menu action (note the shortcut) to navigate to the test.
*/
fun List<User>.aggregate(): List<User> {
    // map logins to Int
//    val userMap = mutableMapOf<String, Int>()
//    this.forEach {
//        userMap[it.login] = userMap[it.login]?.plus(it.contributions) ?: it.contributions
//    }
//
//    return userMap
//        .map { (login, contributions) ->
//            User(login, contributions) }
//        .sortedByDescending { it.contributions }

//    return this
//        .groupingBy { it.login }
//        .fold(0) { acc, user -> acc + user.contributions }
//        .map { (login, contributions) -> User(login, contributions) }
//        .sortedByDescending { it.contributions }

    return this
        .groupBy { it.login }
        .map { (login, users) -> User(login, users.sumOf { it.contributions})}
        .sortedByDescending { it.contributions }
}