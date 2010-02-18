package kata9

class CheckOut(ruleDefs: Map[String, (Int, String)]) {
    val rules = buildRules(ruleDefs)
    var items = List[String]()

    def scan(item: String) = items = item :: items
    def total(): Int = (0 /: rules.map( costOfItems => costOfItems(items) ))(_+_)

    private def buildRules(ruleDefs: Map[String, (Int, String)]) = {
        ruleDefs.keys.map { item =>
          val cost = ruleDefs(item)._1
          val deal = ruleDefs(item)._2
          costItems(item, _: List[String], cost, deal)
        }.toList
    }

    private def costItems(item: String, items: List[String], basicCost: Int, deal: String) = {
        val (discountQty, discountPrice) = if (deal equals "" ) (1, basicCost) else parseDeal(deal)
        val numItems = countItems(item, items)
        val numBundles: Int = numItems / discountQty
        val numBasic = numItems % discountQty

        (numBasic * basicCost)+(numBundles * discountPrice)
    }

    private def parseDeal(deal: String) = {
        val components = deal.split(" for ").map(_.toInt)
        (components(0), components(1))
    }

    private def countItems(item: String, items: List[String]) = items.filter(i => i == item).length
}