package scheduling;

import devutils.entities.NewProcessDetails;

import java.util.ArrayList;

/**
 * Implementation of Shortest Job First Algorithm: This algorithm allows the waiting process with the
 * minimal burst-time to be executed first. see more
 * <a href="https://www.guru99.com/shortest-job-first-sjf-scheduling.html">here</a>
 */
public class SJFScheduling {
    protected ArrayList<NewProcessDetails> processes;
    protected ArrayList<String> schedule;

    /**
     * a simple constructor
     *
     * @param processes a list of processes the user wants to schedule it also sorts the processes
     * based on the time of their arrival.
     */
    SJFScheduling(final ArrayList<NewProcessDetails> processes) {
        this.processes = processes;
        schedule = new ArrayList<>();
        sortByArrivalTime();
    }

    protected void sortByArrivalTime() {
        int size = processes.size();
        int i;
        int j;
        NewProcessDetails temp;
        for (i = 0; i < size; i++) {
            for (j = i + 1; j < size - 1; j++) {
                if (processes.get(j).getArrivalTime() > processes.get(j + 1).getArrivalTime()) {
                    temp = processes.get(j);
                    processes.set(j, processes.get(j + 1));
                    processes.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * this functions returns the order of the executions
     */
    public void scheduleProcesses() {
        ArrayList<NewProcessDetails> ready = new ArrayList<>();

        int size = processes.size();
        int runtime;
        int time = 0;
        int executed = 0;
        int j;
        int k = 0;
        NewProcessDetails running;

        if (size == 0) {
            return;
        }

        while (executed < size) {
            while (k < size && processes.get(k).getArrivalTime() <= time) // here we find the processes that have arrived.
            {
                ready.add(processes.get(k));
                k++;
            }

            running = findShortestJob(ready);
            if (running == null) {
                time++;
            } else {
                runtime = running.getBurstTime();
                for (j = 0; j < runtime; j++) {
                    time++;
                }
                schedule.add(running.getProcessId());
                ready.remove(running);
                executed++;
            }
        }
    }

    /**
     * this function evaluates the shortest job of all the ready processes (based on  a process
     * burst time).
     *
     * @param readyProcesses an array list of ready processes.
     * @return returns the process' with the shortest burst time OR NULL if there are no ready
     * processes.
     */
    private NewProcessDetails findShortestJob(ArrayList<NewProcessDetails> readyProcesses) {
        if (readyProcesses.isEmpty()) {
            return null;
        }
        int i;
        int size = readyProcesses.size();
        int minBurstTime = readyProcesses.get(0).getBurstTime();
        int temp;
        int positionOfShortestJob = 0;

        for (i = 1; i < size; i++) {
            temp = readyProcesses.get(i).getBurstTime();
            if (minBurstTime > temp) {
                minBurstTime = temp;
                positionOfShortestJob = i;
            }
        }

        return readyProcesses.get(positionOfShortestJob);
    }
}
