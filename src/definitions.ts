declare module "@capacitor/core" {
  interface PluginRegistry {
    FileInfosPlugin: FileInfosPlugin;
  }
}

export interface FileInfosPlugin {
  getInfos(options: { uri: string }): Promise<{value: {size: string, name: string}}>;
}