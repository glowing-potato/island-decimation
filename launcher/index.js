const childProcess = require("child_process");
const path = require("path");

function login() {
    childProcess.spawn("java", [
        "-jar",
        path.join(__dirname, "client.jar"),
        document.getElementById("email").value,
        document.getElementById("password").value
    ]);
}
