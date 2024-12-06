const { app, BrowserWindow, globalShortcut, Menu } = require('electron');
const path = require('path');
let win;
let isMaximized = false;
let previousBounds = null;
function createWindow() {
  win = new BrowserWindow({
    width: 1366,
    height: 768,
    minWidth: 1366,
    minHeight: 768,
    webPreferences: {
      nodeIntegration: true,
    }
  });
  win.loadFile(path.join(__dirname, 'index.html'));
  Menu.setApplicationMenu(null); // отключаем нахуй менюшку с view и прочей залупой
  // Реализация ебаного f11
  globalShortcut.register('F11', () => {
    if (isMaximized) {
      win.setBounds({
        x: previousBounds.x,
        y: previousBounds.y,
        width: 1366,
        height: 768
      });
      isMaximized = false;
    } else {
      // Сохранение текущих размеров 
      previousBounds = win.getBounds();
      // Ручное увеличение до максимального размера рабочего стола
      const { width, height } = require('electron').screen.getPrimaryDisplay().workAreaSize;
      win.setBounds({
        x: 0,
        y: 0,
        width: width,
        height: height
      });
      isMaximized = true;
    }
  });

  app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
      app.quit();
    }
  });
}

app.whenReady().then(createWindow);
// Для корректной работы на macOS
app.on('activate', () => {
  if (BrowserWindow.getAllWindows().length === 0) {
    createWindow();
  }
});
