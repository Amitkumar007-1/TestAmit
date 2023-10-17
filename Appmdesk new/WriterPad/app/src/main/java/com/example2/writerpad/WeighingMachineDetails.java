package com.example2.writerpad;

public class WeighingMachineDetails {

    private String weighingMachineName;
    private String  weighing_machine_availability;

    public WeighingMachineDetails(String weighingMachineName, String weighing_machine_availability) {
        this.weighingMachineName = weighingMachineName;
        this.weighing_machine_availability = weighing_machine_availability;
    }

    public String getWeighingMachineName() {
        return weighingMachineName;
    }

    public String getWeighing_machine_availability() {
        return weighing_machine_availability;
    }

    public void setWeighingMachineName(String weighingMachineName) {
        this.weighingMachineName = weighingMachineName;
    }

    public void setWeighing_machine_availability(String weighing_machine_availability) {
        this.weighing_machine_availability = weighing_machine_availability;
    }
}
