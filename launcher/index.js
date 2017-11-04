const childProcess = require("child_process");
const electron = require("electron");
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
