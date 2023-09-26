class Patient {
    constructor(firstName, lastName, pesel, mail,
                telephone, street, streetNumber, flatNumber,
                city, postCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.mail = mail;
        this.telephone = telephone;
        this.street = street;
        this.streetNumber = streetNumber;
        this.flatNumber = flatNumber;
        this.city = city;
        this.postCode = postCode;
    }
}

const patientButton = document.querySelector("#patientButton");

patientButton.addEventListener("click", function (event) {
    event.preventDefault();

    const patientOldLabel = document.querySelector("#patientLabel");
    const patientOldInput = document.querySelector("#patients");

    createLabel("patientFirstName", "Imię: ", patientOldLabel);
    createLabel("patientLastName", "Nazwisko: ", patientOldLabel);
    createLabel("patientPesel", "Pesel: ", patientOldLabel);
    createLabel("patientMail", "Mail: ", patientOldLabel);
    createLabel("patientTelephone", "Telefon: ", patientOldLabel);
    createLabel("patientStreet", "Ulica: ", patientOldLabel);
    createLabel("patientStreetNumber", "Numer domu: ", patientOldLabel);
    createLabel("patientFlatNumber", "Numer mieszkania: ", patientOldLabel);
    createLabel("patientCity", "Miasto: ", patientOldLabel);
    createLabel("patientPostCode", "Kod pocztowy: ", patientOldLabel);

    const patient = document.createElement("input");
    patient.name = "jsonPatient";
    patient.type = "hidden";
    form.insertBefore(patient, patientOldLabel);

    removeLabels([patientOldLabel, patientOldInput, patientButton])

    form.addEventListener("submit", function (submitEvent) {
        submitEvent.preventDefault();
        const patientObject = new Patient(
            document.querySelector("#patientFirstName").value,
            document.querySelector("#patientLastName").value,
            document.querySelector("#patientPesel").value,
            document.querySelector("#patientMail").value,
            document.querySelector("#patientTelephone").value,
            document.querySelector("#patientStreet").value,
            document.querySelector("#patientStreetNumber").value,
            document.querySelector("#patientFlatNumber").value,
            document.querySelector("#patientCity").value,
            document.querySelector("#patientPostCode").value
        )
        patient.value = JSON.stringify(patientObject);
        form.submit();
    })
})