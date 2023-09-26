class Doctor {
    constructor(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

const doctorButton = document.querySelector("#newDoctor");

doctorButton.addEventListener("click", function (event) {
    event.preventDefault();

    const doctorOldLabel = document.querySelector("#doctorLabel");
    const doctorOldInput = document.querySelector("#doctor");

    createLabel("doctorFirstName", "Imię: ", doctorOldLabel);
    createLabel("doctorLastName", "Nazwisko: ", doctorOldLabel);

    const doctor = document.createElement("input");
    doctor.name = "jsonDoctor";
    doctor.type = "hidden";
    form.insertBefore(doctor, doctorOldLabel);

    removeLabels([doctorOldInput, doctorOldLabel, doctorButton])

    form.addEventListener("submit", function (submitEvent) {
        submitEvent.preventDefault();
        const doctorObject = new Doctor(
            document.querySelector("#doctorFirstName").value,
            document.querySelector("#doctorLastName").value
        )
        doctor.value = JSON.stringify(doctorObject);
        form.submit();
    })
})