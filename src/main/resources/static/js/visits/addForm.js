
const form = document.querySelector("#form");
const doctorButton = document.querySelector("#newDoctor");
const doctorLabel = document.querySelector("#doctorLabel");
doctorButton.addEventListener("click", function (event) {
    createDoctorForm();
    form.removeChild(doctorLabel);
    form.removeChild(doctorButton);


    //     Imię: <form:input path="firstName"/><br/>
    // Nazwisko: <form:input path="lastName"/><br/>
    // Specializacje: <form:select path="specializations" items="${specialisations}" itemLabel="name" itemValue="id"/><br/>
    // Szpitale: <form:select path="hospitals" items="${hospitals}" itemLabel="name" itemValue="id"/><br/>
})

function createDoctorForm() {
    const doctorNameLabel = document.createElement("label");
    doctorNameLabel.htmlFor = "doctorName";
    doctorNameLabel.innerText = "Imię lekarza: ";
    form.insertBefore(doctorNameLabel, doctorButton);
    const doctorNameForm = document.createElement("input");
    doctorNameForm.name = "doctorName";
    doctorNameForm.innerText = "Imię";
    doctorNameForm.id = "doctorName";
    form.insertBefore(doctorNameForm, doctorButton)
}