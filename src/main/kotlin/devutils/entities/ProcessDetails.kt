package devutils.entities

data class ProcessDetails(
    val processId: String,
    val arrivalTime: Int,
    val burstTime: Int,
    var waitingTime: Int,
    var turnAroundTime: Int
)