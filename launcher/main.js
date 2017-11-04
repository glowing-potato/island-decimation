const electron = require("electron");
const app = electron.app;
const path = require("path");
const url = require("url");

let mainWindow;

function createWindow () {
    mainWindow = new electron.BrowserWindow({
        width: 800,
        height: 400
    });
    mainWindow.loadURL(url.format({
        pathname: path.join(__dirname, "index.html"),
        protocol: "file:",
        slashes: true
    }));
    mainWindow.on("closed", function () {
        mainWindow = null;
    });
}

app.on("ready", createWindow);

app.on("window-all-closed", function () {
    if (process.platform !== "darwin") {
        app.quit();
    }
});

app.on("activate", function () {
    if (mainWindow === null) {
        createWindow();
    }
});
