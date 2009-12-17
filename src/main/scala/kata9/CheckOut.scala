package kata9

class CheckOut {
    var rules: List[(List[String] => Int)] = Nil
    var items = List[String]()

    def countItems(item: String, items: List[String]) = items.filter(i => i == item).length
    def costItems(item: String, items: List[String], cost: Int) = countItems(item, items) * cost

    def this(ruleDefs: Map[String, (Int, String)]) = {
        this()
        ruleDefs.keysIterator.foreach { item =>
          val cost = ruleDefs(item)._1
          val costOfItems = costItems(item, _: List[String], cost)
          rules = costOfItems :: rules
        }
    }

    def scan(item: String) = {
        items = item :: items
    }
    def total(): Int = {
        var totalCost = 0
        rules.foreach ( costOfItems => totalCost += costOfItems(items) )
        totalCost
    }

}
