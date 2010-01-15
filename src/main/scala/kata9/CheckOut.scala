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
    private def buildRules(ruleDefs: Map[String, (Int, String)]) = {
        ruleDefs.keys.map { item =>
          val cost = ruleDefs(item)._1
          val deal = ruleDefs(item)._2
          costItems(item, _: List[String], cost, deal)
        }.toList
    }

    def this(ruleDefs: Map[String, (Int, String)]) = {
        this()
        rules = buildRules(ruleDefs)
    }

    def scan(item: String) = items = item :: items
    def total(): Int = {
      var totalCost = 0;
      rules.map( costOfItems => costOfItems(items) ).foreach(c => totalCost += c)
      totalCost
    }

}