data class Donut(
    val isDonut: Boolean = false,
    val paidDuration: UInt = 0u,
    val placeholder: String = "Оформите платную подписку",
    val canPublishFreeCopy: Boolean = true,
    val edit_mode: String = "all",
) {
}