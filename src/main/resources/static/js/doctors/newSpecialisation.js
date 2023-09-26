class Specialisation {
    constructor(name) {
        this.name = name;
    }
}

const specButton = document.querySelector("#newSpecialisation");

specButton.addEventListener("click", function (event) {
    event.preventDefault();

    const specOldLabel = document.querySelector("#specialisationLabel")
    const specOldInput = document.querySelector("#specialisation");

    createLabel("specName", "Specjalizacja: ", specOldLabel);

    const specialisation = document.createElement("input");
    specialisation.name = "jsonSpecialisation";
    specialisation.type = "hidden";
    form.insertBefore(specialisation, specOldLabel);

    removeLabels([specOldLabel, specOldInput, specButton]);

    form.addEventListener("submit", function (submitEvent) {
        submitEvent.preventDefault();
        const specObject = new Specialisation(document.querySelector("#specName").value);
        specialisation.value = JSON.stringify(specObject);
        form.submit();
    })
})
