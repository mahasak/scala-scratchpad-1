package kata9

class CheckOut {
    var rules: List[(List[String] => Int)] = Nil
    var items = List[String]()

    private def countItems(item: String, items: List[String]) = items.filter(i => i == item).length
    private def parseDeal(deal: String) = {
        val components = deal.split(" for ").map(_.toInt)
        (components(0), components(1))
    }
    private def costItems(item: String, items: List[String], basicCost: Int, deal: String) = {
        val (discountQty, discountPrice) = if (deal equals "" ) (1, basicCost) else parseDeal(deal)
        val numItems = countItems(item, items)
        val numBundles: Int = numItems / discountQty
        val numBasic = numItems % discountQty

        (numBasic * basicCost)+(numBundles * discountPrice)
    }

    def this(ruleDefs: Map[String, (Int, String)]) = {
        this()
        ruleDefs.keysIterator.foreach { item =>
          val cost = ruleDefs(item)._1
          val deal = ruleDefs(item)._2
          val costOfItems = costItems(item, _: List[String], cost, deal)
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
