package kata9

class CheckOut(val rules: Map[String, (Int, String)]) {
    var items = List[String]()
    def scan(item: String) = {
        items = item :: items
    }
    def total(): Int = {
        def priceOf(item: String) = if (rules.contains(item)) rules(item)._1 else 0
        // Transform to a list of prices, then add them
        (items map (priceOf(_))).sum
    }

}
