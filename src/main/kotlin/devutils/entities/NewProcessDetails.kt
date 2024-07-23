package devutils.entities

data class NewProcessDetails(
    val processId: String,
    val arrivalTime: Int,
    val burstTime: Int,
    var waitingTime: Int,
    var turnAroundTime: Int
)