const childProcess = require("child_process");
const electron = require("electron");
const net = require("net");
const path = require("path");

function login() {
    childProcess.spawn("java", [
        "-jar",
        path.join(__dirname, "client.jar"),
        document.getElementById("email").value,
        document.getElementById("password").value
    ]);
    electron.ipcRenderer.send("quit");
}

function create() {
    if (document.getElementById("password").value === document.getElementById("password2").value) {
        electron.ipcRenderer.send("create", document.getElementById("email").value, document.getElementById("password").value);
    } else {
        alert("Passwords do not match!");
    }
}

electron.ipcRenderer.on("login", login);
electron.ipcRenderer.on("alert", (ev, msg) => alert(msg));
