class Hospital {
    constructor(name, street, streetNumber, flatNumber, city, postCode) {
        this.name = name;
        this.street = street;
        this.streetNumber = streetNumber;
        this.flatNumber = flatNumber;
        this.city = city;
        this.postCode = postCode;
    }
}

const hospitalButton = document.querySelector("#newHospital");

hospitalButton.addEventListener("click", function (event) {
    event.preventDefault();

    const hospitalOldLabel = document.querySelector("#hospitalLabel");
    const hospitalOldInput = document.querySelector("#hospital");

    createLabel("hospitalName", "Nazwa szpitala: ", hospitalOldLabel);
    createLabel("hospitalStreet", "Ulica: ", hospitalOldLabel);
    createLabel("hospitalStreetNumber", "Numer: ", hospitalOldLabel);
    createLabel("hospitalFlatNumber", "Numer mieszkania: ", hospitalOldLabel);
    createLabel("hospitalCity", "Miasto: ", hospitalOldLabel);
    createLabel("hospitalPostCode", "Kod pocztowy: ", hospitalOldLabel);

    const hospital = document.createElement("input");
    hospital.name = "jsonHospital";
    hospital.type = "hidden";
    form.insertBefore(hospital, hospitalOldLabel);

    removeLabels([hospitalOldLabel, hospitalOldInput, hospitalButton]);

    form.addEventListener("submit", function (submitEvent) {
        submitEvent.preventDefault();
        const hospitalObject = new Hospital(
            document.querySelector("#hospitalName").value,
            document.querySelector("#hospitalStreet").value,
            document.querySelector("#hospitalStreetNumber").value,
            document.querySelector("#hospitalFlatNumber").value,
            document.querySelector("#hospitalCity").value,
            document.querySelector("#hospitalPostCode").value);
        hospital.value = JSON.stringify(hospitalObject);
        form.submit();
    })
})