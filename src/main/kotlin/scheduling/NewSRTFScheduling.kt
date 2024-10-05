package scheduling

import devutils.entities.ProcessDetails

/**
 * Implementation of Shortest Remaining Time First Scheduling Algorithm.
 * In the SRTF scheduling algorithm, the process with the smallest amount of time remaining until completion is selected to execute.
 * Example:
 * Consider the processes p1, p2 and the following table with info about their arrival and burst time:
 * Process | Burst Time | Arrival Time
 * P1      | 6 ms        | 0 ms
 * P2      | 2 ms        | 1 ms
 * In this example, P1 will be executed at time = 0 until time = 1 when P2 arrives. At time = 2, P2 will be executed until time = 4. At time 4, P2 is done, and P1 is executed again to be done.
 * That's a simple example of how the algorithm works.
 * More information you can find here -> https://en.wikipedia.org/wiki/Shortest_remaining_time
 */
class NewSRTFScheduling(protected val processes: ArrayList<ProcessDetails>) {
    protected val ready = ArrayList<String?>()

    fun evaluateScheduling(){
        var time = 0
        var cr =0
        var n = processes.size
        val remainingTime = IntArray(n)

        /* calculating remaining time of every process and total units of time */
        for (i in 0 until n) {
            remainingTime[i] = processes[i].burstTime
            time += processes[i].burstTime
        }

        /* if the first process doesn't arrive at 0, we have more units of time */
        if (processes[0].arrivalTime != 0) {
            time += processes[0].arrivalTime
        }

        /* printing id of the process which is executed at every unit of time */
        // if the first process doesn't arrive at 0, we print only \n until it arrives
        if (processes[0].arrivalTime != 0) {
            for (i in 0 until processes[0].arrivalTime) {
                ready.add(null)
            }
        }

        for (i in processes[0].arrivalTime until time) {
            for (j in 0 until n) {
                if (processes[j].arrivalTime <= i && (remainingTime[j] < remainingTime[cr] && remainingTime[j] > 0 || remainingTime[cr] == 0)) {
                    cr = j
                }
            }
            ready.add(processes[cr].processId)
            remainingTime[cr]--
        }
    }

}