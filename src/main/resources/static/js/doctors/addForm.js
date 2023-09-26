const form = document.querySelector("#form");

function createLabel(name, text, childAfterLabel) {
    const input = document.createElement("input");
    setAttribute(input, name);
    addLabel(name, text, input, childAfterLabel);
}

function setAttribute(label, name) {
    label.id = name;
    label.name = name;
}

function addLabel(labelFor, labelText, labelInput, childAfterLabel) {
    const label = document.createElement("label");
    label.htmlFor = labelFor;
    label.innerText = labelText;
    form.insertBefore(label, childAfterLabel);
    form.insertBefore(labelInput, childAfterLabel);
    form.insertBefore(document.createElement("br"), childAfterLabel);
}

function removeLabels(labels) {
    for (let i = 0; i < labels.length; i++) {
        form.removeChild(labels[i]);
    }
}