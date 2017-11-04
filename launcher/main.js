const electron = require("electron");
const net = require("net");
const path = require("path");
const url = require("url");

let mainWindow;

function createWindow () {
    mainWindow = new electron.BrowserWindow({
        width: 800,
        height: 450
    });
    mainWindow.loadURL(url.format({
        pathname: path.join(__dirname, "index.html"),
        protocol: "file:",
        slashes: true
    }));
    mainWindow.on("closed", () => {
        mainWindow = null;
    });
}

electron.app.on("ready", createWindow);

electron.app.on("window-all-closed", () => {
    if (process.platform !== "darwin") {
        electron.app.quit();
    }
});

electron.app.on("activate", () => {
    if (mainWindow === null) {
        createWindow();
    }
});

electron.ipcMain.on("quit", () => {
    mainWindow.close();
});

electron.ipcMain.on("create", (ev, email, pass) => {
    let socket = new net.Socket();
    socket.connect(8000, "localhost", () => {
        socket.write(`+${email}\n${pass}\n`);
    });
    let data = "";
    socket.on("data", chunk => {
        data += chunk;
    });
    socket.on("close", () => {
        let error = data.split("\n")[1];
        if (error === "Account created.") {
            ev.sender.send("login");
        } else {
            ev.sender.send("alert", error);
        }
    });
    socket.on("error", e => console.log(e));
});
