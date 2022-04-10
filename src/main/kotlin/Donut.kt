data class Donut(
    val isDonut : Boolean,
    val paidDuration : Int,
    val placeholder : String = "Оформите платную подписку",
    val canPublishFreeCopy : Boolean = true,
    val edit_mode : String = "all",
) {
}